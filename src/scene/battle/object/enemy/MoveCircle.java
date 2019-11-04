// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.enemy;

import academy.yamamoto.android.game.GameObject2D;
import academy.yamamoto.android.general.Gen;
import android.graphics.PointF;

// Referenced classes of package scene.battle.object.enemy:
//            Movable, Enemy

public class MoveCircle extends Movable
{

    public MoveCircle()
    {
        center = null;
        direction = 0;
        speed = 0.09817477F;
        distance = 100F;
        radian = 0.0F;
        target = null;
        setCenter(new PointF(0.0F, 0.0F));
    }

    public MoveCircle(int i, float f, float f1, float f2, float f3)
    {
        this();
        setMax(i);
        setCenter(f, f1, f2, f3);
    }

    public MoveCircle(int i, GameObject2D gameobject2d)
    {
        this();
        setMax(i);
        setTarget(gameobject2d);
    }

    public MoveCircle(GameObject2D gameobject2d)
    {
        this();
        setTarget(gameobject2d);
    }

    public PointF getCenter()
    {
        return center;
    }

    public int getDirection()
    {
        return direction;
    }

    public float getDistance()
    {
        return distance;
    }

    public float getRadian()
    {
        return radian;
    }

    public float getSpeed()
    {
        return speed;
    }

    public GameObject2D getTarget()
    {
        return target;
    }

    public boolean hasTarget()
    {
        return getTarget() != null;
    }

    public boolean move(Enemy enemy)
    {
        enemy.getX();
        enemy.getY();
        float f;
        float f1;
        float f2;
        float f3;
        float f4;
        if(hasTarget())
        {
            f = getTarget().getX();
            f1 = getTarget().getY();
        } else
        {
            f = getCenter().x;
            f1 = getCenter().y;
        }
        f2 = getRadian();
        if(getDirection() == 0)
            f2 += speed;
        else
            f2 -= speed;
        f3 = (float)((double)getDistance() * Math.cos(f2));
        f4 = (float)((double)getDistance() * Math.sin(f2));
        setRadian(f2);
        enemy.offsetTo(f + f3, f1 + f4);
        return super.move(enemy);
    }

    public void setCenter(float f, float f1, float f2, float f3)
    {
        getCenter().x = f;
        getCenter().y = f1;
        setDistance(Gen.getDistance(f2, f3, f, f1));
        setRadian(Gen.getRadian(f, f1, f2, f3));
    }

    public void setCenter(PointF pointf)
    {
        center = pointf;
    }

    public void setDirection(int i)
    {
        direction = i;
    }

    public void setDistance(float f)
    {
        distance = f;
    }

    public void setRadian(float f)
    {
        radian = f;
    }

    public void setSpeed(float f)
    {
        speed = f;
    }

    public void setTarget(GameObject2D gameobject2d)
    {
        target = gameobject2d;
    }

    public static final int DIRECTION_CLOCKWISE = 0;
    public static final int DIRECTION_REVERS = 1;
    private PointF center;
    private int direction;
    private float distance;
    private float radian;
    private float speed;
    private GameObject2D target;
}
