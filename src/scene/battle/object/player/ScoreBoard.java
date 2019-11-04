// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.player;

import academy.yamamoto.android.game.GameObject2D;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.*;
import main.BitmapHolder;

public class ScoreBoard extends GameObject2D
{

    public ScoreBoard()
    {
        score = 0;
        preScore = -1;
        boardBitmap = null;
        minusBitmap = null;
        numbers = null;
        numberBitmaps = new Vector(10);
        minus = false;
    }

    public void add(int i)
    {
        setScore(getScore() + i);
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(getBoardBitmap(), getX(), getY(), null);
        float f = getX() + 375F;
        float f1 = getY() + 57F;
        Iterator iterator = getNumbers().iterator();
        Bitmap bitmap = null;
        do
        {
            if(!iterator.hasNext())
            {
                if(isMinus())
                {
                    float f2 = getMinusBitmap().getWidth();
                    canvas.drawBitmap(getMinusBitmap(), f - f2, f1 - (float)bitmap.getHeight(), null);
                }
                return;
            }
            bitmap = (Bitmap)getNumberBitmaps().get(((Integer)iterator.next()).intValue());
            f -= bitmap.getWidth();
            canvas.drawBitmap(bitmap, f, f1 - (float)bitmap.getHeight(), null);
        } while(true);
    }

    public Bitmap getBoardBitmap()
    {
        return boardBitmap;
    }

    public Bitmap getMinusBitmap()
    {
        return minusBitmap;
    }

    public Vector getNumberBitmaps()
    {
        return numberBitmaps;
    }

    public ArrayList getNumbers()
    {
        return numbers;
    }

    public int getPreScore()
    {
        return preScore;
    }

    public int getScore()
    {
        return score;
    }

    public void initialize()
    {
        offsetTo(110F, 686F);
        setNumbers(new ArrayList(8));
        getNumberBitmaps().add(BitmapHolder.get(50));
        getNumberBitmaps().add(BitmapHolder.get(40));
        getNumberBitmaps().add(BitmapHolder.get(48));
        getNumberBitmaps().add(BitmapHolder.get(47));
        getNumberBitmaps().add(BitmapHolder.get(30));
        getNumberBitmaps().add(BitmapHolder.get(29));
        getNumberBitmaps().add(BitmapHolder.get(45));
        getNumberBitmaps().add(BitmapHolder.get(44));
        getNumberBitmaps().add(BitmapHolder.get(27));
        getNumberBitmaps().add(BitmapHolder.get(38));
        setBoardBitmap(BitmapHolder.get(85));
        setMinusBitmap(BitmapHolder.get(36));
    }

    public boolean isMinus()
    {
        return minus;
    }

    public void setBoardBitmap(Bitmap bitmap)
    {
        boardBitmap = bitmap;
    }

    public void setMinus(boolean flag)
    {
        minus = flag;
    }

    public void setMinusBitmap(Bitmap bitmap)
    {
        minusBitmap = bitmap;
    }

    public void setNumberBitmaps(Vector vector)
    {
        numberBitmaps = vector;
    }

    public void setNumbers(ArrayList arraylist)
    {
        numbers = arraylist;
    }

    public void setPreScore(int i)
    {
        preScore = i;
    }

    public void setScore(int i)
    {
        score = i;
    }

    public boolean update()
    {
        if(getPreScore() == getScore()) goto _L2; else goto _L1
_L1:
        int i;
        setPreScore(getScore());
        getNumbers().clear();
        i = getScore();
        boolean flag;
        if(i < 0)
            flag = true;
        else
            flag = false;
        setMinus(flag);
        i = Math.abs(i);
_L6:
        if(i > 0) goto _L4; else goto _L3
_L3:
        if(getNumbers().isEmpty())
            getNumbers().add(Integer.valueOf(0));
_L2:
        return true;
_L4:
        getNumbers().add(Integer.valueOf(i % 10));
        i /= 10;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private Bitmap boardBitmap;
    private boolean minus;
    private Bitmap minusBitmap;
    private Vector numberBitmaps;
    private ArrayList numbers;
    private int preScore;
    private int score;
}
