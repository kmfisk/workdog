package net.soggymustache.workingdogs.common.entity.move;

import net.minecraft.entity.EntityBodyHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.MathHelper;

public class DogBodyHelper extends EntityBodyHelper {

    private final EntityLiving entity;
    private int time;
    private float tar;

    public DogBodyHelper(EntityLiving entity) {
        super(entity);
        this.entity = entity;
    }

    @Override
    public void updateRenderAngles() {
        if (!this.entity.isDead) {
            double deltaX = this.entity.posX - this.entity.prevPosX;
            double deltaZ = this.entity.posZ - this.entity.prevPosZ;

            double deltaSq = deltaX * deltaX + deltaZ * deltaZ;
            double ang;

            if (deltaSq > 2.5e-7) {
                ang = (float) MathHelper.atan2(deltaZ, deltaX) * (180 / (float) Math.PI) - 90;

                this.entity.renderYawOffset += MathHelper.wrapDegrees(ang - this.entity.renderYawOffset) * 0.6F;

                if (!this.entity.getNavigator().noPath()) {
                    this.entity.rotationYaw += MathHelper.wrapDegrees(ang - this.entity.rotationYaw) * 0.4F;
                }
            }
            else if (this.entity.getPassengers().isEmpty() || !(this.entity.getPassengers().get(0) instanceof EntityLiving)) {
                float limit = 80;
                if (Math.abs(this.entity.rotationYawHead - this.tar) > 15) {
                    this.time = 0;
                    this.tar = this.entity.rotationYawHead;
                } else {
                    this.time++;
                    final int speed = 30;
                    if (this.time > speed) {
                        limit = Math.max(1 - (this.time - speed) / (float) speed, 0) * 80;
                    }
                }

                this.entity.renderYawOffset = (float) MathHelper.clampedLerp(this.entity.renderYawOffset, this.entity.rotationYawHead, limit);
            }
        }
    }

}