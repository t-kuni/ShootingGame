// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle;

import academy.yamamoto.android.game.*;
import android.graphics.Bitmap;
import java.util.Vector;
import main.BitmapHolder;
import main.SEHolder;

// Referenced classes of package scene.battle:
//            Battle, Ray, StartProduction05

public class StartProduction04 extends GameObject2D
{
    private class SlideChar extends GameObject2D
    {

        public float getProgress()
        {
            return progress;
        }

        public float getProgressInc()
        {
            return progressInc;
        }

        public int getStep()
        {
            return step;
        }

        public float getStopX()
        {
            return stopX;
        }

        public int getWaitTime()
        {
            return waitTime;
        }

        public int getWaitTimeOut()
        {
            return waitTimeOut;
        }

        public void initialize()
        {
            float f;
            if(hasBitmap())
                f = getEngine().getGame().getVirtualScreenHeight() / 2.0F - (float)(getBitmap().getHeight() / 2);
            else
                f = getEngine().getGame().getVirtualScreenHeight() / 2.0F;
            offsetTo(getEngine().getGame().getVirtualScreenWidth(), f);
            SEHolder.load(getEngine().getContext(), 9);
        }

        public void setProgress(float f)
        {
            progress = f;
        }

        public void setProgressInc(float f)
        {
            progressInc = f;
        }

        public void setStep(int i)
        {
            step = i;
        }

        public void setStopX(float f)
        {
            stopX = f;
        }

        public void setWaitTime(int i)
        {
            waitTime = i;
        }

        public void setWaitTimeOut(int i)
        {
            waitTimeOut = i;
        }

        public boolean update()
        {
            getStep();
            JVM INSTR tableswitch 0 3: default 36
        //                       0 38
        //                       1 124
        //                       2 175
        //                       3 261;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            return true;
_L2:
            setProgress(getProgress() + getProgressInc());
            float f = (getEngine().getGame().getVirtualScreenWidth() - getStopX()) / 2.0F;
            if(getProgress() > 3.141593F)
            {
                setProgress(3.141593F);
                setStep(getStep() + 1);
            }
            offsetTo(getStopX() + f + (float)Math.cos(getProgress()) * f, getY());
            continue; /* Loop/switch isn't completed */
_L3:
            setWaitTime(getWaitTime() + 1);
            if(getWaitTime() > getWaitTimeOut())
            {
                setStep(getStep() + 1);
                SEHolder.play(getEngine().getContext(), 9);
            }
            setProgress(0.0F);
            continue; /* Loop/switch isn't completed */
_L4:
            setProgress(getProgress() + getProgressInc());
            float f1 = ((float)getBitmap().getWidth() + getStopX()) / 2.0F;
            if((double)getProgress() > 3.1415926535897931D)
            {
                setProgress(3.141593F);
                setStep(3);
            }
            offsetTo((float)(-getBitmap().getWidth()) + f1 + (float)Math.cos(getProgress()) * f1, getY());
            if(true) goto _L1; else goto _L5
_L5:
            return false;
        }

        private float progress;
        private float progressInc;
        private int step;
        private float stopX;
        final StartProduction04 this$0;
        private int waitTime;
        private int waitTimeOut;

        private SlideChar()
        {
            this$0 = StartProduction04.this;
            super();
            stopX = 500F;
            waitTimeOut = 10;
            waitTime = 0;
            progress = 0.0F;
            progressInc = 0.2617994F;
            step = 0;
        }

        SlideChar(SlideChar slidechar)
        {
            this();
        }
    }


    public StartProduction04(Vector vector)
    {
        charAbitmap = null;
        charDbitmap = null;
        charEbitmap = null;
        charFbitmap = null;
        charGbitmap = null;
        charHbitmap = null;
        charIbitmap = null;
        charRbitmap = null;
        charTbitmap = null;
        charYbitmap = null;
        rayInterval = 0.0F;
        rayWaitTime = 0;
        shootingRay = true;
        stopX = 100F;
        stopMargin = 5F;
        productions = null;
        setProductions(vector);
    }

    public Bitmap getCharAbitmap()
    {
        return charAbitmap;
    }

