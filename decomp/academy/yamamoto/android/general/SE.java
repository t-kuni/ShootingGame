// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.general;

import android.content.Context;
import android.media.MediaPlayer;
import java.util.Iterator;
import java.util.Vector;

public class SE
{

    public SE(Context context, int i, int j)
    {
        int k;
        SEs = null;
        interval = 0;
        time = 0;
        setSEs(new Vector(j));
        k = 0;
_L3:
        if(k < j) goto _L2; else goto _L1
_L1:
        context = getSEs().iterator();
_L4:
        if(!context.hasNext())
            return;
        break MISSING_BLOCK_LABEL_80;
_L2:
        getSEs().add(MediaPlayer.create(context, i));
        k++;
          goto _L3
        try
        {
            ((MediaPlayer)context.next()).prepare();
        }
        catch(Exception exception) { }
          goto _L4
    }

    private int getTime()
    {
        return time;
    }

    private void setTime(int i)
    {
        time = i;
    }

    public int getInterval()
    {
        return interval;
    }

    public Vector getSEs()
    {
        return SEs;
    }

    public void setInterval(int i)
    {
        interval = i;
    }

    public void setSEs(Vector vector)
    {
        SEs = vector;
    }

    public void start()
    {
        if(getTime() <= 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        MediaPlayer mediaplayer;
        Iterator iterator = getSEs().iterator();
        do
        {
            if(!iterator.hasNext())
                continue; /* Loop/switch isn't completed */
            mediaplayer = (MediaPlayer)iterator.next();
        } while(mediaplayer.isPlaying());
        break; /* Loop/switch isn't completed */
        if(true) goto _L1; else goto _L3
_L3:
        try
        {
            mediaplayer.seekTo(0);
        }
        catch(Exception exception) { }
        mediaplayer.start();
        setTime(getInterval());
        return;
    }

    public void update()
    {
        if(getTime() > 0)
            setTime(getTime() - 1);
    }

    private Vector SEs;
    private int interval;
    private int time;
}
