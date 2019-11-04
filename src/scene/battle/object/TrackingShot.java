// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object;

import academy.yamamoto.android.game.GameObject2D;
import academy.yamamoto.android.general.Gen;

// Referenced classes of package scene.battle.object:
//            Shot

public class TrackingShot extends Shot
{

    public TrackingShot(int i, GameObject2D gameobject2d)
    {
        super(i);
        target = null;
        setTarget(gameobject2d);
    }

    public GameObject2D getTarget()
    {
        return target;
    }

    public boolean hasTarget()
    {
        return getTarget() != null;
    }

    public void setTarget(GameObject2D gameobject2d)
    {
        target = gameobject2d;
    }

    public boolean update()
    {
        while(isDeleted() || getHitCount() >= getDeleteCount() || getTarget().isDeleted() || getTime() >= 250) 
            return false;
        float f = getX();
        float f1 = getY();
        float f2 = Gen.getRadian(f, f1, getTarget().getCenterX() - getCenterXdiff(), getTarget().getCenterY() - getCenterYdiff());
        setRatioX((float)Math.cos(f2));
        setRatioY((float)Math.sin(f2));
        offsetTo(f + getSpeed() * getRatioX(), f1 + getSpeed() * getRatioY());
        nextTime();
        return true;
    }

    private GameObject2D target;
}
