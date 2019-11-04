// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle;

import academy.yamamoto.android.game.*;
import android.graphics.*;
import main.BitmapHolder;

public class Cloud extends GameObject2D
{

    public Cloud()
    {
        speed = 20;
        sizeMagnification = 4F;
    }

    public void destroy()
    {
        if(hasBitmap())
        {
            getBitmap().recycle();
            setBitmap(null);
        }
    }

    public float getSizeMagnification()
    {
        return sizeMagnification;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void initialize()
    {
        float f = (float)Math.random();
        offsetTo(getEngine().getGame().getVirtualScreenWidth() + 50F, getEngine().getGame().getVirtualScreenHeight() * f);
        (int)(3F * (float)Math.random());
        JVM INSTR tableswitch 0 2: default 68
    //                   0 192
    //                   1 204
    //                   2 216;
           goto _L1 _L2 _L3 _L4
_L1:
        float f1 = (float)Math.random();
        f1 = 1.0F + getSizeMagnification() * f1;
        Rect rect = new Rect(0, 0, getBitmap().getWidth(), getBitmap().getHeight());
        RectF rectf = new RectF(0.0F, 0.0F, (float)getBitmap().getWidth() * f1, (float)getBitmap().getHeight() * f1);
        Bitmap bitmap = Bitmap.createBitmap((int)rectf.right, (int)rectf.bottom, android.graphics.Bitmap.Config.ARGB_8888);
        (new Canvas(bitmap)).drawBitmap(getBitmap(), rect, rectf, null);
        setBitmap(bitmap);
        setSpeed((int)((float)getSpeed() * f1));
        return;
_L2:
        setBitmap(BitmapHolder.get(51));
        continue; /* Loop/switch isn't completed */
_L3:
        setBitmap(BitmapHolder.get(52));
        continue; /* Loop/switch isn't completed */
_L4:
        setBitmap(BitmapHolder.get(53));
        if(true) goto _L1; else goto _L5
_L5:
    }

    public void setSizeMagnification(float f)
    {
        sizeMagnification = f;
    }

    public void setSpeed(int i)
    {
        speed = i;
    }

    public boolean update()
    {
        if(isDeleted())
            return false;
        offsetTo(getX() - (float)getSpeed(), getY());
        if(getX() < -100F)
            delete();
        return true;
    }

    private float sizeMagnification;
    private int speed;
}
