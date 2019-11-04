// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object;

import academy.yamamoto.android.game.*;
import academy.yamamoto.android.general.HierarchicalRect;

// Referenced classes of package scene.battle.object:
//            Wall

public class InvalidArea extends GameObject2D
{

    public InvalidArea()
    {
    }

    public void initialize()
    {
        GameObjectManager2D gameobjectmanager2d = (GameObjectManager2D)getManager();
        float f = getEngine().getGame().getVirtualScreenWidth();
        float f1 = getEngine().getGame().getVirtualScreenHeight();
        Wall wall = new Wall();
        wall.setCollisionRect(new HierarchicalRect(0, 0.0F, 0.0F, 300F, 900F + f1));
        wall.offsetTo(-600F, -600F);
        gameobjectmanager2d.add(wall);
        wall = new Wall();
        wall.setCollisionRect(new HierarchicalRect(0, 0.0F, 0.0F, 900F + f, 300F));
        wall.offsetTo(-300F, -600F);
        gameobjectmanager2d.add(wall);
        wall = new Wall();
        wall.setCollisionRect(new HierarchicalRect(0, 0.0F, 0.0F, 300F, 900F + f1));
        wall.offsetTo(300F + f, -300F);
        gameobjectmanager2d.add(wall);
        wall = new Wall();
        wall.setCollisionRect(new HierarchicalRect(0, 0.0F, 0.0F, 900F + f, 300F));
        wall.offsetTo(-600F, 300F + f1);
        gameobjectmanager2d.add(wall);
    }

    public boolean update()
    {
        return false;
    }
}
