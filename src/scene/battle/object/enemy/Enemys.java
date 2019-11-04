// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.enemy;

import academy.yamamoto.android.game.*;
import academy.yamamoto.android.general.HierarchicalRect;
import android.graphics.RectF;
import java.util.*;
import main.BitmapHolder;
import scene.battle.Battle;
import scene.battle.object.player.Player;

// Referenced classes of package scene.battle.object.enemy:
//            MoveLine, AttackShot, Enemy, Movable, 
//            MoveCircle

public class Enemys extends GameObject2D
{

    public Enemys()
    {
        enemysMap = null;
        setEnemysMap(new HashMap(4));
    }

    public Enemys(int i)
    {
        this();
        setId(i);
    }

    private void initializeCase0()
    {
        Object obj1 = new MoveLine();
        ((MoveLine) (obj1)).setMax(20);
        ((MoveLine) (obj1)).setAngle(180);
        ((MoveLine) (obj1)).setSpeed(15F);
        Object obj = new MoveLine();
        ((MoveLine) (obj)).setMax(20);
        ((MoveLine) (obj)).setAngle(180);
        ((MoveLine) (obj)).setSpeed(15F);
        MoveLine moveline = new MoveLine();
        moveline.setMax(20);
        moveline.setAngle(180);
        moveline.setSpeed(15F);
        AttackShot attackshot = new AttackShot(getEngine().getContext());
        attackshot.setType(0);
        attackshot.setBulletType(1);
        attackshot.setTarget(((Player)getManager().getObjectMap().get("player")).getPlayerIcon());
        Enemy enemy = new Enemy();
        enemy.setHp(50);
        enemy.setMaxHp(50);
        enemy.setScore(250F);
        enemy.setTimeBorder(300F);
        enemy.setName("0-0");
        enemy.setBitmap(BitmapHolder.get(0));
        enemy.setHitBitmap1(BitmapHolder.get(116));
        enemy.setHitBitmap2(BitmapHolder.get(117));
        enemy.setCollisionRect(new HierarchicalRect(0, 6F, 3F, 30F, 42F));
        enemy.setCenter(enemy.getCollisionRect().getRect().left + enemy.getCollisionRect().getRect().width() / 2.0F, enemy.getCollisionRect().getRect().top + enemy.getCollisionRect().getRect().height() / 2.0F);
        enemy.offsetTo(1380F, 100F);
        enemy.setAttackCycle(25);
        enemy.addMovable(((Movable) (obj1)));
        enemy.addAttackable(attackshot);
        mapping(enemy.getName(), enemy);
        pop(enemy.getName());
        obj1 = new Enemy();
        ((Enemy) (obj1)).setHp(50);
        ((Enemy) (obj1)).setMaxHp(50);
        ((Enemy) (obj1)).setScore(250F);
        ((Enemy) (obj1)).setTimeBorder(300F);
        ((Enemy) (obj1)).setName("0-1");
        ((Enemy) (obj1)).setBitmap(BitmapHolder.get(0));
        ((Enemy) (obj1)).setHitBitmap1(BitmapHolder.get(116));
        ((Enemy) (obj1)).setHitBitmap2(BitmapHolder.get(117));
        ((Enemy) (obj1)).setCollisionRect(new HierarchicalRect(0, 6F, 3F, 30F, 42F));
        ((Enemy) (obj1)).setCenter(((Enemy) (obj1)).getCollisionRect().getRect().left + ((Enemy) (obj1)).getCollisionRect().getRect().width() / 2.0F, ((Enemy) (obj1)).getCollisionRect().getRect().top + ((Enemy) (obj1)).getCollisionRect().getRect().height() / 2.0F);
        ((Enemy) (obj1)).offsetTo(1380F, 300F);
        ((Enemy) (obj1)).setAttackCycle(25);
        ((Enemy) (obj1)).addMovable(((Movable) (obj)));
        ((Enemy) (obj1)).addAttackable(attackshot);
        mapping(((Enemy) (obj1)).getName(), ((Enemy) (obj1)));
        pop(((Enemy) (obj1)).getName());
        obj = new Enemy();
        ((Enemy) (obj)).setHp(50);
        ((Enemy) (obj)).setMaxHp(50);
        ((Enemy) (obj)).setScore(250F);
        ((Enemy) (obj)).setTimeBorder(300F);
        ((Enemy) (obj)).setName("0-2");
        ((Enemy) (obj)).setBitmap(BitmapHolder.get(0));
        ((Enemy) (obj)).setHitBitmap1(BitmapHolder.get(116));
        ((Enemy) (obj)).setHitBitmap2(BitmapHolder.get(117));
        ((Enemy) (obj)).setCollisionRect(new HierarchicalRect(0, 6F, 3F, 30F, 42F));
        ((Enemy) (obj)).setCenter(((Enemy) (obj)).getCollisionRect().getRect().left + ((Enemy) (obj)).getCollisionRect().getRect().width() / 2.0F, ((Enemy) (obj)).getCollisionRect().getRect().top + ((Enemy) (obj)).getCollisionRect().getRect().height() / 2.0F);
        ((Enemy) (obj)).offsetTo(1380F, 500F);
        ((Enemy) (obj)).setAttackCycle(25);
        ((Enemy) (obj)).addMovable(moveline);
        ((Enemy) (obj)).addAttackable(attackshot);
        mapping(((Enemy) (obj)).getName(), ((Enemy) (obj)));
        pop(((Enemy) (obj)).getName());
    }

