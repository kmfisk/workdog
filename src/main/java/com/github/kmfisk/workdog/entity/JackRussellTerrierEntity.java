package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.TerrierDogEntity;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JackRussellTerrierEntity extends TerrierDogEntity {
    public JackRussellTerrierEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.30F).add(Attributes.MAX_HEALTH, 18.0F).add(Attributes.ATTACK_DAMAGE, 6.0F);
    }

    @Override
    public int getVariantCount() {
        return 9;
    }

    @Override
    public String getVariantName() {
        switch (getVariant()) {
            case 0:
                return JackRussellTerrierVariant.BLACK.name();
            case 1:
                return JackRussellTerrierVariant.BLACK_AND_TAN.name();
            case 2:
                return JackRussellTerrierVariant.BROWN_EARS.name();
            case 3:
                return JackRussellTerrierVariant.BROWN_FACE.name();
            case 4:
                return JackRussellTerrierVariant.BROWN_SADDLE.name();
            case 5:
                return JackRussellTerrierVariant.HEAVY_TRI.name();
            case 6:
                return JackRussellTerrierVariant.MID_TRI.name();
            case 7:
                return JackRussellTerrierVariant.LIGHT_TRI.name();
            case 8:
                return JackRussellTerrierVariant.WHITE.name();
            default:
                throw new IllegalStateException("Unexpected Jack Russell Terrier variant, value of: " + getVariant());
        }
    }

    @Override
    public int getCarriedVariant(String name) {
        int size = JackRussellTerrierVariant.getCarriedVariants(name).size();
        return JackRussellTerrierVariant.getCarriedVariants(name).get(random.nextInt(size));
    }

    @Override
    public boolean hasLonghairVariants() {
        return true;
    }

    @Override
    public float getLonghairChance() {
        return 0.08F;
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity entity) {
        JackRussellTerrierEntity baby = WorkDogEntities.JACK_RUSSELL_TERRIER.create(world);
        if (baby != null) baby.setupChildVariant(this, (WorkDogEntity) entity);
        return baby;
    }

    public enum JackRussellTerrierVariant {
        BLACK(Collections.singletonList(1)),
        BLACK_AND_TAN(Arrays.asList(0, 5)),
        BROWN_EARS(Arrays.asList(3, 4)),
        BROWN_FACE(Arrays.asList(2, 7)),
        BROWN_SADDLE(Arrays.asList(5, 7)),
        HEAVY_TRI(Arrays.asList(1, 7)),
        MID_TRI(Arrays.asList(5, 7)),
        LIGHT_TRI(Arrays.asList(8, 5)),
        WHITE(Collections.singletonList(8));

        private final List<Integer> carries;

        JackRussellTerrierVariant(List<Integer> carries) {
            this.carries = carries;
        }

        public static List<Integer> getCarriedVariants(String name) {
            return JackRussellTerrierEntity.JackRussellTerrierVariant.valueOf(name).carries;
        }
    }
}
