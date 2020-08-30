package net.soggymustache.workingdogs.common.entity.type;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;
import net.soggymustache.workingdogs.common.entity.DogData;
import net.soggymustache.workingdogs.common.entity.type.base.EntityHerdingDog;

import javax.annotation.Nullable;

import static net.soggymustache.workingdogs.util.DogDataManager.BORDER_COLLIE;

public class EntityBorderCollie extends EntityHerdingDog {

	public EntityBorderCollie(World worldIn) {
		super(worldIn);
	}

	@Override
	public DogData getData() {
		return BORDER_COLLIE;
	}

	@Nullable
	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return new EntityBorderCollie(this.world);
	}
}