    public Bitmap getCharDbitmap()
    {
        return charDbitmap;
    }

    public Bitmap getCharEbitmap()
    {
        return charEbitmap;
    }

    public Bitmap getCharFbitmap()
    {
        return charFbitmap;
    }

    public Bitmap getCharGbitmap()
    {
        return charGbitmap;
    }

    public Bitmap getCharHbitmap()
    {
        return charHbitmap;
    }

    public Bitmap getCharIbitmap()
    {
        return charIbitmap;
    }

    public Bitmap getCharRbitmap()
    {
        return charRbitmap;
    }

    public Bitmap getCharTbitmap()
    {
        return charTbitmap;
    }

    public Bitmap getCharYbitmap()
    {
        return charYbitmap;
    }

    public Vector getProductions()
    {
        return productions;
    }

    public float getRayInterval()
    {
        return rayInterval;
    }

    public int getRayWaitTime()
    {
        return rayWaitTime;
    }

    public float getStopMargin()
    {
        return stopMargin;
    }

    public float getStopX()
    {
        return stopX;
    }

    public void initialize()
    {
        setCharAbitmap(BitmapHolder.get(21));
        setCharDbitmap(BitmapHolder.get(23));
        setCharEbitmap(BitmapHolder.get(25));
        setCharFbitmap(BitmapHolder.get(28));
        setCharGbitmap(BitmapHolder.get(31));
        setCharHbitmap(BitmapHolder.get(32));
        setCharIbitmap(BitmapHolder.get(33));
        setCharRbitmap(BitmapHolder.get(41));
        setCharTbitmap(BitmapHolder.get(46));
        setCharYbitmap(BitmapHolder.get(49));
        SEHolder.play(getEngine().getContext(), 1);
    }

    public boolean isShootingRay()
    {
        return shootingRay;
    }

    public void setCharAbitmap(Bitmap bitmap)
    {
        charAbitmap = bitmap;
    }

    public void setCharDbitmap(Bitmap bitmap)
    {
        charDbitmap = bitmap;
    }

    public void setCharEbitmap(Bitmap bitmap)
    {
        charEbitmap = bitmap;
    }

    public void setCharFbitmap(Bitmap bitmap)
    {
        charFbitmap = bitmap;
    }

    public void setCharGbitmap(Bitmap bitmap)
    {
        charGbitmap = bitmap;
    }

    public void setCharHbitmap(Bitmap bitmap)
    {
        charHbitmap = bitmap;
    }

    public void setCharIbitmap(Bitmap bitmap)
    {
        charIbitmap = bitmap;
    }

    public void setCharRbitmap(Bitmap bitmap)
    {
        charRbitmap = bitmap;
    }

    public void setCharTbitmap(Bitmap bitmap)
    {
        charTbitmap = bitmap;
    }

    public void setCharYbitmap(Bitmap bitmap)
    {
        charYbitmap = bitmap;
    }

    public void setProductions(Vector vector)
    {
        productions = vector;
    }

    public void setRayInterval(float f)
    {
        rayInterval = f;
    }

    public void setRayWaitTime(int i)
    {
        rayWaitTime = i;
    }

    public void setShootingRay(boolean flag)
    {
        shootingRay = flag;
    }

    public void setStopMargin(float f)
    {
        stopMargin = f;
    }

    public void setStopX(float f)
    {
        stopX = f;
    }

