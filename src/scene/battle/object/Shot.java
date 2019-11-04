// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object;

import academy.yamamoto.android.game.*;
import academy.yamamoto.android.general.HierarchicalRect;
import main.Effect;
import scene.battle.Battle;
import scene.battle.object.player.AttackPrasma;
import scene.battle.object.player.Fire;

// Referenced classes of package scene.battle.object:
//            Wall

public class Shot extends GameObject2D
{

    public Shot(int i)
    {
        speed = 100F;
        RatioX = 1.0F;
        RatioY = 0.0F;
        hitCount = 0;
        deleteCount = 3;
        damage = 5;
        setId(i);
        setName("\u5F3E");
        setCollisionRect(new HierarchicalRect(0, 0.0F, 0.0F, 30F, 30F));
    }

    private void setHitCount(int i)
    {
        hitCount = i;
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
        if(getId() != gameobject2d.getId())
        {
            hit();
            hitEffecting(gameobject2d);
            return;
        }
        if(true) goto _L4; else goto _L3
_L3:
        if(!(gameobject2d instanceof AttackPrasma))
            continue; /* Loop/switch isn't completed */
        if(getId() != 2) goto _L4; else goto _L5
_L5:
        hit();
        hitEffecting(gameobject2d);
        return;
        if(!(gameobject2d instanceof Fire) || getId() != 2) goto _L4; else goto _L6
_L6:
        hit();
        hitEffecting(gameobject2d);
        return;
    }

    public int getDamage()
    {
        return damage;
    }

    public int getDeleteCount()
    {
        return deleteCount;
    }

    public int getHitCount()
    {
        return hitCount;
    }

    public float getRatioX()
    {
        return RatioX;
    }

    public float getRatioY()
    {
        return RatioY;
    }

    public float getSpeed()
    {
        return speed;
    }

    public int hit()
    {
        setHitCount(getHitCount() + 1);
        return getDamage();
    }

    public void hitEffecting(GameObject2D gameobject2d)
    {
        Effect effect = new Effect(6);
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

    public void setAngle(float f)
    {
        RatioX = (float)Math.cos(f);
        RatioY = (float)Math.sin(f);
    }

    public void setDamage(int i)
    {
        damage = i;
    }

    public void setDeleteCount(int i)
    {
        deleteCount = i;
    }

    public void setRatioX(float f)
    {
        RatioX = f;
    }

    public void setRatioY(float f)
    {
        RatioY = f;
    }

    public void setSpeed(float f)
    {
        speed = f;
    }

    public boolean update()
    {
        while(isDeleted() || getHitCount() >= getDeleteCount()) 
            return false;
        float f = getX();
        float f1 = getY();
        offsetTo(f + speed * RatioX, f1 + speed * RatioY);
        return true;
    }

    public static final int FROM_ENEMY = 2;
    public static final int FROM_PLAYER = 1;
    private float RatioX;
    private float RatioY;
    private int damage;
    private int deleteCount;
    private int hitCount;
    private float speed;
}
