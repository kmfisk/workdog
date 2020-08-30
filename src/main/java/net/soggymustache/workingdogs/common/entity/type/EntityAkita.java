package net.soggymustache.workingdogs.common.entity.type;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;
import net.soggymustache.workingdogs.common.entity.DogData;
import net.soggymustache.workingdogs.common.entity.type.base.EntityHuntingDog;

import javax.annotation.Nullable;

import static net.soggymustache.workingdogs.util.DogDataManager.AKITA;

public class EntityAkita extends EntityHuntingDog {

	public EntityAkita(World worldIn) {
		super(worldIn);
	}

	@Override
	public DogData getData() {
		return AKITA;
	}

	@Nullable
	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return new EntityAkita(world);
	}
}
