// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.game;

import academy.yamamoto.android.general.HierarchicalRect;
import android.graphics.*;
import java.util.*;

// Referenced classes of package academy.yamamoto.android.game:
//            GameObjectManager, GameObject2D, CollisionID, GameEngine

public class GameObjectManager2D extends GameObjectManager
{

    private GameObjectManager2D()
    {
    }

    public GameObjectManager2D(GameEngine gameengine)
    {
        this();
        setEngine(gameengine);
    }

    public void CollisionDetection()
    {
        ArrayList arraylist = getGameObjects();
        if(arraylist.size() >= 2)
        {
            int i = 0;
            int j = arraylist.size();
            while(i < j - 1) 
            {
                GameObject2D gameobject2d = (GameObject2D)arraylist.get(i);
                if(gameobject2d.hasCollisionRect())
                {
                    ListIterator listiterator = arraylist.listIterator(i + 1);
                    while(listiterator.hasNext()) 
                    {
                        GameObject2D gameobject2d1 = (GameObject2D)listiterator.next();
                        if(gameobject2d1.hasCollisionRect())
                        {
                            Iterator iterator = HierarchicalRect.intersect(gameobject2d.getCollisionRect(), gameobject2d1.getCollisionRect());
                            while(iterator.hasNext()) 
                            {
                                CollisionID collisionid = (CollisionID)iterator.next();
                                gameobject2d.collision(collisionid.id1, gameobject2d1.getClass(), gameobject2d1, collisionid.id2);
                                gameobject2d1.collision(collisionid.id2, gameobject2d.getClass(), gameobject2d, collisionid.id1);
                            }
                        }
                    }
                }
                i++;
            }
        }
    }

    public void drawDebug(Canvas canvas)
    {
        ListIterator listiterator = getGameObjects().listIterator(getGameObjects().size());
        Paint paint = new Paint();
        paint.setColor(0xffff0000);
        Paint paint1 = new Paint();
        paint.setColor(0xff00ff00);
        Paint paint2 = new Paint();
        paint2.setColor(0xffff0000);
        do
        {
            GameObject2D gameobject2d;
            do
            {
                if(!listiterator.hasPrevious())
                    return;
                gameobject2d = (GameObject2D)listiterator.previous();
            } while(!gameobject2d.hasCollisionRect());
            canvas.drawRect(gameobject2d.getCollisionRect().getRect(), paint);
            canvas.drawText(gameobject2d.getName(), gameobject2d.getX(), gameobject2d.getY(), paint1);
            canvas.drawRect(new RectF(gameobject2d.getCenterX() - 2.0F, gameobject2d.getCenterY() - 2.0F, gameobject2d.getCenterX() + 2.0F, gameobject2d.getCenterY() + 2.0F), paint2);
        } while(true);
    }
}
