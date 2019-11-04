// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle;

import academy.yamamoto.android.game.*;
import android.graphics.*;
import main.BitmapHolder;

// Referenced classes of package scene.battle:
//            Battle, StartProduction01

public class StartProduction00 extends GameObject2D
{

    public StartProduction00()
    {
        fadingLevel = 4;
        src = null;
        dest = null;
    }

    private RectF getDest()
    {
        return dest;
    }

    private int getFadingLevel()
    {
        return fadingLevel;
    }

    private Rect getSrc()
    {
        return src;
    }

    private void setDest(RectF rectf)
    {
        dest = rectf;
    }

    private void setFadingLevel(int i)
    {
        fadingLevel = i;
    }

    private void setSrc(Rect rect)
    {
        src = rect;
    }

    public void draw(Canvas canvas)
    {
        if(hasBitmap())
            canvas.drawBitmap(getBitmap(), getSrc(), getDest(), null);
    }

    public void initialize()
    {
        offsetTo(0.0F, 0.0F);
        setSrc(new Rect(0, 0, 544, 416));
        setDest(new RectF(0.0F, 0.0F, getEngine().getGame().getVirtualScreenWidth(), getEngine().getGame().getVirtualScreenHeight()));
        setBitmap(BitmapHolder.get(8));
    }

    public boolean update()
    {
        getFadingLevel();
        JVM INSTR tableswitch -1 4: default 44
    //                   -1 88
    //                   0 96
    //                   1 107
    //                   2 118
    //                   3 130
    //                   4 142;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_142;
_L8:
        setFadingLevel(getFadingLevel() - 1);
        if(getTime() > 25)
        {
            ((Battle)getEngine().getGame()).getTopGom().add(new StartProduction01());
            return false;
        } else
        {
            nextTime();
            return true;
        }
_L2:
        setBitmap(null);
          goto _L8
_L3:
        setBitmap(BitmapHolder.get(4));
          goto _L8
_L4:
        setBitmap(BitmapHolder.get(5));
          goto _L8
_L5:
        setBitmap(BitmapHolder.get(6));
          goto _L8
_L6:
        setBitmap(BitmapHolder.get(7));
          goto _L8
        setBitmap(BitmapHolder.get(8));
          goto _L8
    }

    private RectF dest;
    private int fadingLevel;
    private Rect src;
}
