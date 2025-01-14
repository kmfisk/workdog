package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.*;
import com.github.kmfisk.workdog.client.renderer.entity.model.*;
import com.github.kmfisk.workdog.item.WorkDogItems;
import com.github.kmfisk.workdog.item.WorkDogSpawnEggItem;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.util.thread.EffectiveSide;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class WorkDogEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRAR = DeferredRegister.create(ForgeRegistries.ENTITIES, WorkDog.MOD_ID);
    private static final List<Tuple<EntityType<? extends LivingEntity>, Supplier<AttributeSupplier.Builder>>> ATTRIBUTES = new ArrayList<>();
    private static final List<Tuple<EntityType<?>, Supplier<EntityRendererProvider<?>>>> RENDERERS = new ArrayList<>();

    public static final EntityType<WDWolfEntity> WOLF = register("wolf", WDWolfEntity::new, MobCategory.CREATURE,
            WDWolfEntity::registerAttributes, () -> WDWolfRenderer::new, 0.95F, 1.2F);
    public static final EntityType<AkitaEntity> AKITA = register("akita", AkitaEntity::new, MobCategory.CREATURE,
            AkitaEntity::registerAttributes, () -> AkitaRenderer::new, 0.95F, 1.3F);
    public static final EntityType<BorderCollieEntity> BORDER_COLLIE = register("border_collie", BorderCollieEntity::new, MobCategory.CREATURE,
            BorderCollieEntity::registerAttributes, () -> BorderCollieRenderer::new, 0.75F, 1.2F);
    public static final EntityType<BostonTerrierEntity> BOSTON_TERRIER = register("boston_terrier", BostonTerrierEntity::new, MobCategory.CREATURE,
            BostonTerrierEntity::registerAttributes, () -> BostonTerrierRenderer::new, 0.55F, 0.95F);
    public static final EntityType<GermanShepherdEntity> GERMAN_SHEPHERD = register("german_shepherd", GermanShepherdEntity::new, MobCategory.CREATURE,
            GermanShepherdEntity::registerAttributes, () -> GermanShepherdRenderer::new, 0.95F, 1.3F);
    public static final EntityType<JackRussellTerrierEntity> JACK_RUSSELL_TERRIER = register("jack_russell_terrier", JackRussellTerrierEntity::new, MobCategory.CREATURE,
            JackRussellTerrierEntity::registerAttributes, () -> JackRussellTerrierRenderer::new, 0.55F, 0.95F);
    public static final EntityType<PitBullEntity> PIT_BULL = register("pit_bull", PitBullEntity::new, MobCategory.CREATURE,
            PitBullEntity::registerAttributes, () -> PitBullRenderer::new, 0.95F, 1.2F);

    public static void registerSpawnPlacements() {
        SpawnPlacements.register(WOLF, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WDWolfEntity::checkWolfSpawnRules);
    }

    public static void registerAttributes(BiConsumer<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> register) {
        for (Tuple<EntityType<? extends LivingEntity>, Supplier<AttributeSupplier.Builder>> attribute : ATTRIBUTES)
            register.accept(attribute.getA(), attribute.getB().get());

        ATTRIBUTES.clear();
    }

    public static void registerRenderers() {
        for (Tuple<EntityType<?>, Supplier<EntityRendererProvider<?>>> renderer : RENDERERS)
            EntityRenderers.register(renderer.getA(), cast(renderer.getB().get()));

        RENDERERS.clear();
    }

    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(WDWolfModel.ADULT_LAYER, WDWolfModel.Adult::createBodyLayer);
        event.registerLayerDefinition(WDWolfModel.BABY_LAYER, WDWolfModel.Baby::createBodyLayer);
        event.registerLayerDefinition(AkitaModel.ADULT_LAYER, AkitaModel.Adult::createBodyLayer);
        event.registerLayerDefinition(AkitaModel.BABY_LAYER, AkitaModel.Baby::createBodyLayer);
        event.registerLayerDefinition(BorderCollieModel.ADULT_LAYER, BorderCollieModel.Adult::createBodyLayer);
        event.registerLayerDefinition(BorderCollieModel.BABY_LAYER, BorderCollieModel.Baby::createBodyLayer);
        event.registerLayerDefinition(BostonTerrierModel.ADULT_LAYER, BostonTerrierModel.Adult::createBodyLayer);
        event.registerLayerDefinition(BostonTerrierModel.BABY_LAYER, BostonTerrierModel.Baby::createBodyLayer);
        event.registerLayerDefinition(GermanShepherdModel.ADULT_LAYER, GermanShepherdModel.Adult::createBodyLayer);
        event.registerLayerDefinition(GermanShepherdModel.BABY_LAYER, GermanShepherdModel.Baby::createBodyLayer);
        event.registerLayerDefinition(JackRussellTerrierModel.ADULT_LAYER, JackRussellTerrierModel.Adult::createBodyLayer);
        event.registerLayerDefinition(JackRussellTerrierModel.BABY_LAYER, JackRussellTerrierModel.Baby::createBodyLayer);
        event.registerLayerDefinition(PitBullModel.ADULT_LAYER, PitBullModel.Adult::createBodyLayer);
        event.registerLayerDefinition(PitBullModel.BABY_LAYER, PitBullModel.Baby::createBodyLayer);
    }

    @SuppressWarnings("unchecked")
    private static <T, F> T cast(F from) {
        return (T) from;
    }

    private static <T extends Entity> EntityType<T> register(String name, EntityType.EntityFactory<T> factory, MobCategory classification, Supplier<AttributeSupplier.Builder> attributes, Supplier<EntityRendererProvider<? super T>> renderer, float width, float height) {
        EntityType<T> type = EntityType.Builder.of(factory, classification).sized(width, height).clientTrackingRange(10).build(name);
        REGISTRAR.register(name, () -> type);
        if (attributes != null) ATTRIBUTES.add(new Tuple<>(cast(type), attributes));
        if (EffectiveSide.get().isClient() && renderer != null) RENDERERS.add(new Tuple<>(cast(type), cast(renderer)));
        WorkDogItems.SPAWN_EGGS.put(type, WorkDogItems.REGISTRAR.register(name + "_spawn_egg", () -> new WorkDogSpawnEggItem(() -> (EntityType<? extends Mob>) type, new Item.Properties().tab(WorkDog.ITEM_GROUP))));
        return type;
    }
}
