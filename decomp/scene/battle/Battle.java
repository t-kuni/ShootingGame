// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle;

import academy.yamamoto.android.game.*;
import academy.yamamoto.android.general.Debug;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import java.util.HashMap;
import main.BGMHolder;
import main.BitmapHolder;
import scene.battle.object.enemy.BossProduction00;
import scene.battle.object.player.ComboCounter;
import scene.battle.object.player.Player;
import scene.battle.object.player.PlayerIcon;
import scene.battle.object.player.ScoreBoard;
import scene.result.Result;
import scene.result.ResultValues;

// Referenced classes of package scene.battle:
//            MemoryMap, StartProduction00, CloudManager

public class Battle extends Game
    implements android.media.MediaPlayer.OnCompletionListener
{

    public Battle(int i)
    {
        gom = null;
        cloudManager = null;
        topGom = null;
        top2Gom = null;
        time = 0;
        stageId = 0;
        currentBgm = 0;
        backBitmap = null;
        backBitmapMoveSpeed = 10;
        backBitmapX = 0;
        setStageId(i);
    }

    private Bitmap getBackBitmap()
    {
        return backBitmap;
    }

    private int getBackBitmapX()
    {
        return backBitmapX;
    }

    public static MediaPlayer getBossBgm()
    {
        return bossBgm;
    }

    private void nextTime()
    {
        setTime(getTime() + 1);
    }

    private void setBackBitmap(Bitmap bitmap)
    {
        backBitmap = bitmap;
    }

    private void setBackBitmapX(int i)
    {
        backBitmapX = i;
    }

    public static void setBossBgm(MediaPlayer mediaplayer)
    {
        bossBgm = mediaplayer;
    }

    private void setCurrentBgm(int i)
    {
        currentBgm = i;
    }

    private void setGom(GameObjectManager2D gameobjectmanager2d)
    {
        gom = gameobjectmanager2d;
    }

    private void setTime(int i)
    {
        time = i;
    }

    public void changeBgm(int i)
    {
        if(BGMHolder.has(getCurrentBgm()) && BGMHolder.has(i))
        {
            stopBgm();
            currentBgm = i;
            startBgm();
        }
    }

    public void destroy()
    {
        if(getBackBitmap() != null)
        {
            getBackBitmap().recycle();
            setBackBitmap(null);
        }
        destroyBitmaps();
        getGom().destroy();
        getTopGom().destroy();
        getTop2Gom().destroy();
        System.gc();
    }

    public void destroyBgm()
    {
        if(BGMHolder.has(0x7f040002))
            BGMHolder.destroy(0x7f040002);
        if(BGMHolder.has(0x7f040003))
            BGMHolder.destroy(0x7f040003);
    }

    public void destroyBitmaps()
    {
        BitmapHolder.destroy(132);
        BitmapHolder.destroy(75);
        BitmapHolder.destroy(51);
        BitmapHolder.destroy(52);
        BitmapHolder.destroy(53);
        BitmapHolder.destroy(4);
        BitmapHolder.destroy(5);
        BitmapHolder.destroy(6);
        BitmapHolder.destroy(7);
        BitmapHolder.destroy(8);
        BitmapHolder.destroy(82);
        BitmapHolder.destroy(13);
        BitmapHolder.destroy(15);
        BitmapHolder.destroy(118);
        BitmapHolder.destroy(119);
        BitmapHolder.destroy(2);
        BitmapHolder.destroy(58);
        BitmapHolder.destroy(128);
        BitmapHolder.destroy(129);
        BitmapHolder.destroy(130);
        BitmapHolder.destroy(131);
        BitmapHolder.destroy(3);
        BitmapHolder.destroy(9);
        BitmapHolder.destroy(10);
        BitmapHolder.destroy(11);
        BitmapHolder.destroy(21);
        BitmapHolder.destroy(23);
        BitmapHolder.destroy(25);
        BitmapHolder.destroy(28);
        BitmapHolder.destroy(31);
        BitmapHolder.destroy(32);
        BitmapHolder.destroy(33);
        BitmapHolder.destroy(41);
        BitmapHolder.destroy(46);
        BitmapHolder.destroy(49);
        BitmapHolder.destroy(57);
        BitmapHolder.destroy(56);
        BitmapHolder.destroy(126);
        BitmapHolder.destroy(127);
        BitmapHolder.destroy(124);
        BitmapHolder.destroy(125);
        BitmapHolder.destroy(59);
        BitmapHolder.destroy(97);
        BitmapHolder.destroy(98);
        BitmapHolder.destroy(99);
        BitmapHolder.destroy(16);
        BitmapHolder.destroy(17);
        BitmapHolder.destroy(18);
        BitmapHolder.destroy(19);
        BitmapHolder.destroy(20);
        BitmapHolder.destroy(84);
        BitmapHolder.destroy(104);
        BitmapHolder.destroy(105);
        BitmapHolder.destroy(1);
        BitmapHolder.destroy(106);
        BitmapHolder.destroy(107);
        BitmapHolder.destroy(54);
        BitmapHolder.destroy(108);
        BitmapHolder.destroy(109);
        BitmapHolder.destroy(12);
        BitmapHolder.destroy(110);
        BitmapHolder.destroy(111);
        BitmapHolder.destroy(55);
        BitmapHolder.destroy(112);
        BitmapHolder.destroy(113);
        BitmapHolder.destroy(96);
        BitmapHolder.destroy(114);
        BitmapHolder.destroy(115);
        BitmapHolder.destroy(0);
        BitmapHolder.destroy(116);
        BitmapHolder.destroy(117);
        BitmapHolder.destroy(68);
        BitmapHolder.destroy(65);
        BitmapHolder.destroy(76);
        BitmapHolder.destroy(50);
        BitmapHolder.destroy(40);
        BitmapHolder.destroy(48);
        BitmapHolder.destroy(47);
        BitmapHolder.destroy(30);
        BitmapHolder.destroy(29);
        BitmapHolder.destroy(45);
        BitmapHolder.destroy(44);
        BitmapHolder.destroy(27);
        BitmapHolder.destroy(38);
        BitmapHolder.destroy(78);
        BitmapHolder.destroy(77);
        BitmapHolder.destroy(74);
        BitmapHolder.destroy(85);
        BitmapHolder.destroy(36);
        BitmapHolder.destroy(95);
        BitmapHolder.destroy(66);
        BitmapHolder.destroy(62);
        BitmapHolder.destroy(63);
        BitmapHolder.destroy(101);
        BitmapHolder.destroy(102);
        BitmapHolder.destroy(103);
        BitmapHolder.destroy(71);
        BitmapHolder.destroy(72);
        BitmapHolder.destroy(70);
        BitmapHolder.destroy(133);
        BitmapHolder.destroy(134);
        BitmapHolder.destroy(135);
        BitmapHolder.destroy(136);
        BitmapHolder.destroy(137);
        BitmapHolder.destroy(138);
        BitmapHolder.destroy(139);
        BitmapHolder.destroy(140);
        BitmapHolder.destroy(141);
        BitmapHolder.destroy(142);
        BitmapHolder.destroy(143);
        BitmapHolder.destroy(144);
        BitmapHolder.destroy(145);
        BitmapHolder.destroy(146);
    }

    public void draw(Canvas canvas)
    {
        setBackBitmapX(getBackBitmapX() - getBackBitmapMoveSpeed());
        if(getBackBitmapX() < -100)
            setBackBitmapX(getBackBitmapX() + 100);
        canvas.drawBitmap(getBackBitmap(), getBackBitmapX(), 0.0F, null);
        getGom().draw(canvas);
        getTopGom().draw(canvas);
        getTop2Gom().draw(canvas);
    }

    public int getBackBitmapMoveSpeed()
    {
        return backBitmapMoveSpeed;
    }

    public CloudManager getCloudManager()
    {
        return cloudManager;
    }

    public int getCurrentBgm()
    {
        return currentBgm;
    }

    public GameObjectManager2D getGom()
    {
        return gom;
    }

    public int getStageId()
    {
        return stageId;
    }

    public int getTime()
    {
        return time;
    }

    public GameObjectManager2D getTop2Gom()
    {
        return top2Gom;
    }

    public GameObjectManager2D getTopGom()
    {
        return topGom;
    }

    public void initialize()
    {
        int i;
        Canvas canvas;
        Bitmap bitmap;
        setVirtualScreenWidth(1280F);
        setVirtualScreenHeight(768F);
        setGom(new GameObjectManager2D(getEngine()));
        setTopGom(new GameObjectManager2D(getEngine()));
        setTop2Gom(new GameObjectManager2D(getEngine()));
        getGom().mapping(MemoryMap.create(getStageId()));
        getTopGom().add(new StartProduction00());
        loadBgm();
        setCurrentBgm(0x7f040002);
        startBgm();
        loadBitmaps();
        setCurrentBgm(0x7f040002);
        setBackBitmap(BitmapHolder.get(132));
        canvas = new Canvas(getBackBitmap());
        bitmap = BitmapHolder.get(75);
        i = 0;
_L2:
        if(i >= 14)
        {
            getEngine().setFilteringScreen(false);
            setCloudManager(new CloudManager(getEngine()));
            return;
        }
        int j = 0;
        do
        {
label0:
            {
                if(j < 8)
                    break label0;
                i++;
            }
            if(true)
                continue;
            canvas.drawBitmap(bitmap, i * 100, j * 100, null);
            j++;
        } while(true);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void loadBgm()
    {
        if(!BGMHolder.has(0x7f040002))
        {
            BGMHolder.load(getEngine().getContext(), 0x7f040002);
            BGMHolder.get(0x7f040002).setLooping(true);
        }
        if(!BGMHolder.has(0x7f040003))
        {
            BGMHolder.load(getEngine().getContext(), 0x7f040003);
            BGMHolder.get(0x7f040003).setOnCompletionListener(this);
        }
    }

    public void loadBitmaps()
    {
        BitmapHolder.load(getEngine().getContext(), 132);
        BitmapHolder.load(getEngine().getContext(), 75);
        BitmapHolder.load(getEngine().getContext(), 51);
        BitmapHolder.load(getEngine().getContext(), 52);
        BitmapHolder.load(getEngine().getContext(), 53);
        BitmapHolder.load(getEngine().getContext(), 4);
        BitmapHolder.load(getEngine().getContext(), 5);
        BitmapHolder.load(getEngine().getContext(), 6);
        BitmapHolder.load(getEngine().getContext(), 7);
        BitmapHolder.load(getEngine().getContext(), 8);
        BitmapHolder.load(getEngine().getContext(), 82);
        BitmapHolder.load(getEngine().getContext(), 13);
        BitmapHolder.load(getEngine().getContext(), 15);
        BitmapHolder.load(getEngine().getContext(), 118);
        BitmapHolder.load(getEngine().getContext(), 119);
        BitmapHolder.load(getEngine().getContext(), 2);
        BitmapHolder.load(getEngine().getContext(), 58);
        BitmapHolder.load(getEngine().getContext(), 128);
        BitmapHolder.load(getEngine().getContext(), 129);
        BitmapHolder.load(getEngine().getContext(), 130);
        BitmapHolder.load(getEngine().getContext(), 131);
        BitmapHolder.load(getEngine().getContext(), 3);
        BitmapHolder.load(getEngine().getContext(), 9);
        BitmapHolder.load(getEngine().getContext(), 10);
        BitmapHolder.load(getEngine().getContext(), 11);
        BitmapHolder.load(getEngine().getContext(), 21);
        BitmapHolder.load(getEngine().getContext(), 23);
        BitmapHolder.load(getEngine().getContext(), 25);
        BitmapHolder.load(getEngine().getContext(), 28);
        BitmapHolder.load(getEngine().getContext(), 31);
        BitmapHolder.load(getEngine().getContext(), 32);
        BitmapHolder.load(getEngine().getContext(), 33);
        BitmapHolder.load(getEngine().getContext(), 41);
        BitmapHolder.load(getEngine().getContext(), 46);
        BitmapHolder.load(getEngine().getContext(), 49);
        BitmapHolder.load(getEngine().getContext(), 57);
        BitmapHolder.load(getEngine().getContext(), 56);
        BitmapHolder.load(getEngine().getContext(), 126);
        BitmapHolder.load(getEngine().getContext(), 127);
        BitmapHolder.load(getEngine().getContext(), 124);
        BitmapHolder.load(getEngine().getContext(), 125);
        BitmapHolder.load(getEngine().getContext(), 59);
        BitmapHolder.load(getEngine().getContext(), 97);
        BitmapHolder.load(getEngine().getContext(), 98);
        BitmapHolder.load(getEngine().getContext(), 99);
        BitmapHolder.load(getEngine().getContext(), 16);
        BitmapHolder.load(getEngine().getContext(), 17);
        BitmapHolder.load(getEngine().getContext(), 18);
        BitmapHolder.load(getEngine().getContext(), 19);
        BitmapHolder.load(getEngine().getContext(), 20);
        BitmapHolder.load(getEngine().getContext(), 84);
        BitmapHolder.load(getEngine().getContext(), 104);
        BitmapHolder.load(getEngine().getContext(), 105);
        BitmapHolder.load(getEngine().getContext(), 1);
        BitmapHolder.load(getEngine().getContext(), 106);
        BitmapHolder.load(getEngine().getContext(), 107);
        BitmapHolder.load(getEngine().getContext(), 54);
        BitmapHolder.load(getEngine().getContext(), 108);
        BitmapHolder.load(getEngine().getContext(), 109);
        BitmapHolder.load(getEngine().getContext(), 12);
        BitmapHolder.load(getEngine().getContext(), 110);
        BitmapHolder.load(getEngine().getContext(), 111);
        BitmapHolder.load(getEngine().getContext(), 55);
        BitmapHolder.load(getEngine().getContext(), 112);
        BitmapHolder.load(getEngine().getContext(), 113);
        BitmapHolder.load(getEngine().getContext(), 96);
        BitmapHolder.load(getEngine().getContext(), 114);
        BitmapHolder.load(getEngine().getContext(), 115);
        BitmapHolder.load(getEngine().getContext(), 0);
        BitmapHolder.load(getEngine().getContext(), 116);
        BitmapHolder.load(getEngine().getContext(), 117);
        BitmapHolder.load(getEngine().getContext(), 68);
        BitmapHolder.load(getEngine().getContext(), 65);
        BitmapHolder.load(getEngine().getContext(), 76);
        BitmapHolder.load(getEngine().getContext(), 50);
        BitmapHolder.load(getEngine().getContext(), 40);
        BitmapHolder.load(getEngine().getContext(), 48);
        BitmapHolder.load(getEngine().getContext(), 47);
        BitmapHolder.load(getEngine().getContext(), 30);
        BitmapHolder.load(getEngine().getContext(), 29);
        BitmapHolder.load(getEngine().getContext(), 45);
        BitmapHolder.load(getEngine().getContext(), 44);
        BitmapHolder.load(getEngine().getContext(), 27);
        BitmapHolder.load(getEngine().getContext(), 38);
        BitmapHolder.load(getEngine().getContext(), 78);
        BitmapHolder.load(getEngine().getContext(), 77);
        BitmapHolder.load(getEngine().getContext(), 74);
        BitmapHolder.load(getEngine().getContext(), 85);
        BitmapHolder.load(getEngine().getContext(), 36);
        BitmapHolder.load(getEngine().getContext(), 95);
        BitmapHolder.load(getEngine().getContext(), 66);
        BitmapHolder.load(getEngine().getContext(), 62);
        BitmapHolder.load(getEngine().getContext(), 63);
        BitmapHolder.load(getEngine().getContext(), 101);
        BitmapHolder.load(getEngine().getContext(), 102);
        BitmapHolder.load(getEngine().getContext(), 103);
        BitmapHolder.load(getEngine().getContext(), 71);
        BitmapHolder.load(getEngine().getContext(), 72);
        BitmapHolder.load(getEngine().getContext(), 70);
        BitmapHolder.load(getEngine().getContext(), 133);
        BitmapHolder.load(getEngine().getContext(), 134);
        BitmapHolder.load(getEngine().getContext(), 135);
        BitmapHolder.load(getEngine().getContext(), 136);
        BitmapHolder.load(getEngine().getContext(), 137);
        BitmapHolder.load(getEngine().getContext(), 138);
        BitmapHolder.load(getEngine().getContext(), 139);
        BitmapHolder.load(getEngine().getContext(), 140);
        BitmapHolder.load(getEngine().getContext(), 141);
        BitmapHolder.load(getEngine().getContext(), 142);
        BitmapHolder.load(getEngine().getContext(), 143);
        BitmapHolder.load(getEngine().getContext(), 144);
        BitmapHolder.load(getEngine().getContext(), 145);
        BitmapHolder.load(getEngine().getContext(), 146);
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        Debug.logoutMsg("BOSS BGM COMPLETION \u547C\u3070\u308C\u305F");
        mediaplayer.seekTo(6153);
        mediaplayer.start();
    }

    public void pause()
    {
        pauseBgm();
    }

    public void pauseBgm()
    {
        if(BGMHolder.has(getCurrentBgm()))
            BGMHolder.get(getCurrentBgm()).pause();
    }

    public void setBackBitmapMoveSpeed(int i)
    {
        backBitmapMoveSpeed = i;
    }

    public void setCloudManager(CloudManager cloudmanager)
    {
        cloudManager = cloudmanager;
    }

    public void setStageId(int i)
    {
        stageId = i;
    }

    public void setTop2Gom(GameObjectManager2D gameobjectmanager2d)
    {
        top2Gom = gameobjectmanager2d;
    }

    public void setTopGom(GameObjectManager2D gameobjectmanager2d)
    {
        topGom = gameobjectmanager2d;
    }

    public void start()
    {
        startBgm();
    }

    public void startBgm()
    {
        if(BGMHolder.has(getCurrentBgm()))
            BGMHolder.get(getCurrentBgm()).start();
    }

    public void startBossBgm()
    {
        changeBgm(0x7f040003);
    }

    public void stopBgm()
    {
        if(BGMHolder.has(getCurrentBgm()))
            BGMHolder.get(getCurrentBgm()).stop();
    }

    public void toBoss()
    {
        stopBgm();
        ((Battle)getEngine().getGame()).getTopGom().add(new BossProduction00());
    }

    public void toResult()
    {
        getEngine().setFilteringScreen(true);
        destroyBgm();
        Player player = (Player)getGom().getObjectMap().get("player");
        ResultValues resultvalues = new ResultValues();
        resultvalues.score = player.getScoreBoard().getScore();
        resultvalues.combo = player.getComboCounter().getComboMaxCount();
        resultvalues.hp = player.getPlayerIcon().getHp();
        resultvalues.distance = player.getPlayerIcon().getTotalDistance();
        resultvalues.shotCount = player.getPlayerIcon().getShotCount();
        resultvalues.killedBoss = player.getPlayerIcon().isKilledBoss();
        getEngine().setGame(new Result(resultvalues)).destroy();
    }

    public boolean update()
    {
        getGom().update();
        getGom().CollisionDetection();
        getTopGom().update();
        getTop2Gom().update();
        nextTime();
        return true;
    }

    private static MediaPlayer bossBgm = null;
    private Bitmap backBitmap;
    private int backBitmapMoveSpeed;
    private int backBitmapX;
    private CloudManager cloudManager;
    private int currentBgm;
    private GameObjectManager2D gom;
    private int stageId;
    private int time;
    private GameObjectManager2D top2Gom;
    private GameObjectManager2D topGom;

}
