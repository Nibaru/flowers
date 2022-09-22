package games.twinhead.flowers.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityRegistry {

    public static final EntityType<MoobloomEntity> MOOBLOOM = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("flowers", "moobloom"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MoobloomEntity::new).dimensions(EntityDimensions.changing(0.9f, 1.5f)).build());





    public static void register(){
        FabricDefaultAttributeRegistry.register(MOOBLOOM, MoobloomEntity.createCowAttributes());
    }
}
