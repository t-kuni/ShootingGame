// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.result;


public class ResultValues
{

    public ResultValues()
    {
        score = 0;
        combo = 0;
        comboBonus = 0;
        hp = 0;
        hpBonus = 0;
        totalScore = 0;
        distance = 0.0F;
        shotCount = null;
        killedBoss = false;
    }

    public int combo;
    public int comboBonus;
    public float distance;
    public int hp;
    public int hpBonus;
    public boolean killedBoss;
    public int score;
    public int shotCount[];
    public int totalScore;
}
