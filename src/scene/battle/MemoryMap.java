// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle;

import java.util.HashMap;
import scene.battle.object.InvalidArea;
import scene.battle.object.enemy.Enemys;
import scene.battle.object.player.Player;

public class MemoryMap
{

    public MemoryMap()
    {
    }

    static HashMap create(int i)
    {
        HashMap hashmap = new HashMap(4);
        switch(i)
        {
        default:
            return hashmap;

        case 0: // '\0'
            hashmap.put("player", new Player());
            break;
        }
        hashmap.put("invalidArea", new InvalidArea());
        hashmap.put("enemys", new Enemys(0));
        return hashmap;
    }
}
