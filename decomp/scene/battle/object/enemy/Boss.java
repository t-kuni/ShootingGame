// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.enemy;

import academy.yamamoto.android.game.*;
import academy.yamamoto.android.general.Gen;
import academy.yamamoto.android.general.HierarchicalRect;
import android.graphics.*;
import java.util.Iterator;
import java.util.Vector;
import main.BitmapHolder;
import main.Effect;
import scene.battle.Battle;
import scene.battle.EndProduction00;
import scene.battle.object.Shot;
import scene.battle.object.player.Player;
import scene.battle.object.player.PlayerIcon;

// Referenced classes of package scene.battle.object.enemy:
//            Enemy, BossRushEffect

public class Boss extends Enemy
{

    public Boss()
    {
        bitmaps = null;
        direction = 0;
        playerIcon = null;
        mainBitmap = null;
        collisionRects = null;
        state = 0;
        invisible = false;
        auraBitmaps = null;
        auraBitmapsIndex = 0;
        waitTimeOut = 15;
        waitTime = 0;
        stayBarrageRadian = 0.0F;
        stayBarrageRadianSingleInc = 0.7853982F;
        stayBarrageRadianSetInc = 0.3926991F;
        stayBarrageSetCount = 0;
        stayBarrageSetMaxCount = 3;
        stayBarrageRadianSingleTime = 0;
        stayBarrageRadianSingleInterval = 2;
        stayBarrageRadianSetTime = 0;
        stayBarrageRadianSetInterval = 6;
        rushEffect = null;
        rushStep = 0;
        rushSpeed = 50F;
        rushRange = 0.0F;
        rushMaxRange = 300F;
        rushRadian = 0.0F;
        rushInterval = 20;
        rushTime = 0;
        rushAimTimeOut = 10;
        rushAimTime = 0;
        rushCount = 0;
        rushMaxCount = 3;
        summonCount = 3;
        summonTime = 0;
        summonTimeOut = 10;
    }

    public void destroy()
    {
        Iterator iterator = getAuraBitmaps().iterator();
        do
        {
            if(!iterator.hasNext())
                return;
            ((Bitmap)iterator.next()).recycle();
        } while(true);
    }

    public void draw(Canvas canvas)
    {
        if(!isInvisible())
        {
            canvas.drawBitmap(getBitmap(), getX(), getY(), null);
            Bitmap bitmap = (Bitmap)getAuraBitmaps().get(getAuraBitmapsIndex());
            float f = getCenterX();
            float f1 = bitmap.getWidth() / 2;
            float f2 = getY();
            canvas.drawBitmap(bitmap, f - f1, ((float)((Bitmap)getBitmaps().get(getDirection())).getHeight() + f2) - (float)(bitmap.getHeight() / 2), null);
        }
    }

    public Vector getAuraBitmaps()
    {
        return auraBitmaps;
    }

    public int getAuraBitmapsIndex()
    {
        return auraBitmapsIndex;
    }

    public Bitmap getBitmap()
    {
        return mainBitmap;
    }

    public Vector getBitmaps()
    {
        return bitmaps;
    }

    public Vector getCollisionRects()
    {
        return collisionRects;
    }

    public int getDirection()
    {
        return direction;
    }

    public Bitmap getMainBitmap()
    {
        return mainBitmap;
    }

    public PlayerIcon getPlayerIcon()
    {
        return playerIcon;
    }

    public int getRushAimTime()
    {
        return rushAimTime;
    }

    public int getRushAimTimeOut()
    {
        return rushAimTimeOut;
    }

    public int getRushCount()
    {
        return rushCount;
    }

    public BossRushEffect getRushEffect()
    {
        return rushEffect;
    }

    public int getRushInterval()
    {
        return rushInterval;
    }

    public int getRushMaxCount()
    {
        return rushMaxCount;
    }

    public float getRushMaxRange()
    {
        return rushMaxRange;
    }

    public float getRushRadian()
    {
        return rushRadian;
    }

    public float getRushRange()
    {
        return rushRange;
    }

    public float getRushSpeed()
    {
        return rushSpeed;
    }

    public int getRushStep()
    {
        return rushStep;
    }

