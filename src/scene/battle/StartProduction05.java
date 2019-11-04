// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle;

import academy.yamamoto.android.game.*;
import android.graphics.*;
import java.util.Iterator;
import java.util.Vector;
import main.*;

// Referenced classes of package scene.battle:
//            Battle

public class StartProduction05 extends GameObject2D
{
    private class EffectingChar extends GameObject2D
    {

        public void draw(Canvas canvas)
        {
            RectF rectf = (RectF)getDestRects().get(getEffectLevel());
            rectf.offsetTo(rectf.left + getMoveX() * (float)getEffectLevel(), rectf.top);
            canvas.drawBitmap((Bitmap)getEffectedBitmaps().get(getEffectLevel()), getSrcRect(), rectf, null);
        }

        public Vector getDestRects()
        {
            return destRects;
        }

        public int getEffectInterval()
        {
            return effectInterval;
        }

        public int getEffectLevel()
        {
            return effectLevel;
        }

        public int getEffectTime()
        {
            return effectTime;
        }

        public Vector getEffectedBitmaps()
        {
            return EffectedBitmaps;
        }

        public float getIncremental()
        {
            return incremental;
        }

        public float getMoveX()
        {
            return moveX;
        }

        public Rect getSrcRect()
        {
            return srcRect;
        }

        public int getStep()
        {
            return step;
        }

        public int getWaitTime()
        {
            return waitTime;
        }

        public void initialize()
        {
            setEffectedBitmaps(new Vector(4));
            setDestRects(new Vector(4));
            if(!hasBitmap()) goto _L2; else goto _L1
_L1:
            int i;
            int j;
            getEffectedBitmaps().add(getBitmap());
            getEffectedBitmaps().add(getBitmap());
            getEffectedBitmaps().add(getBitmap());
            getEffectedBitmaps().add(getBitmap());
            getEffectedBitmaps().add(getBitmap());
            setSrcRect(new Rect(0, 0, getBitmap().getWidth(), getBitmap().getHeight()));
            RectF rectf = new RectF(0.0F, 0.0F, getBitmap().getWidth(), getBitmap().getHeight());
            rectf.offsetTo(getX(), getY());
            getDestRects().add(rectf);
            i = 0;
            j = getEffectedBitmaps().size();
_L5:
            if(i < j) goto _L3; else goto _L2
_L2:
            return;
_L3:
            RectF rectf1 = new RectF(0.0F, 0.0F, (float)getBitmap().getWidth() + getIncremental() * 2.0F * (float)i, (float)getBitmap().getHeight() + getIncremental() * 2.0F * (float)i);
            rectf1.offsetTo(getX() - getIncremental() * (float)i, getY() - getIncremental() * (float)i);
            getDestRects().add(rectf1);
            i++;
            if(true) goto _L5; else goto _L4
_L4:
        }

        public void setDestRects(Vector vector)
        {
            destRects = vector;
        }

        public void setEffectInterval(int i)
        {
            effectInterval = i;
        }

        public void setEffectLevel(int i)
        {
            effectLevel = i;
        }

        public void setEffectTime(int i)
        {
            effectTime = i;
        }

        public void setEffectedBitmaps(Vector vector)
        {
            EffectedBitmaps = vector;
        }

        public void setIncremental(float f)
        {
            incremental = f;
        }

        public void setMoveX(float f)
        {
            moveX = f;
        }

        public void setSrcRect(Rect rect)
        {
            srcRect = rect;
        }

        public void setStep(int i)
        {
            step = i;
        }

        public void setWaitTime(int i)
        {
            waitTime = i;
        }

        public boolean update()
        {
            getStep();
            JVM INSTR tableswitch 0 1: default 28
        //                       0 34
        //                       1 58;
               goto _L1 _L2 _L3
_L1:
            nextTime();
            return true;
_L2:
            if(getTime() > getWaitTime())
                setStep(getStep() + 1);
            continue; /* Loop/switch isn't completed */
_L3:
            if(getEffectTime() > getEffectInterval())
            {
                setEffectLevel(getEffectLevel() + 1);
                if(getEffectLevel() >= getEffectedBitmaps().size())
                    return false;
            } else
            {
                setEffectTime(getEffectTime() + 1);
            }
            if(true) goto _L1; else goto _L4
_L4:
        }

        private Vector EffectedBitmaps;
        private Vector destRects;
        private int effectInterval;
        private int effectLevel;
        private int effectTime;
        private float incremental;
        private float moveX;
        private Rect srcRect;
        private int step;
        final StartProduction05 this$0;
        private int waitTime;

