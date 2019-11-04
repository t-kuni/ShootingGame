// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package scene.battle.object.player;

import academy.yamamoto.android.game.GameObject2D;
import android.graphics.Canvas;
import main.BitmapHolder;

// Referenced classes of package scene.battle.object.player:
//            PlayerIcon

public class InputCircle extends GameObject2D
{

    public InputCircle()
    {
    }

    public void draw(Canvas canvas)
    {
        if(PlayerIcon.getOperationType() == 1 && BitmapHolder.has(146))
            super.draw(canvas);
    }

    public void initialize()
    {
        setBitmap(BitmapHolder.get(146));
        setCenter(100F, 100F);
        offsetTo(5F, 563F);
    }
}
