package games.twinhead.flowers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public class FlowerCropBlock extends CropBlock {

    public static final IntProperty AGE;
    private static final VoxelShape[] AGE_TO_SHAPE;

    private final String flower;
    public FlowerCropBlock(String flower, Settings settings) {
        super(settings);
        this.flower = flower;
    }

    public IntProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 3;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(2) != 0) {
            super.randomTick(state, world, pos, random);
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{AGE});
    }

    protected int getGrowthAmount(World world) {
        return super.getGrowthAmount(world) / 3;
    }


    protected ItemConvertible getSeedsItem() {
        return switch (flower){
            case "allium" -> Registry.ALLIUM_SEEDS;
            case "azure_bluet" -> Registry.AZURE_BLUET_SEEDS;
            case "blue_orchid" -> Registry.BLUE_ORCHID_SEEDS;
            case "dandelion" -> Registry.DANDELION_SEEDS;
            case "poppy" -> Registry.POPPY_SEEDS;
            case "red_tulip" -> Registry.RED_TULIP_SEEDS;
            case "orange_tulip" -> Registry.ORANGE_TULIP_SEEDS;
            case "white_tulip" -> Registry.WHITE_TULIP_SEEDS;
            case "pink_tulip" -> Registry.PINK_TULIP_SEEDS;
            case "oxeye_daisy" -> Registry.OXEYE_DAISY_SEEDS;
            case "cornflower" -> Registry.CORNFLOWER_SEEDS;
            case "lily_of_the_valley" -> Registry.LILY_OF_THE_VALLEY_SEEDS;
            case "wither_rose" -> Registry.WITHER_ROSE_SEEDS;
            default -> null;
        };
    }

    static {
        AGE = Properties.AGE_3;
        AGE_TO_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0), Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0), Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 6.0, 16.0), Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0)};
    }
}
