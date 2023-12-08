package games.twinhead.flowers.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class FlowerCropBlock extends CropBlock {

    public static final IntProperty AGE;

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
        builder.add(AGE);
    }

    protected int getGrowthAmount(World world) {
        return super.getGrowthAmount(world) / 3;
    }


    protected ItemConvertible getSeedsItem() {
        return switch (flower){
            case "allium" -> Flower.ALLIUM.getSeeds();
            case "azure_bluet" -> Flower.AZURE_BLUET.getSeeds();
            case "blue_orchid" -> Flower.BLUE_ORCHID.getSeeds();
            case "dandelion" -> Flower.DANDELION.getSeeds();
            case "poppy" -> Flower.POPPY.getSeeds();
            case "red_tulip" -> Flower.RED_TULIP.getSeeds();
            case "orange_tulip" -> Flower.ORANGE_TULIP.getSeeds();
            case "white_tulip" -> Flower.WHITE_TULIP.getSeeds();
            case "pink_tulip" -> Flower.PINK_TULIP.getSeeds();
            case "oxeye_daisy" -> Flower.OXEYE_DAISY.getSeeds();
            case "cornflower" -> Flower.CORNFLOWER.getSeeds();
            case "lily_of_the_valley" -> Flower.LILY_OF_THE_VALLEY.getSeeds();
            case "wither_rose" -> Flower.WITHER_ROSE.getSeeds();
            default -> null;
        };
    }

    static {
        AGE = Properties.AGE_3;
    }
}
