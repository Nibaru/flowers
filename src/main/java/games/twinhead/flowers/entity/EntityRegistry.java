package games.twinhead.flowers.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class EntityRegistry {

    public static final EntityType<MoobloomEntity> MOOBLOOM = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("flowers", "moobloom"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MoobloomEntity::new).dimensions(EntityDimensions.changing(0.9f, 1.5f)).build());





    public static void register(){
        FabricDefaultAttributeRegistry.register(MOOBLOOM, MoobloomEntity.createCowAttributes());

        addEntitySpawn();
    }

    public static void addEntitySpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST, BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.MEADOW),
                SpawnGroup.CREATURE, MOOBLOOM, 25, 2, 5);


    }
}
