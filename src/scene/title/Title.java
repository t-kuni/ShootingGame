// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.title;

import academy.yamamoto.android.game.*;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import java.util.Iterator;
import java.util.Vector;
import main.*;
import scene.battle.Battle;

// Referenced classes of package scene.title:
//            Menu

public class Title extends Game
{

    public Title()
    {
        touchState = null;
        logoBitmap = null;
        backBitmap = null;
        boardBitmap = null;
        menu = null;
        nextGame = null;
        effectsManager = null;
        touchEffectInterval = 3;
        touchEffectTime = 0;
        touchEffectBitmaps = null;
        brightLogoBitmaps = null;
        brightLogoBitmapIterator = null;
        illuminateLogoInterval = 25;
        illuminateLogoWaitTime = 50;
        logoEffectTime = 0;
        logoEffectTimeRange = 30;
        logoEffectBitmaps = null;
        fading = false;
        fadeLevel = 0;
    }

    private Bitmap getBackBitmap()
    {
        return backBitmap;
    }

    private Bitmap getBoardBitmap()
    {
        return boardBitmap;
    }

    private Iterator getBrightLogoBitmapIterator()
    {
        return brightLogoBitmapIterator;
    }

    private Vector getBrightLogoBitmaps()
    {
        return brightLogoBitmaps;
    }

    private GameObjectManager2D getEffectsManager()
    {
        return effectsManager;
    }

    private int getIlluminateLogoInterval()
    {
        return illuminateLogoInterval;
    }

    private int getIlluminateLogoWaitTime()
    {
        return illuminateLogoWaitTime;
    }

    private Bitmap getLogoBitmap()
    {
        return logoBitmap;
    }

    private Vector getLogoEffectBitmaps()
    {
        return logoEffectBitmaps;
    }

    private int getLogoEffectTime()
    {
        return logoEffectTime;
    }

    private int getLogoEffectTimeRange()
    {
        return logoEffectTimeRange;
    }

    private Menu getMenu()
    {
        return menu;
    }

    private Game getNextGame()
    {
        return nextGame;
    }

    private Vector getTouchEffectBitmaps()
    {
        return touchEffectBitmaps;
    }

    private boolean hasNextGame()
    {
        return getNextGame() != null;
    }

    private boolean isFading()
    {
        return fading;
    }

    private void setBackBitmap(Bitmap bitmap)
    {
        backBitmap = bitmap;
    }

    private void setBoardBitmap(Bitmap bitmap)
    {
        boardBitmap = bitmap;
    }

    private void setBrightLogoBitmapIterator(Iterator iterator)
    {
        brightLogoBitmapIterator = iterator;
    }

    private void setBrightLogoBitmaps(Vector vector)
    {
        brightLogoBitmaps = vector;
    }

    private void setEffectsManager(GameObjectManager2D gameobjectmanager2d)
    {
        effectsManager = gameobjectmanager2d;
    }

    private void setFading(boolean flag)
    {
        fading = flag;
    }

    private void setIlluminateLogoInterval(int i)
    {
        illuminateLogoInterval = i;
    }

    private void setIlluminateLogoWaitTime(int i)
    {
        illuminateLogoWaitTime = i;
    }

    private void setLogoBitmap(Bitmap bitmap)
    {
        logoBitmap = bitmap;
    }

    private void setLogoEffectBitmaps(Vector vector)
    {
        logoEffectBitmaps = vector;
    }

    private void setLogoEffectTime(int i)
    {
        logoEffectTime = i;
    }

    private void setLogoEffectTimeRange(int i)
    {
        logoEffectTimeRange = i;
    }

    private void setMenu(Menu menu1)
    {
        menu = menu1;
    }

    private void setNextGame(Game game)
    {
        nextGame = game;
    }

    private void setTouchEffectBitmaps(Vector vector)
    {
        touchEffectBitmaps = vector;
    }

    private void toNextGame()
    {
        BGMHolder.destroy(0x7f040010);
        getEngine().setGame(getNextGame()).destroy();
    }

    public void destroy()
    {
        super.destroy();
        destroyBitmaps();
        System.gc();
    }

