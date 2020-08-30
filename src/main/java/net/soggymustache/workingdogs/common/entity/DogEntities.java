package net.soggymustache.workingdogs.common.entity;

import net.minecraft.entity.Entity;
import net.soggymustache.workingdogs.common.entity.type.EntityAkita;
import net.soggymustache.workingdogs.common.entity.type.EntityBorderCollie;
import net.soggymustache.workingdogs.common.entity.type.projectile.EntityFrisbee;

import java.util.ArrayList;
import java.util.List;

public class DogEntities {

    public static final List<EntityContainer> CONTAINERS = new ArrayList<>();

    static{
        add(EntityAkita.class, "akita", 0x774C3F, 0x2A5B27);
        add(EntityBorderCollie.class, "bordercollie", 0x774C3F, 0x2A5B27);
        add(EntityFrisbee.class, "frisbee", -1, -1);
    }

    private static void add(Class<? extends Entity> entityClass, String entityNameIn, int prim, int sec){
        CONTAINERS.add(new EntityContainer(entityClass, entityNameIn, prim, sec));
    }

    public static class EntityContainer {
        public Class<? extends Entity> entityClass;
        public String entityName;
        public int prim, sec;
        public EntityContainer(Class<? extends Entity> EntityClass, String entityNameIn, int prim, int sec) {
            this.entityClass = EntityClass;
            this.entityName = entityNameIn;
            this.prim = prim;
            this.sec = sec;
        }
    }
}
