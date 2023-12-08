package games.twinhead.flowers.block;

import games.twinhead.flowers.registry.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;

public enum Flower {
    ALLIUM(Blocks.ALLIUM),
    AZURE_BLUET(Blocks.AZURE_BLUET),
    BLUE_ORCHID(Blocks.BLUE_ORCHID),
    DANDELION(Blocks.DANDELION),
    POPPY(Blocks.POPPY),
    RED_TULIP(Blocks.RED_TULIP),
    ORANGE_TULIP(Blocks.ORANGE_TULIP),
    WHITE_TULIP(Blocks.WHITE_TULIP),
    PINK_TULIP(Blocks.PINK_TULIP),
    OXEYE_DAISY(Blocks.OXEYE_DAISY),
    CORNFLOWER(Blocks.CORNFLOWER),
    LILY_OF_THE_VALLEY(Blocks.LILY_OF_THE_VALLEY),
    WITHER_ROSE(Blocks.WITHER_ROSE),
    ;


    private final Block parent;

    Flower(Block parent){
        this.parent = parent;
    }

    public String toString(){
        return this.name().toLowerCase();
    }

    public Block getCrop() {
        return ModRegistry.CROPS.get(this);
    }

    public Block getSeedling(){
        return ModRegistry.SEEDLINGS.get(this);
    }

    public Item getSeeds(){
        return ModRegistry.SEEDS.get(this);
    }

    public Block getParent(){
        return this.parent;
    }
}
