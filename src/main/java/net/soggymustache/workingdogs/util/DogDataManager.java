package net.soggymustache.workingdogs.util;

import net.soggymustache.workingdogs.common.entity.DogData;
import net.soggymustache.workingdogs.common.entity.type.EntityAkita;
import net.soggymustache.workingdogs.common.entity.type.EntityBorderCollie;

import static net.soggymustache.workingdogs.DogMain.registerPack;

public class DogDataManager {

	public static final DogData AKITA = registerPack(EntityAkita.class, "akita.json");
	public static final DogData BORDER_COLLIE = registerPack(EntityBorderCollie.class, "border_collie.json");

	public static void register() { }
}
