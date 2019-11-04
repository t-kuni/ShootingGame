// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package main;

import academy.yamamoto.android.general.Debug;

// Referenced classes of package main:
//            HorizontalScrollShootingActivity

public class Init extends Thread
{

    public Init(HorizontalScrollShootingActivity horizontalscrollshootingactivity)
    {
        activity = null;
        setActivity(horizontalscrollshootingactivity);
        Debug.logoutMsg("!!! RUN C !!!");
    }

    public HorizontalScrollShootingActivity getActivity()
    {
        return activity;
    }

    public void run()
    {
    }

    public void setActivity(HorizontalScrollShootingActivity horizontalscrollshootingactivity)
    {
        activity = horizontalscrollshootingactivity;
    }

    private HorizontalScrollShootingActivity activity;
}
