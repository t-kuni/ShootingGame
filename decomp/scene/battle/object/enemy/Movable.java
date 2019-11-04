// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.enemy;


// Referenced classes of package scene.battle.object.enemy:
//            Count, Enemy

public class Movable extends Count
{

    public Movable()
    {
    }

    public Movable(int i)
    {
        super(i);
    }

    public boolean move(Enemy enemy)
    {
        next();
        return !check();
    }
}
