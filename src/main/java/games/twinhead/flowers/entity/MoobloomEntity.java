package games.twinhead.flowers.entity;

import games.twinhead.flowers.registry.ModRegistry;
import games.twinhead.flowers.block.Flower;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class MoobloomEntity extends CowEntity implements Shearable {

    private static final TrackedData<Integer> FLOWER_AGE;
    private static final TrackedData<Integer> FLOWER_TYPE;

    private int eatGrassTimer;

    public MoobloomEntity(EntityType<? extends MoobloomEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 2.0));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(3, new TemptGoal(this, 1.25, Ingredient.ofItems(Items.WHEAT), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.25));
        this.goalSelector.add(5, new EatGrassGoal(this));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createCowAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20000000298023224);
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.setFlowerAge(random.nextBetween(0, 4));
        this.setFlowerType(random.nextBetween(0, 11));
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(FLOWER_AGE, 0);
        this.dataTracker.startTracking(FLOWER_TYPE, 0);
    }

    public void tickMovement() {
        if (this.getWorld().isClient) {
            this.eatGrassTimer = Math.max(0, this.eatGrassTimer - 1);
        }

        super.tickMovement();
    }

    public void handleStatus(byte status) {
        if (status == EntityStatuses.SET_SHEEP_EAT_GRASS_TIMER_OR_PRIME_TNT_MINECART) {
            this.eatGrassTimer = 40;
        } else {
            super.handleStatus(status);
        }
    }

    public void onEatingGrass() {
        super.onEatingGrass();
        this.ageFlower(this.random.nextInt(3));
        if (this.isBaby()) {
            this.growUp(60);
        }
    }

    public float getNeckAngle(float delta) {
        if (this.eatGrassTimer <= 0) {
            return 0.0F;
        } else if (this.eatGrassTimer >= 4 && this.eatGrassTimer <= 36) {
            return 1.0F;
        } else {
            return this.eatGrassTimer < 4 ? ((float)this.eatGrassTimer - delta) / 4.0F : -((float)(this.eatGrassTimer - 40) - delta) / 4.0F;
        }
    }

    public float getHeadAngle(float delta) {
        if (this.eatGrassTimer > 4 && this.eatGrassTimer <= 36) {
            float f = ((float)(this.eatGrassTimer - 4) - delta) / 32.0F;
            return 0.62831855F + 0.21991149F * MathHelper.sin(f * 28.7F);
        } else {
            return this.eatGrassTimer > 0 ? 0.62831855F : this.getPitch() * 0.017453292F;
        }
    }

    public BlockState getFlowerState(){
        System.out.println(Flower.values()[getFlowerType()].getSeedling().getDefaultState().with(Properties.AGE_4, getFlowerAge()));
        return Flower.values()[getFlowerType()].getSeedling().getDefaultState().with(Properties.AGE_4, getFlowerAge());
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("flower_age", getFlowerAge());
        nbt.putInt("flower_type", getFlowerType());
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setFlowerAge(nbt.getInt("flower_age"));
        this.setFlowerType(nbt.getInt("flower_type"));
    }

    public void setFlowerAge(int flower_age) {
        this.dataTracker.set(FLOWER_AGE, flower_age);
    }

    public int getFlowerAge() {
        return this.dataTracker.get(FLOWER_AGE);
    }

    public int getFlowerType() {
        return this.dataTracker.get(FLOWER_TYPE);
    }

    public void setFlowerType(int flower_type) {
        this.dataTracker.set(FLOWER_TYPE, flower_type);
    }

    public void ageFlower(int i){
        setFlowerAge(this.getFlowerAge() + i);
        if(getFlowerAge() > 4) setFlowerAge(4);
    }

    @Override
    public void sheared(SoundCategory shearedSoundCategory) {
        this.setFlowerAge(0);
        this.getWorld().playSoundFromEntity(null, this, SoundEvents.ENTITY_SHEEP_SHEAR, shearedSoundCategory, 1.0F, 1.0F);

        int i = 1 + this.random.nextInt(3);

        for(int j = 0; j < i; ++j) {
            ItemEntity itemEntity = this.dropItem(getItemFromInt(), 1);
            if (itemEntity != null) {
                itemEntity.setVelocity(itemEntity.getVelocity().add((this.random.nextFloat() - this.random.nextFloat()) * 0.1F, this.random.nextFloat() * 0.05F, (this.random.nextFloat() - this.random.nextFloat()) * 0.1F));
            }
        }
    }

    @Override
    public boolean isShearable() {
        return this.getFlowerAge() >= 4;
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.SHEARS)) {
            if (!this.getWorld().isClient && this.isShearable()) {
                this.sheared(SoundCategory.PLAYERS);
                this.emitGameEvent(GameEvent.SHEAR, player);
                itemStack.damage(1, player, (Consumer<LivingEntity>)((playerX) -> playerX.sendToolBreakStatus(hand)));
                return ActionResult.SUCCESS;
            } else {
                return ActionResult.CONSUME;
            }
        }else if (itemStack.isOf(Items.BONE_MEAL)) {
            if (!this.getWorld().isClient && this.getFlowerAge() < 4 && this.getFlowerAge() > 0) {
                ageFlower(random.nextBetween(1, 4));
                itemStack.decrement(1);
                return ActionResult.SUCCESS;
            } else {
                return ActionResult.CONSUME;
            }
        }else if (ModRegistry.SEEDS.containsValue(itemStack.getItem())) {
            if (!this.getWorld().isClient && this.getFlowerAge() == 0) {
                this.setFlowerType(itemToInt(itemStack.getItem()));
                this.setFlowerAge(1);
                itemStack.decrement(1);
                return ActionResult.SUCCESS;
            } else {
                return ActionResult.CONSUME;
            }
        }else {
            return super.interactMob(player, hand);
        }
    }

    public MoobloomEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        MoobloomEntity moobloom = (MoobloomEntity) passiveEntity;
        MoobloomEntity moobloom2 = EntityRegistry.MOOBLOOM.create(serverWorld);
        assert moobloom2 != null;
        moobloom2.setFlowerType(moobloom.getFlowerType());
        return moobloom2;
    }

    private int itemToInt(Item item){
        int count = 0;
        for (Flower flower: Flower.values()) {
            if (item.equals(flower.getSeeds())){
                return count;
            } else {
                count++;
            }
        }
        return 0;
    }

    private Item getItemFromInt(){
        return Flower.values()[getFlowerType()].getParent().asItem();
    }


    static {
        FLOWER_AGE = DataTracker.registerData(MoobloomEntity.class, TrackedDataHandlerRegistry.INTEGER);
        FLOWER_TYPE = DataTracker.registerData(MoobloomEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }
}
