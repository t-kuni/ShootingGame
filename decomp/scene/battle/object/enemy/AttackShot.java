// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.enemy;

import academy.yamamoto.android.game.*;
import academy.yamamoto.android.general.Gen;
import academy.yamamoto.android.general.HierarchicalRect;
import android.content.Context;
import android.graphics.RectF;
import main.BitmapHolder;
import scene.battle.object.Shot;
import scene.battle.object.TrackingShot;

// Referenced classes of package scene.battle.object.enemy:
//            Attackable, Enemy

public class AttackShot extends Attackable
{

    public AttackShot(Context context1)
    {
        type = 0;
        target = null;
        maxSwing = 15;
        radian = 0.0F;
        damage = 50;
        deleteCount = 3;
        speed = 30F;
        bulletType = 0;
        context = null;
        setContext(context1);
    }

    public AttackShot(Context context1, int i, GameObject2D gameobject2d)
    {
        super(i);
        type = 0;
        target = null;
        maxSwing = 15;
        radian = 0.0F;
        damage = 50;
        deleteCount = 3;
        speed = 30F;
        bulletType = 0;
        context = null;
        setTarget(gameobject2d);
        setContext(context1);
    }

    public AttackShot(Context context1, GameObject2D gameobject2d)
    {
        this(context1);
        setTarget(gameobject2d);
    }

    private Shot makeShot(Context context1)
    {
        Shot shot = new Shot(2);
        settingBullet(context1, shot);
        return shot;
    }

    private void settingBullet(Context context1, Shot shot)
    {
        switch(getBulletType())
        {
        default:
            return;

        case 0: // '\0'
            shot.setBitmap(BitmapHolder.get(103));
            shot.setCollisionRect(new HierarchicalRect(0, 3F, 3F, 15F, 15F));
            shot.setCenter(shot.getCollisionRect().getRect().left + shot.getCollisionRect().getRect().width() / 2.0F, shot.getCollisionRect().getRect().top + shot.getCollisionRect().getRect().height() / 2.0F);
            return;

        case 1: // '\001'
            shot.setBitmap(BitmapHolder.get(102));
            shot.setCollisionRect(new HierarchicalRect(0, 3F, 3F, 19F, 19F));
            shot.setCenter(shot.getCollisionRect().getRect().left + shot.getCollisionRect().getRect().width() / 2.0F, shot.getCollisionRect().getRect().top + shot.getCollisionRect().getRect().height() / 2.0F);
            return;

        case 2: // '\002'
            shot.setBitmap(BitmapHolder.get(101));
            shot.setCollisionRect(new HierarchicalRect(0, 7F, 9F, 32F, 37F));
            shot.setCenter(shot.getCollisionRect().getRect().left + shot.getCollisionRect().getRect().width() / 2.0F, shot.getCollisionRect().getRect().top + shot.getCollisionRect().getRect().height() / 2.0F);
            return;

        case 3: // '\003'
            shot.setBitmap(BitmapHolder.get(71));
            shot.setCollisionRect(new HierarchicalRect(0, 10F, 17F, 27F, 42F));
            shot.setCenter(shot.getCollisionRect().getRect().left + shot.getCollisionRect().getRect().width() / 2.0F, shot.getCollisionRect().getRect().top + shot.getCollisionRect().getRect().height() / 2.0F);
            return;

        case 4: // '\004'
            shot.setBitmap(BitmapHolder.get(72));
            shot.setCollisionRect(new HierarchicalRect(0, 13F, 40F, 40F, 64F));
            shot.setCenter(shot.getCollisionRect().getRect().left + shot.getCollisionRect().getRect().width() / 2.0F, shot.getCollisionRect().getRect().top + shot.getCollisionRect().getRect().height() / 2.0F);
            return;

        case 5: // '\005'
            shot.setBitmap(BitmapHolder.get(70));
            break;
        }
        shot.setCollisionRect(new HierarchicalRect(0, 20F, 50F, 60F, 93F));
        shot.setCenter(shot.getCollisionRect().getRect().left + shot.getCollisionRect().getRect().width() / 2.0F, shot.getCollisionRect().getRect().top + shot.getCollisionRect().getRect().height() / 2.0F);
    }

