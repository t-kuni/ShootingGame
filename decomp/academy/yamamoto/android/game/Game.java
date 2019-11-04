// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.game;

import android.graphics.Canvas;

// Referenced classes of package academy.yamamoto.android.game:
//            GameEngine

public class Game
{

    public Game()
    {
        engine = null;
        virtualScreenWidth = 1280F;
        virtualScreenHeight = 768F;
    }

    public void destroy()
    {
    }

    public void draw(Canvas canvas)
    {
    }

    protected final GameEngine getEngine()
    {
        return engine;
    }

    public float getVirtualScreenHeight()
    {
        return virtualScreenHeight;
    }

    public float getVirtualScreenWidth()
    {
        return virtualScreenWidth;
    }

    public void initialize()
    {
    }

    protected final boolean isMounted()
    {
        return engine != null;
    }

    public void pause()
    {
    }

    public final void setEngine(GameEngine gameengine)
    {
        engine = gameengine;
    }

    public void setVirtualScreenHeight(float f)
    {
        virtualScreenHeight = f;
    }

    public void setVirtualScreenWidth(float f)
    {
        virtualScreenWidth = f;
    }

    public void start()
    {
    }

    public boolean update()
    {
        return true;
    }

    private GameEngine engine;
    private float virtualScreenHeight;
    private float virtualScreenWidth;
}
