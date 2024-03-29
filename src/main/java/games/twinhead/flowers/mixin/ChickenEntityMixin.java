package games.twinhead.flowers.mixin;

import games.twinhead.flowers.block.Flower;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChickenEntity.class)
public class ChickenEntityMixin extends AnimalEntity {

    protected ChickenEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "isBreedingItem", at = @At("HEAD"), cancellable = true)
    private void injected(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(getBreedingItems().test(stack));
    }

    @Inject(method = "initGoals", at = @At(value = "HEAD"), cancellable = true)
    private void injected(CallbackInfo ci) {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.4));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(3, new TemptGoal(this, 1.0, getBreedingItems(), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
        ci.cancel();
    }

    @Unique
    private Ingredient getBreedingItems(){
        return Ingredient.ofItems(
                Items.WHEAT_SEEDS,
                Items.MELON_SEEDS,
                Items.PUMPKIN_SEEDS,
                Items.BEETROOT_SEEDS,
                Items.TORCHFLOWER_SEEDS,
                Flower.ALLIUM.getSeeds(),
                Flower.AZURE_BLUET.getSeeds(),
                Flower.BLUE_ORCHID.getSeeds(),
                Flower.DANDELION.getSeeds(),
                Flower.POPPY.getSeeds(),
                Flower.RED_TULIP.getSeeds(),
                Flower.ORANGE_TULIP.getSeeds(),
                Flower.WHITE_TULIP.getSeeds(),
                Flower.PINK_TULIP.getSeeds(),
                Flower.OXEYE_DAISY.getSeeds(),
                Flower.CORNFLOWER.getSeeds(),
                Flower.LILY_OF_THE_VALLEY.getSeeds(),
                Flower.WITHER_ROSE.getSeeds());
    }

    @Shadow
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}