    private void initializeCase1()
    {
        MoveLine moveline = new MoveLine();
        moveline.setAngle(180);
        moveline.setSpeed(20F);
        AttackShot attackshot = new AttackShot(getEngine().getContext());
        attackshot.setType(0);
        attackshot.setBulletType(1);
        attackshot.setTarget(((Player)getManager().getObjectMap().get("player")).getPlayerIcon());
        Enemy enemy = new Enemy();
        enemy.setHp(30);
        enemy.setMaxHp(30);
        enemy.setScore(200F);
        enemy.setTimeBorder(300F);
        enemy.setName("1-0");
        enemy.setBitmap(BitmapHolder.get(96));
        enemy.setHitBitmap1(BitmapHolder.get(114));
        enemy.setHitBitmap2(BitmapHolder.get(115));
        enemy.setCollisionRect(new HierarchicalRect(0, 15F, 20F, 70F, 75F));
        enemy.setCenter(enemy.getCollisionRect().getRect().left + enemy.getCollisionRect().getRect().width() / 2.0F, enemy.getCollisionRect().getRect().top + enemy.getCollisionRect().getRect().height() / 2.0F);
        enemy.offsetTo(1380F, 600F);
        enemy.setAttackCycle(25);
        enemy.addMovable(moveline);
        enemy.addAttackable(attackshot);
        mapping(enemy.getName(), enemy);
        pop(enemy.getName());
        enemy = new Enemy();
        enemy.setHp(30);
        enemy.setMaxHp(30);
        enemy.setScore(200F);
        enemy.setTimeBorder(300F);
        enemy.setName("1-1");
        enemy.setBitmap(BitmapHolder.get(96));
        enemy.setHitBitmap1(BitmapHolder.get(114));
        enemy.setHitBitmap2(BitmapHolder.get(115));
        enemy.setCollisionRect(new HierarchicalRect(0, 15F, 20F, 70F, 75F));
        enemy.setCenter(enemy.getCollisionRect().getRect().left + enemy.getCollisionRect().getRect().width() / 2.0F, enemy.getCollisionRect().getRect().top + enemy.getCollisionRect().getRect().height() / 2.0F);
        enemy.offsetTo(1380F, 600F);
        enemy.setAttackCycle(25);
        enemy.addMovable(moveline);
        enemy.addAttackable(attackshot);
        mapping(enemy.getName(), enemy);
        enemy = new Enemy();
        enemy.setHp(30);
        enemy.setMaxHp(30);
        enemy.setScore(200F);
        enemy.setTimeBorder(300F);
        enemy.setName("1-2");
        enemy.setBitmap(BitmapHolder.get(96));
        enemy.setHitBitmap1(BitmapHolder.get(114));
        enemy.setHitBitmap2(BitmapHolder.get(115));
        enemy.setCollisionRect(new HierarchicalRect(0, 15F, 20F, 70F, 75F));
        enemy.setCenter(enemy.getCollisionRect().getRect().left + enemy.getCollisionRect().getRect().width() / 2.0F, enemy.getCollisionRect().getRect().top + enemy.getCollisionRect().getRect().height() / 2.0F);
        enemy.offsetTo(1380F, 600F);
        enemy.setAttackCycle(25);
        enemy.addMovable(moveline);
        enemy.addAttackable(attackshot);
        mapping(enemy.getName(), enemy);
        enemy = new Enemy();
        enemy.setHp(30);
        enemy.setMaxHp(30);
        enemy.setScore(200F);
        enemy.setTimeBorder(300F);
        enemy.setName("1-3");
        enemy.setBitmap(BitmapHolder.get(96));
        enemy.setHitBitmap1(BitmapHolder.get(114));
        enemy.setHitBitmap2(BitmapHolder.get(115));
        enemy.setCollisionRect(new HierarchicalRect(0, 15F, 20F, 70F, 75F));
        enemy.setCenter(enemy.getCollisionRect().getRect().left + enemy.getCollisionRect().getRect().width() / 2.0F, enemy.getCollisionRect().getRect().top + enemy.getCollisionRect().getRect().height() / 2.0F);
        enemy.offsetTo(1380F, 600F);
        enemy.setAttackCycle(25);
        enemy.addMovable(moveline);
        enemy.addAttackable(attackshot);
        mapping(enemy.getName(), enemy);
    }

