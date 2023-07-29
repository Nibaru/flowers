package games.twinhead.flowers;


import games.twinhead.flowers.entity.EntityRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.block.*;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

import java.util.*;

public class BlockRegistry {
    public static HashMap<Flower, Block> CROPS = new HashMap<>();
    public static HashMap<Flower, Block> SEEDLINGS = new HashMap<>();
    public static HashMap<Flower, Item> SEEDS = new HashMap<>();

    public static Item MOOBLOOM_SPAWN_EGG = Registry.register(Registries.ITEM , Flowers.modID + ":moobloom_spawn_egg", new SpawnEggItem(EntityRegistry.MOOBLOOM, 16569344, 16313793, new FabricItemSettings()));

    public static void register(){

        for (Flower flower: Flower.values()) {
            registerSeedling(flower);
            registerCropBlock(flower);
            registerItem(flower);
        }

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(MOOBLOOM_SPAWN_EGG));
    }

    public static void registerSeedling(Flower flower){
        SeedlingBlock seedling = new SeedlingBlock(AbstractBlock.Settings.copy(flower.parent).noCollision().ticksRandomly().breakInstantly());
        SEEDLINGS.put(flower, seedling);
        Registry.register(Registries.BLOCK, Flowers.modID + ":" + flower.toString() + "_seedling", seedling);
    }

    public static void registerCropBlock(Flower flower){
        Block block = new FlowerCropBlock(flower.toString(), FabricBlockSettings.create().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
        CROPS.put(flower, block);
        Registry.register(Registries.BLOCK, Flowers.modID + ":" + flower, block);
    }

    public static void registerItem(Flower flower){
        Item item = new AliasedBlockItem(flower.getCrop(), new FabricItemSettings());
        CompostingChanceRegistry.INSTANCE.add(item, 1.5f);
        SEEDS.put(flower, item);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> content.add(item));

        Registry.register(Registries.ITEM, Flowers.modID + ":" + flower.toString() + "_seeds", item);
    }
}

