package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.*;
import com.github.kmfisk.workdog.client.renderer.entity.model.*;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import com.github.kmfisk.workdog.item.WorkDogItems;
import com.github.kmfisk.workdog.item.WorkDogSpawnEggItem;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class WorkDogEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRAR = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, WorkDog.MOD_ID);
    private static final List<Tuple<RegistryObject<EntityType<? extends LivingEntity>>, Supplier<AttributeSupplier.Builder>>> ATTRIBUTES = new ArrayList<>();

    public static final RegistryObject<EntityType<WDWolfEntity>> WOLF = register("wolf", WDWolfEntity::new, MobCategory.CREATURE,
            WDWolfEntity::registerAttributes, 0.95F, 1.2F);
    public static final RegistryObject<EntityType<AkitaEntity>> AKITA = register("akita", AkitaEntity::new, MobCategory.CREATURE,
            AkitaEntity::registerAttributes, 0.95F, 1.3F);
    public static final RegistryObject<EntityType<BorderCollieEntity>> BORDER_COLLIE = register("border_collie", BorderCollieEntity::new, MobCategory.CREATURE,
            BorderCollieEntity::registerAttributes, 0.75F, 1.2F);
    public static final RegistryObject<EntityType<BostonTerrierEntity>> BOSTON_TERRIER = register("boston_terrier", BostonTerrierEntity::new, MobCategory.CREATURE,
            BostonTerrierEntity::registerAttributes, 0.55F, 0.95F);
    public static final RegistryObject<EntityType<GermanShepherdEntity>> GERMAN_SHEPHERD = register("german_shepherd", GermanShepherdEntity::new, MobCategory.CREATURE,
            GermanShepherdEntity::registerAttributes, 0.95F, 1.3F);
    public static final RegistryObject<EntityType<JackRussellTerrierEntity>> JACK_RUSSELL_TERRIER = register("jack_russell_terrier", JackRussellTerrierEntity::new, MobCategory.CREATURE,
            JackRussellTerrierEntity::registerAttributes, 0.55F, 0.95F);
    public static final RegistryObject<EntityType<PitBullEntity>> PIT_BULL = register("pit_bull", PitBullEntity::new, MobCategory.CREATURE,
            PitBullEntity::registerAttributes, 0.95F, 1.2F);

    public static void registerSpawnPlacements() {
        SpawnPlacements.register(WOLF.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WDWolfEntity::checkWolfSpawnRules);
        SpawnPlacements.register(AKITA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WorkDogEntity::checkAnimalSpawnRules);
        SpawnPlacements.register(BORDER_COLLIE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WorkDogEntity::checkAnimalSpawnRules);
        SpawnPlacements.register(BOSTON_TERRIER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WorkDogEntity::checkAnimalSpawnRules);
        SpawnPlacements.register(GERMAN_SHEPHERD.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WorkDogEntity::checkAnimalSpawnRules);
        SpawnPlacements.register(JACK_RUSSELL_TERRIER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WorkDogEntity::checkAnimalSpawnRules);
        SpawnPlacements.register(PIT_BULL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WorkDogEntity::checkAnimalSpawnRules);
    }

    public static void registerAttributes(BiConsumer<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> register) {
        for (Tuple<RegistryObject<EntityType<? extends LivingEntity>>, Supplier<AttributeSupplier.Builder>> attribute : ATTRIBUTES)
            register.accept(attribute.getA().get(), attribute.getB().get());

        ATTRIBUTES.clear();
    }

    public static void registerRenderers() {
        EntityRenderers.register(WOLF.get(), WDWolfRenderer::new);
        EntityRenderers.register(AKITA.get(), AkitaRenderer::new);
        EntityRenderers.register(BORDER_COLLIE.get(), BorderCollieRenderer::new);
        EntityRenderers.register(BOSTON_TERRIER.get(), BostonTerrierRenderer::new);
        EntityRenderers.register(GERMAN_SHEPHERD.get(), GermanShepherdRenderer::new);
        EntityRenderers.register(JACK_RUSSELL_TERRIER.get(), JackRussellTerrierRenderer::new);
        EntityRenderers.register(PIT_BULL.get(), PitBullRenderer::new);
    }

    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(WDWolfModel.ADULT_LAYER, WDWolfModel.Adult::createBodyLayer);
        event.registerLayerDefinition(WDWolfModel.BABY_LAYER, WDWolfModel.Baby::createBodyLayer);
        event.registerLayerDefinition(AkitaModel.ADULT_LAYER, AkitaModel.Adult::createBodyLayer);
        event.registerLayerDefinition(AkitaModel.EQUIPMENT_LAYER, AkitaModel.Adult::createBodyLayer);
        event.registerLayerDefinition(AkitaModel.BABY_LAYER, AkitaModel.Baby::createBodyLayer);
        event.registerLayerDefinition(BorderCollieModel.ADULT_LAYER, BorderCollieModel.Adult::createBodyLayer);
        event.registerLayerDefinition(BorderCollieModel.EQUIPMENT_LAYER, BorderCollieModel.Adult::createBodyLayer);
        event.registerLayerDefinition(BorderCollieModel.BABY_LAYER, BorderCollieModel.Baby::createBodyLayer);
        event.registerLayerDefinition(BostonTerrierModel.ADULT_LAYER, BostonTerrierModel.Adult::createBodyLayer);
        event.registerLayerDefinition(BostonTerrierModel.EQUIPMENT_LAYER, BostonTerrierModel.Adult::createBodyLayer);
        event.registerLayerDefinition(BostonTerrierModel.BABY_LAYER, BostonTerrierModel.Baby::createBodyLayer);
        event.registerLayerDefinition(GermanShepherdModel.ADULT_LAYER, GermanShepherdModel.Adult::createBodyLayer);
        event.registerLayerDefinition(GermanShepherdModel.EQUIPMENT_LAYER, GermanShepherdModel.Adult::createBodyLayer);
        event.registerLayerDefinition(GermanShepherdModel.BABY_LAYER, GermanShepherdModel.Baby::createBodyLayer);
        event.registerLayerDefinition(JackRussellTerrierModel.ADULT_LAYER, JackRussellTerrierModel.Adult::createBodyLayer);
        event.registerLayerDefinition(JackRussellTerrierModel.EQUIPMENT_LAYER, JackRussellTerrierModel.Adult::createBodyLayer);
        event.registerLayerDefinition(JackRussellTerrierModel.BABY_LAYER, JackRussellTerrierModel.Baby::createBodyLayer);
        event.registerLayerDefinition(PitBullModel.ADULT_LAYER, PitBullModel.Adult::createBodyLayer);
        event.registerLayerDefinition(PitBullModel.EQUIPMENT_LAYER, PitBullModel.Adult::createBodyLayer);
        event.registerLayerDefinition(PitBullModel.BABY_LAYER, PitBullModel.Baby::createBodyLayer);
    }

    @SuppressWarnings("unchecked")
    private static <T, F> T cast(F from) {
        return (T) from;
    }

    private static <T extends Mob> RegistryObject<EntityType<T>> register(String name, EntityType.EntityFactory<T> factory, MobCategory classification, Supplier<AttributeSupplier.Builder> attributes, float width, float height) {
        RegistryObject<EntityType<T>> registryObject = REGISTRAR.register(name, () -> EntityType.Builder.of(factory, classification).sized(width, height).clientTrackingRange(10).build(name));
        if (attributes != null) ATTRIBUTES.add(new Tuple<>(cast(registryObject), attributes));
        WorkDogItems.REGISTRAR.register(name + "_spawn_egg", () -> new WorkDogSpawnEggItem(registryObject, new Item.Properties()));
        return registryObject;
    }
}
