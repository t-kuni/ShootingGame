// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.game;


public class TouchPointer
{

    public TouchPointer(int i)
    {
        id = -1;
        x = 0.0F;
        y = 0.0F;
        readed = false;
        marked = false;
        markId = 0;
        setID(i);
    }

    public TouchPointer(int i, float f, float f1)
    {
        this(i);
        setX(f);
        setY(f1);
    }

    private void setID(int i)
    {
        id = i;
    }

    private void setMarkId(int i)
    {
        markId = i;
    }

    private void setMarked(boolean flag)
    {
        marked = flag;
    }

    private void setReaded(boolean flag)
    {
        readed = flag;
    }

    public int getID()
    {
        setReaded(true);
        return id;
    }

    public int getMarkId()
    {
        return markId;
    }

    public float getX()
    {
        setReaded(true);
        return x;
    }

    public float getY()
    {
        setReaded(true);
        return y;
    }

    public boolean isMarked()
    {
        return marked;
    }

    public boolean isReaded()
    {
        return readed;
    }

    public void mark(int i)
    {
        setMarked(true);
        setMarkId(i);
    }

    public void setX(float f)
    {
        x = f;
    }

    public void setY(float f)
    {
        y = f;
    }

    private int id;
    private int markId;
    private boolean marked;
    private boolean readed;
    public float x;
    public float y;
}
