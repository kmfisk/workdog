package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.ToyDogEntity;
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

public class BostonTerrierEntity extends ToyDogEntity {
    public BostonTerrierEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.175F).add(Attributes.MAX_HEALTH, 6.0F).add(Attributes.ATTACK_DAMAGE, 1.0F);
    }

    @Override
    public int getVariantCount() {
        return 8;
    }

    @Override
    public String getVariantName() {
        switch (getVariant()) {
            case 0:
                return BostonTerrierVariant.BLACK.name();
            case 1:
                return BostonTerrierVariant.BLACK_AND_WHITE.name();
            case 2:
                return BostonTerrierVariant.BLUE.name();
            case 3:
                return BostonTerrierVariant.BRINDLE.name();
            case 4:
                return BostonTerrierVariant.BROWN.name();
            case 5:
                return BostonTerrierVariant.JADE_BLACK.name();
            case 6:
                return BostonTerrierVariant.LILAC.name();
            case 7:
                return BostonTerrierVariant.WHITE.name();
            default:
                throw new IllegalStateException("Unexpected Boston Terrier variant, value of: " + getVariant());
        }
    }

    @Override
    public int getCarriedVariant(String name) {
        int size = BostonTerrierVariant.getCarriedVariants(name).size();
        return BostonTerrierVariant.getCarriedVariants(name).get(random.nextInt(size));
    }

    @Override
    public boolean hasLonghairVariants() {
        return false;
    }

    @Override
    public float getLonghairChance() {
        return 0F;
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity entity) {
        BostonTerrierEntity baby = WorkDogEntities.BOSTON_TERRIER.create(world);
        if (baby != null) baby.setupChildVariant(this, (WorkDogEntity) entity);
        return baby;
    }

    public enum BostonTerrierVariant {
        BLACK(Arrays.asList(5, 3)),
        BLACK_AND_WHITE(Arrays.asList(5, 0)),
        BLUE(Arrays.asList(0, 6)),
        BRINDLE(Arrays.asList(0, 4)),
        BROWN(Arrays.asList(6, 7)),
        JADE_BLACK(Arrays.asList(0, 7)),
        LILAC(Arrays.asList(2, 7)),
        WHITE(Collections.singletonList(7));

        private final List<Integer> carries;

        BostonTerrierVariant(List<Integer> carries) {
            this.carries = carries;
        }

        public static List<Integer> getCarriedVariants(String name) {
            return BostonTerrierEntity.BostonTerrierVariant.valueOf(name).carries;
        }
    }
}
