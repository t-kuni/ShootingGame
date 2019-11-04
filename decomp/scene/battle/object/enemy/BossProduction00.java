// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.enemy;

import academy.yamamoto.android.game.*;
import android.graphics.*;
import java.util.Vector;
import main.*;
import scene.battle.Battle;

// Referenced classes of package scene.battle.object.enemy:
//            Boss

public class BossProduction00 extends GameObject2D
{

    public BossProduction00()
    {
        filteringLevel = 2;
        filterBitmaps = null;
    }

    public static RectF getDestRect()
    {
        return destRect;
    }

    public static Rect getSrcRect()
    {
        return srcRect;
    }

    public static void setDestRect(RectF rectf)
    {
        destRect = rectf;
    }

    public static void setSrcRect(Rect rect)
    {
        srcRect = rect;
    }

    public void draw(Canvas canvas)
    {
        if(hasBitmap())
            canvas.drawBitmap(getBitmap(), getSrcRect(), getDestRect(), null);
    }

    public void flashing()
    {
        setFilteringLevel(getFilterBitmaps().size() - 1);
    }

    public Vector getFilterBitmaps()
    {
        return filterBitmaps;
    }

    public int getFilteringLevel()
    {
        return filteringLevel;
    }

    public void initialize()
    {
        setFilterBitmaps(new Vector(5));
        getFilterBitmaps().add(BitmapHolder.get(5));
        getFilterBitmaps().add(BitmapHolder.get(4));
        getFilterBitmaps().add(null);
        getFilterBitmaps().add(BitmapHolder.get(97));
        getFilterBitmaps().add(BitmapHolder.get(98));
        getFilterBitmaps().add(BitmapHolder.get(99));
        setSrcRect(new Rect(0, 0, 544, 416));
        setDestRect(new RectF(0.0F, 0.0F, getEngine().getGame().getVirtualScreenWidth(), getEngine().getGame().getVirtualScreenHeight()));
    }

    public void lightning(int i)
    {
        switch(i)
        {
        default:
            return;

        case 0: // '\0'
            flashing();
            SEHolder.play(getEngine().getContext(), 11);
            return;

        case 1: // '\001'
            flashing();
            SEHolder.play(getEngine().getContext(), 12);
            return;

        case 2: // '\002'
            flashing();
            SEHolder.play(getEngine().getContext(), 13);
            return;

        case 3: // '\003'
            setFilteringLevel(8);
            break;
        }
        SEHolder.play(getEngine().getContext(), 13);
    }

    public void lightningEffect(float f)
    {
        float f1 = 0.0F;
        GameObjectManager2D gameobjectmanager2d = ((Battle)getEngine().getGame()).getTop2Gom();
        int i = 0;
        do
        {
            if(i >= 16)
                return;
            Effect effect = new Effect(5);
            f1 += 0.3926991F;
            float f2 = (float)Math.cos(f1);
            float f3 = (float)Math.sin(f1);
            float f4 = getEngine().getGame().getVirtualScreenWidth() / 2.0F;
            float f5 = getEngine().getGame().getVirtualScreenHeight() / 2.0F;
            effect.offsetTo((f * f2 + f4) - effect.getCenterXdiff(), (f * f3 + f5) - effect.getCenterYdiff());
            gameobjectmanager2d.add(effect);
            i++;
        } while(true);
    }

    public void setFilterBitmaps(Vector vector)
    {
        filterBitmaps = vector;
    }

    public void setFilteringLevel(int i)
    {
        filteringLevel = i;
    }

    public boolean update()
    {
        if(!isDeleted()) goto _L2; else goto _L1
_L1:
        if(getFilteringLevel() == 2)
            return false;
        if(getFilteringLevel() < getFilterBitmaps().size())
            setBitmap((Bitmap)getFilterBitmaps().get(getFilteringLevel()));
        else
            setBitmap((Bitmap)getFilterBitmaps().get(getFilterBitmaps().size() - 1));
        if(getFilteringLevel() < 2)
            setFilteringLevel(getFilteringLevel() + 1);
        else
            setFilteringLevel(getFilteringLevel() - 1);
_L4:
        nextTime();
        return true;
_L2:
        if(getFilteringLevel() >= 0)
        {
            if(getFilteringLevel() < getFilterBitmaps().size())
                setBitmap((Bitmap)getFilterBitmaps().get(getFilteringLevel()));
            else
                setBitmap((Bitmap)getFilterBitmaps().get(getFilterBitmaps().size() - 1));
            setFilteringLevel(getFilteringLevel() - 1);
        }
        if(getTime() >= 20 && getTime() <= 80)
            if(getTime() == 20)
            {
                lightning(0);
                ((Battle)getEngine().getGame()).startBossBgm();
                lightningEffect(380F);
            } else
            if(getTime() == 40)
            {
                lightning(0);
                lightningEffect(280F);
            } else
            if(getTime() == 60)
            {
                lightning(1);
                lightningEffect(180F);
            } else
            if(getTime() == 80)
            {
                lightning(3);
                lightningEffect(80F);
                ((Battle)getEngine().getGame()).getGom().add(new Boss());
                delete();
            }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static RectF destRect = null;
    private static Rect srcRect = null;
    private Vector filterBitmaps;
    private int filteringLevel;

}
