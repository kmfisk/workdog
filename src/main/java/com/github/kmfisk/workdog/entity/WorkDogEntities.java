package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.WorkingDogs;
import com.github.kmfisk.workdog.client.renderer.entity.*;
import com.github.kmfisk.workdog.item.WorkDogItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.item.Item;
import net.minecraft.util.Tuple;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.thread.EffectiveSide;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class WorkDogEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRAR = DeferredRegister.create(ForgeRegistries.ENTITIES, WorkingDogs.MOD_ID);
    private static final List<Tuple<Supplier<EntityType<? extends LivingEntity>>, Supplier<AttributeModifierMap.MutableAttribute>>> ATTRIBUTES = new ArrayList<>();
    private static final List<Tuple<Supplier<EntityType<?>>, Supplier<IRenderFactory<?>>>> RENDERERS = new ArrayList<>();

    public static final RegistryObject<EntityType<AkitaEntity>> AKITA = new Builder<>(AkitaEntity::new, EntityClassification.CREATURE)
            .attributes(AkitaEntity::registerAttributes)
            .renderer(() -> AkitaRenderer::new)
            .data(builder -> builder.sized(1.0f, 1.0f).clientTrackingRange(10))
            .build(REGISTRAR, "akita");

    public static final RegistryObject<EntityType<BorderCollieEntity>> BORDER_COLLIE = new Builder<>(BorderCollieEntity::new, EntityClassification.CREATURE)
            .attributes(BorderCollieEntity::registerAttributes)
            .renderer(() -> BorderCollieRenderer::new)
            .data(builder -> builder.sized(1.0f, 1.0f).clientTrackingRange(10))
            .build(REGISTRAR, "border_collie");

    public static final RegistryObject<EntityType<GermanShepherdEntity>> GERMAN_SHEPHERD = new Builder<>(GermanShepherdEntity::new, EntityClassification.CREATURE)
            .attributes(GermanShepherdEntity::registerAttributes)
            .renderer(() -> GermanShepherdRenderer::new)
            .data(builder -> builder.sized(1.0f, 1.0f).clientTrackingRange(10))
            .build(REGISTRAR, "german_shepherd");

    public static final RegistryObject<EntityType<JackRussellTerrierEntity>> JACK_RUSSELL_TERRIER = new Builder<>(JackRussellTerrierEntity::new, EntityClassification.CREATURE)
            .attributes(JackRussellTerrierEntity::registerAttributes)
            .renderer(() -> JackRussellTerrierRenderer::new)
            .data(builder -> builder.sized(1.0f, 1.0f).clientTrackingRange(10))
            .build(REGISTRAR, "jack_russell_terrier");

    public static final RegistryObject<EntityType<WDWolfEntity>> WOLF = new Builder<>(WDWolfEntity::new, EntityClassification.CREATURE)
            .attributes(WDWolfEntity::registerAttributes)
            .renderer(() -> WDWolfRenderer::new)
            .data(builder -> builder.sized(1.0f, 1.0f).clientTrackingRange(10))
            .build(REGISTRAR, "wolf");

    public static void registerAttributes(BiConsumer<EntityType<? extends LivingEntity>, AttributeModifierMap.MutableAttribute> register) {
        for (Tuple<Supplier<EntityType<? extends LivingEntity>>, Supplier<AttributeModifierMap.MutableAttribute>> attribute : ATTRIBUTES) {
            register.accept(attribute.getA().get(), attribute.getB().get());
        }
        ATTRIBUTES.clear();
    }

    public static void registerRenderers() {
        for (Tuple<Supplier<EntityType<?>>, Supplier<IRenderFactory<?>>> renderer : RENDERERS) {
            RenderingRegistry.registerEntityRenderingHandler(renderer.getA().get(), cast(renderer.getB().get()));
        }
        RENDERERS.clear();
    }

    @SuppressWarnings("unchecked")
    private static <T, F> T cast(F from) {
        return (T) from;
    }

    public static class Builder<T extends Entity> {
        private final EntityType.IFactory<T> factory;
        private final EntityClassification category;
        private Supplier<AttributeModifierMap.MutableAttribute> attributes;
        private Supplier<IRenderFactory<? super T>> renderer;
        private boolean noSpawnEgg = false;
        private Consumer<EntityType.Builder<T>> builderConsumer;
        private int spawnChance;
        private int minGroup;
        private int maxGroup;

        public Builder(EntityType.IFactory<T> factory, EntityClassification category) {
            this.factory = factory;
            this.category = category;
        }

        public Builder<T> attributes(Supplier<AttributeModifierMap.MutableAttribute> attributes) {
            this.attributes = attributes;
            return this;
        }

        public Builder<T> renderer(Supplier<IRenderFactory<? super T>> renderer) {
            this.renderer = renderer;
            return this;
        }

        public Builder<T> noSpawnEgg() {
            this.noSpawnEgg = true;
            return this;
        }

        public Builder<T> data(Consumer<EntityType.Builder<T>> consumer) {
            builderConsumer = consumer;
            return this;
        }

        public RegistryObject<EntityType<T>> build(DeferredRegister<EntityType<?>> registrar, String name) {
            final RegistryObject<EntityType<T>> type = registrar.register(name, () -> {
                final EntityType.Builder<T> entityBuilder = EntityType.Builder.of(factory, category);
                if (builderConsumer != null) builderConsumer.accept(entityBuilder);
                return entityBuilder.build(WorkingDogs.MOD_ID + "." + name);
            });

            if (attributes != null) {
                ATTRIBUTES.add(new Tuple<>(cast(type), attributes));
            }

            if (EffectiveSide.get().isClient() && renderer != null) {
                RENDERERS.add(new Tuple<>(cast(type), cast(renderer)));
            }

            if (!noSpawnEgg)
                WorkDogItems.REGISTRAR.register(name + "_spawn_egg", () -> new ForgeSpawnEggItem(type, 0xFFFFFF, 0xFFFFFF, new Item.Properties().tab(WorkingDogs.ITEM_GROUP)));

            return type;
        }
    }
}
