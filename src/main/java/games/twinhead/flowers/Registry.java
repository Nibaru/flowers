package games.twinhead.flowers;


import games.twinhead.flowers.entity.EntityRegistry;
import games.twinhead.flowers.entity.MoobloomEntity;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Registry {

    public static Set<Block> crops = new HashSet<>();
    public static List<Item> seeds = new ArrayList<>();

    public static Block ALLIUM_CROP;
    public static Block AZURE_BLUET_CROP;
    public static Block BLUE_ORCHID_CROP;
    public static Block DANDELION_CROP;
    public static Block POPPY_CROP;
    public static Block RED_TULIP_CROP;
    public static Block ORANGE_TULIP_CROP;
    public static Block WHITE_TULIP_CROP;
    public static Block PINK_TULIP_CROP;
    public static Block OXEYE_DAISY_CROP;
    public static Block CORNFLOWER_CROP;
    public static Block LILY_OF_THE_VALLEY_CROP;
    public static Block WITHER_ROSE_CROP;


    public static Item ALLIUM_SEEDS;
    public static Item AZURE_BLUET_SEEDS;
    public static Item BLUE_ORCHID_SEEDS;
    public static Item CORNFLOWER_SEEDS;
    public static Item DANDELION_SEEDS;
    public static Item LILY_OF_THE_VALLEY_SEEDS;
    public static Item ORANGE_TULIP_SEEDS;
    public static Item OXEYE_DAISY_SEEDS;
    public static Item PINK_TULIP_SEEDS;
    public static Item POPPY_SEEDS;
    public static Item RED_TULIP_SEEDS;
    public static Item WHITE_TULIP_SEEDS;
    public static Item WITHER_ROSE_SEEDS;

    public static Block ALLIUM_SEEDLING;
    public static Block AZURE_BLUET_SEEDLING;
    public static Block BLUE_ORCHID_SEEDLING;
    public static Block CORNFLOWER_SEEDLING;
    public static Block DANDELION_SEEDLING;
    public static Block LILY_OF_THE_VALLEY_SEEDLING;
    public static Block ORANGE_TULIP_SEEDLING;
    public static Block OXEYE_DAISY_SEEDLING;
    public static Block PINK_TULIP_SEEDLING;
    public static Block POPPY_SEEDLING;
    public static Block RED_TULIP_SEEDLING;
    public static Block WHITE_TULIP_SEEDLING;
    public static Block WITHER_ROSE_SEEDLING;

    public static Item MOOBLOOM_SPAWN_EGG = net.minecraft.util.registry.Registry.register(net.minecraft.util.registry.Registry.ITEM , Flowers.modID + ":moobloom_spawn_egg", new SpawnEggItem(EntityRegistry.MOOBLOOM, 16569344, 16313793, new FabricItemSettings().group(ItemGroup.MISC)));


    public static String[] flowerTypes = {"allium", "azure_bluet", "blue_orchid", "dandelion", "poppy", "red_tulip", "orange_tulip", "white_tulip", "pink_tulip", "oxeye_daisy", "cornflower", "lily_of_the_valley", "wither_rose"};

    public static void register(){
        ALLIUM_CROP = registerCropBlock("allium");
        ALLIUM_SEEDS = registerItem("allium", ALLIUM_CROP);
        AZURE_BLUET_CROP  = registerCropBlock("azure_bluet");
        AZURE_BLUET_SEEDS = registerItem("azure_bluet", AZURE_BLUET_CROP);
        BLUE_ORCHID_CROP = registerCropBlock("blue_orchid");
        BLUE_ORCHID_SEEDS = registerItem("blue_orchid", BLUE_ORCHID_CROP);
        CORNFLOWER_CROP = registerCropBlock("cornflower");
        CORNFLOWER_SEEDS = registerItem("cornflower", CORNFLOWER_CROP);
        DANDELION_CROP  = registerCropBlock("dandelion");
        DANDELION_SEEDS = registerItem("dandelion", DANDELION_CROP);
        LILY_OF_THE_VALLEY_CROP = registerCropBlock("lily_of_the_valley");
        LILY_OF_THE_VALLEY_SEEDS = registerItem("lily_of_the_valley", LILY_OF_THE_VALLEY_CROP);
        ORANGE_TULIP_CROP = registerCropBlock("orange_tulip");
        ORANGE_TULIP_SEEDS = registerItem("orange_tulip", ORANGE_TULIP_CROP);
        OXEYE_DAISY_CROP = registerCropBlock("oxeye_daisy");
        OXEYE_DAISY_SEEDS = registerItem("oxeye_daisy", OXEYE_DAISY_CROP);
        PINK_TULIP_CROP = registerCropBlock("pink_tulip");
        PINK_TULIP_SEEDS = registerItem("pink_tulip", PINK_TULIP_CROP);
        POPPY_CROP = registerCropBlock("poppy");
        POPPY_SEEDS = registerItem("poppy", POPPY_CROP);
        RED_TULIP_CROP = registerCropBlock("red_tulip");
        RED_TULIP_SEEDS = registerItem("red_tulip", RED_TULIP_CROP);
        WHITE_TULIP_CROP = registerCropBlock("white_tulip");
        WHITE_TULIP_SEEDS = registerItem("white_tulip",WHITE_TULIP_CROP );
        WITHER_ROSE_CROP = registerCropBlock("wither_rose");
        WITHER_ROSE_SEEDS = registerItem("wither_rose", WITHER_ROSE_CROP);

        ALLIUM_SEEDLING = registerSeedling("allium_seedling");
        AZURE_BLUET_SEEDLING = registerSeedling("azure_bluet_seedling");
        BLUE_ORCHID_SEEDLING = registerSeedling("blue_orchid_seedling");
        CORNFLOWER_SEEDLING = registerSeedling("cornflower_seedling");
        DANDELION_SEEDLING = registerSeedling("dandelion_seedling");
        LILY_OF_THE_VALLEY_SEEDLING = registerSeedling("lily_of_the_valley_seedling");
        ORANGE_TULIP_SEEDLING = registerSeedling("orange_tulip_seedling");
        OXEYE_DAISY_SEEDLING = registerSeedling("oxeye_daisy_seedling");
        PINK_TULIP_SEEDLING = registerSeedling("pink_tulip_seedling");
        POPPY_SEEDLING = registerSeedling("poppy_seedling");
        RED_TULIP_SEEDLING = registerSeedling("red_tulip_seedling");
        WHITE_TULIP_SEEDLING = registerSeedling("white_tulip_seedling");
        WITHER_ROSE_SEEDLING = registerSeedling("wither_rose_seedling");
    }

    public static Block registerSeedling(String name){
        return net.minecraft.util.registry.Registry.register(net.minecraft.util.registry.Registry.BLOCK, Flowers.modID + ":" + name, new DandelionSeedlingBlock(AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly()));
    }

    public static Block registerCropBlock(String name){
        Block block = new FlowerCropBlock(name, AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
        crops.add(block);
        return net.minecraft.util.registry.Registry.register(net.minecraft.util.registry.Registry.BLOCK, Flowers.modID + ":" + name, block);
    }

    public static Item registerItem(String name, Block crop){
        Item item = new AliasedBlockItem(crop, new FabricItemSettings().group(ItemGroup.MISC));
        CompostingChanceRegistry.INSTANCE.add(item, 1.5f);
        seeds.add(item);
        return net.minecraft.util.registry.Registry.register(net.minecraft.util.registry.Registry.ITEM , Flowers.modID + ":" + name + "_seeds", item);
    }
}

