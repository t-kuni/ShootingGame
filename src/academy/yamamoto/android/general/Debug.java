// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.general;

import android.content.Context;
import android.util.Log;

// Referenced classes of package academy.yamamoto.android.general:
//            Gen

public class Debug
{

    public Debug()
    {
    }

    public static void logoutMethodName()
    {
        if(!DEBUGGING)
        {
            return;
        } else
        {
            StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[3];
            Log.d("USERS_DEBUG_MSG", (new StringBuilder(String.valueOf(stacktraceelement.getClassName()))).append(".").append(stacktraceelement.getMethodName()).toString());
            return;
        }
    }

    public static void logoutMsg(String s)
    {
        if(!DEBUGGING)
        {
            return;
        } else
        {
            Log.d("USERS_DEBUG_MSG", s);
            return;
        }
    }

    public static void showToast(Context context, String s)
    {
        if(!DEBUGGING)
        {
            return;
        } else
        {
            Gen.showToast(context, s);
            return;
        }
    }

    public static boolean DEBUGGING = false;
    private static final String TAG = "USERS_DEBUG_MSG";

    static 
    {
        DEBUGGING = true;
    }
}
