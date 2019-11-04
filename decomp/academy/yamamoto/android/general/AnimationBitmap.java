// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.general;

import android.graphics.Bitmap;

public class AnimationBitmap
{

    public AnimationBitmap(Bitmap bitmap1, int i)
    {
        bitmap = null;
        maxCount = 0;
        count = 0;
        setBitmap(bitmap1);
        setMaxCount(i);
        setCount(0);
    }

    private int getCount()
    {
        return count;
    }

    private void setCount(int i)
    {
        count = i;
    }

    public Bitmap getBitmap()
    {
        return bitmap;
    }

    public int getMaxCount()
    {
        return maxCount;
    }

    public Bitmap next()
    {
        Bitmap bitmap1 = null;
        if(getCount() < getMaxCount())
            bitmap1 = getBitmap();
        setCount(getCount() + 1);
        return bitmap1;
    }

    public void setBitmap(Bitmap bitmap1)
    {
        bitmap = bitmap1;
    }

    public void setMaxCount(int i)
    {
        maxCount = i;
    }

    private Bitmap bitmap;
    private int count;
    private int maxCount;
}