    private void initializeCase2()
    {
        MoveLine moveline = new MoveLine();
        moveline.setAngle(0);
        moveline.setSpeed(20F);
        AttackShot attackshot = new AttackShot(getEngine().getContext());
        attackshot.setType(0);
        attackshot.setBulletType(1);
        attackshot.setTarget(((Player)getManager().getObjectMap().get("player")).getPlayerIcon());
        Enemy enemy = new Enemy();
        enemy.setHp(30);
        enemy.setMaxHp(30);
        enemy.setScore(200F);
        enemy.setTimeBorder(300F);
        enemy.setName("2-0");
        enemy.setBitmap(BitmapHolder.get(96));
        enemy.setHitBitmap1(BitmapHolder.get(114));
        enemy.setHitBitmap2(BitmapHolder.get(115));
        enemy.setCollisionRect(new HierarchicalRect(0, 15F, 20F, 70F, 75F));
        enemy.setCenter(enemy.getCollisionRect().getRect().left + enemy.getCollisionRect().getRect().width() / 2.0F, enemy.getCollisionRect().getRect().top + enemy.getCollisionRect().getRect().height() / 2.0F);
        enemy.offsetTo(-100F, 100F);
        enemy.setAttackCycle(25);
        enemy.addMovable(moveline);
        enemy.addAttackable(attackshot);
        mapping(enemy.getName(), enemy);
        pop(enemy.getName());
        enemy = new Enemy();
        enemy.setHp(30);
        enemy.setMaxHp(30);
        enemy.setScore(200F);
        enemy.setTimeBorder(300F);
        enemy.setName("2-1");
        enemy.setBitmap(BitmapHolder.get(96));
        enemy.setHitBitmap1(BitmapHolder.get(114));
        enemy.setHitBitmap2(BitmapHolder.get(115));
        enemy.setCollisionRect(new HierarchicalRect(0, 15F, 20F, 70F, 75F));
        enemy.setCenter(enemy.getCollisionRect().getRect().left + enemy.getCollisionRect().getRect().width() / 2.0F, enemy.getCollisionRect().getRect().top + enemy.getCollisionRect().getRect().height() / 2.0F);
        enemy.offsetTo(-100F, 100F);
        enemy.setAttackCycle(25);
        enemy.addMovable(moveline);
        enemy.addAttackable(attackshot);
        mapping(enemy.getName(), enemy);
        enemy = new Enemy();
        enemy.setHp(30);
        enemy.setMaxHp(30);
        enemy.setScore(200F);
        enemy.setTimeBorder(300F);
        enemy.setName("2-2");
        enemy.setBitmap(BitmapHolder.get(96));
        enemy.setHitBitmap1(BitmapHolder.get(114));
        enemy.setHitBitmap2(BitmapHolder.get(115));
        enemy.setCollisionRect(new HierarchicalRect(0, 15F, 20F, 70F, 75F));
        enemy.setCenter(enemy.getCollisionRect().getRect().left + enemy.getCollisionRect().getRect().width() / 2.0F, enemy.getCollisionRect().getRect().top + enemy.getCollisionRect().getRect().height() / 2.0F);
        enemy.offsetTo(-100F, 100F);
        enemy.setAttackCycle(25);
        enemy.addMovable(moveline);
        enemy.addAttackable(attackshot);
        mapping(enemy.getName(), enemy);
        enemy = new Enemy();
        enemy.setHp(30);
        enemy.setMaxHp(30);
        enemy.setScore(200F);
        enemy.setTimeBorder(300F);
        enemy.setName("2-3");
        enemy.setBitmap(BitmapHolder.get(96));
        enemy.setHitBitmap1(BitmapHolder.get(114));
        enemy.setHitBitmap2(BitmapHolder.get(115));
        enemy.setCollisionRect(new HierarchicalRect(0, 15F, 20F, 70F, 75F));
        enemy.setCenter(enemy.getCollisionRect().getRect().left + enemy.getCollisionRect().getRect().width() / 2.0F, enemy.getCollisionRect().getRect().top + enemy.getCollisionRect().getRect().height() / 2.0F);
        enemy.offsetTo(-100F, 100F);
        enemy.setAttackCycle(25);
        enemy.addMovable(moveline);
        enemy.addAttackable(attackshot);
        mapping(enemy.getName(), enemy);
    }

