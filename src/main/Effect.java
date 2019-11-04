// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package main;

import academy.yamamoto.android.game.*;
import academy.yamamoto.android.general.Animation;
import academy.yamamoto.android.general.AnimationBitmap;
import android.content.Context;
import android.graphics.*;
import java.util.*;
import scene.battle.Battle;
import scene.battle.object.enemy.Sword;

// Referenced classes of package main:
//            BitmapHolder

public class Effect extends GameObject2D
{

    public Effect(int i)
    {
        effectType = 0;
        animation = null;
        repeatable = false;
        setEffectType(i);
        setAnimation(new Animation());
        setCenter(47F, 47F);
    }

    public static Bitmap clipBitmap(Bitmap bitmap, int i, int j)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(94, 94, android.graphics.Bitmap.Config.ARGB_8888);
        (new Canvas(bitmap1)).drawBitmap(bitmap, new Rect(i * 96 + 1, j * 96 + 1, (i + 1) * 96 - 1, (j + 1) * 96 - 1), new RectF(0.0F, 0.0F, 94F, 94F), null);
        return bitmap1;
    }

    public static void destroyAll()
    {
        Iterator iterator = getAnimationBitmaps().keySet().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                getAnimationBitmaps().clear();
                return;
            }
            Iterator iterator1 = ((Vector)getAnimationBitmaps().get(iterator.next())).iterator();
            while(iterator1.hasNext()) 
                ((Bitmap)iterator1.next()).recycle();
        } while(true);
    }

    private static HashMap getAnimationBitmaps()
    {
        return animationBitmaps;
    }

    public static Rect getRect()
    {
        if(rect == null)
            rect = new Rect(0, 0, 96, 96);
        return rect;
    }

    public static void load(Context context, int i)
    {
        i;
        JVM INSTR tableswitch 0 11: default 64
    //                   0 65
    //                   1 185
    //                   2 393
    //                   3 490
    //                   4 587
    //                   5 684
    //                   6 804
    //                   7 903
    //                   8 980
    //                   9 1113
    //                   10 1257
    //                   11 1356;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
        return;
_L2:
        if(!getAnimationBitmaps().containsKey(Integer.valueOf(0)))
        {
            context = BitmapHolder.load(context, 60);
            Vector vector = new Vector(7);
            vector.add(clipBitmap(context, 0, 2));
            vector.add(clipBitmap(context, 1, 2));
            vector.add(clipBitmap(context, 2, 2));
            vector.add(clipBitmap(context, 3, 2));
            vector.add(clipBitmap(context, 4, 2));
            vector.add(clipBitmap(context, 0, 3));
            vector.add(clipBitmap(context, 1, 3));
            getAnimationBitmaps().put(Integer.valueOf(0), vector);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if(!getAnimationBitmaps().containsKey(Integer.valueOf(1)))
        {
            context = BitmapHolder.load(context, 61);
            Vector vector1 = new Vector(15);
            vector1.add(clipBitmap(context, 4, 2));
            vector1.add(clipBitmap(context, 3, 2));
            vector1.add(clipBitmap(context, 2, 2));
            vector1.add(clipBitmap(context, 1, 2));
            vector1.add(clipBitmap(context, 0, 2));
            vector1.add(clipBitmap(context, 4, 1));
            vector1.add(clipBitmap(context, 3, 1));
            vector1.add(clipBitmap(context, 2, 1));
            vector1.add(clipBitmap(context, 1, 1));
            vector1.add(clipBitmap(context, 0, 1));
            vector1.add(clipBitmap(context, 4, 0));
            vector1.add(clipBitmap(context, 3, 0));
            vector1.add(clipBitmap(context, 2, 0));
            vector1.add(clipBitmap(context, 1, 0));
            vector1.add(clipBitmap(context, 0, 0));
            getAnimationBitmaps().put(Integer.valueOf(1), vector1);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if(!getAnimationBitmaps().containsKey(Integer.valueOf(2)))
        {
            context = BitmapHolder.load(context, 80);
            Vector vector2 = new Vector(5);
            vector2.add(clipBitmap(context, 0, 3));
            vector2.add(clipBitmap(context, 1, 3));
            vector2.add(clipBitmap(context, 2, 3));
            vector2.add(clipBitmap(context, 3, 3));
            vector2.add(clipBitmap(context, 4, 3));
            getAnimationBitmaps().put(Integer.valueOf(2), vector2);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if(!getAnimationBitmaps().containsKey(Integer.valueOf(3)))
        {
            context = BitmapHolder.load(context, 81);
            Vector vector3 = new Vector(5);
            vector3.add(clipBitmap(context, 0, 0));
            vector3.add(clipBitmap(context, 1, 0));
            vector3.add(clipBitmap(context, 2, 0));
            vector3.add(clipBitmap(context, 3, 0));
            vector3.add(clipBitmap(context, 4, 0));
            getAnimationBitmaps().put(Integer.valueOf(3), vector3);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if(!getAnimationBitmaps().containsKey(Integer.valueOf(4)))
        {
            context = BitmapHolder.load(context, 81);
            Vector vector4 = new Vector(5);
            vector4.add(clipBitmap(context, 0, 1));
            vector4.add(clipBitmap(context, 1, 1));
            vector4.add(clipBitmap(context, 2, 1));
            vector4.add(clipBitmap(context, 3, 1));
            vector4.add(clipBitmap(context, 4, 1));
            getAnimationBitmaps().put(Integer.valueOf(4), vector4);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if(!getAnimationBitmaps().containsKey(Integer.valueOf(5)))
        {
            context = BitmapHolder.load(context, 64);
            Vector vector5 = new Vector(7);
            vector5.add(clipBitmap(context, 0, 0));
            vector5.add(clipBitmap(context, 1, 0));
            vector5.add(clipBitmap(context, 2, 0));
            vector5.add(clipBitmap(context, 3, 0));
            vector5.add(clipBitmap(context, 4, 0));
            vector5.add(clipBitmap(context, 0, 1));
            vector5.add(clipBitmap(context, 1, 1));
            getAnimationBitmaps().put(Integer.valueOf(5), vector5);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if(!getAnimationBitmaps().containsKey(Integer.valueOf(6)))
        {
            context = BitmapHolder.load(context, 65);
            Vector vector6 = new Vector(5);
            vector6.add(clipBitmap(context, 0, 1));
            vector6.add(clipBitmap(context, 1, 1));
            vector6.add(clipBitmap(context, 2, 1));
            vector6.add(clipBitmap(context, 3, 1));
            vector6.add(clipBitmap(context, 4, 1));
            getAnimationBitmaps().put(Integer.valueOf(6), vector6);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if(!getAnimationBitmaps().containsKey(Integer.valueOf(7)))
        {
            context = BitmapHolder.load(context, 65);
            Vector vector7 = new Vector(3);
            vector7.add(clipBitmap(context, 0, 3));
            vector7.add(clipBitmap(context, 1, 3));
            vector7.add(clipBitmap(context, 2, 3));
            getAnimationBitmaps().put(Integer.valueOf(7), vector7);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if(!getAnimationBitmaps().containsKey(Integer.valueOf(8)))
        {
            context = BitmapHolder.load(context, 63);
            Vector vector8 = new Vector(8);
            vector8.add(clipBitmap(context, 2, 2));
            vector8.add(clipBitmap(context, 3, 2));
            vector8.add(clipBitmap(context, 2, 0));
            vector8.add(clipBitmap(context, 3, 0));
            vector8.add(clipBitmap(context, 2, 3));
            vector8.add(clipBitmap(context, 3, 3));
            vector8.add(clipBitmap(context, 2, 1));
            vector8.add(clipBitmap(context, 3, 1));
            getAnimationBitmaps().put(Integer.valueOf(8), vector8);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L11:
        if(!getAnimationBitmaps().containsKey(Integer.valueOf(9)))
        {
            context = BitmapHolder.load(context, 69);
            Vector vector9 = new Vector(9);
            vector9.add(clipBitmap(context, 0, 0));
            vector9.add(clipBitmap(context, 1, 0));
            vector9.add(clipBitmap(context, 2, 0));
            vector9.add(clipBitmap(context, 3, 0));
            vector9.add(clipBitmap(context, 4, 0));
            vector9.add(clipBitmap(context, 0, 1));
            vector9.add(clipBitmap(context, 1, 1));
            vector9.add(clipBitmap(context, 2, 1));
            vector9.add(clipBitmap(context, 3, 1));
            getAnimationBitmaps().put(Integer.valueOf(9), vector9);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L12:
        if(!getAnimationBitmaps().containsKey(Integer.valueOf(10)))
        {
            context = BitmapHolder.load(context, 67);
            Vector vector10 = new Vector(5);
            vector10.add(clipBitmap(context, 0, 1));
            vector10.add(clipBitmap(context, 1, 1));
            vector10.add(clipBitmap(context, 2, 1));
            vector10.add(clipBitmap(context, 3, 1));
            vector10.add(clipBitmap(context, 4, 1));
            getAnimationBitmaps().put(Integer.valueOf(10), vector10);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L13:
        if(!getAnimationBitmaps().containsKey(Integer.valueOf(11)))
        {
            context = BitmapHolder.load(context, 68);
            Vector vector11 = new Vector(14);
            vector11.add(clipBitmap(context, 0, 2));
            vector11.add(clipBitmap(context, 1, 2));
            vector11.add(clipBitmap(context, 2, 2));
            vector11.add(clipBitmap(context, 3, 2));
            vector11.add(clipBitmap(context, 4, 2));
            vector11.add(clipBitmap(context, 0, 0));
            vector11.add(clipBitmap(context, 1, 0));
            vector11.add(clipBitmap(context, 2, 0));
            vector11.add(clipBitmap(context, 3, 0));
            vector11.add(clipBitmap(context, 4, 0));
            vector11.add(clipBitmap(context, 0, 1));
            vector11.add(clipBitmap(context, 1, 1));
            vector11.add(clipBitmap(context, 2, 1));
            vector11.add(clipBitmap(context, 3, 1));
            getAnimationBitmaps().put(Integer.valueOf(11), vector11);
            return;
        }
        if(true) goto _L1; else goto _L14
_L14:
    }

    public static void loadAll(Context context)
    {
        int i = 0;
        do
        {
            if(i >= 12)
                return;
            load(context, i);
            i++;
        } while(true);
    }

    private void registerSrcBitmap(Vector vector, int i)
    {
        vector = vector.iterator();
        do
        {
            if(!vector.hasNext())
                return;
            getAnimation().add(new AnimationBitmap((Bitmap)vector.next(), 2));
        } while(true);
    }

    private static void setAnimationBitmaps(HashMap hashmap)
    {
        animationBitmaps = hashmap;
    }

    public static void setRect(Rect rect1)
    {
        rect = rect1;
    }

    public Animation getAnimation()
    {
        return animation;
    }

    public Vector getBitmaps()
    {
        Iterator iterator = getAnimation().getBitmaps().iterator();
        Vector vector = new Vector(4);
        do
        {
            if(!iterator.hasNext())
                return vector;
            vector.add(((AnimationBitmap)iterator.next()).getBitmap());
        } while(true);
    }

    public int getEffectType()
    {
        return effectType;
    }

    public boolean hasAnimation()
    {
        return getAnimation() != null;
    }

    public void initialize()
    {
        if(!getAnimationBitmaps().containsKey(Integer.valueOf(getEffectType())))
            load(getEngine().getContext(), getEffectType());
        switch(getEffectType())
        {
        default:
            return;

        case 0: // '\0'
            registerSrcBitmap((Vector)getAnimationBitmaps().get(Integer.valueOf(0)), 2);
            return;

        case 1: // '\001'
            registerSrcBitmap((Vector)getAnimationBitmaps().get(Integer.valueOf(1)), 2);
            return;

        case 2: // '\002'
            registerSrcBitmap((Vector)getAnimationBitmaps().get(Integer.valueOf(2)), 2);
            return;

        case 3: // '\003'
            registerSrcBitmap((Vector)getAnimationBitmaps().get(Integer.valueOf(3)), 2);
            return;

        case 4: // '\004'
            registerSrcBitmap((Vector)getAnimationBitmaps().get(Integer.valueOf(4)), 2);
            return;

        case 5: // '\005'
            registerSrcBitmap((Vector)getAnimationBitmaps().get(Integer.valueOf(5)), 2);
            return;

        case 6: // '\006'
            registerSrcBitmap((Vector)getAnimationBitmaps().get(Integer.valueOf(6)), 2);
            return;

        case 7: // '\007'
            registerSrcBitmap((Vector)getAnimationBitmaps().get(Integer.valueOf(7)), 2);
            return;

        case 8: // '\b'
            registerSrcBitmap((Vector)getAnimationBitmaps().get(Integer.valueOf(8)), 2);
            return;

        case 9: // '\t'
            registerSrcBitmap((Vector)getAnimationBitmaps().get(Integer.valueOf(9)), 1);
            return;

        case 10: // '\n'
            registerSrcBitmap((Vector)getAnimationBitmaps().get(Integer.valueOf(10)), 2);
            return;

        case 11: // '\013'
            registerSrcBitmap((Vector)getAnimationBitmaps().get(Integer.valueOf(11)), 1);
            break;
        }
    }

    public boolean isRepeatable()
    {
        return repeatable;
    }

    public void setAnimation(Animation animation1)
    {
        animation = animation1;
    }

    public void setEffectType(int i)
    {
        effectType = i;
    }

    public void setRepeatable(boolean flag)
    {
        repeatable = flag;
    }

    public boolean update()
    {
        boolean flag = true;
        getEffectType();
        JVM INSTR tableswitch 6 7: default 28
    //                   6 143
    //                   7 162;
           goto _L1 _L2 _L3
_L1:
        setBitmap(getAnimation().next());
        if(getBitmap() == null)
        {
            if(isRepeatable())
            {
                Effect effect = new Effect(getEffectType());
                effect.offsetTo(getX(), getY());
                effect.setRepeatable(true);
                ((GameObjectManager2D)getManager()).add(effect);
            }
            if(getEffectType() == 11)
            {
                Sword sword = new Sword();
                sword.offsetTo(getX(), getY());
                ((Battle)getEngine().getGame()).getGom().add(sword);
            }
            flag = false;
        }
        return flag;
_L2:
        offsetTo(getX() - 20F, getY());
        continue; /* Loop/switch isn't completed */
_L3:
        offsetTo(getX() - 20F, getY());
        if(true) goto _L1; else goto _L4
_L4:
    }

    public static final int EFFECT_COUNT = 12;
    public static final int EFFECT_TYPE_BOMB00 = 0;
    public static final int EFFECT_TYPE_BOMB01 = 1;
    public static final int EFFECT_TYPE_FIRERING = 8;
    public static final int EFFECT_TYPE_FLASH00 = 6;
    public static final int EFFECT_TYPE_FLASH01 = 7;
    public static final int EFFECT_TYPE_PRASMA00 = 5;
    public static final int EFFECT_TYPE_PRISM00 = 2;
    public static final int EFFECT_TYPE_PRISM01 = 3;
    public static final int EFFECT_TYPE_PRISM02 = 4;
    public static final int EFFECT_TYPE_PRISM03 = 10;
    public static final int EFFECT_TYPE_SUMMON_SWORD = 11;
    public static final int EFFECT_TYPE_WIND = 9;
    private static HashMap animationBitmaps = new HashMap(12);
    private static Rect rect = null;
    private Animation animation;
    private int effectType;
    private boolean repeatable;

}
