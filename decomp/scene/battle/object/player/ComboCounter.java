// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.player;

import academy.yamamoto.android.game.*;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.*;
import main.BitmapHolder;
import main.Effect;
import scene.battle.Battle;

public class ComboCounter extends GameObject2D
{

    public ComboCounter()
    {
        comboCount = 0;
        comboDuration = 40;
        comboTime = 0;
        comboMaxCount = 0;
        effectInterval = 5;
        effectTime = 0;
        width = 0.0F;
        height = 0.0F;
        preComboCount = 0;
        numbers = null;
        margin = 5F;
        displayingCount = 2;
        hitBitmap = null;
        numberBitmaps = null;
    }

    public void countUp()
    {
        setComboCount(getComboCount() + 1);
        setComboTime(getComboDuration());
    }

    public void determine()
    {
        if(getComboCount() == 0)
            return;
        if(getComboCount() > getComboMaxCount())
            setComboMaxCount(getComboCount());
        if(getComboCount() > getDisplayingCount())
        {
            Effect effect = new Effect(9);
            effect.offsetTo(getCenterX() - effect.getCenterXdiff(), getCenterY() - effect.getCenterYdiff());
            ((Battle)getEngine().getGame()).getTopGom().add(effect);
        }
        setComboCount(0);
        setComboTime(0);
    }

    public void draw(Canvas canvas)
    {
        if(getComboCount() <= getDisplayingCount()) goto _L2; else goto _L1
_L1:
        float f;
        float f1;
        ListIterator listiterator;
        f = getX();
        f1 = getY();
        listiterator = getNumbers().listIterator(getNumbers().size());
_L6:
        if(listiterator.hasPrevious()) goto _L4; else goto _L3
_L3:
        canvas.drawBitmap(getHitBitmap(), f, f1, null);
_L2:
        return;
_L4:
        Bitmap bitmap = (Bitmap)getNumberBitmaps().get(((Integer)listiterator.previous()).intValue());
        canvas.drawBitmap(bitmap, f, f1, null);
        f += (float)bitmap.getWidth() + getMargin();
        if(true) goto _L6; else goto _L5
_L5:
    }

    public int getComboCount()
    {
        return comboCount;
    }

    public int getComboDuration()
    {
        return comboDuration;
    }

    public int getComboMaxCount()
    {
        return comboMaxCount;
    }

    public int getComboTime()
    {
        return comboTime;
    }

    public int getDisplayingCount()
    {
        return displayingCount;
    }

    public int getEffectInterval()
    {
        return effectInterval;
    }

    public int getEffectTime()
    {
        return effectTime;
    }

    public float getHeight()
    {
        return height;
    }

    public Bitmap getHitBitmap()
    {
        return hitBitmap;
    }

    public float getMargin()
    {
        return margin;
    }

    public Vector getNumberBitmaps()
    {
        return numberBitmaps;
    }

    public ArrayList getNumbers()
    {
        return numbers;
    }

    public int getPreComboCount()
    {
        return preComboCount;
    }

    public float getWidth()
    {
        return width;
    }

    public void initialize()
    {
        if(getHitBitmap() == null)
            setHitBitmap(BitmapHolder.get(76));
        if(getNumberBitmaps() == null)
        {
            setNumberBitmaps(new Vector(10));
            getNumberBitmaps().add(BitmapHolder.get(50));
            getNumberBitmaps().add(BitmapHolder.get(40));
            getNumberBitmaps().add(BitmapHolder.get(48));
            getNumberBitmaps().add(BitmapHolder.get(47));
            getNumberBitmaps().add(BitmapHolder.get(30));
            getNumberBitmaps().add(BitmapHolder.get(29));
            getNumberBitmaps().add(BitmapHolder.get(45));
            getNumberBitmaps().add(BitmapHolder.get(44));
            getNumberBitmaps().add(BitmapHolder.get(27));
            getNumberBitmaps().add(BitmapHolder.get(38));
        }
    }