    private void initializeCase3()
    {
        MoveLine moveline = new MoveLine();
        moveline.setAngle(0);
        moveline.setSpeed(5F);
        AttackShot attackshot = new AttackShot(getEngine().getContext());
        attackshot.setType(1);
        attackshot.setBulletType(2);
        attackshot.setTarget(((Player)getManager().getObjectMap().get("player")).getPlayerIcon());
        attackshot.setDamage(50);
        attackshot.setDeleteCount(2);
        attackshot.setSpeed(30F);
        attackshot.setMaxSwing(30);
        Enemy enemy = new Enemy();
        enemy.setHp(200);
        enemy.setMaxHp(200);
        enemy.setScore(800F);
        enemy.setTimeBorder(600F);
        enemy.setName("3-0");
        enemy.setBitmap(BitmapHolder.get(55));
        enemy.setHitBitmap1(BitmapHolder.get(112));
        enemy.setHitBitmap2(BitmapHolder.get(113));
        enemy.setCollisionRect(new HierarchicalRect(0, 5F, 15F, 80F, 80F));
        enemy.setCenter(enemy.getCollisionRect().getRect().left + enemy.getCollisionRect().getRect().width() / 2.0F, enemy.getCollisionRect().getRect().top + enemy.getCollisionRect().getRect().height() / 2.0F);
        enemy.offsetTo(-100F, 300F);
        enemy.setAttackCycle(10);
        enemy.addMovable(moveline);
        enemy.addAttackable(attackshot);
        mapping(enemy.getName(), enemy);
        pop(enemy.getName());
    }