    public void destroyBitmaps()
    {
        BitmapHolder.destroy(93);
        BitmapHolder.destroy(120);
        BitmapHolder.destroy(121);
        BitmapHolder.destroy(122);
        BitmapHolder.destroy(123);
        BitmapHolder.destroy(90);
        BitmapHolder.destroy(91);
        BitmapHolder.destroy(26);
        BitmapHolder.destroy(37);
        BitmapHolder.destroy(24);
        BitmapHolder.destroy(42);
        BitmapHolder.destroy(43);
        BitmapHolder.destroy(39);
        BitmapHolder.destroy(35);
        BitmapHolder.destroy(22);
        BitmapHolder.destroy(34);
    }

    public void draw(Canvas canvas)
    {
        Bitmap bitmap;
        canvas.drawBitmap(getBackBitmap(), 0.0F, 0.0F, null);
        if(getBrightLogoBitmapIterator() != null && getBrightLogoBitmapIterator().hasNext())
        {
            bitmap = (Bitmap)getBrightLogoBitmapIterator().next();
        } else
        {
            setBrightLogoBitmapIterator(null);
            bitmap = getLogoBitmap();
        }
        if(bitmap != null)
            canvas.drawBitmap(bitmap, 10F, 10F, null);
        canvas.drawBitmap(getBoardBitmap(), 283F, 325F, null);
        getMenu().draw(canvas);
        getEffectsManager().draw(canvas);
        if(!isFading()) goto _L2; else goto _L1
_L1:
        getFadeLevel();
        JVM INSTR tableswitch 0 4: default 132
    //                   0 191
    //                   1 199
    //                   2 207
    //                   3 216
    //                   4 225;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        bitmap = BitmapHolder.get(8);
_L10:
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, null);
        setFadeLevel(getFadeLevel() + 1);
        if(getFadeLevel() >= 20)
            setNextGame(new Battle(0));
_L2:
        return;
_L4:
        bitmap = BitmapHolder.get(4);
        continue; /* Loop/switch isn't completed */
_L5:
        bitmap = BitmapHolder.get(5);
        continue; /* Loop/switch isn't completed */
_L6:
        bitmap = BitmapHolder.get(6);
        continue; /* Loop/switch isn't completed */
_L7:
        bitmap = BitmapHolder.get(7);
        continue; /* Loop/switch isn't completed */
_L8:
        bitmap = BitmapHolder.get(8);
        if(true) goto _L10; else goto _L9
_L9:
    }

    public int getFadeLevel()
    {
        return fadeLevel;
    }

    public int getTouchEffectInterval()
    {
        return touchEffectInterval;
    }

    public int getTouchEffectTime()
    {
        return touchEffectTime;
    }

    public TouchState getTouchState()
    {
        return touchState;
    }

    public void illuminateLogo()
    {
        setBrightLogoBitmapIterator(getBrightLogoBitmaps().iterator());
    }

    public void initialize()
    {
        setVirtualScreenWidth(544F);
        setVirtualScreenHeight(416F);
        setTouchState(getEngine().getTouchState());
        BGMHolder.load(getEngine().getContext(), 0x7f040010);
        BGMHolder.get(0x7f040010).setLooping(true);
        BGMHolder.get(0x7f040010).start();
        loadBitmaps();
        setLogoBitmap(BitmapHolder.get(93));
        setBrightLogoBitmaps(new Vector(5));
        getBrightLogoBitmaps().add(BitmapHolder.get(120));
        getBrightLogoBitmaps().add(BitmapHolder.get(121));
        getBrightLogoBitmaps().add(BitmapHolder.get(122));
        getBrightLogoBitmaps().add(BitmapHolder.get(123));
        getBrightLogoBitmaps().add(BitmapHolder.get(122));
        getBrightLogoBitmaps().add(BitmapHolder.get(121));
        getBrightLogoBitmaps().add(BitmapHolder.get(120));
        setBackBitmap(BitmapHolder.get(90));
        setBoardBitmap(BitmapHolder.get(91));
        setMenu(new Menu(getEngine()));
        setEffectsManager(new GameObjectManager2D(getEngine()));
    }

    public void loadBitmaps()
    {
        BitmapHolder.load(getEngine().getContext(), 93);
        BitmapHolder.load(getEngine().getContext(), 120);
        BitmapHolder.load(getEngine().getContext(), 121);
        BitmapHolder.load(getEngine().getContext(), 122);
        BitmapHolder.load(getEngine().getContext(), 123);
        BitmapHolder.load(getEngine().getContext(), 90);
        BitmapHolder.load(getEngine().getContext(), 91);
        BitmapHolder.load(getEngine().getContext(), 4);
        BitmapHolder.load(getEngine().getContext(), 5);
        BitmapHolder.load(getEngine().getContext(), 6);
        BitmapHolder.load(getEngine().getContext(), 7);
        BitmapHolder.load(getEngine().getContext(), 8);
        BitmapHolder.load(getEngine().getContext(), 26);
        BitmapHolder.load(getEngine().getContext(), 37);
        BitmapHolder.load(getEngine().getContext(), 24);
        BitmapHolder.load(getEngine().getContext(), 42);
        BitmapHolder.load(getEngine().getContext(), 43);
        BitmapHolder.load(getEngine().getContext(), 39);
        BitmapHolder.load(getEngine().getContext(), 35);
        BitmapHolder.load(getEngine().getContext(), 22);
        BitmapHolder.load(getEngine().getContext(), 34);
    }

    public void pause()
    {
        BGMHolder.get(0x7f040010).pause();
    }

    public void setFadeLevel(int i)
    {
        fadeLevel = i;
    }

    public void setTouchEffectInterval(int i)
    {
        touchEffectInterval = i;
    }

    public void setTouchEffectTime(int i)
    {
        touchEffectTime = i;
    }

    public void setTouchState(TouchState touchstate)
    {
        touchState = touchstate;
    }

    public void start()
    {
        BGMHolder.get(0x7f040010).start();
    }

    public boolean update()
    {
        if(getTouchEffectTime() > 0)
            setTouchEffectTime(getTouchEffectTime() - 1);
        if(getTouchState().containsKey(Integer.valueOf(0)))
        {
            if(!isFading() && !((TouchPointer)getTouchState().get(Integer.valueOf(0))).isMarked())
            {
                ((TouchPointer)getTouchState().get(Integer.valueOf(0))).mark(0);
                float f = ((TouchPointer)getTouchState().get(Integer.valueOf(0))).x;
                float f2 = ((TouchPointer)getTouchState().get(Integer.valueOf(0))).y;
                if(f > 323F && f2 > 333F && f < 531F && f2 < 365F)
                {
                    SEHolder.play(getEngine().getContext(), 14);
                    setFading(true);
                }
            }
            if(getTouchEffectTime() == 0)
            {
                Effect effect = new Effect(2);
                effect.offsetTo(((TouchPointer)getTouchState().get(Integer.valueOf(0))).x - effect.getCenterXdiff(), ((TouchPointer)getTouchState().get(Integer.valueOf(0))).y - effect.getCenterYdiff());
                getEffectsManager().add(effect);
                setTouchEffectTime(getTouchEffectInterval());
            }
        }
        if(getIlluminateLogoWaitTime() > getIlluminateLogoInterval())
        {
            illuminateLogo();
            setIlluminateLogoWaitTime(0);
        } else
        {
            setIlluminateLogoWaitTime(getIlluminateLogoWaitTime() + 1);
        }
        if(getLogoEffectTime() < 0)
        {
            float f1 = getLogoBitmap().getWidth();
            float f3 = (float)Math.random();
            float f4 = getLogoBitmap().getHeight();
            float f5 = (float)Math.random();
            Effect effect1 = new Effect(3);
            setLogoEffectTime((int)((double)getLogoEffectTimeRange() * Math.random()));
            effect1.offsetTo(f1 * f3 - effect1.getCenterXdiff(), f4 * f5 - effect1.getCenterYdiff());
            getEffectsManager().add(effect1);
        } else
        {
            setLogoEffectTime(getLogoEffectTime() - 1);
        }
        getMenu().update();
        getEffectsManager().update();
        if(hasNextGame())
            toNextGame();
        return true;
    }

    private Bitmap backBitmap;
    private Bitmap boardBitmap;
    private Iterator brightLogoBitmapIterator;
    private Vector brightLogoBitmaps;
    private GameObjectManager2D effectsManager;
    private int fadeLevel;
    private boolean fading;
    private int illuminateLogoInterval;
    private int illuminateLogoWaitTime;
    private Bitmap logoBitmap;
    private Vector logoEffectBitmaps;
    private int logoEffectTime;
    private int logoEffectTimeRange;
    private Menu menu;
    private Game nextGame;
    private Vector touchEffectBitmaps;
    private int touchEffectInterval;
    private int touchEffectTime;
    private TouchState touchState;
}
