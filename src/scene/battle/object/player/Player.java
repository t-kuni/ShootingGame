// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.player;

import academy.yamamoto.android.game.*;
import scene.battle.Battle;

// Referenced classes of package scene.battle.object.player:
//            LifeGauge, PlayerIcon, ScoreBoard, Weapon, 
//            ComboCounter, InputCircle

public class Player extends GameObject2D
{

    public Player()
    {
        hp = 1000F;
        maxHp = 1000F;
        score = 0;
        lifeGauge = null;
        playerIcon = null;
        scoreBoard = null;
        weapon = null;
        comboCounter = null;
        inputCircle = null;
    }

    private void setLifeGauge(LifeGauge lifegauge)
    {
        lifeGauge = lifegauge;
    }

    private void setPlayerIcon(PlayerIcon playericon)
    {
        playerIcon = playericon;
    }

    private void setScoreBoard(ScoreBoard scoreboard)
    {
        scoreBoard = scoreboard;
    }

    public ComboCounter getComboCounter()
    {
        return comboCounter;
    }

    public float getHp()
    {
        return hp;
    }

    public InputCircle getInputCircle()
    {
        return inputCircle;
    }

    public LifeGauge getLifeGauge()
    {
        return lifeGauge;
    }

    public float getMaxHp()
    {
        return maxHp;
    }

    public PlayerIcon getPlayerIcon()
    {
        return playerIcon;
    }

    public ScoreBoard getScoreBoard()
    {
        return scoreBoard;
    }

    public Weapon getWeapon()
    {
        return weapon;
    }

    public void initialize()
    {
        setLifeGauge(new LifeGauge());
        setPlayerIcon(new PlayerIcon());
        setScoreBoard(new ScoreBoard());
        setWeapon(new Weapon());
        setComboCounter(new ComboCounter());
        setInputCircle(new InputCircle());
        Battle battle = (Battle)getEngine().getGame();
        battle.getGom().add(getPlayerIcon());
        battle.getTopGom().add(getLifeGauge());
        battle.getTopGom().add(getScoreBoard());
        battle.getTopGom().add(getWeapon());
        battle.getTopGom().add(getComboCounter());
        battle.getTop2Gom().add(getInputCircle());
    }

    public void setComboCounter(ComboCounter combocounter)
    {
        comboCounter = combocounter;
    }

    public void setHp(float f)
    {
        hp = f;
    }

    public void setInputCircle(InputCircle inputcircle)
    {
        inputCircle = inputcircle;
    }

    public void setMaxHp(float f)
    {
        maxHp = f;
    }

    public void setWeapon(Weapon weapon1)
    {
        weapon = weapon1;
    }

    public boolean update()
    {
        getLifeGauge().setHp(getPlayerIcon().getHp());
        getLifeGauge().setMaxHp(getPlayerIcon().getMaxHp());
        return true;
    }

    private ComboCounter comboCounter;
    private float hp;
    private InputCircle inputCircle;
    private LifeGauge lifeGauge;
    private float maxHp;
    private PlayerIcon playerIcon;
    private int score;
    private ScoreBoard scoreBoard;
    private Weapon weapon;
}
