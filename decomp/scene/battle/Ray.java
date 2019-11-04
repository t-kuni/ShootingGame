// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle;

import academy.yamamoto.android.game.*;
import android.graphics.Bitmap;
import main.BitmapHolder;

public class Ray extends GameObject2D
{

    public Ray()
    {
        speed = 100F;
        rayHeightMin = 128F;
        rayHeightRange = 512F;
    }

    public static Bitmap getRayBitmap()
    {
        return rayBitmap;
    }

    public static void setRayBitmap(Bitmap bitmap)
    {
        rayBitmap = bitmap;
    }

    public float getRayHeightMin()
    {
        return rayHeightMin;
    }

    public float getRayHeightRange()
    {
        return rayHeightRange;
    }

    public float getSpeed()
    {
        return speed;
    }

    public void initialize()
    {
        setBitmap(BitmapHolder.get(82));
        float f = getRayHeightRange();
        float f1 = (float)Math.random();
        float f2 = getRayHeightMin();
        offsetTo(getEngine().getGame().getVirtualScreenWidth(), f * f1 + f2);
    }

    public void setRayHeightMin(float f)
    {
        rayHeightMin = f;
    }

    public void setRayHeightRange(float f)
    {
        rayHeightRange = f;
    }

    public void setSpeed(float f)
    {
        speed = f;
    }

    public boolean update()
    {
        offsetTo(getX() - getSpeed(), getY());
        return getX() >= (float)(-getBitmap().getWidth());
    }

    private static Bitmap rayBitmap = null;
    private float rayHeightMin;
    private float rayHeightRange;
    private float speed;

}