    public int getRushTime()
    {
        return rushTime;
    }

    public int getState()
    {
        return state;
    }

    public float getStayBarrageRadian()
    {
        return stayBarrageRadian;
    }

    public float getStayBarrageRadianSetInc()
    {
        return stayBarrageRadianSetInc;
    }

    public int getStayBarrageRadianSetInterval()
    {
        return stayBarrageRadianSetInterval;
    }

    public int getStayBarrageRadianSetTime()
    {
        return stayBarrageRadianSetTime;
    }

    public float getStayBarrageRadianSingleInc()
    {
        return stayBarrageRadianSingleInc;
    }

    public int getStayBarrageRadianSingleInterval()
    {
        return stayBarrageRadianSingleInterval;
    }

    public int getStayBarrageRadianSingleTime()
    {
        return stayBarrageRadianSingleTime;
    }

    public int getStayBarrageSetCount()
    {
        return stayBarrageSetCount;
    }

    public int getStayBarrageSetMaxCount()
    {
        return stayBarrageSetMaxCount;
    }

    public int getSummonCount()
    {
        return summonCount;
    }

    public int getSummonTime()
    {
        return summonTime;
    }

    public int getSummonTimeOut()
    {
        return summonTimeOut;
    }

    public int getWaitTime()
    {
        return waitTime;
    }

    public int getWaitTimeOut()
    {
        return waitTimeOut;
    }

    public boolean hasBitmap()
    {
        return getBitmap() != null;
    }

    public void initialize()
    {
        setBitmaps(new Vector(2));
        setCollisionRects(new Vector(2));
        setAuraBitmaps(new Vector(6));
        setPlayerIcon(((Player)((Battle)getEngine().getGame()).getGom().getMappedObject("player")).getPlayerIcon());
        getBitmaps().add(BitmapHolder.get(57));
        getBitmaps().add(BitmapHolder.get(56));
        Bitmap bitmap = (Bitmap)getBitmaps().get(0);
        getBitmaps().add(BitmapHolder.get(126));
        getBitmaps().add(BitmapHolder.get(127));
        bitmap = (Bitmap)getBitmaps().get(1);
        getBitmaps().add(BitmapHolder.get(124));
        getBitmaps().add(BitmapHolder.get(125));
        bitmap = BitmapHolder.get(59);
        getAuraBitmaps().add(Effect.clipBitmap(bitmap, 0, 1));
        getAuraBitmaps().add(Effect.clipBitmap(bitmap, 1, 1));
        getAuraBitmaps().add(Effect.clipBitmap(bitmap, 2, 1));
        getAuraBitmaps().add(Effect.clipBitmap(bitmap, 3, 1));
        getAuraBitmaps().add(Effect.clipBitmap(bitmap, 4, 1));
        getAuraBitmaps().add(Effect.clipBitmap(bitmap, 0, 2));
        getCollisionRects().add(new HierarchicalRect(0, 74F, 9F, 113F, 71F));
        float f = ((Bitmap)getBitmaps().get(1)).getWidth();
        getCollisionRects().add(new HierarchicalRect(0, f - 113F, 9F, f - 74F, 71F));
        setHp(350);
        setMaxHp(350);
        setScore(4000F);
        setTimeBorder(500F);
        setName("BOSS");
        setBitmap((Bitmap)getBitmaps().get(0));
        setCollisionRect((HierarchicalRect)getCollisionRects().get(0));
        setCenter(getCollisionRect().getRect().left + getCollisionRect().getRect().width() / 2.0F, getCollisionRect().getRect().top + getCollisionRect().getRect().height() / 2.0F);
        offsetTo(getEngine().getGame().getVirtualScreenWidth() / 2.0F - getCenterXdiff(), getEngine().getGame().getVirtualScreenHeight() / 2.0F - getCenterYdiff());
        super.initialize();
    }

    public void invisible()
    {
        if(!isInvisible())
            setInvisible(true);
    }

    public boolean isInvisible()
    {
        return invisible;
    }