    private void initializeCase4()
    {
        AttackShot attackshot = new AttackShot(getEngine().getContext());
        attackshot.setType(2);
        attackshot.setBulletType(3);
        attackshot.setTarget(((Player)getManager().getObjectMap().get("player")).getPlayerIcon());
        attackshot.setDamage(50);
        attackshot.setDeleteCount(1);
        attackshot.setSpeed(15F);
        MoveLine moveline = new MoveLine();
        moveline.setMax(10);
        moveline.setAngle(45);
        moveline.setSpeed(20F);
        Enemy enemy = new Enemy();
        enemy.setHp(75);
        enemy.setMaxHp(75);
        enemy.setScore(400F);
        enemy.setTimeBorder(800F);
        enemy.setName("4-0");
        enemy.setBitmap(BitmapHolder.get(12));
        enemy.setHitBitmap1(BitmapHolder.get(110));
        enemy.setHitBitmap2(BitmapHolder.get(111));
        enemy.setCollisionRect(new HierarchicalRect(0, 9F, 19F, 46F, 55F));
        enemy.setCenter(enemy.getCollisionRect().getRect().left + enemy.getCollisionRect().getRect().width() / 2.0F, enemy.getCollisionRect().getRect().top + enemy.getCollisionRect().getRect().height() / 2.0F);
        enemy.offsetTo(-100F, -100F);
        enemy.setAttackCycle(25);
        enemy.addMovable(moveline);
        enemy.addAttackable(attackshot);
        mapping(enemy.getName(), enemy);
        pop(enemy.getName());
        moveline = new MoveLine();
        moveline.setMax(10);
        moveline.setAngle(135);
        moveline.setSpeed(20F);
        enemy = new Enemy();
        enemy.setHp(75);
        enemy.setMaxHp(75);
        enemy.setScore(400F);
        enemy.setTimeBorder(800F);
        enemy.setName("4-1");
        enemy.setBitmap(BitmapHolder.get(12));
        enemy.setHitBitmap1(BitmapHolder.get(110));
        enemy.setHitBitmap2(BitmapHolder.get(111));
        enemy.setCollisionRect(new HierarchicalRect(0, 9F, 19F, 46F, 55F));
        enemy.setCenter(enemy.getCollisionRect().getRect().left + enemy.getCollisionRect().getRect().width() / 2.0F, enemy.getCollisionRect().getRect().top + enemy.getCollisionRect().getRect().height() / 2.0F);
        enemy.offsetTo(1280F, -100F);
        enemy.setAttackCycle(25);
        enemy.addMovable(moveline);
        enemy.addAttackable(attackshot);
        mapping(enemy.getName(), enemy);
        pop(enemy.getName());
        moveline = new MoveLine();
        moveline.setMax(10);
        moveline.setAngle(-135);
        moveline.setSpeed(20F);
        enemy = new Enemy();
        enemy.setHp(75);
        enemy.setMaxHp(75);
        enemy.setScore(400F);
        enemy.setTimeBorder(800F);
        enemy.setName("4-2");
        enemy.setBitmap(BitmapHolder.get(12));
        enemy.setHitBitmap1(BitmapHolder.get(110));
        enemy.setHitBitmap2(BitmapHolder.get(111));
        enemy.setCollisionRect(new HierarchicalRect(0, 9F, 19F, 46F, 55F));
        enemy.setCenter(enemy.getCollisionRect().getRect().left + enemy.getCollisionRect().getRect().width() / 2.0F, enemy.getCollisionRect().getRect().top + enemy.getCollisionRect().getRect().height() / 2.0F);
        enemy.offsetTo(1280F, 768F);
        enemy.setAttackCycle(25);
        enemy.addMovable(moveline);
        enemy.addAttackable(attackshot);
        mapping(enemy.getName(), enemy);
        pop(enemy.getName());
        moveline = new MoveLine();
        moveline.setMax(10);
        moveline.setAngle(-45);
        moveline.setSpeed(20F);
        enemy = new Enemy();
        enemy.setHp(75);
        enemy.setMaxHp(75);
        enemy.setScore(400F);
        enemy.setTimeBorder(800F);
        enemy.setName("4-3");
        enemy.setBitmap(BitmapHolder.get(12));
        enemy.setHitBitmap1(BitmapHolder.get(110));
        enemy.setHitBitmap2(BitmapHolder.get(111));
        enemy.setCollisionRect(new HierarchicalRect(0, 9F, 19F, 46F, 55F));
        enemy.setCenter(enemy.getCollisionRect().getRect().left + enemy.getCollisionRect().getRect().width() / 2.0F, enemy.getCollisionRect().getRect().top + enemy.getCollisionRect().getRect().height() / 2.0F);
        enemy.offsetTo(-100F, 768F);
        enemy.setAttackCycle(25);
        enemy.addMovable(moveline);
        enemy.addAttackable(attackshot);
        mapping(enemy.getName(), enemy);
        pop(enemy.getName());
    }

