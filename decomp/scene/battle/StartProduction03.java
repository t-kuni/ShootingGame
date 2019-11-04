// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle;

import academy.yamamoto.android.game.*;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.Vector;
import main.BitmapHolder;

// Referenced classes of package scene.battle:
//            Battle, StartProduction04

public class StartProduction03 extends GameObject2D
{

    public StartProduction03(Vector vector)
    {
        step = 0;
        bandBitmap = null;
        bandHeight = 0;
        bandHeightInc = 15;
        productionTimeEnded = false;
        filterBitmap = null;
        filterLevel = 0;
        filterBitmaps = null;
        productions = null;
        setProductions(vector);
    }

    public void delete()
    {
        super.delete();
        setStep(0);
    }

    public void draw(Canvas canvas)
    {
        float f = getBandHeight() - 128;
        canvas.drawBitmap(getBandBitmap(), 0.0F, f, null);
        f = getEngine().getGame().getVirtualScreenHeight();
        float f1 = getBandHeight();
        canvas.drawBitmap(getBandBitmap(), 0.0F, f - f1, null);
        if(hasFilterBitmap())
            canvas.drawBitmap(getFilterBitmap(), 0.0F, 128F, null);
    }

    public Bitmap getBandBitmap()
    {
        return bandBitmap;
    }

    public int getBandHeight()
    {
        return bandHeight;
    }

    public int getBandHeightInc()
    {
        return bandHeightInc;
    }

    public Bitmap getFilterBitmap()
    {
        return filterBitmap;
    }

    public Vector getFilterBitmaps()
    {
        return filterBitmaps;
    }

    public int getFilterLevel()
    {
        return filterLevel;
    }

    public Vector getProductions()
    {
        return productions;
    }

    public int getStep()
    {
        return step;
    }

    public boolean hasFilterBitmap()
    {
        return getFilterBitmap() != null;
    }

    public void initialize()
    {
        setBandBitmap(BitmapHolder.get(3));
        setFilterBitmaps(new Vector(4));
        getFilterBitmaps().add(BitmapHolder.get(9));
        getFilterBitmaps().add(BitmapHolder.get(10));
        getFilterBitmaps().add(BitmapHolder.get(11));
    }

    public boolean isProductionTimeEnded()
    {
        return productionTimeEnded;
    }

    public void setBandBitmap(Bitmap bitmap)
    {
        bandBitmap = bitmap;
    }

    public void setBandHeight(int i)
    {
        bandHeight = i;
    }

    public void setBandHeightInc(int i)
    {
        bandHeightInc = i;
    }

    public void setFilterBitmap(Bitmap bitmap)
    {
        filterBitmap = bitmap;
    }

    public void setFilterBitmaps(Vector vector)
    {
        filterBitmaps = vector;
    }

    public void setFilterLevel(int i)
    {
        filterLevel = i;
    }

    public void setProductionTimeEnded(boolean flag)
    {
        productionTimeEnded = flag;
    }

    public void setProductions(Vector vector)
    {
        productions = vector;
    }

    public void setStep(int i)
    {
        step = i;
    }

    public boolean update()
    {
        if(!isDeleted()) goto _L2; else goto _L1
_L1:
        getStep();
        JVM INSTR tableswitch 0 1: default 32
    //                   0 34
    //                   1 145;
           goto _L3 _L4 _L5
_L3:
        return false;
_L4:
        if(getFilterLevel() > 0)
        {
            setFilterLevel(getFilterLevel() - 1);
            setFilterBitmap((Bitmap)getFilterBitmaps().get(getFilterLevel()));
        } else
        {
            setStep(getStep() + 1);
        }
_L7:
        if(!isProductionTimeEnded() && getTime() > 15)
        {
            setProductionTimeEnded(true);
            getProductions().add(this);
            ((Battle)getEngine().getGame()).getTopGom().add(new StartProduction04(getProductions()));
        }
        nextTime();
        return true;
_L5:
        if(getBandHeight() > 0)
        {
            setBandHeight(getBandHeight() - getBandHeightInc());
            if(getBandHeight() < 0)
            {
                setBandHeight(0);
                setStep(getStep() + 1);
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        switch(getStep())
        {
        default:
            break;

        case 0: // '\0'
            if(getBandHeight() >= 128)
                break;
            setBandHeight(getBandHeight() + getBandHeightInc());
            if(getBandHeight() > 128)
            {
                setBandHeight(128);
                setStep(getStep() + 1);
            }
            break;

        case 1: // '\001'
            if(getFilterLevel() < 3)
            {
                setFilterBitmap((Bitmap)getFilterBitmaps().get(getFilterLevel()));
                setFilterLevel(getFilterLevel() + 1);
            } else
            {
                setStep(getStep() + 1);
            }
            break;
        }
        if(true) goto _L7; else goto _L6
_L6:
    }

    private Bitmap bandBitmap;
    private int bandHeight;
    private int bandHeightInc;
    private Bitmap filterBitmap;
    private Vector filterBitmaps;
    private int filterLevel;
    private boolean productionTimeEnded;
    private Vector productions;
    private int step;
}
