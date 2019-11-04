// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.game;

import android.graphics.Canvas;
import java.util.*;

// Referenced classes of package academy.yamamoto.android.game:
//            GameObject, SpoXmlReader, GameEngine

public class GameObjectManager
{

    protected GameObjectManager()
    {
        engine = null;
        gameObjects = null;
        objectsBuffer = null;
        objectMap = null;
        usingObjects = false;
        setGameObjects(new ArrayList(4));
        setObjectsBuffer(new ArrayList(4));
        setObjectMap(new HashMap(4));
    }

    public GameObjectManager(GameEngine gameengine)
    {
        this();
        setEngine(gameengine);
    }

    private ArrayList getObjectsBuffer()
    {
        return objectsBuffer;
    }

    private boolean isUsingObjects()
    {
        return usingObjects;
    }

    private void setGameObjects(ArrayList arraylist)
    {
        gameObjects = arraylist;
    }

    private void setObjectMap(HashMap hashmap)
    {
        objectMap = hashmap;
    }

    private void setObjectsBuffer(ArrayList arraylist)
    {
        objectsBuffer = arraylist;
    }

    private void setUsingObjects(boolean flag)
    {
        usingObjects = flag;
    }

    private void settingGameObject(GameObject gameobject)
    {
        gameobject.setEngine(getEngine());
        gameobject.setManager(this);
        gameobject.initialize();
    }

    public void add(int i, GameObject gameobject)
    {
        if(isUsingObjects())
            getObjectsBuffer().add(gameobject);
        else
            getGameObjects().add(i, gameobject);
        settingGameObject(gameobject);
    }

    public void add(int i, String s)
    {
        s = (new SpoXmlReader(getEngine().getContext(), i, s)).getResult();
        do
        {
            String s1;
            do
            {
                if(!s.hasNext())
                    return;
                s1 = (String)s.next();
            } while(!getObjectMap().containsKey(s1));
            add((GameObject)getObjectMap().get(s1));
        } while(true);
    }

    public void add(GameObject gameobject)
    {
        if(isUsingObjects())
        {
            getObjectsBuffer().add(gameobject);
            return;
        } else
        {
            getGameObjects().add(gameobject);
            settingGameObject(gameobject);
            return;
        }
    }

    public void destroy()
    {
        ListIterator listiterator = getGameObjects().listIterator(getGameObjects().size());
        do
        {
            if(!listiterator.hasPrevious())
                return;
            ((GameObject)listiterator.previous()).destroy();
        } while(true);
    }

    public void dispatch(String s)
    {
        if(getObjectMap().containsKey(s))
            add((GameObject)getObjectMap().get(s));
    }

    public void dispatchAll()
    {
        Iterator iterator = getObjectMap().keySet().iterator();
        do
        {
            String s;
            do
            {
                if(!iterator.hasNext())
                    return;
                s = (String)iterator.next();
            } while(!getObjectMap().containsKey(s));
            add((GameObject)getObjectMap().get(s));
        } while(true);
    }

    public void draw(Canvas canvas)
    {
        ListIterator listiterator = getGameObjects().listIterator(getGameObjects().size());
        do
        {
            if(!listiterator.hasPrevious())
                return;
            ((GameObject)listiterator.previous()).draw(canvas);
        } while(true);
    }

    public GameEngine getEngine()
    {
        return engine;
    }

    protected ArrayList getGameObjects()
    {
        return gameObjects;
    }

    public GameObject getMappedObject(String s)
    {
        return (GameObject)getObjectMap().get(s);
    }

    public HashMap getObjectMap()
    {
        return objectMap;
    }

    protected void lockObjects()
    {
        setUsingObjects(true);
    }

    public void mapping(String s, GameObject gameobject)
    {
        getObjectMap().put(s, gameobject);
    }

    public void mapping(HashMap hashmap)
    {
        Iterator iterator = hashmap.keySet().iterator();
        do
        {
            if(!iterator.hasNext())
                return;
            String s = (String)iterator.next();
            getObjectMap().put(s, (GameObject)hashmap.get(s));
        } while(true);
    }

    public void setEngine(GameEngine gameengine)
    {
        engine = gameengine;
        Iterator iterator = getGameObjects().iterator();
        do
        {
            if(!iterator.hasNext())
                return;
            ((GameObject)iterator.next()).setEngine(gameengine);
        } while(true);
    }

    protected void unlockObjects()
    {
        if(isUsingObjects())
        {
            setUsingObjects(false);
            if(!getObjectsBuffer().isEmpty())
            {
                Iterator iterator = getObjectsBuffer().iterator();
                do
                {
                    if(!iterator.hasNext())
                    {
                        getObjectsBuffer().clear();
                        return;
                    }
                    add((GameObject)iterator.next());
                } while(true);
            }
        }
    }

    public void update()
    {
        unlockObjects();
        lockObjects();
        Iterator iterator = getGameObjects().iterator();
        do
        {
            GameObject gameobject;
            do
            {
                if(!iterator.hasNext())
                    return;
                gameobject = (GameObject)iterator.next();
            } while(gameobject.update());
            gameobject.destroy();
            iterator.remove();
        } while(true);
    }

    private static final long serialVersionUID = 1L;
    private GameEngine engine;
    private ArrayList gameObjects;
    private HashMap objectMap;
    private ArrayList objectsBuffer;
    private boolean usingObjects;
}