    private void initializeCase5()
    {
        Object obj1 = new MoveLine();
        ((MoveLine) (obj1)).setMax(8);
        ((MoveLine) (obj1)).setAngle(150);
        ((MoveLine) (obj1)).setSpeed(50F);
        Object obj2 = new Movable();
        ((Movable) (obj2)).setMax(15);
        Object obj = new Enemy();
        ((Enemy) (obj)).setHp(75);
        ((Enemy) (obj)).setMaxHp(75);
        ((Enemy) (obj)).setScore(500F);
        ((Enemy) (obj)).setTimeBorder(600F);
        ((Enemy) (obj)).setName("5-0");
        ((Enemy) (obj)).setBitmap(BitmapHolder.get(84));
        ((Enemy) (obj)).setHitBitmap1(BitmapHolder.get(104));
        ((Enemy) (obj)).setHitBitmap2(BitmapHolder.get(105));
        ((Enemy) (obj)).setCollisionRect(new HierarchicalRect(0, 9F, 10F, 57F, 61F));
        ((Enemy) (obj)).setCenter(((Enemy) (obj)).getCollisionRect().getRect().left + ((Enemy) (obj)).getCollisionRect().getRect().width() / 2.0F, ((Enemy) (obj)).getCollisionRect().getRect().top + ((Enemy) (obj)).getCollisionRect().getRect().height() / 2.0F);
        ((Enemy) (obj)).offsetTo(1280F, -100F);
        ((Enemy) (obj)).setAttackCycle(25);
        ((Enemy) (obj)).addMovable(((Movable) (obj1)));
        ((Enemy) (obj)).addMovable(((Movable) (obj2)));
        ((Enemy) (obj)).setMoveRepeatable(true);
        mapping(((Enemy) (obj)).getName(), ((Enemy) (obj)));
        pop(((Enemy) (obj)).getName());
        obj1 = new MoveCircle();
        ((MoveCircle) (obj1)).setTarget(((GameObject2D) (obj)));
        ((MoveCircle) (obj1)).setDirection(1);
        ((MoveCircle) (obj1)).setDistance(100F);
        ((MoveCircle) (obj1)).setSpeed(0.1963495F);
        obj = new AttackShot(getEngine().getContext());
        ((AttackShot) (obj)).setType(0);
        ((AttackShot) (obj)).setBulletType(0);
        ((AttackShot) (obj)).setTarget(((Player)getManager().getObjectMap().get("player")).getPlayerIcon());
        ((AttackShot) (obj)).setDamage(25);
        ((AttackShot) (obj)).setDeleteCount(1);
        ((AttackShot) (obj)).setSpeed(50F);
        ((AttackShot) (obj)).setMaxSwing(60);
        obj2 = new Enemy();
        ((Enemy) (obj2)).setHp(50);
        ((Enemy) (obj2)).setMaxHp(50);
        ((Enemy) (obj2)).setScore(800F);
        ((Enemy) (obj2)).setTimeBorder(500F);
        ((Enemy) (obj2)).setName("5-1");
        ((Enemy) (obj2)).setBitmap(BitmapHolder.get(54));
        ((Enemy) (obj2)).setHitBitmap1(BitmapHolder.get(108));
        ((Enemy) (obj2)).setHitBitmap2(BitmapHolder.get(109));
        ((Enemy) (obj2)).setCollisionRect(new HierarchicalRect(0, 10F, 7F, 33F, 50F));
        ((Enemy) (obj2)).setCenter(((Enemy) (obj2)).getCollisionRect().getRect().left + ((Enemy) (obj2)).getCollisionRect().getRect().width() / 2.0F, ((Enemy) (obj2)).getCollisionRect().getRect().top + ((Enemy) (obj2)).getCollisionRect().getRect().height() / 2.0F);
        ((Enemy) (obj2)).setAttackCycle(3);
        ((Enemy) (obj2)).addMovable(((Movable) (obj1)));
        ((Enemy) (obj2)).addAttackable(((Attackable) (obj)));
        mapping(((Enemy) (obj2)).getName(), ((Enemy) (obj2)));
        pop(((Enemy) (obj2)).getName());
    }

