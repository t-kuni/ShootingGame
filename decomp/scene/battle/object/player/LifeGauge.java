// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.player;

import academy.yamamoto.android.game.GameObject2D;
import android.graphics.*;
import main.BitmapHolder;

public class LifeGauge extends GameObject2D
{

    public LifeGauge()
    {
        prevHp = 0.0F;
        hp = 1000F;
        maxHp = 1000F;
        iconBitmap = null;
        iconSrcRect = null;
        iconDestRect = null;
        gaugeBitmap = null;
        barBitmap = null;
        barSrcRect = null;
        barDestRect = null;
        sizeOfShaking = 0.0F;
        decayOfShaking = 2.0F;
        dx = 0.0F;
        dy = 0.0F;
    }

    private Bitmap getBarBitmap()
    {
        return barBitmap;
    }

    private RectF getBarDestRect()
    {
        return barDestRect;
    }

    private Rect getBarSrcRect()
    {
        return barSrcRect;
    }

    private float getDecayOfShaking()
    {
        return decayOfShaking;
    }

    private float getDx()
    {
        return dx;
    }

    private float getDy()
    {
        return dy;
    }

    private Bitmap getGaugeBitmap()
    {
        return gaugeBitmap;
    }

    private Bitmap getIconBitmap()
    {
        return iconBitmap;
    }

    private RectF getIconDestRect()
    {
        return iconDestRect;
    }

    private Rect getIconSrcRect()
    {
        return iconSrcRect;
    }

    private void setBarBitmap(Bitmap bitmap)
    {
        barBitmap = bitmap;
    }

    private void setBarDestRect(RectF rectf)
    {
        barDestRect = rectf;
    }

    private void setBarSrcRect(Rect rect)
    {
        barSrcRect = rect;
    }

    private void setDecayOfShaking(float f)
    {
        decayOfShaking = f;
    }

    private void setDx(float f)
    {
        dx = f;
    }

    private void setDy(float f)
    {
        dy = f;
    }

    private void setGaugeBitmap(Bitmap bitmap)
    {
        gaugeBitmap = bitmap;
    }

    private void setIconBitmap(Bitmap bitmap)
    {
        iconBitmap = bitmap;
    }

    private void setIconDestRect(RectF rectf)
    {
        iconDestRect = rectf;
    }

    private void setIconSrcRect(Rect rect)
    {
        iconSrcRect = rect;
    }

    public void draw(Canvas canvas)
    {
        float f = getX();
        float f1 = getDx();
        float f2 = getY();
        float f3 = getDy();
        getBarDestRect().offset(getDx(), getDy());
        getIconDestRect().offset(getDx(), getDy());
        canvas.drawBitmap(getBarBitmap(), getBarSrcRect(), getBarDestRect(), null);
        canvas.drawBitmap(getGaugeBitmap(), f + f1, f2 + f3, null);
        canvas.drawBitmap(getIconBitmap(), getIconSrcRect(), getIconDestRect(), null);
        getBarDestRect().offset(-getDx(), -getDy());
        getIconDestRect().offset(-getDx(), -getDy());
    }

    public float getHp()
    {
        return hp;
    }

    public float getMaxHp()
    {
        return maxHp;
    }

    public float getSizeOfShaking()
    {
        return sizeOfShaking;
    }

    public void initialize()
    {
        setName("HP");
        offsetTo(830F, 678F);
        setIconBitmap(BitmapHolder.get(15));
        setGaugeBitmap(BitmapHolder.get(78));
        setBarBitmap(BitmapHolder.get(77));
        setIconSrcRect(new Rect(0, 0, getIconBitmap().getWidth(), 39));
        setIconDestRect(new RectF(0.0F, 0.0F, 46F, 61F));
        getIconDestRect().offsetTo(getX() + 15F, getY() + 10F);
        setBarSrcRect(new Rect(0, 0, getBarBitmap().getWidth(), getBarBitmap().getHeight()));
        setBarDestRect(new RectF(0.0F, 0.0F, getBarBitmap().getWidth(), getBarBitmap().getHeight()));
        getBarDestRect().offsetTo(getX() + 64F, getY() + 10F);
    }

    public void setHp(float f)
    {
        hp = f;
    }

    public void setMaxHp(float f)
    {
        maxHp = f;
    }

    public void setSizeOfShaking(float f)
    {
        sizeOfShaking = f;
    }

    public boolean update()
    {
        if(prevHp != getHp())
        {
            float f = (float)getBarBitmap().getWidth() * (getHp() / getMaxHp());
            getBarSrcRect().right = (int)f;
            getBarDestRect().right = getX() + 64F + f;
            prevHp = getHp();
            setSizeOfShaking(10F);
        }
        if(getSizeOfShaking() > 0.0F)
        {
            float f1 = 6.283185F * (float)Math.random();
            setDy(getSizeOfShaking() * (float)Math.sin(f1));
            setDx(getSizeOfShaking() * (float)Math.cos(f1));
            setSizeOfShaking(getSizeOfShaking() - getDecayOfShaking());
            if(getSizeOfShaking() < 0.0F)
                setSizeOfShaking(0.0F);
        } else
        {
            setDx(0.0F);
            setDy(0.0F);
        }
        return true;
    }

    private Bitmap barBitmap;
    private RectF barDestRect;
    private Rect barSrcRect;
    private float decayOfShaking;
    private float dx;
    private float dy;
    private Bitmap gaugeBitmap;
    private float hp;
    private Bitmap iconBitmap;
    private RectF iconDestRect;
    private Rect iconSrcRect;
    private float maxHp;
    private float prevHp;
    private float sizeOfShaking;
}
