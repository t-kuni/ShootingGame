// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.enemy;

import academy.yamamoto.android.game.*;
import academy.yamamoto.android.general.Gen;
import android.graphics.*;
import java.util.HashMap;
import java.util.Vector;
import main.Effect;
import main.SEHolder;
import scene.battle.Battle;
import scene.battle.object.Shot;
import scene.battle.object.Wall;
import scene.battle.object.player.*;

// Referenced classes of package scene.battle.object.enemy:
//            Attackable, Movable

public class Enemy extends GameObject2D
{

    public Enemy()
    {
        hp = 100;
        maxHp = 100;
        score = 1000F;
        timeBorder = 1000F;
        movers = null;
        moverIndex = 0;
        moveRepeatable = false;
        attackers = null;
        attackerIndex = 0;
        attackCycle = 20;
        attackRepeatable = false;
        hitBitmap2 = null;
        hitBitmap1 = null;
        hitTime = 0;
        hpBarPaint = null;
        hpBarWidth = 70F;
        hpBarHeight = 8F;
        hpBarRect = null;
        setMovers(new Vector(4));
        setAttackers(new Vector(4));
    }

    private int scoreCalc(int i)
    {
        Player player = (Player)getManager().getObjectMap().get("player");
        float f1 = getScore() * ((float)i / (float)getMaxHp());
        float f = 0.0F;
        if((float)getTime() < getTimeBorder())
            f = f1 * ((getTimeBorder() - (float)getTime()) / (2.0F * getTimeBorder()));
        return (int)(f1 + f + f1 * ((1000F - Gen.getDistance(getX(), getY(), player.getPlayerIcon().getX(), player.getPlayerIcon().getY())) / 1250F));
    }

    private void setAttackers(Vector vector)
    {
        attackers = vector;
    }

    private void setMovers(Vector vector)
    {
        movers = vector;
    }

    private void updateHpBarPosition()
    {
        getHpBarRect().offsetTo(getCenterX() - getHpBarWidth() / 2.0F, getY() + (float)getBitmap().getHeight() + 10F);
    }

    private void updateHpBarRect()
    {
        float f = (float)getHp() / (float)getMaxHp();
        RectF rectf = new RectF(0.0F, 0.0F, getHpBarWidth() * f, getHpBarHeight());
        if(hasBitmap())
            rectf.offsetTo(getCenterX() - getHpBarWidth() / 2.0F, getY() + (float)getBitmap().getHeight() + 10F);
        else
            rectf.offsetTo(getCenterX() - getHpBarWidth() / 2.0F, getY());
        setHpBarRect(rectf);
    }

    public void addAttackable(Attackable attackable)
    {
        getAttackers().add(attackable);
    }

    public void addAttackable(Attackable aattackable[])
    {
        int i = 0;
        do
        {
            if(i >= aattackable.length)
                return;
            addAttackable(aattackable[i]);
            i++;
        } while(true);
    }

    public void addMovable(Movable movable)
    {
        getMovers().add(movable);
    }

    public void addMovable(Movable amovable[])
    {
        int i = 0;
        do
        {
            if(i >= amovable.length)
                return;
            addMovable(amovable[i]);
            i++;
        } while(true);
    }

    public void attack()
    {
        if(!getAttackers().isEmpty())
            if(getAttackerIndex() < getAttackers().size())
            {
                float f = getCenterX();
                float f1 = getCenterY();
                if(!((Attackable)getAttackers().get(getAttackerIndex())).attack(this, f, f1))
                {
                    ((Attackable)getAttackers().get(getAttackerIndex())).reset();
                    setAttackerIndex(getAttackerIndex() + 1);
                }
            } else
            if(isAttackRepeatable())
            {
                setAttackerIndex(0);
                attack();
                return;
            }
    }

