package games.twinhead.flowers;

import games.twinhead.flowers.entity.EntityRegistry;
import games.twinhead.flowers.entity.Villager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.LocationCheckLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Flowers implements ModInitializer {
    public static final String modID = "flowers";

    public static final Logger LOGGER = LoggerFactory.getLogger(modID);

    @Override
    public void onInitialize() {
        Registry.register();
        EntityRegistry.register();

        Flowers.LOGGER.debug("Pre Villagers ++++++++++++++");
        Villager.register();
        Villager.registerTrades();
        LootTables();
    }

    private static final Identifier GRASS_LOOT_TABLE_ID = Blocks.GRASS.getLootTableId();
    private static final Identifier WITHER_SKELETON_LOOT_TABLE_ID = EntityType.WITHER_SKELETON.getLootTableId();

    public void LootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            // Let's only modify built-in loot tables and leave data pack loot tables untouched by checking the source.
            // We also check that the loot table ID is equal to the ID we want.
            if (source.isBuiltin() && GRASS_LOOT_TABLE_ID.equals(id)) {
                LootPool.Builder any = LootPool.builder()
                        .with(ItemEntry.builder(Registry.DANDELION_SEEDS))
                        .with(ItemEntry.builder(Registry.POPPY_SEEDS))
                        .conditionally(RandomChanceLootCondition.builder(0.10f));

                LootPool.Builder plains = LootPool.builder()
                        .with(ItemEntry.builder(Registry.AZURE_BLUET_SEEDS))
                        .with(ItemEntry.builder(Registry.RED_TULIP_SEEDS))
                        .with(ItemEntry.builder(Registry.PINK_TULIP_SEEDS))
                        .with(ItemEntry.builder(Registry.WHITE_TULIP_SEEDS))
                        .with(ItemEntry.builder(Registry.ORANGE_TULIP_SEEDS))
                        .with(ItemEntry.builder(Registry.AZURE_BLUET_SEEDS))
                        .with(ItemEntry.builder(Registry.OXEYE_DAISY_SEEDS))
                        .with(ItemEntry.builder(Registry.CORNFLOWER_SEEDS))
                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.PLAINS)))
                        .conditionally(RandomChanceLootCondition.builder(0.15f));

                LootPool.Builder sunflower_plains = LootPool.builder()
                        .with(ItemEntry.builder(Registry.AZURE_BLUET_SEEDS))
                        .with(ItemEntry.builder(Registry.RED_TULIP_SEEDS))
                        .with(ItemEntry.builder(Registry.PINK_TULIP_SEEDS))
                        .with(ItemEntry.builder(Registry.WHITE_TULIP_SEEDS))
                        .with(ItemEntry.builder(Registry.ORANGE_TULIP_SEEDS))
                        .with(ItemEntry.builder(Registry.AZURE_BLUET_SEEDS))
                        .with(ItemEntry.builder(Registry.OXEYE_DAISY_SEEDS))
                        .with(ItemEntry.builder(Registry.CORNFLOWER_SEEDS))
                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SUNFLOWER_PLAINS)))
                        .conditionally(RandomChanceLootCondition.builder(0.15f));

                LootPool.Builder swamp = LootPool.builder()
                        .with(ItemEntry.builder(Registry.BLUE_ORCHID_SEEDS))
                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SWAMP)))
                        .conditionally(RandomChanceLootCondition.builder(0.15f));

                LootPool.Builder flower_forest = LootPool.builder()
                        .with(ItemEntry.builder(Registry.ALLIUM_SEEDS))
                        .with(ItemEntry.builder(Registry.AZURE_BLUET_SEEDS))
                        .with(ItemEntry.builder(Registry.RED_TULIP_SEEDS))
                        .with(ItemEntry.builder(Registry.PINK_TULIP_SEEDS))
                        .with(ItemEntry.builder(Registry.WHITE_TULIP_SEEDS))
                        .with(ItemEntry.builder(Registry.ORANGE_TULIP_SEEDS))
                        .with(ItemEntry.builder(Registry.AZURE_BLUET_SEEDS))
                        .with(ItemEntry.builder(Registry.OXEYE_DAISY_SEEDS))
                        .with(ItemEntry.builder(Registry.CORNFLOWER_SEEDS))
                        .with(ItemEntry.builder(Registry.LILY_OF_THE_VALLEY_SEEDS))
                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.FLOWER_FOREST)))
                        .conditionally(RandomChanceLootCondition.builder(0.30f));

                LootPool.Builder meadow = LootPool.builder()
                        .with(ItemEntry.builder(Registry.ALLIUM_SEEDS))
                        .with(ItemEntry.builder(Registry.AZURE_BLUET_SEEDS))
                        .with(ItemEntry.builder(Registry.OXEYE_DAISY_SEEDS))
                        .with(ItemEntry.builder(Registry.CORNFLOWER_SEEDS))
                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.MEADOW)))
                        .conditionally(RandomChanceLootCondition.builder(0.30f));

                tableBuilder.pool(any);
                tableBuilder.pool(plains);
                tableBuilder.pool(sunflower_plains);
                tableBuilder.pool(swamp);
                tableBuilder.pool(flower_forest);
                tableBuilder.pool(meadow);
            }

            if (source.isBuiltin() && WITHER_SKELETON_LOOT_TABLE_ID.equals(id)) {
                LootPool.Builder wither_rose_seeds = LootPool.builder()
                        .with(ItemEntry.builder(Registry.WITHER_ROSE_SEEDS))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.5f, 0.05f));
                tableBuilder.pool(wither_rose_seeds);
            }
        });


    }
}
