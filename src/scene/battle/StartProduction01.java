// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle;

import academy.yamamoto.android.game.*;
import android.graphics.*;
import main.BitmapHolder;
import main.SEHolder;

// Referenced classes of package scene.battle:
//            Battle, StartProduction02

public class StartProduction01 extends GameObject2D
{

    public StartProduction01()
    {
        playerPoint = null;
        playerBitmap = null;
        moveSpeed = 100F;
    }

    private Bitmap getPlayerBitmap()
    {
        return playerBitmap;
    }

    private void setPlayerBitmap(Bitmap bitmap)
    {
        playerBitmap = bitmap;
    }

    public void draw(Canvas canvas)
    {
        if(getPlayerBitmap() != null)
            canvas.drawBitmap(getPlayerBitmap(), getPlayerPoint().x, getPlayerPoint().y, null);
    }

    public float getMoveSpeed()
    {
        return moveSpeed;
    }

    public PointF getPlayerPoint()
    {
        return playerPoint;
    }

    public void initialize()
    {
        setPlayerBitmap(BitmapHolder.get(13));
        setPlayerPoint(new PointF(-getPlayerBitmap().getWidth(), getEngine().getGame().getVirtualScreenHeight() / 2.0F - (float)(getPlayerBitmap().getHeight() / 2)));
        SEHolder.play(getEngine().getContext(), 6);
    }

    public void setMoveSpeed(float f)
    {
        moveSpeed = f;
    }

    public void setPlayerPoint(PointF pointf)
    {
        playerPoint = pointf;
    }

    public boolean update()
    {
        PointF pointf = getPlayerPoint();
        pointf.x = pointf.x + getMoveSpeed();
        if(getPlayerPoint().x > getEngine().getGame().getVirtualScreenWidth())
            setPlayerBitmap(null);
        if(getTime() > 35)
        {
            ((Battle)getEngine().getGame()).getGom().add(new StartProduction02());
            return false;
        } else
        {
            nextTime();
            return true;
        }
    }

    private float moveSpeed;
    private Bitmap playerBitmap;
    private PointF playerPoint;
}
