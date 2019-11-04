// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.game;

import android.graphics.Canvas;

// Referenced classes of package academy.yamamoto.android.game:
//            GameEngine, GameObjectManager

public class GameObject
{

    public GameObject()
    {
        engine = null;
        manager = null;
        time = 0;
        deleted = false;
    }

    private void setDeleted(boolean flag)
    {
        deleted = flag;
    }

    public void delete()
    {
        setDeleted(true);
    }

    public void destroy()
    {
        delete();
    }

    public void draw(Canvas canvas)
    {
    }

    protected GameEngine getEngine()
    {
        return engine;
    }

    public GameObjectManager getManager()
    {
        return manager;
    }

    public int getTime()
    {
        return time;
    }

    public boolean hasEngine()
    {
        return getEngine() != null;
    }

    public boolean hasManager()
    {
        return getManager() != null;
    }

    public void initialize()
    {
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public void nextTime()
    {
        setTime(getTime() + 1);
    }

    public void setEngine(GameEngine gameengine)
    {
        engine = gameengine;
    }

    public void setManager(GameObjectManager gameobjectmanager)
    {
        manager = gameobjectmanager;
    }

    public void setTime(int i)
    {
        time = i;
    }

    public boolean update()
    {
        return !isDeleted();
    }

    private boolean deleted;
    private GameEngine engine;
    private GameObjectManager manager;
    private int time;
}
