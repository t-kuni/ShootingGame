// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.result;

import academy.yamamoto.android.game.Game;
import academy.yamamoto.android.game.GameEngine;
import academy.yamamoto.android.general.Gen;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.text.InputFilter;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;
import main.*;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import scene.title.Title;

// Referenced classes of package scene.result:
//            ResultValues

public class Result extends Game
    implements android.content.DialogInterface.OnClickListener
{
    private class GameEndDialogLisner
        implements android.content.DialogInterface.OnClickListener
    {

        public void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.dismiss();
            switch(i)
            {
            default:
                return;

            case -1: 
                result.setEnding(true);
                return;

            case -2: 
                result.showResultDialog();
                return;
            }
        }

        private Result result;
        final Result this$0;

        public GameEndDialogLisner(Result result2)
        {
            this$0 = Result.this;
            super();
            result = null;
            result = result2;
        }
    }


    public Result(ResultValues resultvalues)
    {
        resultValues = null;
        backBitmap = null;
        ending = false;
        edit = null;
        setResultValues(resultvalues);
    }

    public void destroy()
    {
        super.destroy();
        destroyBitmaps();
        System.gc();
    }

    public void destroyBitmaps()
    {
        BitmapHolder.destroy(83);
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(getBackBitmap(), 0.0F, 0.0F, null);
    }

    public Bitmap getBackBitmap()
    {
        return backBitmap;
    }

    public EditText getEdit()
    {
        return edit;
    }

    public ResultValues getResultValues()
    {
        return resultValues;
    }

    public void initialize()
    {
        setVirtualScreenWidth(640F);
        setVirtualScreenHeight(480F);
        getEngine().setFilteringScreen(false);
        makeTotalScore();
        showResultDialog();
        loadBitmaps();
        setBackBitmap(BitmapHolder.get(83));
    }

    public boolean isEnding()
    {
        return ending;
    }

    public void loadBitmaps()
    {
        BitmapHolder.load(getEngine().getContext(), 83);
    }

    public void makeTotalScore()
    {
        ResultValues resultvalues = getResultValues();
        resultvalues.comboBonus = resultvalues.combo * 50;
        resultvalues.hpBonus = resultvalues.hp * 10;
        resultvalues.totalScore = resultvalues.score + resultvalues.comboBonus + resultvalues.hpBonus;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        i;
        JVM INSTR tableswitch -2 -1: default 28
    //                   -2 678
    //                   -1 29;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        Object obj;
        DefaultHttpClient defaulthttpclient;
        Object obj1;
        ArrayList arraylist;
        defaulthttpclient = new DefaultHttpClient();
        obj1 = new HttpPost("http://testxxx.lolipop.jp/ranking.php");
        dialoginterface = getResultValues();
        arraylist = new ArrayList(4);
        arraylist.add(new BasicNameValuePair("send_score", "true"));
        arraylist.add(new BasicNameValuePair("authentication_key", "a0ZLYznPQEZVIrRbMm2HHchES"));
        arraylist.add(new BasicNameValuePair("name", (new StringBuilder()).append(getEdit().getText()).toString()));
        arraylist.add(new BasicNameValuePair("score", (new StringBuilder()).append(((ResultValues) (dialoginterface)).score).toString()));
        arraylist.add(new BasicNameValuePair("combo", (new StringBuilder()).append(((ResultValues) (dialoginterface)).combo).toString()));
        arraylist.add(new BasicNameValuePair("comboBonus", (new StringBuilder()).append(((ResultValues) (dialoginterface)).comboBonus).toString()));
        arraylist.add(new BasicNameValuePair("hp", (new StringBuilder()).append(((ResultValues) (dialoginterface)).hp).toString()));
        arraylist.add(new BasicNameValuePair("hpBonus", (new StringBuilder()).append(((ResultValues) (dialoginterface)).hpBonus).toString()));
        arraylist.add(new BasicNameValuePair("totalScore", (new StringBuilder()).append(((ResultValues) (dialoginterface)).totalScore).toString()));
        arraylist.add(new BasicNameValuePair("distance", (new StringBuilder()).append((int)((ResultValues) (dialoginterface)).distance).toString()));
        arraylist.add(new BasicNameValuePair("shotCountDark", (new StringBuilder()).append(((ResultValues) (dialoginterface)).shotCount[0]).toString()));
        arraylist.add(new BasicNameValuePair("shotCountPrasma", (new StringBuilder()).append(((ResultValues) (dialoginterface)).shotCount[1]).toString()));
        arraylist.add(new BasicNameValuePair("shotCountFlame", (new StringBuilder()).append(((ResultValues) (dialoginterface)).shotCount[2]).toString()));
        arraylist.add(new BasicNameValuePair("killedBoss", (new StringBuilder()).append(((ResultValues) (dialoginterface)).killedBoss).toString()));
        i = 1;
        obj = null;
        dialoginterface = ((DialogInterface) (obj));
        ((HttpPost) (obj1)).setEntity(new UrlEncodedFormEntity(arraylist, "SJIS"));
        dialoginterface = ((DialogInterface) (obj));
        obj1 = defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj1))).getFirstHeader("no");
        if(obj1 != null) goto _L5; else goto _L4
