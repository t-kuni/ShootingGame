// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.general;

import android.graphics.Bitmap;
import java.util.Vector;

// Referenced classes of package academy.yamamoto.android.general:
//            AnimationBitmap

public class Animation
{

    public Animation()
    {
        bitmaps = null;
        bitmapIndex = 0;
        repeatable = false;
        setBitmaps(new Vector(4));
    }

    private void setBitmaps(Vector vector)
    {
        bitmaps = vector;
    }

    private void setRepeatable(boolean flag)
    {
        repeatable = flag;
    }

    public void add(AnimationBitmap animationbitmap)
    {
        getBitmaps().add(animationbitmap);
        setBitmapIndex(0);
    }

    public int getBitmapIndex()
    {
        return bitmapIndex;
    }

    public Vector getBitmaps()
    {
        return bitmaps;
    }

    public boolean isRepeatable()
    {
        return repeatable;
    }

    public Bitmap next()
    {
        Bitmap bitmap;
        if(getBitmapIndex() >= getBitmaps().size())
        {
            bitmap = null;
        } else
        {
            Bitmap bitmap1 = ((AnimationBitmap)getBitmaps().get(getBitmapIndex())).next();
            bitmap = bitmap1;
            if(bitmap1 == null)
            {
                setBitmapIndex(getBitmapIndex() + 1);
                if(getBitmapIndex() >= getBitmaps().size())
                {
                    if(isRepeatable())
                    {
                        setBitmapIndex(0);
                        return next();
                    } else
                    {
                        return null;
                    }
                } else
                {
                    return next();
                }
            }
        }
        return bitmap;
    }

    public void repeatable()
    {
        setRepeatable(true);
    }

    public void setBitmapIndex(int i)
    {
        bitmapIndex = i;
    }

    public void unrepeatable()
    {
        setRepeatable(false);
    }

    private int bitmapIndex;
    private Vector bitmaps;
    private boolean repeatable;
}
