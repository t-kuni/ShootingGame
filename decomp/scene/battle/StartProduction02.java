// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle;

import academy.yamamoto.android.game.*;
import android.graphics.*;
import java.util.Vector;
import main.BitmapHolder;
import main.SEHolder;

// Referenced classes of package scene.battle:
//            Battle, StartProduction03

public class StartProduction02 extends GameObject2D
{

    public StartProduction02()
    {
        playerPoint = null;
        playerBitmap = null;
        moveSpeed = 20F;
        attention = true;
        attentionBitmap = null;
        visible = false;
        switchInterval = 8;
        switchTime = 0;
        allows = null;
        allowsIndex = 0;
        allowsInterval = 2;
        allowsTime = 0;
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(getPlayerBitmap(), getPlayerPoint().x, getPlayerPoint().y, null);
        if(isVisible())
        {
            canvas.drawBitmap(getAttentionBitmap(), getPlayerPoint().x - 50F, getPlayerPoint().y - 100F, null);
            canvas.drawBitmap((Bitmap)getAllows().get(allowsIndex), getPlayerPoint().x - 33F, getPlayerPoint().y - 65F, null);
        }
    }

    public Vector getAllows()
    {
        return allows;
    }

    public int getAllowsIndex()
    {
        return allowsIndex;
    }

    public int getAllowsInterval()
    {
        return allowsInterval;
    }

    public int getAllowsTime()
    {
        return allowsTime;
    }

    public Bitmap getAttentionBitmap()
    {
        return attentionBitmap;
    }

    public float getMoveSpeed()
    {
        return moveSpeed;
    }

    public Bitmap getPlayerBitmap()
    {
        return playerBitmap;
    }

    public PointF getPlayerPoint()
    {
        return playerPoint;
    }

    public int getSwitchInterval()
    {
        return switchInterval;
    }

    public int getSwitchTime()
    {
        return switchTime;
    }

    public void initialize()
    {
        setAllows(new Vector(4));
        setPlayerBitmap(BitmapHolder.get(15));
        setAttentionBitmap(BitmapHolder.get(2));
        getAllows().add(BitmapHolder.get(128));
        getAllows().add(BitmapHolder.get(129));
        getAllows().add(BitmapHolder.get(130));
        getAllows().add(BitmapHolder.get(131));
        setPlayerPoint(new PointF(getEngine().getGame().getVirtualScreenWidth(), getEngine().getGame().getVirtualScreenHeight() / 2.0F - (float)(getPlayerBitmap().getHeight() / 2)));
    }

    public boolean isAttention()
    {
        return attention;
    }

    public boolean isVisible()
    {
        return visible;
    }

    public void setAllows(Vector vector)
    {
        allows = vector;
    }

    public void setAllowsIndex(int i)
    {
        allowsIndex = i;
    }

    public void setAllowsInterval(int i)
    {
        allowsInterval = i;
    }

    public void setAllowsTime(int i)
    {
        allowsTime = i;
    }

    public void setAttention(boolean flag)
    {
        attention = flag;
    }

    public void setAttentionBitmap(Bitmap bitmap)
    {
        attentionBitmap = bitmap;
    }

    public void setMoveSpeed(float f)
    {
        moveSpeed = f;
    }

    public void setPlayerBitmap(Bitmap bitmap)
    {
        playerBitmap = bitmap;
    }

    public void setPlayerPoint(PointF pointf)
    {
        playerPoint = pointf;
    }

    public void setSwitchInterval(int i)
    {
        switchInterval = i;
    }

    public void setSwitchTime(int i)
    {
        switchTime = i;
    }

    public void setVisible(boolean flag)
    {
        visible = flag;
    }

    public boolean update()
    {
        if(isDeleted())
            return false;
        if(getPlayerPoint().x > 200F)
        {
            PointF pointf = getPlayerPoint();
            pointf.x = pointf.x - getMoveSpeed();
            if(getPlayerPoint().x < 200F)
                getPlayerPoint().x = 200F;
        }
        if(isAttention())
        {
            if(getSwitchTime() > getSwitchInterval())
            {
                boolean flag;
                Vector vector;
                if(isVisible())
                    flag = false;
                else
                    flag = true;
                setVisible(flag);
                if(isVisible())
                    SEHolder.play(getEngine().getContext(), 0);
                setSwitchTime(0);
            } else
            {
                setSwitchTime(getSwitchTime() + 1);
            }
            if(isVisible())
                if(getAllowsTime() > getAllowsInterval())
                {
                    setAllowsIndex(getAllowsIndex() + 1);
                    if(getAllowsIndex() >= getAllows().size())
                        setAllowsIndex(0);
                    setAllowsTime(0);
                } else
                {
                    setAllowsTime(getAllowsTime() + 1);
                }
        }
        if(isAttention() && getTime() > getSwitchInterval() * 10)
        {
            setAttention(false);
            vector = new Vector(4);
            vector.add(this);
            ((Battle)getEngine().getGame()).getTopGom().add(new StartProduction03(vector));
        }
        nextTime();
        return true;
    }

    private Vector allows;
    private int allowsIndex;
    private int allowsInterval;
    private int allowsTime;
    private boolean attention;
    private Bitmap attentionBitmap;
    private float moveSpeed;
    private Bitmap playerBitmap;
    private PointF playerPoint;
    private int switchInterval;
    private int switchTime;
    private boolean visible;
}
