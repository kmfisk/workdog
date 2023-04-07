package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.*;
import com.github.kmfisk.workdog.item.WorkDogItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.item.Item;
import net.minecraft.util.Tuple;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.thread.EffectiveSide;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class WorkDogEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRAR = DeferredRegister.create(ForgeRegistries.ENTITIES, WorkDog.MOD_ID);
    private static final List<Tuple<EntityType<? extends LivingEntity>, Supplier<AttributeModifierMap.MutableAttribute>>> ATTRIBUTES = new ArrayList<>();
    private static final List<Tuple<EntityType<?>, Supplier<IRenderFactory<?>>>> RENDERERS = new ArrayList<>();

    public static final EntityType<AkitaEntity> AKITA = register("akita", AkitaEntity::new, EntityClassification.CREATURE, AkitaEntity::registerAttributes, () -> AkitaRenderer::new, 1.0F, 1.0F);
    public static final EntityType<BorderCollieEntity> BORDER_COLLIE = register("border_collie", BorderCollieEntity::new, EntityClassification.CREATURE, BorderCollieEntity::registerAttributes, () -> BorderCollieRenderer::new, 1.0F, 1.0F);
    public static final EntityType<BostonTerrierEntity> BOSTON_TERRIER = register("boston_terrier", BostonTerrierEntity::new, EntityClassification.CREATURE, BostonTerrierEntity::registerAttributes, () -> BostonTerrierRenderer::new, 1.0F, 1.0F);
    public static final EntityType<GermanShepherdEntity> GERMAN_SHEPHERD = register("german_shepherd", GermanShepherdEntity::new, EntityClassification.CREATURE, GermanShepherdEntity::registerAttributes, () -> GermanShepherdRenderer::new, 1.0F, 1.0F);
    public static final EntityType<JackRussellTerrierEntity> JACK_RUSSELL_TERRIER = register("jack_russell_terrier", JackRussellTerrierEntity::new, EntityClassification.CREATURE, JackRussellTerrierEntity::registerAttributes, () -> JackRussellTerrierRenderer::new, 1.0F, 1.0F);
    public static final EntityType<PitBullEntity> PIT_BULL = register("pit_bull", PitBullEntity::new, EntityClassification.CREATURE, PitBullEntity::registerAttributes, () -> PitBullRenderer::new, 1.0F, 1.0F);
    public static final EntityType<WDWolfEntity> WOLF = register("wolf", WDWolfEntity::new, EntityClassification.CREATURE, WDWolfEntity::registerAttributes, () -> WDWolfRenderer::new, 1.0F, 1.0F);

    public static void registerSpawnPlacements() {
        EntitySpawnPlacementRegistry.register(WOLF, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WDWolfEntity::checkWolfSpawnRules);
    }

    public static void registerAttributes(BiConsumer<EntityType<? extends LivingEntity>, AttributeModifierMap.MutableAttribute> register) {
        for (Tuple<EntityType<? extends LivingEntity>, Supplier<AttributeModifierMap.MutableAttribute>> attribute : ATTRIBUTES)
            register.accept(attribute.getA(), attribute.getB().get());

        ATTRIBUTES.clear();
    }

    public static void registerRenderers() {
        for (Tuple<EntityType<?>, Supplier<IRenderFactory<?>>> renderer : RENDERERS)
            RenderingRegistry.registerEntityRenderingHandler(renderer.getA(), cast(renderer.getB().get()));

        RENDERERS.clear();
    }

    @SuppressWarnings("unchecked")
    private static <T, F> T cast(F from) {
        return (T) from;
    }

    private static <T extends Entity> EntityType<T> register(String name, EntityType.IFactory<T> factory, EntityClassification classification, Supplier<AttributeModifierMap.MutableAttribute> attributes, Supplier<IRenderFactory<? super T>> renderer, float width, float height) {
        EntityType<T> type = EntityType.Builder.of(factory, classification).sized(width, height).clientTrackingRange(10).build(name);
        REGISTRAR.register(name, () -> type);
        if (attributes != null) ATTRIBUTES.add(new Tuple<>(cast(type), attributes));
        if (EffectiveSide.get().isClient() && renderer != null) RENDERERS.add(new Tuple<>(cast(type), cast(renderer)));
        WorkDogItems.REGISTRAR.register(name + "_spawn_egg", () -> new ForgeSpawnEggItem(() -> type, 0xFFFFFF, 0xFFFFFF, new Item.Properties().tab(WorkDog.ITEM_GROUP)));
        return type;
    }
}
