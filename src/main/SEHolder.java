// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package main;

import android.content.Context;
import android.media.SoundPool;
import java.util.HashMap;

public class SEHolder
{

    public SEHolder()
    {
    }

    public static void destroyAll()
    {
        getSoundPool().release();
        getIds().clear();
    }

    public static int getId(int i)
    {
        return ((Integer)getIds().get(Integer.valueOf(i))).intValue();
    }

    private static HashMap getIds()
    {
        return ids;
    }

    public static SoundPool getSoundPool()
    {
        return soundPool;
    }

    public static boolean hasId(int i)
    {
        return getIds().containsKey(Integer.valueOf(i));
    }

    public static void load(Context context, int i)
    {
        if(hasId(i)) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 0 16: default 92
    //                   0 93
    //                   1 110
    //                   2 116
    //                   3 122
    //                   4 128
    //                   5 134
    //                   6 140
    //                   7 146
    //                   8 152
    //                   9 158
    //                   10 164
    //                   11 170
    //                   12 176
    //                   13 182
    //                   14 188
    //                   15 194
    //                   16 200;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19
_L2:
        return;
_L3:
        int j = 0x7f040000;
_L21:
        setId(i, getSoundPool().load(context, j, 1));
        return;
_L4:
        j = 0x7f040001;
        continue; /* Loop/switch isn't completed */
_L5:
        j = 0x7f040004;
        continue; /* Loop/switch isn't completed */
_L6:
        j = 0x7f040005;
        continue; /* Loop/switch isn't completed */
_L7:
        j = 0x7f040006;
        continue; /* Loop/switch isn't completed */
_L8:
        j = 0x7f040007;
        continue; /* Loop/switch isn't completed */
_L9:
        j = 0x7f040008;
        continue; /* Loop/switch isn't completed */
_L10:
        j = 0x7f040009;
        continue; /* Loop/switch isn't completed */
_L11:
        j = 0x7f04000a;
        continue; /* Loop/switch isn't completed */
_L12:
        j = 0x7f04000b;
        continue; /* Loop/switch isn't completed */
_L13:
        j = 0x7f04000c;
        continue; /* Loop/switch isn't completed */
_L14:
        j = 0x7f04000d;
        continue; /* Loop/switch isn't completed */
_L15:
        j = 0x7f04000e;
        continue; /* Loop/switch isn't completed */
_L16:
        j = 0x7f04000f;
        continue; /* Loop/switch isn't completed */
_L17:
        j = 0x7f040011;
        continue; /* Loop/switch isn't completed */
_L18:
        j = 0x7f040012;
        continue; /* Loop/switch isn't completed */
_L19:
        j = 0x7f040013;
        if(true) goto _L21; else goto _L20
_L20:
    }

    public static void loadAll(Context context)
    {
        int i = 0;
        do
        {
            if(i >= 20)
                return;
            load(context, i);
            i++;
        } while(true);
    }

    public static void play(Context context, int i)
    {
        if(!hasId(i))
            load(context, i);
        getSoundPool().play(getId(i), 1.0F, 1.0F, 0, 0, 1.0F);
    }

    private static void setId(int i, int j)
    {
        getIds().put(Integer.valueOf(i), Integer.valueOf(j));
    }

    public static final int ATTENTION = 0;
    public static final int AURA = 1;
    public static final int EXPLOSION00 = 2;
    public static final int EXPLOSION01 = 3;
    public static final int EXPLOSION02 = 4;
    public static final int HIT00 = 5;
    public static final int MOVE00 = 6;
    public static final int PLAYER_HIT = 7;
    private static final int POOL_COUNT = 8;
    public static final int SE_COUNT = 20;
    public static final int SHOT00 = 8;
    public static final int SLIDE = 9;
    public static final int TARGET00 = 10;
    public static final int THUNDER00 = 11;
    public static final int THUNDER01 = 12;
    public static final int THUNDER02 = 13;
    public static final int TITLE_SELECT = 14;
    public static final int TUP = 15;
    public static final int WEAPON_CHANGE = 16;
    private static HashMap ids = new HashMap(20);
    private static SoundPool soundPool = new SoundPool(8, 3, 0);

}
