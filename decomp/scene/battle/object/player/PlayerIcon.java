// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.player;

import academy.yamamoto.android.game.*;
import academy.yamamoto.android.general.Gen;
import academy.yamamoto.android.general.HierarchicalRect;
import android.graphics.*;
import java.util.HashMap;
import java.util.Vector;
import main.*;
import scene.battle.Battle;
import scene.battle.EndProduction00;
import scene.battle.object.Shot;
import scene.battle.object.enemy.BossRushEffect;

// Referenced classes of package scene.battle.object.player:
//            Player, ComboCounter, InputCircle, AttackPrasma, 
//            AttackFlame

public class PlayerIcon extends GameObject2D
{

    public PlayerIcon()
    {
        slopeState = null;
        touchState = null;
        hitSeInterval = 3;
        hitSeTime = 0;
        dead = false;
        hitBitmap1 = null;
        hitBitmap2 = null;
        hitTime = 0;
        totalDistance = 0.0F;
        shotCount = new int[3];
        handling = true;
        movable = true;
        killedBoss = false;
        inputCircle = null;
        hp = 1000;
        maxHp = 1000;
        attackType = 0;
        attackDarkLevel = 1;
        attackPrasmaLevel = 1;
        attackFlameLevel = 1;
        attackPrasmaBitmaps = null;
    }

    private void addTotalDistance(float f)
    {
        setTotalDistance(getTotalDistance() + f);
    }

    private void dead()
    {
        setDead(true);
    }

    public static int getOperationType()
    {
        return operationType;
    }

    private boolean isDead()
    {
        return dead;
    }

    private void setDead(boolean flag)
    {
        dead = flag;
    }

    public static void setOperationType(int i)
    {
        operationType = i;
    }

