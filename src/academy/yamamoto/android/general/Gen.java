// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.general;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.graphics.*;
import android.view.View;
import android.widget.*;

// Referenced classes of package academy.yamamoto.android.general:
//            Debug

public class Gen
{

    public Gen()
    {
    }

    public static Bitmap changeAlpha(Bitmap bitmap, int i)
    {
        int k;
        int i1;
        int j1;
        int ai[];
        i1 = bitmap.getWidth();
        j1 = bitmap.getHeight();
        ai = new int[i1 * j1];
        bitmap.getPixels(ai, 0, i1, 0, 0, i1, j1);
        k = 0;
_L2:
        if(k >= ai.length)
            return Bitmap.createBitmap(ai, 0, i1, i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
        if((ai[k] & 0xff000000) >> 24 != 0)
            break; /* Loop/switch isn't completed */
_L3:
        k++;
        if(true) goto _L2; else goto _L1
_L1:
        int k1 = ai[k];
        int l1 = ai[k];
        int i2 = ai[k];
        int l = i;
        int j;
        if(l > 255)
        {
            j = 255;
        } else
        {
            j = l;
            if(l < 0)
                j = 0;
        }
        ai[k] = Color.argb(j, (k1 & 0xff0000) >> 16, (l1 & 0xff00) >> 8, i2 & 0xff);
          goto _L3
        if(true) goto _L2; else goto _L4
_L4:
    }

    public static Bitmap changeBrightness(Bitmap bitmap, int i)
    {
        int i1;
        int k1;
        int l1;
        int ai[];
        k1 = bitmap.getWidth();
        l1 = bitmap.getHeight();
        ai = new int[k1 * l1];
        bitmap.getPixels(ai, 0, k1, 0, 0, k1, l1);
        i1 = 0;
_L2:
        int i2;
        if(i1 >= ai.length)
            return Bitmap.createBitmap(ai, 0, k1, k1, l1, android.graphics.Bitmap.Config.ARGB_8888);
        i2 = (ai[i1] & 0xff000000) >> 24;
        if(i2 != 0)
            break; /* Loop/switch isn't completed */
_L3:
        i1++;
        if(true) goto _L2; else goto _L1
_L1:
        int k = ai[i1];
        int l = ai[i1];
        int j = ai[i1];
        k = ((k & 0xff0000) >> 16) + i;
        l = ((l & 0xff00) >> 8) + i;
        int j1 = (j & 0xff) + i;
        if(k > 255)
        {
            j = 255;
        } else
        {
            j = k;
            if(k < 0)
                j = 0;
        }
        if(l > 255)
        {
            k = 255;
        } else
        {
            k = l;
            if(l < 0)
                k = 0;
        }
        if(j1 > 255)
        {
            l = 255;
        } else
        {
            l = j1;
            if(j1 < 0)
                l = 0;
        }
        ai[i1] = Color.argb(i2, j, k, l);
          goto _L3
        if(true) goto _L2; else goto _L4
_L4:
    }

    public static Bitmap filteringToRed(Bitmap bitmap, int i)
    {
        int i1;
        int k1;
        int l1;
        int ai[];
        k1 = bitmap.getWidth();
        l1 = bitmap.getHeight();
        ai = new int[k1 * l1];
        bitmap.getPixels(ai, 0, k1, 0, 0, k1, l1);
        i1 = 0;
_L2:
        int i2;
        if(i1 >= ai.length)
            return Bitmap.createBitmap(ai, 0, k1, k1, l1, android.graphics.Bitmap.Config.ARGB_8888);
        i2 = (ai[i1] & 0xff000000) >> 24;
        if(i2 != 0)
            break; /* Loop/switch isn't completed */
_L3:
        i1++;
        if(true) goto _L2; else goto _L1
_L1:
        int k = ai[i1];
        int l = ai[i1];
        int j = ai[i1];
        k = ((k & 0xff0000) >> 16) + i;
        l = ((l & 0xff00) >> 8) - i;
        int j1 = (j & 0xff) - i;
        if(k > 255)
        {
            j = 255;
        } else
        {
            j = k;
            if(k < 0)
                j = 0;
        }
        if(l > 255)
        {
            k = 255;
        } else
        {
            k = l;
            if(l < 0)
                k = 0;
        }
        if(j1 > 255)
        {
            l = 255;
        } else
        {
            l = j1;
            if(j1 < 0)
                l = 0;
        }
        ai[i1] = Color.argb(i2, j, k, l);
          goto _L3
        if(true) goto _L2; else goto _L4
_L4:
    }

    public static float getDistance(float f, float f1, float f2, float f3)
    {
        f = f2 - f;
        f1 = f3 - f1;
        return (float)Math.sqrt(f * f + f1 * f1);
    }

    public static float getRadian(float f, float f1, float f2, float f3)
    {
        return (float)Math.atan2(f3 - f1, f2 - f);
    }

    public static boolean isInclusion(RectF rectf, RectF rectf1)
    {
        while(rectf.left > rectf1.left || rectf.top > rectf1.top || rectf.right < rectf1.right || rectf.bottom < rectf1.bottom) 
            return false;
        return true;
    }

    public static Button makeButton(Context context, android.view.View.OnClickListener onclicklistener, String s, int i)
    {
        context = new Button(context);
        context.setText(s);
        context.setTag(Integer.valueOf(i));
        context.setOnClickListener(onclicklistener);
        context.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
        return context;
    }

    public static Bitmap makeImage(Context context, int i)
    {
        return BitmapFactory.decodeResource(context.getResources(), i);
    }

    public static ListView makeListView(Context context, android.widget.AdapterView.OnItemClickListener onitemclicklistener, BaseAdapter baseadapter)
    {
        context = new ListView(context);
        context.setScrollingCacheEnabled(false);
        context.setOnItemClickListener(onitemclicklistener);
        context.setAdapter(baseadapter);
        Debug.logoutMethodName();
        return context;
    }

    public static TextView makeTextView(Context context, String s, int i)
    {
        context = new TextView(context);
        context.setText(s);
        context.setId(i);
        return context;
    }

    public static void showDialog(Context context, String s, View view)
    {
        context = new android.app.AlertDialog.Builder(context);
        context.setTitle(s);
        context.setView(view);
        context.show();
    }

    public static void showNotification(Context context, Class class1, int i, String s, String s1, String s2)
    {
        s = new Notification(i, s, System.currentTimeMillis());
        s.setLatestEventInfo(context, s1, s2, PendingIntent.getActivity(context, 0, new Intent(context, class1), 0));
        context = (NotificationManager)context.getSystemService("notification");
        context.cancel(0);
        context.notify(0, s);
    }

    public static void showToast(Context context, String s)
    {
        Toast.makeText(context, s, 0).show();
        Debug.logoutMsg(s);
    }

    public static void showToastLong(Context context, String s)
    {
        Toast.makeText(context, s, 1).show();
        Debug.logoutMsg(s);
    }

    public static void swap(Object obj, Object obj1)
    {
    }

    public static final String BR = System.getProperty("line.separator");
    public static final int FP = -1;
    public static final int WC = -2;

}
