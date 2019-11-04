// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.player;

import academy.yamamoto.android.game.*;
import android.graphics.*;
import java.util.Vector;
import main.*;
import scene.battle.Battle;

// Referenced classes of package scene.battle.object.player:
//            Fire

public class AttackFlame extends GameObject2D
{

    public AttackFlame()
    {
        targetAnimationBitmaps = null;
        targetAnimationBitmapIndex = 0;
        step = 0;
        src = null;
        dest = null;
        dests = null;
        seInterval = 2;
        seTime = 0;
        seCount = 0;
        setCenter(48F, 48F);
    }

    private RectF getDest()
    {
        return dest;
    }

    private Vector getDests()
    {
        return dests;
    }

    private Rect getSrc()
    {
        return src;
    }

    private int getStep()
    {
        return step;
    }

    private void setDest(RectF rectf)
    {
        dest = rectf;
    }

    private void setDests(Vector vector)
    {
        dests = vector;
    }

    private void setSrc(Rect rect)
    {
        src = rect;
    }

    private void setStep(int i)
    {
        step = i;
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(getBitmap(), getSrc(), getDest(), null);
    }

    public int getSeCount()
    {
        return seCount;
    }

    public int getSeInterval()
    {
        return seInterval;
    }

    public int getSeTime()
    {
        return seTime;
    }

    public int getTargetAnimationBitmapIndex()
    {
        return targetAnimationBitmapIndex;
    }

    public Vector getTargetAnimationBitmaps()
    {
        return targetAnimationBitmaps;
    }

    public boolean hasTargetAnimationBitmaps()
    {
        return getTargetAnimationBitmaps() != null;
    }

    public void initialize()
    {
        setSrc(new Rect(0, 0, 96, 96));
        setDests(new Vector(4));
        if(!hasTargetAnimationBitmaps())
        {
            Bitmap bitmap = BitmapHolder.get(65);
            setTargetAnimationBitmaps(new Vector(4));
            getTargetAnimationBitmaps().add(Effect.clipBitmap(bitmap, 2, 0));
            getTargetAnimationBitmaps().add(Effect.clipBitmap(bitmap, 1, 0));
        }
        setBitmap((Bitmap)getTargetAnimationBitmaps().get(0));
        RectF rectf = new RectF(0.0F, 0.0F, 96F + 200F, 96F + 200F);
        rectf.offsetTo(getX() - 200F / 2.0F, getY() - 200F / 2.0F);
        getDests().add(rectf);
        float f = 200F - 50F;
        rectf = new RectF(0.0F, 0.0F, 96F + f, 96F + f);
        rectf.offsetTo(getX() - f / 2.0F, getY() - f / 2.0F);
        getDests().add(rectf);
        f -= 50F;
        rectf = new RectF(0.0F, 0.0F, 96F + f, 96F + f);
        rectf.offsetTo(getX() - f / 2.0F, getY() - f / 2.0F);
        getDests().add(rectf);
        f -= 50F;
        rectf = new RectF(0.0F, 0.0F, 96F + f, 96F + f);
        rectf.offsetTo(getX() - f / 2.0F, getY() - f / 2.0F);
        getDests().add(rectf);
        rectf = new RectF(0.0F, 0.0F, 96F, 96F);
        rectf.offsetTo(getX(), getY());
        getDests().add(rectf);
    }

    public void setSeCount(int i)
    {
        seCount = i;
    }

    public void setSeInterval(int i)
    {
        seInterval = i;
    }

    public void setSeTime(int i)
    {
        seTime = i;
    }

    public void setTargetAnimationBitmapIndex(int i)
    {
        targetAnimationBitmapIndex = i;
    }

    public void setTargetAnimationBitmaps(Vector vector)
    {
        targetAnimationBitmaps = vector;
    }

    public boolean update()
    {
        if(getSeCount() < 3)
            if(getSeTime() < 1)
            {
                setSeTime(getSeInterval());
                SEHolder.play(getEngine().getContext(), 10);
                setSeCount(getSeCount() + 1);
            } else
            {
                setSeTime(getSeTime() - 1);
            }
        switch(getStep())
        {
        case 0: // '\0'
            switch(getTime())
            {
            case 0: // '\0'
                setDest((RectF)getDests().get(0));
                break;

            case 1: // '\001'
                setDest((RectF)getDests().get(1));
                break;

            case 2: // '\002'
                setDest((RectF)getDests().get(2));
                break;

            case 3: // '\003'
                setDest((RectF)getDests().get(3));
                break;

            case 4: // '\004'
                setDest((RectF)getDests().get(4));
                break;

            case 5: // '\005'
                setStep(getStep() + 1);
                setBitmap((Bitmap)getTargetAnimationBitmaps().get(1));
                break;
            }
            // fall through

        default:
            if(false)
                ;
            break;

        case 1: // '\001'
            if(getTime() > 15)
            {
                Battle battle = (Battle)getEngine().getGame();
                Fire fire = new Fire();
                fire.offsetTo(getCenterX() - fire.getCenterXdiff(), getCenterY() - fire.getCenterYdiff());
                battle.getGom().add(fire);
                return false;
            }
            break;
        }
        while(true) 
        {
            nextTime();
            return true;
        }
    }

    private RectF dest;
    private Vector dests;
    private int seCount;
    private int seInterval;
    private int seTime;
    private Rect src;
    private int step;
    private int targetAnimationBitmapIndex;
    private Vector targetAnimationBitmaps;
}