    public boolean attack(Enemy enemy, float f, float f1)
    {
        float f2;
        float f3;
        float f5;
        Object obj;
        obj = enemy.getManager().getEngine().getContext();
        f5 = (float)Math.toRadians(Math.random() * (double)maxSwing);
        f3 = getRadian();
        if(hasTarget())
            f3 = Gen.getRadian(f, f1, getTarget().getCenterX(), getTarget().getCenterY());
        f2 = f3;
        (int)(Math.random() * 3D);
        JVM INSTR tableswitch 0 2: default 100
    //                   0 104
    //                   1 144
    //                   2 154;
           goto _L1 _L2 _L3 _L4
_L2:
        break MISSING_BLOCK_LABEL_104;
_L1:
        f2 = f3;
_L9:
        getType();
        JVM INSTR tableswitch 0 2: default 136
    //                   0 164
    //                   1 240
    //                   2 483;
           goto _L5 _L6 _L7 _L8
_L5:
        return super.attack(enemy, f, f1);
_L3:
        f2 = f3 + f5;
          goto _L9
_L4:
        f2 = f3 - f5;
          goto _L9
_L6:
        obj = makeShot(((Context) (obj)));
        ((Shot) (obj)).offsetTo(f - ((Shot) (obj)).getCenterX(), f1 - ((Shot) (obj)).getCenterY());
        ((Shot) (obj)).setSpeed(getSpeed());
        ((Shot) (obj)).setDamage(getDamage());
        ((Shot) (obj)).setDeleteCount(getDeleteCount());
        ((Shot) (obj)).setAngle(f2);
        ((GameObjectManager2D)enemy.getManager()).add(((academy.yamamoto.android.game.GameObject) (obj)));
          goto _L5
_L7:
        Shot shot = makeShot(((Context) (obj)));
        shot.offsetTo(f - shot.getCenterX(), f1 - shot.getCenterY());
        shot.setSpeed(getSpeed());
        shot.setDamage(getDamage());
        shot.setDeleteCount(getDeleteCount());
        shot.setAngle(f2);
        ((GameObjectManager2D)enemy.getManager()).add(shot);
        float f4 = (float)Math.toRadians(Math.random() * (double)maxSwing);
        shot = makeShot(((Context) (obj)));
        shot.offsetTo(f - shot.getCenterX(), f1 - shot.getCenterY());
        shot.setSpeed(getSpeed());
        shot.setDamage(getDamage());
        shot.setDeleteCount(getDeleteCount());
        shot.setAngle(f2 - f4);
        ((GameObjectManager2D)enemy.getManager()).add(shot);
        obj = makeShot(((Context) (obj)));
        ((Shot) (obj)).offsetTo(f - ((Shot) (obj)).getCenterX(), f1 - ((Shot) (obj)).getCenterY());
        ((Shot) (obj)).setSpeed(getSpeed());
        ((Shot) (obj)).setDamage(getDamage());
        ((Shot) (obj)).setDeleteCount(getDeleteCount());
        ((Shot) (obj)).setAngle(f2 + f4);
        ((GameObjectManager2D)enemy.getManager()).add(((academy.yamamoto.android.game.GameObject) (obj)));
          goto _L5
_L8:
        if(hasTarget())
        {
            TrackingShot trackingshot = new TrackingShot(2, getTarget());
            settingBullet(((Context) (obj)), trackingshot);
            trackingshot.offsetTo(f - trackingshot.getCenterX(), f1 - trackingshot.getCenterY());
            trackingshot.setSpeed(getSpeed());
            trackingshot.setDamage(getDamage());
            trackingshot.setDeleteCount(getDeleteCount());
            trackingshot.setAngle(f2);
            ((GameObjectManager2D)enemy.getManager()).add(trackingshot);
        }
          goto _L5
    }

    public int getBulletType()
    {
        return bulletType;
    }

    public Context getContext()
    {
        return context;
    }

    public int getDamage()
    {
        return damage;
    }

    public int getDeleteCount()
    {
        return deleteCount;
    }

    public int getMaxSwing()
    {
        return maxSwing;
    }

    public float getRadian()
    {
        return radian;
    }

    public float getSpeed()
    {
        return speed;
    }

    public GameObject2D getTarget()
    {
        return target;
    }

    public int getType()
    {
        return type;
    }

    public boolean hasTarget()
    {
        return getTarget() != null;
    }

    public void setBulletType(int i)
    {
        bulletType = i;
    }

    public void setContext(Context context1)
    {
        context = context1;
    }

    public void setDamage(int i)
    {
        damage = i;
    }

    public void setDeleteCount(int i)
    {
        deleteCount = i;
    }

    public void setMaxSwing(int i)
    {
        maxSwing = i;
    }

    public void setRadian(float f)
    {
        radian = f;
    }

    public void setSpeed(float f)
    {
        speed = f;
    }

    public void setTarget(GameObject2D gameobject2d)
    {
        target = gameobject2d;
    }

    public void setType(int i)
    {
        type = i;
    }

    public static final int BULLET_TYPE_FIRE_BIG = 5;
    public static final int BULLET_TYPE_FIRE_MINI = 3;
    public static final int BULLET_TYPE_FIRE_NORMAL = 4;
    public static final int BULLET_TYPE_WISP_BIG = 2;
    public static final int BULLET_TYPE_WISP_MINI = 0;
    public static final int BULLET_TYPE_WISP_NORMAL = 1;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_THREE_WAY = 1;
    public static final int TYPE_TRACKING = 2;
    private int bulletType;
    private Context context;
    private int damage;
    private int deleteCount;
    private int maxSwing;
    private float radian;
    private float speed;
    private GameObject2D target;
    private int type;
}