    public void collision(int i, Class class1, GameObject2D gameobject2d, int j)
    {
        if(!(gameobject2d instanceof Wall)) goto _L2; else goto _L1
_L1:
        delete();
_L4:
        return;
_L2:
        if(!(gameobject2d instanceof Shot))
            break; /* Loop/switch isn't completed */
        if(gameobject2d.getId() == 1)
        {
            damage(((Shot)gameobject2d).hit());
            setHitTime(2);
            hitEffecting(gameobject2d);
            return;
        }
        if(true) goto _L4; else goto _L3
_L3:
        if(gameobject2d instanceof AttackPrasma)
        {
            damage(((AttackPrasma)gameobject2d).getDamage());
            setHitTime(2);
            hitEffecting(gameobject2d);
            return;
        }
        if(gameobject2d instanceof Fire)
        {
            damage(((Fire)gameobject2d).getDamage());
            setHitTime(2);
            hitEffecting(gameobject2d);
            return;
        }
        if(gameobject2d instanceof PlayerIcon)
        {
            class1 = (Player)getManager().getObjectMap().get("player");
            i = (int)(getScore() / 20F);
            class1.getPlayerIcon().damage(i / 2);
            class1.getScoreBoard().add(-i);
            return;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    public void damage(int i)
    {
        int l = getHp() - i;
        int k = l;
        int j = i;
        if(l <= 0)
        {
            j = i + l;
            k = 0;
            delete();
            SEHolder.play(getEngine().getContext(), 2);
            Effect effect = new Effect(0);
            effect.offsetTo(getCenterX() - effect.getCenterXdiff(), getCenterY() - effect.getCenterYdiff());
            ((Battle)getEngine().getGame()).getTopGom().add(effect);
        }
        setHp(k);
        setHitTime(2);
        SEHolder.play(getEngine().getContext(), 5);
        Player player = (Player)getManager().getObjectMap().get("player");
        i = scoreCalc(j);
        player.getScoreBoard().add(i);
        updateHpBarRect();
    }

    public void draw(Canvas canvas)
    {
        Bitmap bitmap;
        if(getHitTime() <= 0)
            break MISSING_BLOCK_LABEL_103;
        bitmap = null;
        getHitTime();
        JVM INSTR tableswitch 1 2: default 36
    //                   1 95
    //                   2 87;
           goto _L1 _L2 _L3
_L1:
        canvas.drawBitmap(bitmap, getX(), getY(), null);
        setHitTime(getHitTime() - 1);
_L4:
        if(getHpBarRect() != null && getHpBarPaint() != null)
            canvas.drawRect(getHpBarRect(), getHpBarPaint());
        return;
_L3:
        bitmap = getHitBitmap2();
          goto _L1
_L2:
        bitmap = getHitBitmap1();
          goto _L1
        canvas.drawBitmap(getBitmap(), getX(), getY(), null);
          goto _L4
    }

    public int getAttackCycle()
    {
        return attackCycle;
    }

    public int getAttackerIndex()
    {
        return attackerIndex;
    }

    public Vector getAttackers()
    {
        return attackers;
    }

    public Bitmap getHitBitmap1()
    {
        return hitBitmap1;
    }

    public Bitmap getHitBitmap2()
    {
        return hitBitmap2;
    }

    public int getHitTime()
    {
        return hitTime;
    }

    public int getHp()
    {
        return hp;
    }

    public float getHpBarHeight()
    {
        return hpBarHeight;
    }

    public Paint getHpBarPaint()
    {
        return hpBarPaint;
    }

    public RectF getHpBarRect()
    {
        return hpBarRect;
    }

    public float getHpBarWidth()
    {
        return hpBarWidth;
    }

    public int getMaxHp()
    {
        return maxHp;
    }

    public int getMoverIndex()
    {
        return moverIndex;
    }

    public Vector getMovers()
    {
        return movers;
    }

    public float getScore()
    {
        return score;
    }

    public float getTimeBorder()
    {
        return timeBorder;
    }

    public boolean hasHitBitmap1()
    {
        return getHitBitmap1() != null;
    }

    public boolean hasHitBitmap2()
    {
        return getHitBitmap2() != null;
    }

    public void hitEffecting(GameObject2D gameobject2d)
    {
        Effect effect = new Effect(7);
        float f2 = gameobject2d.getCenterX();
        float f3 = getCenterX();
        float f = gameobject2d.getCenterY();
        float f1 = getCenterY();
        f2 = getCenterX() + (f2 - f3) / 2.0F;
        f = getCenterY() + (f - f1) / 2.0F;
        effect.offsetTo(f2 - effect.getCenterXdiff(), f - effect.getCenterYdiff());
        ((Battle)getEngine().getGame()).getTopGom().add(effect);
        gameobject2d = ((Player)getManager().getObjectMap().get("player")).getComboCounter();
        gameobject2d.countUp();
        gameobject2d.offsetTo(f2 - 100F - gameobject2d.getCenterXdiff(), f - 50F - gameobject2d.getCenterYdiff());
    }

    public void initialize()
    {
        Paint paint = new Paint();
        paint.setColor(0xffff0000);
        setHpBarPaint(paint);
        updateHpBarRect();
    }

    public boolean isAttackRepeatable()
    {
        return attackRepeatable;
    }

    public boolean isMoveRepeatable()
    {
        return moveRepeatable;
    }

    public void move()
    {
        if(!getMovers().isEmpty())
            if(getMoverIndex() < getMovers().size())
            {
                if(!((Movable)getMovers().get(getMoverIndex())).move(this))
                {
                    ((Movable)getMovers().get(getMoverIndex())).reset();
                    setMoverIndex(getMoverIndex() + 1);
                }
            } else
            if(isMoveRepeatable())
            {
                setMoverIndex(0);
                move();
                return;
            }
    }

    public void setAttackCycle(int i)
    {
        attackCycle = i;
    }

    public void setAttackRepeatable(boolean flag)
    {
        attackRepeatable = flag;
    }

    public void setAttackerIndex(int i)
    {
        attackerIndex = i;
    }

    public void setBitmap(Bitmap bitmap)
    {
        super.setBitmap(bitmap);
    }

    public void setHitBitmap1(Bitmap bitmap)
    {
        hitBitmap1 = bitmap;
    }

    public void setHitBitmap2(Bitmap bitmap)
    {
        hitBitmap2 = bitmap;
    }

    public void setHitTime(int i)
    {
        hitTime = i;
    }

    public void setHp(int i)
    {
        hp = i;
    }

    public void setHpBarHeight(float f)
    {
        hpBarHeight = f;
    }

    public void setHpBarPaint(Paint paint)
    {
        hpBarPaint = paint;
    }

    public void setHpBarRect(RectF rectf)
    {
        hpBarRect = rectf;
    }

    public void setHpBarWidth(float f)
    {
        hpBarWidth = f;
    }

    public void setMaxHp(int i)
    {
        maxHp = i;
    }

    public void setMoveRepeatable(boolean flag)
    {
        moveRepeatable = flag;
    }

    public void setMoverIndex(int i)
    {
        moverIndex = i;
    }

    public void setScore(float f)
    {
        score = f;
    }

    public void setTimeBorder(float f)
    {
        timeBorder = f;
    }

    public boolean update()
    {
        if(isDeleted())
            return false;
        move();
        if(getHpBarRect() != null)
            updateHpBarPosition();
        if(getTime() % getAttackCycle() == 0)
            attack();
        nextTime();
        return true;
    }

    private int attackCycle;
    private boolean attackRepeatable;
    private int attackerIndex;
    private Vector attackers;
    private Bitmap hitBitmap1;
    private Bitmap hitBitmap2;
    private int hitTime;
    private int hp;
    private float hpBarHeight;
    private Paint hpBarPaint;
    private RectF hpBarRect;
    private float hpBarWidth;
    private int maxHp;
    private boolean moveRepeatable;
    private int moverIndex;
    private Vector movers;
    private float score;
    private float timeBorder;
}
