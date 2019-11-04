// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.general;


// Referenced classes of package academy.yamamoto.android.general:
//            Debug

public class RunnableThread extends Thread
{

    public RunnableThread(Runnable runnable1)
    {
        super(runnable1);
        runnable = null;
        setRunnable(runnable1);
        Debug.logoutMethodName();
    }

    private void setRunnable(Runnable runnable1)
    {
        Debug.logoutMethodName();
        runnable = runnable1;
    }

    public Runnable getRunnable()
    {
        Debug.logoutMethodName();
        return runnable;
    }

    private Runnable runnable;
}