    public void setComboCount(int i)
    {
        comboCount = i;
    }

    public void setComboDuration(int i)
    {
        comboDuration = i;
    }

    public void setComboMaxCount(int i)
    {
        comboMaxCount = i;
    }

    public void setComboTime(int i)
    {
        comboTime = i;
    }

    public void setDisplayingCount(int i)
    {
        displayingCount = i;
    }

    public void setEffectInterval(int i)
    {
        effectInterval = i;
    }

    public void setEffectTime(int i)
    {
        effectTime = i;
    }

    public void setHeight(float f)
    {
        height = f;
    }

    public void setHitBitmap(Bitmap bitmap)
    {
        hitBitmap = bitmap;
    }

    public void setMargin(float f)
    {
        margin = f;
    }

    public void setNumberBitmaps(Vector vector)
    {
        numberBitmaps = vector;
    }

    public void setNumbers(ArrayList arraylist)
    {
        numbers = arraylist;
    }

    public void setPreComboCount(int i)
    {
        preComboCount = i;
    }

    public void setWidth(float f)
    {
        width = f;
    }

    public boolean update()
    {
        if(getComboCount() <= 0) goto _L2; else goto _L1
_L1:
        float f;
        float f1;
        int i;
        Object obj;
        if(getComboTime() < 0)
            determine();
        else
            setComboTime(getComboTime() - 1);
        if(getComboCount() <= getDisplayingCount() || getPreComboCount() == getComboCount()) goto _L4; else goto _L3
_L3:
        setPreComboCount(getComboCount());
        setNumbers(new ArrayList(4));
        i = getComboCount();
_L7:
        if(i > 0) goto _L6; else goto _L5
_L5:
        f1 = 0.0F;
        f = 0.0F;
        obj = getNumbers().listIterator(getNumbers().size() - 1);
_L8:
        if(((ListIterator) (obj)).hasPrevious())
            break MISSING_BLOCK_LABEL_318;
        float f2 = f1 + (float)getHitBitmap().getWidth();
        f1 = f;
        if(f < (float)getHitBitmap().getHeight())
            f1 = getHitBitmap().getHeight();
        setWidth(f2);
        setHeight(f1);
        setCenterDiff(f2 / 2.0F, f1 / 2.0F);
_L4:
        if(getComboCount() > getDisplayingCount())
            if(getEffectTime() > getEffectInterval())
            {
                setEffectTime(0);
                obj = new Effect(10);
                f = getX();
                f1 = getWidth();
                float f3 = (float)Math.random();
                float f5 = getY();
                float f7 = getHeight();
                float f8 = (float)Math.random();
                ((Effect) (obj)).offsetTo((f + f1 * f3) - ((Effect) (obj)).getCenterXdiff(), (f5 + f7 * f8) - ((Effect) (obj)).getCenterYdiff());
                ((Battle)getEngine().getGame()).getTop2Gom().add(((academy.yamamoto.android.game.GameObject) (obj)));
            } else
            {
                setEffectTime(getEffectTime() + 1);
            }
_L2:
        return true;
_L6:
        getNumbers().add(Integer.valueOf(i % 10));
        i /= 10;
          goto _L7
        Bitmap bitmap = (Bitmap)getNumberBitmaps().get(((Integer)((ListIterator) (obj)).previous()).intValue());
        float f6 = bitmap.getWidth();
        float f4 = f;
        if(f < (float)bitmap.getHeight())
            f4 = bitmap.getHeight();
        f1 = f1 + f6 + getMargin();
        f = f4;
          goto _L8
    }

    private int comboCount;
    private int comboDuration;
    private int comboMaxCount;
    private int comboTime;
    private int displayingCount;
    private int effectInterval;
    private int effectTime;
    private float height;
    private Bitmap hitBitmap;
    private float margin;
    private Vector numberBitmaps;
    private ArrayList numbers;
    private int preComboCount;
    private float width;
}