    public void offsetTo(float f, float f1)
    {
        RectF rectf = ((HierarchicalRect)getCollisionRects().get(0)).getRect();
        float f2 = rectf.left;
        float f3 = getX();
        float f4 = rectf.top;
        float f5 = getY();
        ((HierarchicalRect)getCollisionRects().get(0)).offsetTo((f2 - f3) + f, (f4 - f5) + f1);
        rectf = ((HierarchicalRect)getCollisionRects().get(1)).getRect();
        f2 = rectf.left;
        f3 = getX();
        f4 = rectf.top;
        f5 = getY();
        ((HierarchicalRect)getCollisionRects().get(1)).offsetTo((f2 - f3) + f, (f4 - f5) + f1);
        setCollisionRect(null);
        super.offsetTo(f, f1);
        setCollisionRect((HierarchicalRect)getCollisionRects().get(getDirection()));
    }

    public void setAuraBitmaps(Vector vector)
    {
        auraBitmaps = vector;
    }

    public void setAuraBitmapsIndex(int i)
    {
        auraBitmapsIndex = i;
    }

    public void setBitmap(Bitmap bitmap)
    {
        mainBitmap = bitmap;
    }

    public void setBitmaps(Vector vector)
    {
        bitmaps = vector;
    }

    public void setCollisionRects(Vector vector)
    {
        collisionRects = vector;
    }

    public void setDirection(int i)
    {
        direction = i;
    }

    public void setInvisible(boolean flag)
    {
        invisible = flag;
    }

    public void setMainBitmap(Bitmap bitmap)
    {
        mainBitmap = bitmap;
    }

    public void setPlayerIcon(PlayerIcon playericon)
    {
        playerIcon = playericon;
    }

    public void setRushAimTime(int i)
    {
        rushAimTime = i;
    }

    public void setRushAimTimeOut(int i)
    {
        rushAimTimeOut = i;
    }

    public void setRushCount(int i)
    {
        rushCount = i;
    }

    public void setRushEffect(BossRushEffect bossrusheffect)
    {
        rushEffect = bossrusheffect;
    }

    public void setRushInterval(int i)
    {
        rushInterval = i;
    }

    public void setRushMaxCount(int i)
    {
        rushMaxCount = i;
    }

    public void setRushMaxRange(float f)
    {
        rushMaxRange = f;
    }

    public void setRushRadian(float f)
    {
        rushRadian = f;
    }

    public void setRushRange(float f)
    {
        rushRange = f;
    }

    public void setRushSpeed(float f)
    {
        rushSpeed = f;
    }

    public void setRushStep(int i)
    {
        rushStep = i;
    }

    public void setRushTime(int i)
    {
        rushTime = i;
    }

    public void setState(int i)
    {
        state = i;
    }

    public void setStayBarrageRadian(float f)
    {
        stayBarrageRadian = f;
    }

    public void setStayBarrageRadianSetInc(float f)
    {
        stayBarrageRadianSetInc = f;
    }

    public void setStayBarrageRadianSetInterval(int i)
    {
        stayBarrageRadianSetInterval = i;
    }

    public void setStayBarrageRadianSetTime(int i)
    {
        stayBarrageRadianSetTime = i;
    }

    public void setStayBarrageRadianSingleInc(float f)
    {
        stayBarrageRadianSingleInc = f;
    }

    public void setStayBarrageRadianSingleInterval(int i)
    {
        stayBarrageRadianSingleInterval = i;
    }

    public void setStayBarrageRadianSingleTime(int i)
    {
        stayBarrageRadianSingleTime = i;
    }

    public void setStayBarrageSetCount(int i)
    {
        stayBarrageSetCount = i;
    }

    public void setStayBarrageSetMaxCount(int i)
    {
        stayBarrageSetMaxCount = i;
    }

    public void setSummonCount(int i)
    {
        summonCount = i;
    }

    public void setSummonTime(int i)
    {
        summonTime = i;
    }

    public void setSummonTimeOut(int i)
    {
        summonTimeOut = i;
    }

    public void setWaitTime(int i)
    {
        waitTime = i;
    }

    public void setWaitTimeOut(int i)
    {
        waitTimeOut = i;
    }

