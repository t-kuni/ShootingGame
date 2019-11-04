// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.enemy;


// Referenced classes of package scene.battle.object.enemy:
//            Count, Enemy

public class Attackable extends Count
{

    public Attackable()
    {
    }

    public Attackable(int i)
    {
        super(i);
    }

    public boolean attack(Enemy enemy, float f, float f1)
    {
        next();
        return !check();
    }
}