    private void initializeCase6()
    {
        Object obj = new MoveLine();
        ((MoveLine) (obj)).setMax(2);
        ((MoveLine) (obj)).setAngle(0);
        ((MoveLine) (obj)).setSpeed(60F);
        Object obj2 = new Movable();
        ((Movable) (obj2)).setMax(8);
        Object obj1 = new Enemy();
        ((Enemy) (obj1)).setHp(75);
        ((Enemy) (obj1)).setMaxHp(75);
        ((Enemy) (obj1)).setScore(400F);
        ((Enemy) (obj1)).setTimeBorder(600F);
        ((Enemy) (obj1)).setName("6-0");
        ((Enemy) (obj1)).setBitmap(BitmapHolder.get(84));
        ((Enemy) (obj1)).setHitBitmap1(BitmapHolder.get(104));
        ((Enemy) (obj1)).setHitBitmap2(BitmapHolder.get(105));
        ((Enemy) (obj1)).setCollisionRect(new HierarchicalRect(0, 9F, 10F, 57F, 61F));
        ((Enemy) (obj1)).setCenter(((Enemy) (obj1)).getCollisionRect().getRect().left + ((Enemy) (obj1)).getCollisionRect().getRect().width() / 2.0F, ((Enemy) (obj1)).getCollisionRect().getRect().top + ((Enemy) (obj1)).getCollisionRect().getRect().height() / 2.0F);
        ((Enemy) (obj1)).offsetTo(-100F, 150F);
        ((Enemy) (obj1)).addMovable(((Movable) (obj)));
        ((Enemy) (obj1)).addMovable(((Movable) (obj2)));
        ((Enemy) (obj1)).setMoveRepeatable(true);
        mapping(((Enemy) (obj1)).getName(), ((Enemy) (obj1)));
        pop(((Enemy) (obj1)).getName());
        obj2 = new MoveCircle();
        ((MoveCircle) (obj2)).setTarget(((GameObject2D) (obj1)));
        ((MoveCircle) (obj2)).setDirection(0);
        ((MoveCircle) (obj2)).setRadian(0.0F);
        ((MoveCircle) (obj2)).setDistance(100F);
        ((MoveCircle) (obj2)).setSpeed(0.3926991F);
        obj = new MoveCircle();
        ((MoveCircle) (obj)).setTarget(((GameObject2D) (obj1)));
        ((MoveCircle) (obj)).setDirection(0);
        ((MoveCircle) (obj)).setRadian(3.141593F);
        ((MoveCircle) (obj)).setDistance(100F);
        ((MoveCircle) (obj)).setSpeed(0.1963495F);
        obj1 = new AttackShot(getEngine().getContext());
        ((AttackShot) (obj1)).setType(0);
        ((AttackShot) (obj1)).setBulletType(0);
        ((AttackShot) (obj1)).setTarget(((Player)getManager().getObjectMap().get("player")).getPlayerIcon());
        ((AttackShot) (obj1)).setDamage(25);
        ((AttackShot) (obj1)).setDeleteCount(1);
        ((AttackShot) (obj1)).setSpeed(60F);
        ((AttackShot) (obj1)).setMaxSwing(30);
        Enemy enemy = new Enemy();
        enemy.setHp(50);
        enemy.setMaxHp(50);
        enemy.setScore(800F);
        enemy.setTimeBorder(500F);
        enemy.setName("6-1");
        enemy.setBitmap(BitmapHolder.get(1));
        enemy.setHitBitmap1(BitmapHolder.get(106));
        enemy.setHitBitmap2(BitmapHolder.get(107));
        enemy.setCollisionRect(new HierarchicalRect(0, 13F, 20F, 50F, 55F));
        enemy.setCenter(enemy.getCollisionRect().getRect().left + enemy.getCollisionRect().getRect().width() / 2.0F, enemy.getCollisionRect().getRect().top + enemy.getCollisionRect().getRect().height() / 2.0F);
        enemy.setAttackCycle(3);
        enemy.addMovable(((Movable) (obj2)));
        enemy.addAttackable(((Attackable) (obj1)));
        mapping(enemy.getName(), enemy);
        pop(enemy.getName());
        obj2 = new Enemy();
        ((Enemy) (obj2)).setHp(50);
        ((Enemy) (obj2)).setMaxHp(50);
        ((Enemy) (obj2)).setScore(800F);
        ((Enemy) (obj2)).setTimeBorder(500F);
        ((Enemy) (obj2)).setName("6-2");
        ((Enemy) (obj2)).setBitmap(BitmapHolder.get(54));
        ((Enemy) (obj2)).setHitBitmap1(BitmapHolder.get(108));
        ((Enemy) (obj2)).setHitBitmap2(BitmapHolder.get(109));
        ((Enemy) (obj2)).setCollisionRect(new HierarchicalRect(0, 10F, 7F, 33F, 50F));
        ((Enemy) (obj2)).setCenter(((Enemy) (obj2)).getCollisionRect().getRect().left + ((Enemy) (obj2)).getCollisionRect().getRect().width() / 2.0F, ((Enemy) (obj2)).getCollisionRect().getRect().top + ((Enemy) (obj2)).getCollisionRect().getRect().height() / 2.0F);
        ((Enemy) (obj2)).setAttackCycle(3);
        ((Enemy) (obj2)).addMovable(((Movable) (obj)));
        ((Enemy) (obj2)).addAttackable(((Attackable) (obj1)));
        mapping(((Enemy) (obj2)).getName(), ((Enemy) (obj2)));
        pop(((Enemy) (obj2)).getName());
    }