    public void toStateRush()
    {
        setState(2);
        BossRushEffect bossrusheffect = new BossRushEffect();
        bossrusheffect.offsetTo(getCenterX() - bossrusheffect.getCenterXdiff(), getCenterY() - bossrusheffect.getCenterYdiff());
        setRushEffect(bossrusheffect);
        ((Battle)getEngine().getGame()).getGom().add(bossrusheffect);
        setRushStep(0);
        setRushAimTime(0);
        setRushTime(0);
        setRushRadian(0.0F);
        setRushRange(0.0F);
        setRushCount(0);
        if(getHp() < getMaxHp() / 3)
        {
            setRushInterval(6);
            setRushAimTimeOut(2);
            setRushMaxRange(500F);
            setRushSpeed(70F);
            setRushMaxCount(4);
            return;
        }
        if(getHp() < (getMaxHp() / 3) * 2)
        {
            setRushInterval(7);
            setRushAimTimeOut(5);
            setRushMaxRange(400F);
            setRushSpeed(60F);
            setRushMaxCount(3);
            return;
        } else
        {
            setRushInterval(8);
            setRushAimTimeOut(8);
            setRushMaxRange(300F);
            setRushSpeed(50F);
            setRushMaxCount(2);
            return;
        }
    }

    public void toStateStayBarrage()
    {
        setState(1);
        setStayBarrageRadian(0.0F);
        setStayBarrageRadianSingleTime(0);
        setStayBarrageRadianSetTime(0);
        setStayBarrageSetCount(0);
        if(getHp() < getMaxHp() / 3)
        {
            setStayBarrageRadianSingleInc(0.5235988F);
            setStayBarrageRadianSingleInterval(2);
            setStayBarrageRadianSetInc(0.2617994F);
            setStayBarrageRadianSetInterval(0);
            setStayBarrageSetMaxCount(2);
            return;
        }
        if(getHp() < (getMaxHp() / 3) * 2)
        {
            setStayBarrageRadianSingleInc(0.6283185F);
            setStayBarrageRadianSingleInterval(2);
            setStayBarrageRadianSetInc(0.3141593F);
            setStayBarrageRadianSetInterval(1);
            setStayBarrageSetMaxCount(2);
            return;
        } else
        {
            setStayBarrageRadianSingleInc(0.7853982F);
            setStayBarrageRadianSingleInterval(2);
            setStayBarrageRadianSetInc(0.3926991F);
            setStayBarrageRadianSetInterval(2);
            setStayBarrageSetMaxCount(2);
            return;
        }
    }

    public void toStateWait(int i)
    {
        setWaitTime(0);
        setWaitTimeOut(i);
        setState(0);
    }

    public void toSummonSword()
    {
        setState(3);
        setSummonTime(0);
        int i;
        int j;
        if(getHp() < getMaxHp() / 3)
        {
            setSummonCount(5);
            setSummonTime(4);
        } else
        if(getHp() < (getMaxHp() / 3) * 2)
        {
            setSummonCount(4);
            setSummonTime(7);
        } else
        {
            setSummonCount(3);
            setSummonTime(10);
        }
        i = 0;
        j = getSummonCount();
        do
        {
            if(i >= j)
                return;
            Effect effect = new Effect(11);
            effect.offsetTo(getEngine().getGame().getVirtualScreenWidth() * (float)Math.random() - effect.getCenterXdiff(), getEngine().getGame().getVirtualScreenHeight() * (float)Math.random() - effect.getCenterYdiff());
            ((Battle)getEngine().getGame()).getTopGom().add(effect);
            i++;
        } while(true);
    }

