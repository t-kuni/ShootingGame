// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.enemy;

import academy.yamamoto.android.game.GameObject2D;
import academy.yamamoto.android.general.HierarchicalRect;
import android.graphics.*;
import java.util.Vector;
import main.BitmapHolder;
import scene.battle.object.Shot;
import scene.battle.object.player.Fire;

public class BossRushEffect extends GameObject2D
{

    public BossRushEffect()
    {
        bitmaps = null;
        srcRect = null;
        destRect = null;
        destRects = null;
        bitmapIndex = 0;
        damage = 150;
        setCollisionRect(new HierarchicalRect(0, 30F, 30F, 158F, 158F));
        setCenter(94F, 94F);
    }

    public void collision(int i, Class class1, GameObject2D gameobject2d, int j)
    {
        if(gameobject2d instanceof Shot)
        {
            if(((Shot)gameobject2d).getId() == 1)
                gameobject2d.delete();
        } else
        if(gameobject2d instanceof Fire)
        {
            gameobject2d.delete();
            return;
        }
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(getBitmap(), getSrcRect(), getDestRect(), null);
    }

    public int getBitmapIndex()
    {
        return bitmapIndex;
    }

    public Vector getBitmaps()
    {
        return bitmaps;
    }

    public int getDamage()
    {
        return damage;
    }

    public RectF getDestRect()
    {
        return destRect;
    }

    public Vector getDestRects()
    {
        return destRects;
    }

    public Rect getSrcRect()
    {
        return srcRect;
    }

    public void initialize()
    {
        setSrcRect(new Rect(0, 0, 188, 188));
        if(getDestRects() == null)
        {
            setDestRects(new Vector(4));
            getDestRects().add(new RectF(0.0F, 0.0F, 98F, 98F));
            getDestRects().add(new RectF(0.0F, 0.0F, 128F, 128F));
            getDestRects().add(new RectF(0.0F, 0.0F, 158F, 158F));
            getDestRects().add(new RectF(0.0F, 0.0F, 188F, 188F));
        }
        setDestRect((RectF)getDestRects().get(0));
        if(getBitmaps() == null)
        {
            setBitmaps(new Vector(5));
            getBitmaps().add(BitmapHolder.get(16));
            getBitmaps().add(BitmapHolder.get(17));
            getBitmaps().add(BitmapHolder.get(18));
            getBitmaps().add(BitmapHolder.get(19));
            getBitmaps().add(BitmapHolder.get(20));
        }
    }

    public void setBitmapIndex(int i)
    {
        bitmapIndex = i;
    }

    public void setBitmaps(Vector vector)
    {
        bitmaps = vector;
    }

    public void setDamage(int i)
    {
        damage = i;
    }

    public void setDestRect(RectF rectf)
    {
        destRect = rectf;
    }

    public void setDestRects(Vector vector)
    {
        destRects = vector;
    }

    public void setSrcRect(Rect rect)
    {
        srcRect = rect;
    }

    public boolean update()
    {
        if(isDeleted())
            return false;
        if(getTime() < getDestRects().size())
        {
            setDestRect((RectF)getDestRects().get(getTime()));
            float f = (getDestRects().size() - 1 - getTime()) * 15;
            getDestRect().offsetTo(getX() + f, getY() + f);
        } else
        {
            getDestRect().offsetTo(getX(), getY());
        }
        setBitmap((Bitmap)getBitmaps().get(getBitmapIndex()));
        setBitmapIndex(getBitmapIndex() + 1);
        if(getBitmapIndex() >= getBitmaps().size())
            setBitmapIndex(0);
        nextTime();
        return true;
    }

    private int bitmapIndex;
    private Vector bitmaps;
    private int damage;
    private RectF destRect;
    private Vector destRects;
    private Rect srcRect;
}