        private EffectingChar()
        {
            this$0 = StartProduction05.this;
            super();
            EffectedBitmaps = null;
            srcRect = null;
            destRects = null;
            incremental = 20F;
            effectLevel = 0;
            effectInterval = 3;
            effectTime = 0;
            moveX = 0.0F;
            waitTime = 3;
            step = 0;
        }

        EffectingChar(EffectingChar effectingchar)
        {
            this();
        }
    }


    public StartProduction05(Vector vector)
    {
        effectBitmaps = null;
        effectInterval = 1;
        effectTime = 0;
        productions = null;
        setProductions(vector);
    }

    public Vector getEffectBitmaps()
    {
        return effectBitmaps;
    }

    public int getEffectInterval()
    {
        return effectInterval;
    }

    public int getEffectTime()
    {
        return effectTime;
    }

    public Vector getProductions()
    {
        return productions;
    }

    public boolean hasEffectBitmaps()
    {
        return getEffectBitmaps() != null;
    }

    public void initialize()
    {
        offsetTo(400F, 300F);
        EffectingChar effectingchar = new EffectingChar(null);
        effectingchar.setBitmap(BitmapHolder.get(28));
        effectingchar.offsetTo(getX(), getY());
        offsetTo(getX() + (float)effectingchar.getBitmap().getWidth() + 5F, getY());
        effectingchar.setMoveX(-(effectingchar.getIncremental() * 2.0F * 2.0F));
        ((Battle)getEngine().getGame()).getTop2Gom().add(effectingchar);
        effectingchar = new EffectingChar(null);
        effectingchar.setBitmap(BitmapHolder.get(33));
        effectingchar.offsetTo(getX(), getY());
        offsetTo(getX() + (float)effectingchar.getBitmap().getWidth() + 5F, getY());
        effectingchar.setMoveX(-(effectingchar.getIncremental() * 2.0F));
        ((Battle)getEngine().getGame()).getTop2Gom().add(effectingchar);
        effectingchar = new EffectingChar(null);
        effectingchar.setBitmap(BitmapHolder.get(31));
        effectingchar.offsetTo(getX(), getY());
        offsetTo(getX() + (float)effectingchar.getBitmap().getWidth() + 5F, getY());
        ((Battle)getEngine().getGame()).getTop2Gom().add(effectingchar);
        effectingchar = new EffectingChar(null);
        effectingchar.setBitmap(BitmapHolder.get(32));
        effectingchar.offsetTo(getX(), getY());
        offsetTo(getX() + (float)effectingchar.getBitmap().getWidth() + 5F, getY());
        effectingchar.setMoveX(effectingchar.getIncremental() * 2.0F);
        ((Battle)getEngine().getGame()).getTop2Gom().add(effectingchar);
        effectingchar = new EffectingChar(null);
        effectingchar.setBitmap(BitmapHolder.get(46));
        effectingchar.offsetTo(getX(), getY());
        offsetTo(getX() + (float)effectingchar.getBitmap().getWidth() + 5F, getY());
        effectingchar.setMoveX(effectingchar.getIncremental() * 2.0F * 2.0F);
        ((Battle)getEngine().getGame()).getTop2Gom().add(effectingchar);
        SEHolder.play(getEngine().getContext(), 3);
    }

    public void setEffectBitmaps(Vector vector)
    {
        effectBitmaps = vector;
    }

    public void setEffectInterval(int i)
    {
        effectInterval = i;
    }

    public void setEffectTime(int i)
    {
        effectTime = i;
    }

    public void setProductions(Vector vector)
    {
        productions = vector;
    }

    public boolean update()
    {
        if(getEffectTime() < 1)
        {
            setEffectTime((int)((double)getEffectInterval() * Math.random()));
            Effect effect = new Effect(5);
            effect.offsetTo(400F + 500F * (float)Math.random(), 300F + 150F * (float)Math.random());
            ((Battle)getEngine().getGame()).getTop2Gom().add(effect);
        } else
        {
            setEffectTime(getEffectTime() - 1);
        }
        if(getTime() > 20)
        {
            Iterator iterator = getProductions().iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    ((Battle)getEngine().getGame()).getGom().dispatchAll();
                    return false;
                }
                ((GameObject2D)iterator.next()).delete();
            } while(true);
        } else
        {
            nextTime();
            return true;
        }
    }

    private Vector effectBitmaps;
    private int effectInterval;
    private int effectTime;
    private Vector productions;
}
