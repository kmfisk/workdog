package com.github.kmfisk.workdog;

import com.github.kmfisk.workdog.client.render.entity.BorderCollieRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

import static com.github.kmfisk.workdog.init.ModEntities.BORDER_COLLIE;

@Environment(EnvType.CLIENT)
public class WorkingDogsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(BORDER_COLLIE, ((entityRenderDispatcher, context) -> new BorderCollieRenderer(entityRenderDispatcher)));
    }
}
