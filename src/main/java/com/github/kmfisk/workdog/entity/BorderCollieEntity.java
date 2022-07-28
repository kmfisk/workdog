package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.HerdingDogEntity;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class BorderCollieEntity extends HerdingDogEntity {
    public BorderCollieEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    @Override
    public int getVariants() {
        return 12;
    }

    public static AttributeModifierMap.MutableAttribute registerBorderCollieAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.30F).add(Attributes.MAX_HEALTH, 18.0F).add(Attributes.ATTACK_DAMAGE, 6.0F);
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity entity) {
        return null;
    }
}