    public void collision(int i, Class class1, GameObject2D gameobject2d, int j)
    {
        if(!isDead()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(!(gameobject2d instanceof Shot))
            continue; /* Loop/switch isn't completed */
        if(gameobject2d.getId() != 2) goto _L1; else goto _L3
_L3:
        damage(((Shot)gameobject2d).hit());
        hitEffecting(gameobject2d);
        return;
        if(!(gameobject2d instanceof BossRushEffect)) goto _L1; else goto _L4
_L4:
        damage(((BossRushEffect)gameobject2d).getDamage());
        hitEffecting(gameobject2d);
        return;
    }

    public void damage(int i)
    {
        if(isDead())
            return;
        int j = getHp() - i;
        i = j;
        if(j <= 0)
        {
            i = 0;
            setHp(0);
            dead();
            Effect effect = new Effect(1);
            effect.offsetTo(getCenterX() - effect.getCenterXdiff(), getCenterY() - effect.getCenterYdiff());
            ((Battle)getEngine().getGame()).getTopGom().add(effect);
            ((Battle)getEngine().getGame()).getTop2Gom().add(new EndProduction00());
        }
        setHitTime(2);
        if(getHitSeTime() == 0)
        {
            setHitSeTime(getHitSeInterval());
            SEHolder.play(getEngine().getContext(), 7);
        }
        ((Player)getManager().getObjectMap().get("player")).getComboCounter().determine();
        setHp(i);
    }

    public void draw(Canvas canvas)
    {
        if(getHitTime() <= 0) goto _L2; else goto _L1
_L1:
        Bitmap bitmap = null;
        getHitTime();
        JVM INSTR tableswitch 1 2: default 36
    //                   1 69
    //                   2 61;
           goto _L3 _L4 _L5
_L3:
        canvas.drawBitmap(bitmap, getX(), getY(), null);
        setHitTime(getHitTime() - 1);
        return;
_L5:
        bitmap = getHitBitmap2();
        continue; /* Loop/switch isn't completed */
_L4:
        bitmap = getHitBitmap1();
        if(true) goto _L3; else goto _L2
_L2:
        canvas.drawBitmap(getBitmap(), getX(), getY(), null);
        return;
    }

    public int getAttackDarkLevel()
    {
        return attackDarkLevel;
    }

    public int getAttackFlameLevel()
    {
        return attackFlameLevel;
    }

    public Vector getAttackPrasmaBitmaps()
    {
        return attackPrasmaBitmaps;
    }

    public int getAttackPrasmaLevel()
    {
        return attackPrasmaLevel;
    }

    public int getAttackType()
    {
        return attackType;
    }

    public Bitmap getHitBitmap1()
    {
        return hitBitmap1;
    }

    public Bitmap getHitBitmap2()
    {
        return hitBitmap2;
    }

    public int getHitSeInterval()
    {
        return hitSeInterval;
    }

    public int getHitSeTime()
    {
        return hitSeTime;
    }

    public int getHitTime()
    {
        return hitTime;
    }

    public int getHp()
    {
        return hp;
    }

    public InputCircle getInputCircle()
    {
        return inputCircle;
    }

    public int getMaxHp()
    {
        return maxHp;
    }

    public int[] getShotCount()
    {
        return shotCount;
    }

    public SlopeState getSlopeState()
    {
        return slopeState;
    }

    public float getTotalDistance()
    {
        return totalDistance;
    }

    public TouchState getTouchState()
    {
        return touchState;
    }

    public boolean hasAttackPrasmaBitmaps()
    {
        return getAttackPrasmaBitmaps() != null;
    }

    public void hitEffecting(GameObject2D gameobject2d)
    {
        Effect effect = new Effect(7);
        float f3 = gameobject2d.getCenterX();
        float f4 = getCenterX();
        float f1 = gameobject2d.getCenterY();
        float f2 = getCenterY();
        float f = getCenterX();
        f3 = (f3 - f4) / 2.0F;
        f4 = getCenterY();
        f1 = (f1 - f2) / 2.0F;
        effect.offsetTo((f + f3) - effect.getCenterXdiff(), (f4 + f1) - effect.getCenterYdiff());
        ((Battle)getEngine().getGame()).getTopGom().add(effect);
    }

    public void initialize()
    {
        setName("\u81EA\u6A5F");
        setCollisionRect(new HierarchicalRect(0, 2.0F, 2.0F, 26F, 35F));
        setCenter(getCollisionRect().getRect().left + getCollisionRect().getRect().width() / 2.0F, getCollisionRect().getRect().top + getCollisionRect().getRect().height() / 2.0F);
        setBitmap(BitmapHolder.get(15));
        setHitBitmap1(BitmapHolder.get(118));
        setHitBitmap2(BitmapHolder.get(119));
        offsetTo(200F, getEngine().getGame().getVirtualScreenHeight() / 2.0F - (float)(getBitmap().getHeight() / 2));
        setSlopeState(getEngine().getSlopeState());
        setTouchState(getEngine().getTouchState());
    }

    public boolean isHandling()
    {
        return handling;
    }

    public boolean isKilledBoss()
    {
        return killedBoss;
    }

    public boolean isMovable()
    {
        return movable;
    }

    public void setAttackDarkLevel(int i)
    {
        attackDarkLevel = i;
    }

    public void setAttackFlameLevel(int i)
    {
        attackFlameLevel = i;
    }

    public void setAttackPrasmaBitmaps(Vector vector)
    {
        attackPrasmaBitmaps = vector;
    }

    public void setAttackPrasmaLevel(int i)
    {
        attackPrasmaLevel = i;
    }

    public void setAttackType(int i)
    {
        attackType = i;
    }

    public void setHandling(boolean flag)
    {
        handling = flag;
    }

    public void setHitBitmap1(Bitmap bitmap)
    {
        hitBitmap1 = bitmap;
    }

    public void setHitBitmap2(Bitmap bitmap)
    {
        hitBitmap2 = bitmap;
    }

    public void setHitSeInterval(int i)
    {
        hitSeInterval = i;
    }

    public void setHitSeTime(int i)
    {
        hitSeTime = i;
    }

    public void setHitTime(int i)
    {
        hitTime = i;
    }

    public void setHp(int i)
    {
        hp = i;
    }

    public void setInputCircle(InputCircle inputcircle)
    {
        inputCircle = inputcircle;
    }

    public void setKilledBoss(boolean flag)
    {
        killedBoss = flag;
    }

    public void setMaxHp(int i)
    {
        maxHp = i;
    }

    public void setMovable(boolean flag)
    {
        movable = flag;
    }

    public void setShotCount(int ai[])
    {
        shotCount = ai;
    }

    public void setSlopeState(SlopeState slopestate)
    {
        slopeState = slopestate;
    }

    public void setTotalDistance(float f)
    {
        totalDistance = f;
    }

    public void setTouchState(TouchState touchstate)
    {
        touchState = touchstate;
    }

    public void shotCountUp(int i)
    {
        int ai[] = getShotCount();
        ai[i] = ai[i] + 1;
    }

    public boolean update()
    {
        if(isDead())
            return false;
        if(!isHandling()) goto _L2; else goto _L1
_L1:
        if(!isMovable()) goto _L4; else goto _L3
_L3:
        float f4;
        float f6;
        float f8;
        float f10;
        f10 = getX();
        f8 = getY();
        f4 = getEngine().getGame().getVirtualScreenWidth() - getCollisionRect().getRect().width();
        f6 = getEngine().getGame().getVirtualScreenHeight() - getCollisionRect().getRect().height();
        getOperationType();
        JVM INSTR tableswitch 0 1: default 104
    //                   0 379
    //                   1 492;
           goto _L5 _L6 _L7
_L5:
        float f;
        float f2;
        f = f8;
        f2 = f10;
_L15:
        int i;
        TouchPointer touchpointer1;
        float f12;
        float f13;
        float f14;
        boolean flag;
        TouchPointer touchpointer;
        if(f2 <= f4)
        {
            f4 = f2;
            if(f2 < 0.0F)
                f4 = 0.0F;
        }
        if(f > f6)
        {
            f2 = f6;
        } else
        {
            f2 = f;
            if(f < 0.0F)
                f2 = 0.0F;
        }
        addTotalDistance(Gen.getDistance(getX(), getY(), f4, f2) / 10F);
        offsetTo(f4, f2);
_L4:
        touchpointer = null;
        if(getTouchState() == null) goto _L2; else goto _L8
_L8:
        if(getTouchState().containsKey(Integer.valueOf(0)))
        {
            touchpointer = (TouchPointer)getTouchState().get(Integer.valueOf(0));
            if(touchpointer.isMarked())
                touchpointer = null;
        }
        flag = false;
        touchpointer1 = touchpointer;
        i = ((flag) ? 1 : 0);
        if(touchpointer == null)
        {
            touchpointer1 = touchpointer;
            i = ((flag) ? 1 : 0);
            if(getOperationType() == 1)
            {
                touchpointer1 = touchpointer;
                i = ((flag) ? 1 : 0);
                if(getTouchState().containsKey(Integer.valueOf(1)))
                {
                    touchpointer1 = (TouchPointer)getTouchState().get(Integer.valueOf(1));
                    if(touchpointer1.isMarked())
                    {
                        touchpointer1 = null;
                        i = ((flag) ? 1 : 0);
                    } else
                    {
                        i = 1;
                    }
                }
            }
        }
        if(touchpointer1 == null || touchpointer1.isMarked()) goto _L2; else goto _L9
_L9:
        if(touchpointer1.x <= 500F || touchpointer1.y <= 678F || touchpointer1.x >= 580F || touchpointer1.y >= 758F) goto _L11; else goto _L10
_L10:
        touchpointer1.mark(5);
        setAttackType(0);
_L2:
        if(getHitSeTime() > 0)
            setHitSeTime(getHitSeTime() - 1);
        return true;
_L6:
        f2 = getSlopeState().x;
        if(f2 > 90F)
        {
            f = 90F;
        } else
        {
            f = f2;
            if(f2 < -90F)
                f = -90F;
        }
        f2 = f10 + 100F * (float)Math.sin(Math.toRadians(f));
        f10 = getSlopeState().y;
        if(f10 > 90F)
        {
            f = 90F;
        } else
        {
            f = f10;
            if(f10 < -90F)
                f = -90F;
        }
        f = f8 + 100F * (float)Math.sin(Math.toRadians(f));
        continue; /* Loop/switch isn't completed */
_L7:
        if(getInputCircle() == null)
            setInputCircle(((Player)((Battle)getEngine().getGame()).getGom().getMappedObject("player")).getInputCircle());
        touchpointer = null;
        f2 = f10;
        f = f8;
        if(getTouchState() != null)
        {
            if(getTouchState().containsKey(Integer.valueOf(0)))
            {
                touchpointer1 = (TouchPointer)getTouchState().get(Integer.valueOf(0));
                touchpointer = touchpointer1;
                if(touchpointer1.isMarked())
                {
                    touchpointer = touchpointer1;
                    if(touchpointer1.getMarkId() != 1)
                        touchpointer = null;
                }
            }
            touchpointer1 = touchpointer;
            if(touchpointer == null)
            {
                touchpointer1 = touchpointer;
                if(getOperationType() == 1)
                {
                    touchpointer1 = touchpointer;
                    if(getTouchState().containsKey(Integer.valueOf(1)))
                    {
                        touchpointer = (TouchPointer)getTouchState().get(Integer.valueOf(1));
                        touchpointer1 = touchpointer;
                        if(touchpointer.isMarked())
                        {
                            touchpointer1 = touchpointer;
                            if(touchpointer.getMarkId() != 1)
                                touchpointer1 = null;
                        }
                    }
                }
            }
            f2 = f10;
            f = f8;
            if(touchpointer1 != null)
            {
                f12 = getInputCircle().getCenterX();
                f13 = getInputCircle().getCenterY();
                f14 = Gen.getDistance(f12, f13, touchpointer1.x, touchpointer1.y);
                f2 = f10;
                f = f8;
                if(f14 <= 100F)
                {
                    touchpointer1.mark(1);
                    f = f14 / 100F;
                    f12 = Gen.getRadian(f12, f13, touchpointer1.x, touchpointer1.y);
                    f2 = f10 + 60F * f * (float)Math.cos(f12);
                    f = f8 + 60F * f * (float)Math.sin(f12);
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L11:
        if(touchpointer1.x > 600F && touchpointer1.y > 678F && touchpointer1.x < 680F && touchpointer1.y < 758F)
        {
            touchpointer1.mark(5);
            setAttackType(1);
            continue; /* Loop/switch isn't completed */
        }
        if(touchpointer1.x <= 700F || touchpointer1.y <= 678F || touchpointer1.x >= 780F || touchpointer1.y >= 758F)
            break; /* Loop/switch isn't completed */
        touchpointer1.mark(5);
        setAttackType(2);
        if(true) goto _L2; else goto _L12
_L12:
        switch(getAttackType())
        {
        case 0: // '\0'
            touchpointer1.mark(2);
            Shot shot = new Shot(1);
            shot.setBitmap(BitmapHolder.get(74));
            shot.setCollisionRect(new HierarchicalRect(0, 12F, 12F, 45F, 45F));
            shot.setCenter(shot.getCollisionRect().getRect().left + shot.getCollisionRect().getRect().width() / 2.0F, shot.getCollisionRect().getRect().top + shot.getCollisionRect().getRect().height() / 2.0F);
            float f1 = getCenterX() - shot.getCenterXdiff();
            float f3 = getCenterY() - shot.getCenterYdiff();
            float f5 = touchpointer1.getX();
            float f7 = shot.getCenterXdiff();
            float f9 = touchpointer1.getY();
            float f11 = shot.getCenterYdiff();
            shot.offsetTo(f1, f3);
            shot.setSpeed(50F);
            shot.setAngle(Gen.getRadian(f1, f3, f5 - f7, f9 - f11));
            ((GameObjectManager2D)getManager()).add(shot);
            shotCountUp(0);
            SEHolder.play(getEngine().getContext(), 8);
            break;

        case 1: // '\001'
            touchpointer1.mark(3);
            AttackPrasma attackprasma;
            if(hasAttackPrasmaBitmaps())
                attackprasma = new AttackPrasma(this, getAttackPrasmaBitmaps());
            else
                attackprasma = new AttackPrasma(this);
            attackprasma.setPointerId(i);
            ((GameObjectManager2D)getManager()).add(attackprasma);
            if(!hasAttackPrasmaBitmaps())
                setAttackPrasmaBitmaps(attackprasma.getBitmaps());
            shotCountUp(1);
            break;

        case 2: // '\002'
            touchpointer1.mark(4);
            AttackFlame attackflame = new AttackFlame();
            attackflame.offsetTo(touchpointer1.x - attackflame.getCenterXdiff(), touchpointer1.y - attackflame.getCenterYdiff());
            ((Battle)getEngine().getGame()).getTopGom().add(attackflame);
            shotCountUp(2);
            break;
        }
        if(true) goto _L2; else goto _L13
_L13:
        if(true) goto _L15; else goto _L14
_L14:
    }

    public static final int ATTACK_TYPE_DARK = 0;
    public static final int ATTACK_TYPE_FLAME = 2;
    public static final int ATTACK_TYPE_PRASMA = 1;
    private static final float MOVE_SPEED = 100F;
    public static final int OPERATION_TYPE_SLOPE = 0;
    public static final int OPERATION_TYPE_TOUCH = 1;
    private static int operationType = 0;
    private int attackDarkLevel;
    private int attackFlameLevel;
    private Vector attackPrasmaBitmaps;
    private int attackPrasmaLevel;
    private int attackType;
    private boolean dead;
    private boolean handling;
    private Bitmap hitBitmap1;
    private Bitmap hitBitmap2;
    private int hitSeInterval;
    private int hitSeTime;
    private int hitTime;
    private int hp;
    private InputCircle inputCircle;
    private boolean killedBoss;
    private int maxHp;
    private boolean movable;
    private int shotCount[];
    private SlopeState slopeState;
    private float totalDistance;
    private TouchState touchState;

}