_L4:
        dialoginterface = ((DialogInterface) (obj));
        try
        {
            throw new Exception();
        }
        // Misplaced declaration of an exception variable
        catch(Object obj)
        {
            i = 0;
        }
_L6:
        if(i != 0)
        {
            dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://testxxx.lolipop.jp/ranking.php?no=")).append(dialoginterface).toString()));
            ((HorizontalScrollShootingActivity)getEngine().getContext()).startActivityForResult(dialoginterface, 0);
            return;
        } else
        {
            Gen.showToastLong(getEngine().getContext(), "\u9001\u4FE1\u306B\u5931\u6557\u3057\u307E\u3057\u305F\n\u6642\u9593\u3092\u7F6E\u3044\u3066\u518D\u9001\u4FE1\u3059\u308B\u304B\n\u30CD\u30C3\u30C8\u30EF\u30FC\u30AF\u306E\u69CB\u6210\u3092\u78BA\u8A8D\u3057\u3066\u304F\u3060\u3055\u3044");
            showResultDialog();
            return;
        }
_L5:
        dialoginterface = ((DialogInterface) (obj));
        obj = ((Header) (obj1)).getValue();
        dialoginterface = ((DialogInterface) (obj));
        defaulthttpclient.getConnectionManager().shutdown();
        dialoginterface = ((DialogInterface) (obj));
          goto _L6
_L2:
        showGameEndDialog();
        return;
    }

    public void setBackBitmap(Bitmap bitmap)
    {
        backBitmap = bitmap;
    }

    public void setEdit(EditText edittext)
    {
        edit = edittext;
    }

    public void setEnding(boolean flag)
    {
        ending = flag;
    }

    public void setResultValues(ResultValues resultvalues)
    {
        resultValues = resultvalues;
    }

    public void showGameEndDialog()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getEngine().getContext());
        Object obj = new GameEndDialogLisner(this);
        builder.setTitle("\u30BF\u30A4\u30C8\u30EB\u753B\u9762\u3078\u79FB\u52D5\u3057\u307E\u3059");
        builder.setCancelable(false);
        builder.setPositiveButton("\u6C7A\u5B9A", ((android.content.DialogInterface.OnClickListener) (obj)));
        builder.setNegativeButton("\u30AD\u30E3\u30F3\u30BB\u30EB", ((android.content.DialogInterface.OnClickListener) (obj)));
        obj = ((HorizontalScrollShootingActivity)getEngine().getContext()).getHandler();
        ((MyHandler) (obj)).setAlertBuilder(builder);
        ((MyHandler) (obj)).sendEmptyMessage(0);
    }

    public void showResultDialog()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getEngine().getContext());
        builder.setTitle("\u30AA\u30F3\u30E9\u30A4\u30F3\u30EA\u30B6\u30EB\u30C8\u753B\u9762\u3078");
        builder.setMessage("\u540D\u524D\u5165\u529B(16\u6587\u5B57\u307E\u3067)");
        builder.setCancelable(false);
        builder.setPositiveButton("\u9001\u4FE1", this);
        builder.setNegativeButton("\u30AD\u30E3\u30F3\u30BB\u30EB", this);
        Object obj = new EditText(getEngine().getContext());
        ((EditText) (obj)).setInputType(1);
        ((EditText) (obj)).setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(16)
        });
        builder.setView(((android.view.View) (obj)));
        setEdit(((EditText) (obj)));
        obj = ((HorizontalScrollShootingActivity)getEngine().getContext()).getHandler();
        ((MyHandler) (obj)).setAlertBuilder(builder);
        ((MyHandler) (obj)).sendEmptyMessage(0);
    }

    public void toTitle()
    {
        getEngine().setGame(new Title()).destroy();
    }

    public boolean update()
    {
        if(isEnding())
            toTitle();
        return true;
    }

    public static final int ACTIVITY_BROWSER = 0;
    private Bitmap backBitmap;
    private EditText edit;
    private boolean ending;
    private ResultValues resultValues;
}
