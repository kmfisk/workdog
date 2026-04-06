package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.HuntingDogEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AkitaEntity extends HuntingDogEntity {
    public AkitaEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.25F).add(Attributes.MAX_HEALTH, 20.0F).add(Attributes.ATTACK_DAMAGE, 5.0F);
    }

    @Override
    public int getVariantCount() {
        return 21;
    }

    @Override
    public int getCarriedVariant(int variant) {
        int size = AkitaVariant.getCarriedVariants(variant).size();
        return AkitaVariant.getCarriedVariants(variant).get(random.nextInt(size));
    }

    @Override
    public boolean hasLonghairVariants() {
        return false;
    }

    @Override
    public float getLonghairChance() {
        return 1.0F;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob entity) {
        return WorkDogEntities.AKITA.get().create(world);
    }

    @Override
    public int getLootingLevel() {
        return 2;
    }

    public enum AkitaVariant {
        BLACK(Arrays.asList(2, 5)),
        BLACK_WHITE_SOCKS(Arrays.asList(2, 3)),
        BLACK_PINTO(Arrays.asList(1, 4)),
        BLACK_BROWN_PINTO(Arrays.asList(4, 6)),
        BLACK_TAN_PINTO(Arrays.asList(8, 12)),
        BLACK_BRINDLE(Arrays.asList(0, 11)),
        BROWN_BRINDLE(Arrays.asList(17, 7)),
        BROWN_PINTO(Arrays.asList(3, 2)),
        FAWN(Arrays.asList(9, 10)),
        FAWN_BRINDLE(Arrays.asList(10, 15)),
        FAWN_PINTO(Arrays.asList(4, 16)),
        GRAY_BRINDLE(Arrays.asList(13, 17)),
        GRAY_PINTO(Collections.singletonList(11)),
        SILVER_BRINDLE(Arrays.asList(14, 15)),
        SILVER_PINTO(Arrays.asList(20, 10)),
        TAN_BRINDLE(Arrays.asList(18, 19)),
        TAN_PINTO(Arrays.asList(4, 3)),
        TIGER_BRINDLE(Arrays.asList(11, 15)),
        RED_SESAME(Arrays.asList(19, 17)),
        GOLD_SESAME(Arrays.asList(18, 16)),
        WHITE(Collections.singletonList(20)),
        ALBINISTIC(Collections.singletonList(20)),
        MELANISTIC(Collections.singletonList(0));

        private final List<Integer> carries;

        AkitaVariant(List<Integer> carries) {
            this.carries = carries;
        }

        public static List<Integer> getCarriedVariants(int variant) {
            return AkitaVariant.values()[variant].carries;
        }
    }

    @Override
    public int getInventoryColumns() {
        return 9; // todo (large= 27, 9 columns; medium= 18, 6 columns; small= 9, 3 columns)
    }

    @Override
    public boolean canWearDogEquipmentType(DogEquipmentType dogEquipmentType) {
        return true;
    }
}