    public boolean update()
    {
        getTime();
        JVM INSTR lookupswitch 8: default 80
    //                   9: 190
    //                   12: 264
    //                   15: 338
    //                   18: 423
    //                   21: 497
    //                   24: 571
    //                   27: 645
    //                   30: 719;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        break; /* Loop/switch isn't completed */
_L9:
        break MISSING_BLOCK_LABEL_719;
_L10:
        SlideChar slidechar;
        if(isShootingRay())
            if(getRayWaitTime() < 0)
            {
                setRayWaitTime((int)(getRayInterval() * (float)Math.random()));
                ((Battle)getEngine().getGame()).getTopGom().add(new Ray());
            } else
            {
                setRayWaitTime(getRayWaitTime() - 1);
            }
        if(isShootingRay() && getTime() > 70)
            setShootingRay(false);
        if(getTime() > 85)
        {
            ((Battle)getEngine().getGame()).getTopGom().add(new StartProduction05(getProductions()));
            return false;
        } else
        {
            nextTime();
            return true;
        }
_L2:
        slidechar = new SlideChar(null);
        slidechar.setBitmap(getCharGbitmap());
        slidechar.setStopX(getStopX());
        setStopX(getStopX() + getStopMargin() + (float)slidechar.getBitmap().getWidth());
        slidechar.setWaitTimeOut(30);
        ((Battle)getEngine().getGame()).getTop2Gom().add(slidechar);
          goto _L10
_L3:
        slidechar = new SlideChar(null);
        slidechar.setBitmap(getCharEbitmap());
        slidechar.setStopX(getStopX());
        setStopX(getStopX() + getStopMargin() + (float)slidechar.getBitmap().getWidth());
        slidechar.setWaitTimeOut(30);
        ((Battle)getEngine().getGame()).getTop2Gom().add(slidechar);
          goto _L10
_L4:
        slidechar = new SlideChar(null);
        slidechar.setBitmap(getCharTbitmap());
        slidechar.setStopX(getStopX());
        setStopX(getStopX() + getStopMargin() + (float)slidechar.getBitmap().getWidth());
        slidechar.setWaitTimeOut(30);
        ((Battle)getEngine().getGame()).getTop2Gom().add(slidechar);
        setStopX(getStopX() + 150F);
          goto _L10
_L5:
        slidechar = new SlideChar(null);
        slidechar.setBitmap(getCharRbitmap());
        slidechar.setStopX(getStopX());
        setStopX(getStopX() + getStopMargin() + (float)slidechar.getBitmap().getWidth());
        slidechar.setWaitTimeOut(30);
        ((Battle)getEngine().getGame()).getTop2Gom().add(slidechar);
          goto _L10
_L6:
        slidechar = new SlideChar(null);
        slidechar.setBitmap(getCharEbitmap());
        slidechar.setStopX(getStopX());
        setStopX(getStopX() + getStopMargin() + (float)slidechar.getBitmap().getWidth());
        slidechar.setWaitTimeOut(30);
        ((Battle)getEngine().getGame()).getTop2Gom().add(slidechar);
          goto _L10
_L7:
        slidechar = new SlideChar(null);
        slidechar.setBitmap(getCharAbitmap());
        slidechar.setStopX(getStopX());
        setStopX(getStopX() + getStopMargin() + (float)slidechar.getBitmap().getWidth());
        slidechar.setWaitTimeOut(30);
        ((Battle)getEngine().getGame()).getTop2Gom().add(slidechar);
          goto _L10
_L8:
        slidechar = new SlideChar(null);
        slidechar.setBitmap(getCharDbitmap());
        slidechar.setStopX(getStopX());
        setStopX(getStopX() + getStopMargin() + (float)slidechar.getBitmap().getWidth());
        slidechar.setWaitTimeOut(30);
        ((Battle)getEngine().getGame()).getTop2Gom().add(slidechar);
          goto _L10
        slidechar = new SlideChar(null);
        slidechar.setBitmap(getCharYbitmap());
        slidechar.setStopX(getStopX());
        setStopX(getStopX() + getStopMargin() + (float)slidechar.getBitmap().getWidth());
        slidechar.setWaitTimeOut(30);
        ((Battle)getEngine().getGame()).getTop2Gom().add(slidechar);
          goto _L10
    }

    private static final int WAIT_TIME = 30;
    private Bitmap charAbitmap;
    private Bitmap charDbitmap;
    private Bitmap charEbitmap;
    private Bitmap charFbitmap;
    private Bitmap charGbitmap;
    private Bitmap charHbitmap;
    private Bitmap charIbitmap;
    private Bitmap charRbitmap;
    private Bitmap charTbitmap;
    private Bitmap charYbitmap;
    private Vector productions;
    private float rayInterval;
    private int rayWaitTime;
    private boolean shootingRay;
    private float stopMargin;
    private float stopX;
}
