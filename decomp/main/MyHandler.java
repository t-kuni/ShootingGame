// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package main;

import academy.yamamoto.android.game.GameEngine;
import academy.yamamoto.android.general.Debug;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import scene.title.Title;

// Referenced classes of package main:
//            HorizontalScrollShootingActivity

public class MyHandler extends Handler
{

    public MyHandler(HorizontalScrollShootingActivity horizontalscrollshootingactivity)
    {
        activity = null;
        alertBuilder = null;
        progressDialog = null;
        setActivity(horizontalscrollshootingactivity);
    }

    public static ProgressDialog makeLoadingDialog(Context context)
    {
        context = new ProgressDialog(context);
        context.setTitle("\u30C7\u30FC\u30BF\u8AAD\u307F\u8FBC\u307F\u4E2D");
        context.setMessage("Now loading...");
        context.setIndeterminate(false);
        context.setProgressStyle(0);
        context.setCancelable(false);
        return context;
    }

    public HorizontalScrollShootingActivity getActivity()
    {
        return activity;
    }

    public android.app.AlertDialog.Builder getAlertBuilder()
    {
        return alertBuilder;
    }

    public ProgressDialog getProgressDialog()
    {
        return progressDialog;
    }

    public void handleMessage(Message message)
    {
        Debug.logoutMsg((new StringBuilder("!!! HANDLE = ")).append(message.what).append(" !!!").toString());
        message.what;
        JVM INSTR tableswitch 0 3: default 60
    //                   0 61
    //                   1 77
    //                   2 103
    //                   3 123;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        if(getAlertBuilder() != null)
        {
            getAlertBuilder().show();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if(getProgressDialog() == null)
        {
            setProgressDialog(makeLoadingDialog(getActivity()));
            getProgressDialog().show();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if(getProgressDialog() != null)
        {
            getProgressDialog().dismiss();
            setProgressDialog(null);
            return;
        }
        if(true) goto _L1; else goto _L5
_L5:
        Debug.logoutMsg("!!! a RUN !!!");
        message = getActivity().getHandler();
        Message message1 = new Message();
        message1.what = 1;
        message.handleMessage(message1);
        Debug.logoutMsg("!!! a RUN !!!");
        GameEngine gameengine = new GameEngine(getActivity());
        Debug.logoutMsg("!!! a RUN1 !!!");
        getActivity().setContentView(gameengine);
        Debug.logoutMsg("!!! a RUN2 !!!");
        gameengine.orientationEnable();
        Debug.logoutMsg("!!! a RUN3 !!!");
        gameengine.touchable(true);
        Debug.logoutMsg("!!! a RUN4 !!!");
        gameengine.setWaitTime(0);
        Debug.logoutMsg("!!! a RUN5 !!!");
        gameengine.setGame(new Title());
        Debug.logoutMsg("!!! a RUN !!!");
        message1.what = 2;
        message.handleMessage(message1);
        Debug.logoutMsg("!!! a RUN !!!");
        return;
    }

    public void setActivity(HorizontalScrollShootingActivity horizontalscrollshootingactivity)
    {
        activity = horizontalscrollshootingactivity;
    }

    public void setAlertBuilder(android.app.AlertDialog.Builder builder)
    {
        alertBuilder = builder;
    }

    public void setProgressDialog(ProgressDialog progressdialog)
    {
        progressDialog = progressdialog;
    }

    public static final int MESSAGE_BUILD_DIALOG = 0;
    public static final int MESSAGE_END_LOADING = 2;
    public static final int MESSAGE_INIT_ACTIVITY = 3;
    public static final int MESSAGE_LOADING = 1;
    private HorizontalScrollShootingActivity activity;
    private android.app.AlertDialog.Builder alertBuilder;
    private ProgressDialog progressDialog;
}
