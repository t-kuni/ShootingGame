// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.general;


public class Counter
{

    public Counter(int i)
    {
        count = 0;
        def = 0;
        max = 0;
        min = 0;
        setCount(i);
        setDefault(i);
    }

    public void add(int i)
    {
        setCount(getCount() + i);
    }

    public void dec()
    {
        setCount(getCount() - 1);
    }

    public int getCount()
    {
        return count;
    }

    public int getDefault()
    {
        return def;
    }

    public int getMax()
    {
        return max;
    }

    public int getMin()
    {
        return min;
    }

    public boolean higherThanMax()
    {
        return getCount() > getMax();
    }

    public void inc()
    {
        setCount(getCount() + 1);
    }

    public boolean lowerThanMin()
    {
        return getCount() < getMin();
    }

    public void reset()
    {
        setCount(getDefault());
    }

    public void setCount(int i)
    {
        count = i;
    }

    public void setDefault(int i)
    {
        def = i;
    }

    public void setMax(int i)
    {
        max = i;
    }

    public void setMin(int i)
    {
        min = i;
    }

    public void sub(int i)
    {
        setCount(getCount() - i);
    }

    private int count;
    private int def;
    private int max;
    private int min;
}
