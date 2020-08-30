package net.soggymustache.workingdogs.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public interface IBabyModel<T extends Entity> {

	ModelBase getBabyModel();

	ResourceLocation getBabyTexture(T entity);

}
