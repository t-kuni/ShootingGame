// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package main;

import android.content.Context;
import android.media.MediaPlayer;
import java.util.*;

public class BGMHolder
{

    public BGMHolder()
    {
    }

    public static void destroy(int i)
    {
        if(has(i))
        {
            get(i).release();
            getMediaPlayers().remove(Integer.valueOf(i));
        }
    }

    public static void destroyAll()
    {
        Iterator iterator = getMediaPlayers().keySet().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                getMediaPlayers().clear();
                return;
            }
            destroy(((Integer)iterator.next()).intValue());
        } while(true);
    }

    public static MediaPlayer get(int i)
    {
        return (MediaPlayer)getMediaPlayers().get(Integer.valueOf(i));
    }

    private static HashMap getMediaPlayers()
    {
        return mediaPlayers;
    }

    public static boolean has(int i)
    {
        return getMediaPlayers().containsKey(Integer.valueOf(i));
    }

    public static void load(Context context, int i)
    {
        if(!has(i))
            set(i, MediaPlayer.create(context, i));
    }

    private static void set(int i, MediaPlayer mediaplayer)
    {
        getMediaPlayers().put(Integer.valueOf(i), mediaplayer);
    }

    private static HashMap mediaPlayers = new HashMap(3);

}
