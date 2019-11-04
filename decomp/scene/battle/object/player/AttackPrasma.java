// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.player;

import academy.yamamoto.android.game.*;
import academy.yamamoto.android.general.Gen;
import academy.yamamoto.android.general.HierarchicalRect;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.Vector;
import main.BitmapHolder;
import main.Effect;

// Referenced classes of package scene.battle.object.player:
//            PlayerIcon

public class AttackPrasma extends GameObject2D
{

    public AttackPrasma(PlayerIcon playericon)
    {
        bitmaps = null;
        bitmapsIndex = 8;
        playerIcon = null;
        distance = 60;
        touchState = null;
        updated = false;
        damage = 3;
        abnormality = false;
        pointerId = 0;
        setPlayerIcon(playericon);
    }

    public AttackPrasma(PlayerIcon playericon, Vector vector)
    {
        this(playericon);
        setBitmaps(vector);
    }

    public static int getCount()
    {
        return count;
    }

    public static void setCount(int i)
    {
        count = i;
    }

    public void destroy()
    {
        setCount(getCount() - 1);
    }

    public void draw(Canvas canvas)
    {
        if(isUpdated())
        {
            canvas.drawBitmap((Bitmap)getBitmaps().get(getBitmapsIndex()), getX(), getY(), null);
            setUpdated(false);
        }
    }

    public Vector getBitmaps()
    {
        return bitmaps;
    }

    public int getBitmapsIndex()
    {
        return bitmapsIndex;
    }

    public int getDamage()
    {
        return damage;
    }

    public int getDistance()
    {
        return distance;
    }

    public PlayerIcon getPlayerIcon()
    {
        return playerIcon;
    }

    public int getPointerId()
    {
        return pointerId;
    }

    public TouchState getTouchState()
    {
        return touchState;
    }

    public boolean hasBitmaps()
    {
        return getBitmaps() != null;
    }

    public void initialize()
    {
        if(!hasBitmaps())
        {
            setBitmaps(new Vector(4));
            Bitmap bitmap = BitmapHolder.get(66);
            getBitmaps().add(Effect.clipBitmap(bitmap, 3, 0));
            getBitmaps().add(Effect.clipBitmap(bitmap, 2, 0));
            getBitmaps().add(Effect.clipBitmap(bitmap, 1, 0));
            getBitmaps().add(Effect.clipBitmap(bitmap, 0, 0));
            getBitmaps().add(Effect.clipBitmap(bitmap, 3, 2));
            getBitmaps().add(Effect.clipBitmap(bitmap, 2, 2));
            getBitmaps().add(Effect.clipBitmap(bitmap, 1, 2));
            getBitmaps().add(Effect.clipBitmap(bitmap, 0, 2));
            getBitmaps().add(Effect.clipBitmap(bitmap, 4, 0));
            getBitmaps().add(Effect.clipBitmap(bitmap, 0, 1));
        }
        setCenter(48F, 48F);
        setTouchState(getEngine().getTouchState());
        if(getTouchState().containsKey(Integer.valueOf(getPointerId())))
        {
            setCollisionRect(new HierarchicalRect(0, 0.0F, 0.0F, 96F, 96F));
            pointUpdate();
        } else
        {
            setAbnormality(true);
        }
        setCount(getCount() + 1);
        if(getCount() > 1)
            setAbnormality(true);
    }

    public boolean isAbnormality()
    {
        return abnormality;
    }

    public boolean isUpdated()
    {
        return updated;
    }

    public void pointUpdate()
    {
        TouchPointer touchpointer = (TouchPointer)getTouchState().get(Integer.valueOf(getPointerId()));
        float f3 = Gen.getRadian(getPlayerIcon().getCenterX(), getPlayerIcon().getCenterY(), touchpointer.x, touchpointer.y);
        float f = getDistance();
        float f1 = (float)Math.cos(f3);
        float f2 = getDistance();
        f3 = (float)Math.sin(f3);
        offsetTo((getPlayerIcon().getCenterX() + f * f1) - getCenterXdiff(), (getPlayerIcon().getCenterY() + f2 * f3) - getCenterYdiff());
    }

    public void setAbnormality(boolean flag)
    {
        abnormality = flag;
    }

    public void setBitmaps(Vector vector)
    {
        bitmaps = vector;
    }

    public void setBitmapsIndex(int i)
    {
        bitmapsIndex = i;
    }

    public void setDamage(int i)
    {
        damage = i;
    }

    public void setDistance(int i)
    {
        distance = i;
    }

    public void setPlayerIcon(PlayerIcon playericon)
    {
        playerIcon = playericon;
    }

    public void setPointerId(int i)
    {
        pointerId = i;
    }

    public void setTouchState(TouchState touchstate)
    {
        touchState = touchstate;
    }

    public void setUpdated(boolean flag)
    {
        updated = flag;
    }

    public boolean update()
    {
        if(!isAbnormality()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if(!getTouchState().containsKey(Integer.valueOf(getPointerId())) || getPlayerIcon().isDeleted() || getPlayerIcon().getAttackType() != 1)
            delete();
        if(!isDeleted()) goto _L4; else goto _L3
_L3:
        if(getBitmapsIndex() < 8)
        {
            setBitmapsIndex(8);
            setCollisionRect(null);
        } else
        {
            setBitmapsIndex(getBitmapsIndex() + 1);
        }
        if(getBitmapsIndex() > 9) goto _L1; else goto _L5
_L5:
        setUpdated(true);
        return true;
_L4:
        pointUpdate();
        setBitmapsIndex(getBitmapsIndex() + 1);
        if(getBitmapsIndex() > 7)
            setBitmapsIndex(0);
        if(true) goto _L5; else goto _L6
_L6:
    }

    private static int count = 0;
    private boolean abnormality;
    private Vector bitmaps;
    private int bitmapsIndex;
    private int damage;
    private int distance;
    private PlayerIcon playerIcon;
    private int pointerId;
    private TouchState touchState;
    private boolean updated;

}
