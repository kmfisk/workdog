package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.WorkingDogs;
import com.github.kmfisk.workdog.entity.BorderCollieEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<BorderCollieEntity> BORDER_COLLIE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(WorkingDogs.MOD_ID, "border_collie"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BorderCollieEntity::new).dimensions(EntityDimensions.fixed(0.8f, 1.0f)).build()
    );
}