    public boolean update()
    {
        float f;
        float f2;
        if(isDeleted())
        {
            if(getRushEffect() != null)
                getRushEffect().delete();
            getPlayerIcon().setKilledBoss(true);
            ((Battle)getEngine().getGame()).getTop2Gom().add(new EndProduction00());
            return false;
        }
        f = getCenterX();
        f2 = getCenterY();
        if(getDirection() != 1 || getPlayerIcon().getCenterX() >= getCenterX()) goto _L2; else goto _L1
_L1:
        setDirection(0);
        setCollisionRect((HierarchicalRect)getCollisionRects().get(0));
_L17:
        setCenter(getCollisionRect().getRect().left + getCollisionRect().getRect().width() / 2.0F, getCollisionRect().getRect().top + getCollisionRect().getRect().height() / 2.0F);
        offsetTo(f - getCenterXdiff(), f2 - getCenterYdiff());
        if(getDirection() != 0) goto _L4; else goto _L3
_L3:
        getHitTime();
        JVM INSTR tableswitch 0 2: default 212
    //                   0 339
    //                   1 357
    //                   2 375;
           goto _L5 _L6 _L7 _L8
_L5:
        if(getHitTime() > 0)
            setHitTime(getHitTime() - 1);
        setAuraBitmapsIndex(getAuraBitmapsIndex() + 1);
        if(getAuraBitmapsIndex() >= getAuraBitmaps().size())
            setAuraBitmapsIndex(0);
        getState();
        JVM INSTR tableswitch 0 3: default 292
    //                   0 481
    //                   1 512
    //                   2 749
    //                   3 1226;
           goto _L9 _L10 _L11 _L12 _L13
_L9:
        return true;
_L2:
        if(getPlayerIcon().getCenterX() > getCenterX())
        {
            setDirection(1);
            if(!isInvisible())
                setCollisionRect((HierarchicalRect)getCollisionRects().get(1));
        }
        continue; /* Loop/switch isn't completed */
_L6:
        setBitmap((Bitmap)getBitmaps().get(0));
          goto _L5
_L7:
        setBitmap((Bitmap)getBitmaps().get(2));
          goto _L5
_L8:
        setBitmap((Bitmap)getBitmaps().get(3));
          goto _L5
_L4:
        switch(getHitTime())
        {
        case 0: // '\0'
            setBitmap((Bitmap)getBitmaps().get(1));
            break;

        case 1: // '\001'
            setBitmap((Bitmap)getBitmaps().get(4));
            break;

        case 2: // '\002'
            setBitmap((Bitmap)getBitmaps().get(5));
            break;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if(getWaitTime() >= getWaitTimeOut())
            toStateStayBarrage();
        else
            setWaitTime(getWaitTime() + 1);
          goto _L9
_L11:
        setStayBarrageRadianSingleTime(getStayBarrageRadianSingleTime() + 1);
        if(getStayBarrageRadianSingleTime() >= getStayBarrageRadianSingleInterval())
        {
            setStayBarrageRadianSingleTime(0);
            Shot shot = new Shot(2);
            shot.setBitmap(BitmapHolder.get(101));
            shot.setCollisionRect(new HierarchicalRect(0, 7F, 9F, 32F, 37F));
            shot.offsetTo(getCenterX() - shot.getCenterXdiff(), getCenterY() - shot.getCenterYdiff());
            shot.setSpeed(50F);
            shot.setDamage(75);
            shot.setDeleteCount(5);
            if(getDirection() == 0)
                shot.setAngle(getStayBarrageRadian() + 1.570796F);
            else
                shot.setAngle(1.570796F - getStayBarrageRadian());
            ((Battle)getEngine().getGame()).getGom().add(shot);
            setStayBarrageRadian(getStayBarrageRadian() + getStayBarrageRadianSingleInc());
            if((double)getStayBarrageRadian() >= 3.1415926535897931D)
            {
                setStayBarrageSetCount(getStayBarrageSetCount() + 1);
                setStayBarrageRadian(getStayBarrageRadianSetInc() * (float)getStayBarrageSetCount());
                if(getStayBarrageSetCount() >= getStayBarrageSetMaxCount())
                    toStateRush();
            }
        }
          goto _L9
_L12:
        switch(getRushStep())
        {
        case 0: // '\0'
            if(getRushTime() >= 5)
            {
                setRushTime(0);
                setRushStep(getRushStep() + 1);
            } else
            {
                setRushTime(getRushTime() + 1);
            }
            break;

        case 1: // '\001'
            if(getRushTime() >= 5)
            {
                setRushTime(0);
                setRushStep(getRushStep() + 1);
            } else
            {
                setRushTime(getRushTime() + 1);
            }
            break;

        case 2: // '\002'
            if(getRushAimTime() == 0)
                setRushRadian(Gen.getRadian(getCenterX(), getCenterY(), getPlayerIcon().getCenterX(), getPlayerIcon().getCenterY()));
            if(getRushAimTime() >= getRushAimTimeOut())
            {
                setRushAimTime(0);
                setRushStep(getRushStep() + 1);
            } else
            {
                setRushAimTime(getRushAimTime() + 1);
            }
            break;

        case 3: // '\003'
            float f3 = getEngine().getGame().getVirtualScreenWidth();
            float f4 = getEngine().getGame().getVirtualScreenHeight();
            float f6 = getRushSpeed();
            float f7 = (float)Math.cos(getRushRadian());
            float f1 = getRushSpeed();
            float f5 = (float)Math.sin(getRushRadian());
            f6 = getCenterX() + f6 * f7;
            f5 = getCenterY() + f1 * f5;
            if(f6 < 0.0F)
            {
                f1 = 0.0F;
            } else
            {
                f1 = f6;
                if(f6 > f3)
                    f1 = f3;
            }
            if(f5 < 0.0F)
            {
                f3 = 0.0F;
            } else
            {
                f3 = f5;
                if(f5 > f4)
                    f3 = f4;
            }
            getRushEffect().offsetTo(f1 - getRushEffect().getCenterXdiff(), f3 - getRushEffect().getCenterYdiff());
            offsetTo(f1 - getCenterXdiff(), f3 - getCenterYdiff());
            setRushRange(getRushRange() + getRushSpeed());
            if(getRushRange() >= getRushMaxRange())
            {
                setRushRange(0.0F);
                setRushCount(getRushCount() + 1);
                if(getRushCount() >= getRushMaxCount())
                {
                    setRushStep(getRushStep() + 1);
                    getRushEffect().delete();
                } else
                {
                    setRushStep(1);
                }
            }
            break;

        case 4: // '\004'
            if(getRushTime() >= 5)
            {
                setRushTime(0);
                toSummonSword();
            } else
            {
                setRushTime(getRushTime() + 1);
            }
            break;
        }
        if(true) goto _L9; else goto _L14
_L14:
_L13:
        if(getSummonTime() >= getSummonTimeOut())
            toStateStayBarrage();
        else
            setSummonTime(getSummonTime() + 1);
          goto _L9
        if(true) goto _L5; else goto _L15
_L15:
        if(true) goto _L17; else goto _L16
_L16:
    }

    public void visible()
    {
        if(isInvisible())
        {
            setInvisible(false);
            setCollisionRect((HierarchicalRect)getCollisionRects().get(getDirection()));
        }
    }

    private static final int DIRECTION_LEFT = 0;
    private static final int DIRECTION_RIGHT = 1;
    private static final int STATE_RUSH = 2;
    private static final int STATE_STAY_BARRAGE = 1;
    private static final int STATE_SUMMON_SWORD = 3;
    private static final int STATE_WAIT = 0;
    private Vector auraBitmaps;
    private int auraBitmapsIndex;
    private Vector bitmaps;
    private Vector collisionRects;
    private int direction;
    private boolean invisible;
    private Bitmap mainBitmap;
    private PlayerIcon playerIcon;
    private int rushAimTime;
    private int rushAimTimeOut;
    private int rushCount;
    private BossRushEffect rushEffect;
    private int rushInterval;
    private int rushMaxCount;
    private float rushMaxRange;
    private float rushRadian;
    private float rushRange;
    private float rushSpeed;
    private int rushStep;
    private int rushTime;
    private int state;
    private float stayBarrageRadian;
    private float stayBarrageRadianSetInc;
    private int stayBarrageRadianSetInterval;
    private int stayBarrageRadianSetTime;
    private float stayBarrageRadianSingleInc;
    private int stayBarrageRadianSingleInterval;
    private int stayBarrageRadianSingleTime;
    private int stayBarrageSetCount;
    private int stayBarrageSetMaxCount;
    private int summonCount;
    private int summonTime;
    private int summonTimeOut;
    private int waitTime;
    private int waitTimeOut;
}
