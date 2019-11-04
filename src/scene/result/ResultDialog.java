// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.result;

import android.content.Context;

public class ResultDialog extends android.app.AlertDialog.Builder
{

    public ResultDialog(Context context)
    {
        super(context);
        setTitle("\u30EA\u30B6\u30EB\u30C8");
        setMessage("\u30E1\u30C3\u30BB\u30FC\u30B8");
        setPositiveButton("OK", null);
    }
}
