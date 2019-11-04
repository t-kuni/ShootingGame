// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.player;

import academy.yamamoto.android.game.*;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.Vector;
import main.*;
import scene.battle.Battle;

// Referenced classes of package scene.battle.object.player:
//            PlayerIcon, Player

public class Weapon extends GameObject2D
{

    public Weapon()
    {
        weaponBoard = null;
        playerIcon = null;
        darkBitmap = null;
        prasmaBitmap = null;
        flameBitmap = null;
        preAttackType = 0;
        selectAnimationBitmaps = null;
        selectAnimationBitmapIndex = 0;
    }

    public void draw(Canvas canvas)
    {
        float f1 = getX();
        float f = getY();
        canvas.drawBitmap(getWeaponBoard(), f1, f, null);
        canvas.drawBitmap(getDarkBitmap(), f1 + 13F, 13F + f, null);
        if(getPlayerIcon().getAttackType() == 0)
            canvas.drawBitmap((Bitmap)getSelectAnimationBitmaps().get(getSelectAnimationBitmapIndex()), f1 - 35F, f - 35F, null);
        f1 += 100F;
        canvas.drawBitmap(getWeaponBoard(), f1, f, null);
        canvas.drawBitmap(getPrasmaBitmap(), f1 - 6F, f - 7F, null);
        if(getPlayerIcon().getAttackType() == 1)
            canvas.drawBitmap((Bitmap)getSelectAnimationBitmaps().get(getSelectAnimationBitmapIndex()), f1 - 35F, f - 35F, null);
        f1 += 100F;
        canvas.drawBitmap(getWeaponBoard(), f1, f, null);
        canvas.drawBitmap(getFlameBitmap(), f1 - 6F, f - 7F, null);
        if(getPlayerIcon().getAttackType() == 2)
            canvas.drawBitmap((Bitmap)getSelectAnimationBitmaps().get(getSelectAnimationBitmapIndex()), f1 - 35F, f - 35F, null);
    }

    public Bitmap getDarkBitmap()
    {
        return darkBitmap;
    }

    public Bitmap getFlameBitmap()
    {
        return flameBitmap;
    }

    public PlayerIcon getPlayerIcon()
    {
        return playerIcon;
    }

    public Bitmap getPrasmaBitmap()
    {
        return prasmaBitmap;
    }

    public int getPreAttackType()
    {
        return preAttackType;
    }

    public int getSelectAnimationBitmapIndex()
    {
        return selectAnimationBitmapIndex;
    }

    public Vector getSelectAnimationBitmaps()
    {
        return selectAnimationBitmaps;
    }

    public Bitmap getWeaponBoard()
    {
        return weaponBoard;
    }

    public void initialize()
    {
        offsetTo(530F, 678F);
        setWeaponBoard(BitmapHolder.get(95));
        setDarkBitmap(BitmapHolder.get(74));
        setPrasmaBitmap(Effect.clipBitmap(BitmapHolder.get(66), 0, 0));
        setFlameBitmap(Effect.clipBitmap(BitmapHolder.get(62), 3, 1));
        setPlayerIcon(((Player)((Battle)getEngine().getGame()).getGom().getMappedObject("player")).getPlayerIcon());
        Bitmap bitmap = BitmapHolder.get(63);
        setSelectAnimationBitmaps(new Vector(4));
        getSelectAnimationBitmaps().add(Effect.clipBitmap(bitmap, 2, 2));
        getSelectAnimationBitmaps().add(Effect.clipBitmap(bitmap, 3, 2));
        getSelectAnimationBitmaps().add(Effect.clipBitmap(bitmap, 2, 0));
        getSelectAnimationBitmaps().add(Effect.clipBitmap(bitmap, 3, 0));
        getSelectAnimationBitmaps().add(Effect.clipBitmap(bitmap, 2, 3));
        getSelectAnimationBitmaps().add(Effect.clipBitmap(bitmap, 3, 3));
        getSelectAnimationBitmaps().add(Effect.clipBitmap(bitmap, 2, 1));
        getSelectAnimationBitmaps().add(Effect.clipBitmap(bitmap, 3, 1));
    }

    public void setDarkBitmap(Bitmap bitmap)
    {
        darkBitmap = bitmap;
    }

    public void setFlameBitmap(Bitmap bitmap)
    {
        flameBitmap = bitmap;
    }

    public void setPlayerIcon(PlayerIcon playericon)
    {
        playerIcon = playericon;
    }

    public void setPrasmaBitmap(Bitmap bitmap)
    {
        prasmaBitmap = bitmap;
    }

    public void setPreAttackType(int i)
    {
        preAttackType = i;
    }

    public void setSelectAnimationBitmapIndex(int i)
    {
        selectAnimationBitmapIndex = i;
    }

    public void setSelectAnimationBitmaps(Vector vector)
    {
        selectAnimationBitmaps = vector;
    }

    public void setWeaponBoard(Bitmap bitmap)
    {
        weaponBoard = bitmap;
    }

    public boolean update()
    {
        setSelectAnimationBitmapIndex(getSelectAnimationBitmapIndex() + 1);
        if(getSelectAnimationBitmapIndex() >= getSelectAnimationBitmaps().size())
            setSelectAnimationBitmapIndex(0);
        if(getPlayerIcon().getAttackType() != getPreAttackType())
        {
            SEHolder.play(getEngine().getContext(), 16);
            setPreAttackType(getPlayerIcon().getAttackType());
        }
        return true;
    }

    private Bitmap darkBitmap;
    private Bitmap flameBitmap;
    private PlayerIcon playerIcon;
    private Bitmap prasmaBitmap;
    private int preAttackType;
    private int selectAnimationBitmapIndex;
    private Vector selectAnimationBitmaps;
    private Bitmap weaponBoard;
}
