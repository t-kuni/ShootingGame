// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle;

import academy.yamamoto.android.game.*;
import android.graphics.*;
import main.BitmapHolder;

// Referenced classes of package scene.battle:
//            Battle

public class EndProduction00 extends GameObject2D
{

    public EndProduction00()
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
    }

    public boolean update()
    {
        if(getTime() <= 40) goto _L2; else goto _L1
_L1:
        getFadingLevel();
        JVM INSTR tableswitch 0 4: default 48
    //                   0 82
    //                   1 94
    //                   2 106
    //                   3 118
    //                   4 129;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        setFadingLevel(getFadingLevel() - 1);
_L2:
        if(getTime() > 45)
        {
            ((Battle)getEngine().getGame()).toResult();
            return false;
        } else
        {
            nextTime();
            return true;
        }
_L4:
        setBitmap(BitmapHolder.get(8));
        continue; /* Loop/switch isn't completed */
_L5:
        setBitmap(BitmapHolder.get(7));
        continue; /* Loop/switch isn't completed */
_L6:
        setBitmap(BitmapHolder.get(6));
        continue; /* Loop/switch isn't completed */
_L7:
        setBitmap(BitmapHolder.get(5));
        continue; /* Loop/switch isn't completed */
_L8:
        setBitmap(BitmapHolder.get(4));
        if(true) goto _L3; else goto _L9
_L9:
    }

    private RectF dest;
    private int fadingLevel;
    private Rect src;
}
