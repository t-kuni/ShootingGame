// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package main;

import academy.yamamoto.android.game.GameEngine;
import academy.yamamoto.android.general.Debug;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Calendar;
import scene.battle.object.player.PlayerIcon;
import scene.title.Title;

// Referenced classes of package main:
//            MyHandler, SEHolder, BitmapHolder

public class HorizontalScrollShootingActivity extends Activity
{

    public HorizontalScrollShootingActivity()
    {
        gameEngine = null;
        handler = null;
    }

    public GameEngine getGameEngine()
    {
        return gameEngine;
    }

    public MyHandler getHandler()
    {
        return handler;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if(i == 0 && j == 0)
            gameEngine.setGame(new Title());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Debug.DEBUGGING = false;
        requestWindowFeature(1);
        setRequestedOrientation(0);
        setHandler(new MyHandler(this));
        SEHolder.loadAll(this);
        gameEngine = new GameEngine(this);
        setContentView(gameEngine);
        gameEngine.orientationEnable();
        gameEngine.touchable(true);
        gameEngine.setWaitTime(0);
        gameEngine.setGame(new Title());
    }

    protected Dialog onCreateDialog(int i)
    {
        return super.onCreateDialog(i);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 0, 0, "\u30B9\u30AF\u30EA\u30FC\u30F3\u30B7\u30E7\u30C3\u30C8").setIcon(0x1080037);
        menu.add(0, 1, 0, "\u64CD\u4F5C\u5207\u308A\u66FF\u3048[\u30BF\u30C3\u30C1]").setIcon(0x1080033).setVisible(true);
        menu.add(0, 2, 0, "\u64CD\u4F5C\u5207\u308A\u66FF\u3048[\u50BE\u304D]").setIcon(0x1080033).setVisible(false);
        return true;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        gameEngine.end();
        BitmapHolder.destroyAll();
        SEHolder.destroyAll();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if(gameEngine == null) goto _L2; else goto _L1
_L1:
        menuitem.getItemId();
        JVM INSTR tableswitch 0 2: default 40
    //                   0 42
    //                   1 181
    //                   2 187;
           goto _L2 _L3 _L4 _L5
_L2:
        return true;
_L3:
        menuitem = Calendar.getInstance();
        int i = menuitem.get(1);
        int j = menuitem.get(2);
        int k = menuitem.get(5);
        int l = menuitem.get(11);
        int i1 = menuitem.get(12);
        int j1 = menuitem.get(13);
        int k1 = menuitem.get(14);
        menuitem = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/Pictures/ShootingGame/").toString();
        String s = (new StringBuilder()).append(i).append(j).append(k).append(l).append(i1).append(j1).append(k1).append(".jpg").toString();
        gameEngine.screenShooting(menuitem, s);
        return true;
_L4:
        PlayerIcon.setOperationType(1);
        return true;
_L5:
        PlayerIcon.setOperationType(0);
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        gameEngine.pause();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        super.onPrepareOptionsMenu(menu);
        if(PlayerIcon.getOperationType() == 0)
        {
            menu.findItem(1).setVisible(true);
            menu.findItem(2).setVisible(false);
            return true;
        } else
        {
            menu.findItem(1).setVisible(false);
            menu.findItem(2).setVisible(true);
            return true;
        }
    }

    protected void onResume()
    {
        super.onResume();
        gameEngine.start();
    }

    public void setGameEngine(GameEngine gameengine)
    {
        gameEngine = gameengine;
    }

    public void setHandler(MyHandler myhandler)
    {
        handler = myhandler;
    }

    private static final int MENU_ID_OPETYPE_TO_SLOPE = 2;
    private static final int MENU_ID_OPETYPE_TO_TOUCH = 1;
    private static final int MENU_ID_SCREENSHOT = 0;
    private GameEngine gameEngine;
    private MyHandler handler;
}
