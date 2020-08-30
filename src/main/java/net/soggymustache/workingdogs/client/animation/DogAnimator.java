package net.soggymustache.workingdogs.client.animation;

import net.minecraft.client.model.ModelBase;
import net.soggymustache.bookworm.client.animation.part.BookwormModelBase;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;
import net.soggymustache.bookworm.util.BookwormUtils;
import net.soggymustache.workingdogs.common.entity.type.base.EntityWorkingDog;

public class DogAnimator<T extends EntityWorkingDog> extends CMFAnimator<T> {

    protected float speed = 1.0F, degree = 1.0F;
    protected BookwormModelBase sitModel, layModel;

    public DogAnimator(ModelCMF model) {
        super(model);
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, T e) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
        if (e == null)
            return;
        this.getModel().reset();

/*        if (e instanceof ZAWABaseLand) {
            ((ZAWABaseLand) e).animator.updateModel(this.getModel());
        }*/

        if(!e.isSitting())
            performGenericAnimation(f, f1, f2, f3, f4, f5, e);
        else
            if(e.getState() == EntityWorkingDog.State.SIT) this.getModel().loadPosedModel(sitModel);
            else if (e.getState() == EntityWorkingDog.State.LYING) this.getModel().loadPosedModel(layModel);
            else performGenericAnimation(f, f1, f2, f3, f4, f5, e);

        if (!BookwormUtils.isEntityMoving(e)) {
            f = e.ticksExisted;
            f1 = 0.3F;
            performIdleAnimation(f, f1, f2, f3, f4, f5, e);
        }
    }

    protected void performSleepAnimation(float f, float f1, float f2, float f3, float f4, float f5, T entity) {}

    protected void performGenericAnimation(float f, float f1, float f2, float f3, float f4, float f5, T entity) {}

    protected void performIdleAnimation(float f, float f1, float f2, float f3, float f4, float f5, T entity) {}
}
