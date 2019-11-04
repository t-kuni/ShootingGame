// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.title;

import academy.yamamoto.android.game.*;
import android.graphics.Canvas;
import main.BitmapHolder;

public class Menu extends GameObjectManager2D
{
    private class MenuCharactor extends GameObject2D
    {

        private float getDy()
        {
            return dy;
        }

        private float getHeight()
        {
            return height;
        }

        private float getProgress()
        {
            return progress;
        }

        private float getProgressInc()
        {
            return progressInc;
        }

        private void setDy(float f)
        {
            dy = f;
        }

        private void setHeight(float f)
        {
            height = f;
        }

        private void setProgress(float f)
        {
            progress = f;
        }

        private void setProgressInc(float f)
        {
            progressInc = f;
        }

        public void draw(Canvas canvas)
        {
            canvas.drawBitmap(getBitmap(), getX(), getY() - getDy(), null);
        }

        public int getInterval()
        {
            return interval;
        }

        public int getTime()
        {
            return time;
        }

        public void setInterval(int i)
        {
            interval = i;
        }

        public void setTime(int i)
        {
            time = i;
        }

        public boolean update()
        {
            if(getTime() > getInterval())
            {
                setProgress(getProgress() + getProgressInc());
                if((double)getProgress() >= 3.1415926535897931D)
                {
                    setProgress(0.0F);
                    setTime(0);
                    setDy(0.0F);
                } else
                {
                    setDy(getHeight() * (float)Math.sin(getProgress()));
                }
            } else
            {
                setTime(getTime() + 1);
            }
            return true;
        }

        private float dy;
        private float height;
        private int interval;
        private float progress;
        private float progressInc;
        final Menu this$0;
        private int time;

        private MenuCharactor()
        {
            this$0 = Menu.this;
            super();
            dy = 0.0F;
            height = 15F;
            interval = 50;
            time = 0;
            progress = 0.0F;
            progressInc = 0.5235988F;
        }

        MenuCharactor(MenuCharactor menucharactor)
        {
            this();
        }
    }


    public Menu(GameEngine gameengine)
    {
        super(gameengine);
        charA = null;
        charD = null;
        charE = null;
        charL = null;
        charM = null;
        charN = null;
        charO = null;
        charR = null;
        charS = null;
        gameengine = new MenuCharactor(null);
        gameengine.setBitmap(BitmapHolder.get(26));
        gameengine.offsetTo(325F, 370F);
        gameengine.setTime(25);
        add(gameengine);
        gameengine = new MenuCharactor(null);
        gameengine.setBitmap(BitmapHolder.get(37));
        gameengine.offsetTo(355F, 370F);
        gameengine.setTime(23);
        add(gameengine);
        gameengine = new MenuCharactor(null);
        gameengine.setBitmap(BitmapHolder.get(24));
        gameengine.offsetTo(388F, 370F);
        gameengine.setTime(21);
        add(gameengine);
        gameengine = new MenuCharactor(null);
        gameengine.setBitmap(BitmapHolder.get(42));
        gameengine.offsetTo(420F, 370F);
        gameengine.setTime(19);
        add(gameengine);
        gameengine = new MenuCharactor(null);
        gameengine.setBitmap(BitmapHolder.get(26));
        gameengine.offsetTo(450F, 370F);
        gameengine.setTime(17);
        add(gameengine);
        gameengine = new MenuCharactor(null);
        gameengine.setBitmap(BitmapHolder.get(43));
        gameengine.offsetTo(480F, 370F);
        gameengine.setTime(15);
        add(gameengine);
        gameengine = new MenuCharactor(null);
        gameengine.setBitmap(BitmapHolder.get(43));
        gameengine.offsetTo(505F, 370F);
        gameengine.setTime(13);
        add(gameengine);
        gameengine = new MenuCharactor(null);
        gameengine.setBitmap(BitmapHolder.get(37));
        gameengine.offsetTo(327F, 333F);
        gameengine.setTime(50);
        add(gameengine);
        gameengine = new MenuCharactor(null);
        gameengine.setBitmap(BitmapHolder.get(39));
        gameengine.offsetTo(359F, 333F);
        gameengine.setTime(48);
        add(gameengine);
        gameengine = new MenuCharactor(null);
        gameengine.setBitmap(BitmapHolder.get(42));
        gameengine.offsetTo(394F, 333F);
        gameengine.setTime(46);
        add(gameengine);
        gameengine = new MenuCharactor(null);
        gameengine.setBitmap(BitmapHolder.get(35));
        gameengine.offsetTo(422F, 333F);
        gameengine.setTime(44);
        add(gameengine);
        gameengine = new MenuCharactor(null);
        gameengine.setBitmap(BitmapHolder.get(22));
        gameengine.offsetTo(460F, 333F);
        gameengine.setTime(42);
        add(gameengine);
        gameengine = new MenuCharactor(null);
        gameengine.setBitmap(BitmapHolder.get(34));
        gameengine.offsetTo(495F, 333F);
        gameengine.setTime(40);
        add(gameengine);
    }

    public MenuCharactor getCharA()
    {
        return charA;
    }

    public MenuCharactor getCharD()
    {
        return charD;
    }

    public MenuCharactor getCharE()
    {
        return charE;
    }

    public MenuCharactor getCharL()
    {
        return charL;
    }

    public MenuCharactor getCharM()
    {
        return charM;
    }

    public MenuCharactor getCharN()
    {
        return charN;
    }

    public MenuCharactor getCharO()
    {
        return charO;
    }

    public MenuCharactor getCharR()
    {
        return charR;
    }

    public MenuCharactor getCharS()
    {
        return charS;
    }

    public void setCharA(MenuCharactor menucharactor)
    {
        charA = menucharactor;
    }

    public void setCharD(MenuCharactor menucharactor)
    {
        charD = menucharactor;
    }

    public void setCharE(MenuCharactor menucharactor)
    {
        charE = menucharactor;
    }

    public void setCharL(MenuCharactor menucharactor)
    {
        charL = menucharactor;
    }

    public void setCharM(MenuCharactor menucharactor)
    {
        charM = menucharactor;
    }

    public void setCharN(MenuCharactor menucharactor)
    {
        charN = menucharactor;
    }

    public void setCharO(MenuCharactor menucharactor)
    {
        charO = menucharactor;
    }

    public void setCharR(MenuCharactor menucharactor)
    {
        charR = menucharactor;
    }

    public void setCharS(MenuCharactor menucharactor)
    {
        charS = menucharactor;
    }

    private MenuCharactor charA;
    private MenuCharactor charD;
    private MenuCharactor charE;
    private MenuCharactor charL;
    private MenuCharactor charM;
    private MenuCharactor charN;
    private MenuCharactor charO;
    private MenuCharactor charR;
    private MenuCharactor charS;
}
