// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle;

import academy.yamamoto.android.game.GameEngine;
import academy.yamamoto.android.game.GameObjectManager2D;

// Referenced classes of package scene.battle:
//            Cloud

public class CloudManager extends GameObjectManager2D
{

    public CloudManager(GameEngine gameengine)
    {
        super(gameengine);
        nextTime = 0;
        nextTimeLength = 50;
        randNextTime();
    }

    public int getNextTime()
    {
        return nextTime;
    }

    public int getNextTimeLength()
    {
        return nextTimeLength;
    }

    public void randNextTime()
    {
        setNextTime((int)((double)getNextTimeLength() * Math.random()));
    }

    public void setNextTime(int i)
    {
        nextTime = i;
    }

    public void setNextTimeLength(int i)
    {
        nextTimeLength = i;
    }

    public void update()
    {
        super.update();
        lockObjects();
        if(getNextTime() <= 0)
        {
            add(new Cloud());
            randNextTime();
        }
        setNextTime(getNextTime() - 1);
        unlockObjects();
    }

    private int nextTime;
    private int nextTimeLength;
}
