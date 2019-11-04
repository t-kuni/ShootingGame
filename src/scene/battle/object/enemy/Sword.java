// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.enemy;

import academy.yamamoto.android.game.*;
import academy.yamamoto.android.general.HierarchicalRect;
import android.graphics.Bitmap;
import java.util.ArrayList;
import main.BitmapHolder;
import main.Effect;
import scene.battle.Battle;
import scene.battle.object.player.Player;
import scene.battle.object.player.PlayerIcon;

// Referenced classes of package scene.battle.object.enemy:
//            Enemy

public class Sword extends Enemy
{

    public Sword()
    {
        swordBitmap = null;
        playerIcon = null;
        caught = false;
        effectInterval = 15;
        effectTime = 0;
        setCollisionRect(new HierarchicalRect(0, 43F, 10F, 51F, 90F));
        setCenter(48F, 48F);
    }

    public static ArrayList getHistory()
    {
        return history;
    }

    public static void setHistory(ArrayList arraylist)
    {
        history = arraylist;
    }

    public void collision(int i, Class class1, GameObject2D gameobject2d, int j)
    {
        if(gameobject2d instanceof PlayerIcon)
        {
            ((PlayerIcon)gameobject2d).setMovable(false);
            setCaught(true);
            return;
        } else
        {
            super.collision(i, class1, gameobject2d, j);
            return;
        }
    }

    public boolean doCaught()
    {
        return caught;
    }

    public int getEffectInterval()
    {
        return effectInterval;
    }

    public int getEffectTime()
    {
        return effectTime;
    }

    public PlayerIcon getPlayerIcon()
    {
        return playerIcon;
    }

    public Bitmap getSwordBitmap()
    {
        return swordBitmap;
    }

    public void initialize()
    {
        if(getHistory() == null)
            setHistory(new ArrayList(21));
        getHistory().add(this);
        if(getHistory().size() > 20)
        {
            ((Sword)getHistory().get(0)).delete();
            getHistory().remove(0);
        }
        if(getSwordBitmap() == null)
            setSwordBitmap(BitmapHolder.get(133));
        setHitBitmap1(BitmapHolder.get(134));
        setHitBitmap2(BitmapHolder.get(135));
        setPlayerIcon(((Player)((Battle)getEngine().getGame()).getGom().getMappedObject("player")).getPlayerIcon());
        setHp(15);
        setMaxHp(15);
        setScore(0.0F);
        setTimeBorder(1.0F);
        setName("sword");
        setBitmap(getSwordBitmap());
    }

    public void setCaught(boolean flag)
    {
        caught = flag;
    }

    public void setEffectInterval(int i)
    {
        effectInterval = i;
    }

    public void setEffectTime(int i)
    {
        effectTime = i;
    }

    public void setPlayerIcon(PlayerIcon playericon)
    {
        playerIcon = playericon;
    }

    public void setSwordBitmap(Bitmap bitmap)
    {
        swordBitmap = bitmap;
    }

    public boolean update()
    {
        if(!super.update())
        {
            if(doCaught())
                getPlayerIcon().setMovable(true);
            return false;
        }
        if(doCaught() && getEffectTime() >= getEffectInterval())
        {
            setEffectTime(0);
            Effect effect = new Effect(5);
            effect.offsetTo(getPlayerIcon().getCenterX() - effect.getCenterXdiff(), getPlayerIcon().getCenterY() - effect.getCenterYdiff());
            ((Battle)getEngine().getGame()).getTopGom().add(effect);
        }
        if(getEffectTime() < getEffectInterval())
            setEffectTime(getEffectTime() + 1);
        return true;
    }

    private static ArrayList history = null;
    private boolean caught;
    private int effectInterval;
    private int effectTime;
    private PlayerIcon playerIcon;
    private Bitmap swordBitmap;

}
