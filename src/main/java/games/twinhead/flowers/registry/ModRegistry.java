package games.twinhead.flowers.registry;

import games.twinhead.flowers.Flowers;
import games.twinhead.flowers.block.Flower;
import games.twinhead.flowers.block.FlowerCropBlock;
import games.twinhead.flowers.block.SeedlingBlock;
import games.twinhead.flowers.entity.EntityRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.block.*;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import java.util.*;

public class ModRegistry {
    public static HashMap<Flower, Block> CROPS = new HashMap<>();
    public static HashMap<Flower, Block> SEEDLINGS = new HashMap<>();
    public static HashMap<Flower, Item> SEEDS = new HashMap<>();

    public static Item MOOBLOOM_SPAWN_EGG = Registry.register(Registry.ITEM , Flowers.MOD_ID + ":moobloom_spawn_egg", new SpawnEggItem(EntityRegistry.MOOBLOOM, 16569344, 16313793, new FabricItemSettings().group(ItemGroup.MISC)));

    public static void register(){
        for (Flower flower: Flower.values()) {
            registerSeedling(flower);
            registerCropBlock(flower);
            registerItem(flower);
        }
    }

    public static void registerSeedling(Flower flower){
        SEEDLINGS.put(flower, Registry.register(Registry.BLOCK, Flowers.MOD_ID + ":" + flower.toString() + "_seedling",
                 new SeedlingBlock(FabricBlockSettings.copy(flower.getParent()).noCollision().ticksRandomly().breakInstantly())));
    }

    public static void registerCropBlock(Flower flower){
        CROPS.put(flower, Registry.register(Registry.BLOCK, Flowers.MOD_ID + ":" + flower,
                new FlowerCropBlock(flower.toString(), FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP))));
    }

    public static void registerItem(Flower flower){
        Item item = new AliasedBlockItem(flower.getCrop(), new FabricItemSettings());
                SEEDS.put(flower,Registry.register(Registry.ITEM, Flowers.MOD_ID + ":" + flower + "_seeds", item));

        CompostingChanceRegistry.INSTANCE.add(item, 1.5f);
    }
}