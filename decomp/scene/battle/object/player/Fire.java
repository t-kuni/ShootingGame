// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.player;

import academy.yamamoto.android.game.GameEngine;
import academy.yamamoto.android.game.GameObject2D;
import academy.yamamoto.android.general.HierarchicalRect;
import android.graphics.*;
import main.*;

public class Fire extends GameObject2D
{

    public Fire()
    {
        fireAnimationBitmapIndex = 0;
        step = 0;
        dest = null;
        duration = 5;
        durationCount = 0;
        damage = 7;
        setCenter(96F, 96F);
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(getFireAnimationBitmap(getFireAnimationBitmapIndex()), Effect.getRect(), getDest(), null);
    }

    public int getDamage()
    {
        return damage;
    }

    public RectF getDest()
    {
        return dest;
    }

    public int getDuration()
    {
        return duration;
    }

    public int getDurationCount()
    {
        return durationCount;
    }

    public Bitmap getFireAnimationBitmap(int i)
    {
        switch(i)
        {
        default:
            return null;

        case 0: // '\0'
            return BitmapHolder.get(136);

        case 1: // '\001'
            return BitmapHolder.get(137);

        case 2: // '\002'
            return BitmapHolder.get(138);

        case 3: // '\003'
            return BitmapHolder.get(139);

        case 4: // '\004'
            return BitmapHolder.get(140);

        case 5: // '\005'
            return BitmapHolder.get(141);

        case 6: // '\006'
            return BitmapHolder.get(142);

        case 7: // '\007'
            return BitmapHolder.get(143);

        case 8: // '\b'
            return BitmapHolder.get(144);

        case 9: // '\t'
            return BitmapHolder.get(145);
        }
    }

    public int getFireAnimationBitmapIndex()
    {
        return fireAnimationBitmapIndex;
    }

    public int getStep()
    {
        return step;
    }

    public void initialize()
    {
        RectF rectf = new RectF(0.0F, 0.0F, 192F, 192F);
        rectf.offsetTo(getX(), getY());
        setDest(rectf);
        SEHolder.play(getEngine().getContext(), 4);
    }

    public void setDamage(int i)
    {
        damage = i;
    }

    public void setDest(RectF rectf)
    {
        dest = rectf;
    }

    public void setDuration(int i)
    {
        duration = i;
    }

    public void setDurationCount(int i)
    {
        durationCount = i;
    }

    public void setFireAnimationBitmapIndex(int i)
    {
        fireAnimationBitmapIndex = i;
    }

    public void setStep(int i)
    {
        step = i;
    }

    public boolean update()
    {
        if(isDeleted())
            return false;
        getStep();
        JVM INSTR tableswitch 0 2: default 40
    //                   0 42
    //                   1 111
    //                   2 176;
           goto _L1 _L2 _L3 _L4
_L1:
        return true;
_L2:
        setFireAnimationBitmapIndex(getFireAnimationBitmapIndex() + 1);
        if(getFireAnimationBitmapIndex() > 2)
        {
            setStep(getStep() + 1);
            HierarchicalRect hierarchicalrect = new HierarchicalRect(0, 0.0F, 0.0F, 100F, 100F);
            hierarchicalrect.offsetTo(getCenterX() - 50F, getCenterY() - 50F);
            setCollisionRect(hierarchicalrect);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        setFireAnimationBitmapIndex(getFireAnimationBitmapIndex() + 1);
        if(getFireAnimationBitmapIndex() > 5)
        {
            setDurationCount(getDurationCount() + 1);
            if(getDurationCount() < getDuration())
            {
                setFireAnimationBitmapIndex(3);
            } else
            {
                setStep(getStep() + 1);
                setCollisionRect(null);
            }
        }
        if(true) goto _L1; else goto _L4
_L4:
        setFireAnimationBitmapIndex(getFireAnimationBitmapIndex() + 1);
        if(getFireAnimationBitmapIndex() > 8)
            return false;
        if(true) goto _L1; else goto _L5
_L5:
    }

    private int damage;
    private RectF dest;
    private int duration;
    private int durationCount;
    private int fireAnimationBitmapIndex;
    private int step;
}
