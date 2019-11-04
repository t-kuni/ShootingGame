// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.general;

import academy.yamamoto.android.game.CollisionID;
import android.graphics.RectF;
import java.util.Iterator;
import java.util.Vector;

// Referenced classes of package academy.yamamoto.android.general:
//            Gen

public class HierarchicalRect
{

    public HierarchicalRect(int i, float f, float f1, float f2, float f3)
    {
        rect = null;
        underRects = null;
        id = 0;
        invalidId = false;
        setId(i);
        setRect(new RectF(f, f1, f2, f3));
        setUnderRects(new Vector(4));
    }

    public static Iterator intersect(HierarchicalRect hierarchicalrect, HierarchicalRect hierarchicalrect1)
    {
        int i;
        int k;
        Vector vector1;
        Vector vector2;
        vector2 = new Vector(16);
        if(!hierarchicalrect.hasRect())
            return vector2.iterator();
        if(!RectF.intersects(hierarchicalrect.getRect(), hierarchicalrect1.getRect()))
            return vector2.iterator();
        if(!hierarchicalrect.isInvalidId() && !hierarchicalrect1.isInvalidId())
            vector2.add(new CollisionID(hierarchicalrect.getId(), hierarchicalrect1.getId()));
        Vector vector = null;
        vector1 = null;
        if(hierarchicalrect.haveUnderRects())
            vector = secondIntersect(hierarchicalrect, hierarchicalrect1, vector2, false);
        if(hierarchicalrect1.haveUnderRects())
            vector1 = secondIntersect(hierarchicalrect1, hierarchicalrect, vector2, true);
        if(vector == null || vector1 == null)
            return vector2.iterator();
        if(vector.isEmpty() || vector1.isEmpty())
            return vector2.iterator();
        i = 0;
        k = vector.size();
_L2:
        if(i >= k)
            return vector2.iterator();
        int j = 0;
        int l = vector1.size();
        do
        {
label0:
            {
                if(j < l)
                    break label0;
                i++;
            }
            if(true)
                continue;
            recursiveIntersect2((HierarchicalRect)hierarchicalrect.getUnderRects().get(i), (HierarchicalRect)hierarchicalrect1.getUnderRects().get(j), vector2, false);
            j++;
        } while(true);
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void recursiveAdd(HierarchicalRect hierarchicalrect)
    {
        int j = 0;
        int k = getUnderRects().size();
        int i = 0;
        do
        {
            if(i >= k)
            {
                if(j >= k)
                    getUnderRects().add(hierarchicalrect);
                return;
            }
            if(Gen.isInclusion(((HierarchicalRect)getUnderRects().get(i)).getRect(), hierarchicalrect.getRect()))
                ((HierarchicalRect)getUnderRects().get(i)).recursiveAdd(hierarchicalrect);
            else
                j++;
            i++;
        } while(true);
    }

    private static void recursiveIntersect(HierarchicalRect hierarchicalrect, HierarchicalRect hierarchicalrect1, Vector vector, boolean flag)
    {
        int i = 0;
        int j = hierarchicalrect.getUnderRects().size();
        do
        {
            if(i >= j)
                return;
            HierarchicalRect hierarchicalrect2 = (HierarchicalRect)hierarchicalrect.getUnderRects().get(i);
            if(RectF.intersects(hierarchicalrect2.getRect(), hierarchicalrect1.getRect()))
            {
                if(!hierarchicalrect2.isInvalidId() && !hierarchicalrect1.isInvalidId())
                    if(flag)
                        vector.add(new CollisionID(hierarchicalrect1.getId(), hierarchicalrect2.getId()));
                    else
                        vector.add(new CollisionID(hierarchicalrect2.getId(), hierarchicalrect1.getId()));
                if(hierarchicalrect2.haveUnderRects())
                    recursiveIntersect(hierarchicalrect2, hierarchicalrect1, vector, flag);
            }
            i++;
        } while(true);
    }

    private static void recursiveIntersect2(HierarchicalRect hierarchicalrect, HierarchicalRect hierarchicalrect1, Vector vector, boolean flag)
    {
_L2:
        return;
        if(!hierarchicalrect.hasRect() || !RectF.intersects(hierarchicalrect.getRect(), hierarchicalrect1.getRect())) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        int k;
        int l;
        Vector vector1;
        Vector vector2;
        if(!hierarchicalrect.isInvalidId() && !hierarchicalrect1.isInvalidId())
            if(flag)
                vector.add(new CollisionID(hierarchicalrect1.getId(), hierarchicalrect.getId()));
            else
                vector.add(new CollisionID(hierarchicalrect.getId(), hierarchicalrect1.getId()));
        vector1 = null;
        vector2 = null;
        if(hierarchicalrect.haveUnderRects())
            vector1 = secondIntersect(hierarchicalrect, hierarchicalrect1, vector, false);
        if(hierarchicalrect1.haveUnderRects())
            vector2 = secondIntersect(hierarchicalrect1, hierarchicalrect, vector, true);
        if(vector1 == null || vector2 == null || vector1.isEmpty() || vector2.isEmpty()) goto _L2; else goto _L3
_L3:
        i = 0;
        k = vector1.size();
_L5:
        if(i >= k) goto _L2; else goto _L4
_L4:
        j = 0;
        l = vector2.size();
_L6:
label0:
        {
            if(j < l)
                break label0;
            i++;
        }
          goto _L5
          goto _L2
        recursiveIntersect2((HierarchicalRect)hierarchicalrect.getUnderRects().get(i), (HierarchicalRect)hierarchicalrect1.getUnderRects().get(j), vector, flag);
        j++;
          goto _L6
    }

    private static Vector secondIntersect(HierarchicalRect hierarchicalrect, HierarchicalRect hierarchicalrect1, Vector vector, boolean flag)
    {
        Vector vector1 = new Vector(16);
        int i = 0;
        int j = hierarchicalrect.getUnderRects().size();
        do
        {
            if(i >= j)
                return vector1;
            HierarchicalRect hierarchicalrect2 = (HierarchicalRect)hierarchicalrect.getUnderRects().get(i);
            if(RectF.intersects(hierarchicalrect2.getRect(), hierarchicalrect1.getRect()))
            {
                if(!hierarchicalrect2.isInvalidId() && !hierarchicalrect1.isInvalidId())
                    if(flag)
                        vector.add(new CollisionID(hierarchicalrect1.getId(), hierarchicalrect2.getId()));
                    else
                        vector.add(new CollisionID(hierarchicalrect2.getId(), hierarchicalrect1.getId()));
                vector1.add(Integer.valueOf(i));
                if(hierarchicalrect2.haveUnderRects())
                    recursiveIntersect(hierarchicalrect2, hierarchicalrect1, vector, flag);
            }
            i++;
        } while(true);
    }

    private void setInvalidId(boolean flag)
    {
        invalidId = flag;
    }

    private void setRect(RectF rectf)
    {
        rect = rectf;
    }

    private void setUnderRects(Vector vector)
    {
        underRects = vector;
    }

    public void add(HierarchicalRect hierarchicalrect)
    {
        if(Gen.isInclusion(getRect(), hierarchicalrect.getRect()))
        {
            recursiveAdd(hierarchicalrect);
            return;
        }
        if(Gen.isInclusion(hierarchicalrect.getRect(), getRect()))
        {
            HierarchicalRect hierarchicalrect1 = new HierarchicalRect(getId(), getRect().left, getRect().top, getRect().right, getRect().bottom);
            hierarchicalrect1.setInvalidId(isInvalidId());
            hierarchicalrect1.setUnderRects(getUnderRects());
            hierarchicalrect.recursiveAdd(hierarchicalrect1);
            setId(hierarchicalrect.getId());
            setRect(hierarchicalrect.getRect());
            setUnderRects(hierarchicalrect.getUnderRects());
            setInvalidId(hierarchicalrect.isInvalidId());
            return;
        } else
        {
            HierarchicalRect hierarchicalrect2 = new HierarchicalRect(getId(), getRect().left, getRect().top, getRect().right, getRect().bottom);
            hierarchicalrect2.setInvalidId(isInvalidId());
            hierarchicalrect2.setUnderRects(getUnderRects());
            getRect().union(hierarchicalrect.getRect());
            setInvalidId(true);
            setUnderRects(new Vector(4));
            getUnderRects().add(hierarchicalrect2);
            getUnderRects().add(hierarchicalrect);
            return;
        }
    }

    public int getId()
    {
        return id;
    }

    public RectF getRect()
    {
        return rect;
    }

    public Vector getUnderRects()
    {
        return underRects;
    }

    public boolean hasRect()
    {
        return getRect() != null;
    }

    public boolean haveUnderRects()
    {
        for(Vector vector = getUnderRects(); vector == null || vector.isEmpty();)
            return false;

        return true;
    }

    public boolean isInvalidId()
    {
        return invalidId;
    }

    public void offsetTo(float f, float f1)
    {
        if(hasRect()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        float f2 = getRect().left;
        float f3 = getRect().top;
        getRect().offsetTo(f, f1);
        if(haveUnderRects())
        {
            int i = 0;
            int j = getUnderRects().size();
            while(i < j) 
            {
                HierarchicalRect hierarchicalrect = (HierarchicalRect)getUnderRects().get(i);
                hierarchicalrect.offsetTo((hierarchicalrect.getRect().left + f) - f2, (hierarchicalrect.getRect().top + f1) - f3);
                i++;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setId(int i)
    {
        id = i;
    }

    private int id;
    private boolean invalidId;
    private RectF rect;
    private Vector underRects;
}
