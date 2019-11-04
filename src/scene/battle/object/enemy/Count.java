// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.enemy;


public class Count
{

    public Count()
    {
        count = 0;
        max = -1;
    }

    public Count(int i)
    {
        count = 0;
        max = -1;
        setMax(i);
    }

    private int getCount()
    {
        return count;
    }

    private void setCount(int i)
    {
        count = i;
    }

    public boolean check()
    {
        while(getMax() < 0 || getCount() < getMax()) 
            return false;
        return true;
    }

    public int getMax()
    {
        return max;
    }

    public void next()
    {
        setCount(getCount() + 1);
    }

    public void reset()
    {
        setCount(0);
    }

    public void setMax(int i)
    {
        max = i;
    }

    private int count;
    private int max;
}
