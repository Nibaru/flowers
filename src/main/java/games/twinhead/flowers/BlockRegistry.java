package games.twinhead.flowers;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.HashMap;

public class BlockRegistry {

    public static ArrayList<Block> crops = new ArrayList<>();

    public static Block ALLIUM_CROP;
    public static Item ALLIUM_SEEDS;
    public static Block AZURE_BLUET_CROP;
    public static Item AZURE_BLUET_SEEDS;
    public static Block BLUE_ORCHID_CROP;
    public static Item BLUE_ORCHID_SEEDS;
    public static Block DANDELION_CROP;
    public static Item DANDELION_SEEDS;
    public static Block POPPY_CROP;
    public static Item POPPY_SEEDS;
    public static Block RED_TULIP_CROP;
    public static Item RED_TULIP_SEEDS;
    public static Block ORANGE_TULIP_CROP;
    public static Item ORANGE_TULIP_SEEDS;
    public static Block WHITE_TULIP_CROP;
    public static Item WHITE_TULIP_SEEDS;
    public static Block PINK_TULIP_CROP;
    public static Item PINK_TULIP_SEEDS;
    public static Block OXEYE_DAISY_CROP;
    public static Item OXEYE_DAISY_SEEDS;
    public static Block CORNFLOWER_CROP;
    public static Item CORNFLOWER_SEEDS;
    public static Block LILY_OF_THE_VALLEY_CROP;
    public static Item LILY_OF_THE_VALLEY_SEEDS;
    public static Block WITHER_ROSE_CROP;
    public static Item WITHER_ROSE_SEEDS;


    public static String[] flowerTypes = {"allium", "azure_bluet", "blue_orchid", "dandelion", "poppy", "red_tulip", "orange_tulip", "white_tulip", "pink_tulip", "oxeye_daisy", "cornflower", "lily_of_the_valley", "wither_rose"};

    public static void register(){
        ALLIUM_CROP = registerBlock("allium");
        ALLIUM_SEEDS = registerItem("allium", ALLIUM_CROP);
        AZURE_BLUET_CROP  = registerBlock("azure_bluet");
        AZURE_BLUET_SEEDS = registerItem("azure_bluet", AZURE_BLUET_CROP);
        BLUE_ORCHID_CROP = registerBlock("blue_orchid");
        BLUE_ORCHID_SEEDS = registerItem("blue_orchid", BLUE_ORCHID_CROP);
        DANDELION_CROP  = registerBlock("dandelion");
        DANDELION_SEEDS = registerItem("dandelion", DANDELION_CROP);
        POPPY_CROP = registerBlock("poppy");
        POPPY_SEEDS = registerItem("poppy", POPPY_CROP);
        RED_TULIP_CROP = registerBlock("red_tulip");
        RED_TULIP_SEEDS = registerItem("red_tulip", RED_TULIP_CROP);
        ORANGE_TULIP_CROP = registerBlock("orange_tulip");
        ORANGE_TULIP_SEEDS = registerItem("orange_tulip", ORANGE_TULIP_CROP);
        WHITE_TULIP_CROP = registerBlock("white_tulip");
        WHITE_TULIP_SEEDS = registerItem("white_tulip",WHITE_TULIP_CROP );
        PINK_TULIP_CROP = registerBlock("pink_tulip");
        PINK_TULIP_SEEDS = registerItem("pink_tulip", PINK_TULIP_CROP);
        OXEYE_DAISY_CROP = registerBlock("oxeye_daisy");
        OXEYE_DAISY_SEEDS = registerItem("oxeye_daisy", OXEYE_DAISY_CROP);
        CORNFLOWER_CROP = registerBlock("cornflower");
        CORNFLOWER_SEEDS = registerItem("cornflower", CORNFLOWER_CROP);
        LILY_OF_THE_VALLEY_CROP = registerBlock("lily_of_the_valley");
        LILY_OF_THE_VALLEY_SEEDS = registerItem("lily_of_the_valley", LILY_OF_THE_VALLEY_CROP);
        WITHER_ROSE_CROP = registerBlock("wither_rose");
        WITHER_ROSE_SEEDS = registerItem("wither_rose", WITHER_ROSE_CROP);
    }

    public static Block registerBlock(String name){
        Block block = new FlowerCropBlock(name, AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
        crops.add(block);
        return Registry.register(Registry.BLOCK, Flowers.modID + ":" + name, block);
    }

    public static Item registerItem(String name, Block crop){
        return Registry.register(Registry.ITEM , Flowers.modID + ":" + name + "_seeds", new AliasedBlockItem(crop, new FabricItemSettings().group(ItemGroup.MISC)));
    }
}

