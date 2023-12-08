package games.twinhead.flowers.registry;

import games.twinhead.flowers.block.Flower;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.LocationCheckLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.world.biome.BiomeKeys;

public class LootTablesRegistry {

    public static void register(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && Blocks.GRASS.getLootTableId().equals(id)) {
                LootPool.Builder any = LootPool.builder()
                        .with(ItemEntry.builder(Flower.DANDELION.getSeeds()))
                        .with(ItemEntry.builder(Flower.POPPY.getSeeds()))
                        .conditionally(RandomChanceLootCondition.builder(0.10f));

                LootPool.Builder plains = LootPool.builder()
                        .with(ItemEntry.builder(Flower.AZURE_BLUET.getSeeds()))
                        .with(ItemEntry.builder(Flower.RED_TULIP.getSeeds()))
                        .with(ItemEntry.builder(Flower.PINK_TULIP.getSeeds()))
                        .with(ItemEntry.builder(Flower.WHITE_TULIP.getSeeds()))
                        .with(ItemEntry.builder(Flower.ORANGE_TULIP.getSeeds()))
                        .with(ItemEntry.builder(Flower.AZURE_BLUET.getSeeds()))
                        .with(ItemEntry.builder(Flower.OXEYE_DAISY.getSeeds()))
                        .with(ItemEntry.builder(Flower.CORNFLOWER.getSeeds()))
                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.PLAINS)))
                        .conditionally(RandomChanceLootCondition.builder(0.15f));

                LootPool.Builder sunflower_plains = LootPool.builder()
                        .with(ItemEntry.builder(Flower.AZURE_BLUET.getSeeds()))
                        .with(ItemEntry.builder(Flower.RED_TULIP.getSeeds()))
                        .with(ItemEntry.builder(Flower.PINK_TULIP.getSeeds()))
                        .with(ItemEntry.builder(Flower.WHITE_TULIP.getSeeds()))
                        .with(ItemEntry.builder(Flower.ORANGE_TULIP.getSeeds()))
                        .with(ItemEntry.builder(Flower.AZURE_BLUET.getSeeds()))
                        .with(ItemEntry.builder(Flower.OXEYE_DAISY.getSeeds()))
                        .with(ItemEntry.builder(Flower.CORNFLOWER.getSeeds()))
                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SUNFLOWER_PLAINS)))
                        .conditionally(RandomChanceLootCondition.builder(0.15f));

                LootPool.Builder swamp = LootPool.builder()
                        .with(ItemEntry.builder(Flower.BLUE_ORCHID.getSeeds()))
                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SWAMP)))
                        .conditionally(RandomChanceLootCondition.builder(0.15f));

                LootPool.Builder flower_forest = LootPool.builder()
                        .with(ItemEntry.builder(Flower.ALLIUM.getSeeds()))
                        .with(ItemEntry.builder(Flower.AZURE_BLUET.getSeeds()))
                        .with(ItemEntry.builder(Flower.RED_TULIP.getSeeds()))
                        .with(ItemEntry.builder(Flower.PINK_TULIP.getSeeds()))
                        .with(ItemEntry.builder(Flower.WHITE_TULIP.getSeeds()))
                        .with(ItemEntry.builder(Flower.ORANGE_TULIP.getSeeds()))
                        .with(ItemEntry.builder(Flower.AZURE_BLUET.getSeeds()))
                        .with(ItemEntry.builder(Flower.OXEYE_DAISY.getSeeds()))
                        .with(ItemEntry.builder(Flower.CORNFLOWER.getSeeds()))
                        .with(ItemEntry.builder(Flower.LILY_OF_THE_VALLEY.getSeeds()))
                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.FLOWER_FOREST)))
                        .conditionally(RandomChanceLootCondition.builder(0.30f));

                LootPool.Builder meadow = LootPool.builder()
                        .with(ItemEntry.builder(Flower.ALLIUM.getSeeds()))
                        .with(ItemEntry.builder(Flower.AZURE_BLUET.getSeeds()))
                        .with(ItemEntry.builder(Flower.OXEYE_DAISY.getSeeds()))
                        .with(ItemEntry.builder(Flower.CORNFLOWER.getSeeds()))
                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.MEADOW)))
                        .conditionally(RandomChanceLootCondition.builder(0.30f));

                tableBuilder.pool(any);
                tableBuilder.pool(plains);
                tableBuilder.pool(sunflower_plains);
                tableBuilder.pool(swamp);
                tableBuilder.pool(flower_forest);
                tableBuilder.pool(meadow);
            }

            if (source.isBuiltin() && EntityType.WITHER_SKELETON.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder()
                        .with(ItemEntry.builder(Flower.WITHER_ROSE.getSeeds()))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.125f, 0.05f)));
            }
        });
    }
}
