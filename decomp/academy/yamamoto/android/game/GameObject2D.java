// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.game;

import academy.yamamoto.android.general.HierarchicalRect;
import android.graphics.*;

// Referenced classes of package academy.yamamoto.android.game:
//            GameObject

public class GameObject2D extends GameObject
{

    public GameObject2D()
    {
        id = 0;
        name = "DEFAULT";
        point = null;
        centerPoint = null;
        bitmap = null;
        collisionRect = null;
        setPoint(new PointF(0.0F, 0.0F));
        setCenterPoint(new PointF(0.0F, 0.0F));
    }

    public GameObject2D(int i, float f, float f1, Bitmap bitmap1)
    {
        this();
        setId(i);
        offsetTo(f, f1);
        setBitmap(bitmap1);
    }

    private void setCenterPoint(PointF pointf)
    {
        centerPoint = pointf;
    }

    private void setPoint(PointF pointf)
    {
        point = pointf;
    }

    public void collision(int i, Class class1, GameObject2D gameobject2d, int j)
    {
    }

    public void draw(Canvas canvas)
    {
        if(hasBitmap())
            canvas.drawBitmap(getBitmap(), getX(), getY(), null);
    }

    public Bitmap getBitmap()
    {
        return bitmap;
    }

    public PointF getCenterPoint()
    {
        return centerPoint;
    }

    public float getCenterX()
    {
        return getCenterPoint().x;
    }

    public float getCenterXdiff()
    {
        return getCenterX() - getX();
    }

    public float getCenterY()
    {
        return getCenterPoint().y;
    }

    public float getCenterYdiff()
    {
        return getCenterY() - getY();
    }

    public HierarchicalRect getCollisionRect()
    {
        return collisionRect;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public PointF getPoint()
    {
        return point;
    }

    public float getX()
    {
        return getPoint().x;
    }

    public float getY()
    {
        return getPoint().y;
    }

    public boolean hasBitmap()
    {
        return getBitmap() != null;
    }

    public boolean hasCollisionRect()
    {
        return getCollisionRect() != null;
    }

    public void offsetTo(float f, float f1)
    {
        float f2 = getPoint().x;
        float f3 = getPoint().y;
        float f4 = getX();
        float f5 = getY();
        getPoint().set(f, f1);
        setCenter(getCenterX() + (f - f4), getCenterY() + (f1 - f5));
        if(hasCollisionRect())
            getCollisionRect().offsetTo((getCollisionRect().getRect().left + f) - f2, (getCollisionRect().getRect().top + f1) - f3);
    }

    public void setBitmap(Bitmap bitmap1)
    {
        bitmap = bitmap1;
    }

    public void setCenter(float f, float f1)
    {
        getCenterPoint().set(f, f1);
    }

    public void setCenterDiff(float f, float f1)
    {
        setCenter(getX() + f, getY() + f1);
    }

    public void setCollisionRect(HierarchicalRect hierarchicalrect)
    {
        collisionRect = hierarchicalrect;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setName(String s)
    {
        name = s;
    }

    private Bitmap bitmap;
    private PointF centerPoint;
    private HierarchicalRect collisionRect;
    private int id;
    private String name;
    private PointF point;
}
