// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.enemy;

import academy.yamamoto.android.general.Gen;

// Referenced classes of package scene.battle.object.enemy:
//            Movable, Enemy

public class MoveLine extends Movable
{

    public MoveLine()
    {
        speed = 25F;
        ratioX = 1.0F;
        ratioY = 0.0F;
    }

    public MoveLine(int i)
    {
        this();
        setMax(i);
    }

    public float getRatioX()
    {
        return ratioX;
    }

    public float getRatioY()
    {
        return ratioY;
    }

    public float getSpeed()
    {
        return speed;
    }

    public boolean move(Enemy enemy)
    {
        float f = enemy.getX();
        float f1 = enemy.getY();
        enemy.offsetTo(f + getSpeed() * getRatioX(), f1 + getSpeed() * getRatioY());
        return super.move(enemy);
    }

    public void setAngle(float f)
    {
        setRatioX((float)Math.cos(f));
        setRatioY((float)Math.sin(f));
    }

    public void setAngle(int i)
    {
        setRatioX((float)Math.cos(Math.toRadians(i)));
        setRatioY((float)Math.sin(Math.toRadians(i)));
    }

    public void setPoint(float f, float f1, float f2, float f3)
    {
        setAngle(Gen.getRadian(f2, f3, f, f1));
    }

    public void setRatioX(float f)
    {
        ratioX = f;
    }

    public void setRatioY(float f)
    {
        ratioY = f;
    }

    public void setSpeed(float f)
    {
        speed = f;
    }

    private float ratioX;
    private float ratioY;
    private float speed;
}