    private void initializeCase7()
    {
    }

    private boolean isAllDeleted()
    {
        if(getEnemysMap().isEmpty())
            return true;
        Iterator iterator = getEnemysMap().values().iterator();
        do
            if(!iterator.hasNext())
                return true;
        while(((Enemy)iterator.next()).isDeleted());
        return false;
    }

    private void mapping(String s, Enemy enemy)
    {
        getEnemysMap().put(s, enemy);
    }

    private void pop(String s)
    {
        if(getEnemysMap().containsKey(s))
            ((GameObjectManager2D)getManager()).add((GameObject)getEnemysMap().get(s));
    }

    public HashMap getEnemysMap()
    {
        return enemysMap;
    }

    public void initialize()
    {
        switch(getId())
        {
        default:
            ((Battle)getEngine().getGame()).toBoss();
            delete();
            return;

        case 0: // '\0'
            initializeCase0();
            return;

        case 1: // '\001'
            initializeCase1();
            return;

        case 2: // '\002'
            initializeCase2();
            return;

        case 3: // '\003'
            initializeCase3();
            return;

        case 4: // '\004'
            initializeCase4();
            return;

        case 5: // '\005'
            initializeCase5();
            return;

        case 6: // '\006'
            initializeCase6();
            break;
        }
    }

    public void setEnemysMap(HashMap hashmap)
    {
        enemysMap = hashmap;
    }

    public boolean update()
    {
        if(isDeleted())
            return false;
        getId();
        JVM INSTR tableswitch 0 5: default 52
    //                   0 52
    //                   1 88
    //                   2 136
    //                   3 52
    //                   4 52
    //                   5 52;
           goto _L1 _L1 _L2 _L3 _L1 _L1 _L1
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_136;
_L4:
        if(isAllDeleted())
        {
            delete();
            ((GameObjectManager2D)getManager()).add(new Enemys(getId() + 1));
            return false;
        } else
        {
            nextTime();
            return true;
        }
_L2:
        if(getTime() == 10)
            pop("1-1");
        if(getTime() == 20)
            pop("1-2");
        if(getTime() == 30)
            pop("1-3");
          goto _L4
        if(getTime() == 10)
            pop("2-1");
        if(getTime() == 20)
            pop("2-2");
        if(getTime() == 30)
            pop("2-3");
          goto _L4
    }

    private HashMap enemysMap;
}
