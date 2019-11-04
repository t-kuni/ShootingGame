// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.game;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.hardware.*;
import android.view.*;
import java.io.*;
import java.util.List;

// Referenced classes of package academy.yamamoto.android.game:
//            Game, SlopeState, TouchPointer, TouchState, 
//            GameTouchListener

public class GameEngine extends SurfaceView
    implements android.view.SurfaceHolder.Callback, Runnable, android.view.View.OnTouchListener, SensorEventListener
{

    public GameEngine(Context context)
    {
        super(context);
        game = null;
        holder = null;
        thread = null;
        touchState = null;
        sensorManager = null;
        orientation = null;
        slopeState = null;
        windowManager = null;
        resources = null;
        configuration = null;
        display = null;
        gameTouchListener = null;
        screenShotDirectory = null;
        screenShotFileName = null;
        waitTime = 50;
        playing = false;
        pausing = false;
        ended = false;
        canvasColor = 0xff0000ff;
        touchable = false;
        realScreenWidth = 0;
        realScreenHeight = 0;
        filteringScreen = true;
        screenShooting = false;
        holder = getHolder();
        holder.addCallback(this);
        setThread(new Thread(this));
        setFocusable(true);
        requestFocus();
        setResources(context.getResources());
        setConfiguration(getResources().getConfiguration());
        setSensorManager((SensorManager)context.getSystemService("sensor"));
        setWindowManager((WindowManager)context.getSystemService("window"));
        setDisplay(getWindowManager().getDefaultDisplay());
    }

    public GameEngine(Context context, Game game1)
    {
        this(context);
        setGame(game1);
    }

    private Thread getThread()
    {
        return thread;
    }

    private void setEnded(boolean flag)
    {
        ended = flag;
    }

    private void setOrientation(Sensor sensor)
    {
        orientation = sensor;
    }

    private void setPausing(boolean flag)
    {
        pausing = flag;
    }

    private void setPlaying(boolean flag)
    {
        playing = flag;
    }

    private void setRealScreenHeight(int i)
    {
        realScreenHeight = i;
    }

    private void setRealScreenWidth(int i)
    {
        realScreenWidth = i;
    }

    private void setSensorManager(SensorManager sensormanager)
    {
        sensorManager = sensormanager;
    }

    private void setSlopeState(SlopeState slopestate)
    {
        slopeState = slopestate;
    }

    private void setThread(Thread thread1)
    {
        thread = thread1;
    }

    private void setTouchState(TouchState touchstate)
    {
        touchState = touchstate;
    }

    private void setTouchable(boolean flag)
    {
        touchable = flag;
    }

    private void setWindowManager(WindowManager windowmanager)
    {
        windowManager = windowmanager;
    }

    public void end()
    {
        if(!isEnded())
        {
            setPlaying(false);
            setPausing(false);
            setEnded(true);
            if(isGaming())
            {
                getGame().destroy();
                return;
            }
        }
    }

    public int getCanvasColor()
    {
        return canvasColor;
    }

    public Configuration getConfiguration()
    {
        return configuration;
    }

    public Display getDisplay()
    {
        return display;
    }

    public Game getGame()
    {
        return game;
    }

    public GameTouchListener getGameTouchListener()
    {
        return gameTouchListener;
    }

    public float getHorizontalRatioToReal()
    {
        if(!isGaming())
            return 1.0F;
        else
            return (float)getRealScreenWidth() / getGame().getVirtualScreenWidth();
    }

    public float getHorizontalRatioToVirtual()
    {
        if(!isGaming())
            return 1.0F;
        else
            return getGame().getVirtualScreenWidth() / (float)getRealScreenWidth();
    }

    public Sensor getOrientation()
    {
        return orientation;
    }

    public int getRealScreenHeight()
    {
        return realScreenHeight;
    }

    public int getRealScreenWidth()
    {
        return realScreenWidth;
    }

    public Resources getResources()
    {
        return resources;
    }

    public String getScreenShotDirectory()
    {
        return screenShotDirectory;
    }

    public String getScreenShotFileName()
    {
        return screenShotFileName;
    }

    public SensorManager getSensorManager()
    {
        return sensorManager;
    }

    public SlopeState getSlopeState()
    {
        return slopeState;
    }

    public TouchState getTouchState()
    {
        return touchState;
    }

    public float getVerticalRatioToReal()
    {
        if(!isGaming())
            return 1.0F;
        else
            return (float)getRealScreenHeight() / getGame().getVirtualScreenHeight();
    }

    public float getVerticalRatioToVirtual()
    {
        if(!isGaming())
            return 1.0F;
        else
            return getGame().getVirtualScreenHeight() / (float)getRealScreenHeight();
    }

    public int getWaitTime()
    {
        return waitTime;
    }

    public WindowManager getWindowManager()
    {
        return windowManager;
    }

    public boolean hasGameTouchListener()
    {
        return getGameTouchListener() != null;
    }

    public boolean isEnded()
    {
        return ended;
    }

    public boolean isFilteringScreen()
    {
        return filteringScreen;
    }

    public boolean isGaming()
    {
        return getGame() != null;
    }

    public boolean isOrientationEnabled()
    {
        return getOrientation() != null;
    }

    public boolean isPausing()
    {
        return pausing;
    }

    public boolean isPlaying()
    {
        return playing;
    }

    public boolean isScreenShooting()
    {
        return screenShooting;
    }

    public boolean isTouchable()
    {
        return touchable;
    }

    public void onAccuracyChanged(Sensor sensor, int i)
    {
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        if(sensorevent.sensor != getOrientation()) goto _L2; else goto _L1
_L1:
        getDisplay().getOrientation();
        JVM INSTR tableswitch 0 3: default 48
    //                   0 49
    //                   1 78
    //                   2 106
    //                   3 133;
           goto _L2 _L3 _L4 _L5 _L6
_L2:
        return;
_L3:
        getSlopeState().x = -sensorevent.values[2];
        getSlopeState().y = -sensorevent.values[1];
        return;
_L4:
        getSlopeState().x = -sensorevent.values[1];
        getSlopeState().y = sensorevent.values[2];
        return;
_L5:
        getSlopeState().x = sensorevent.values[2];
        getSlopeState().y = sensorevent.values[1];
        return;
_L6:
        getSlopeState().x = sensorevent.values[1];
        getSlopeState().y = -sensorevent.values[2];
        return;
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        int i;
        int k;
        int l;
        int j1;
        i = motionevent.getAction();
        l = (0xff00 & i) >> 8;
        j1 = motionevent.getPointerId(l);
        k = motionevent.getPointerCount();
        i & 0xff;
        JVM INSTR tableswitch 0 6: default 80
    //                   0 82
    //                   1 156
    //                   2 205
    //                   3 80
    //                   4 80
    //                   5 82
    //                   6 156;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L2 _L3
_L1:
        return true;
_L2:
        float f = motionevent.getX(l) * getHorizontalRatioToVirtual();
        float f2 = motionevent.getY(l) * getVerticalRatioToVirtual();
        getTouchState().put(Integer.valueOf(j1), new TouchPointer(j1, f, f2));
        if(hasGameTouchListener())
            getGameTouchListener().down(j1, f, f2);
        continue; /* Loop/switch isn't completed */
_L3:
        if(getTouchState().containsKey(Integer.valueOf(j1)))
            getTouchState().remove(Integer.valueOf(j1));
        if(hasGameTouchListener())
            getGameTouchListener().up(j1);
        if(true) goto _L1; else goto _L4
_L4:
        int j = 0;
        while(j < k) 
        {
            int i1 = motionevent.getPointerId(j);
            if(i1 != -1 && getTouchState().containsKey(Integer.valueOf(i1)))
            {
                view = (TouchPointer)getTouchState().get(Integer.valueOf(i1));
                float f1 = motionevent.getX(j) * getHorizontalRatioToVirtual();
                float f3 = motionevent.getY(j) * getVerticalRatioToVirtual();
                view.setX(f1);
                view.setY(f3);
                if(hasGameTouchListener())
                    getGameTouchListener().move(i1, f1, f3);
            }
            j++;
        }
        if(true) goto _L1; else goto _L5
_L5:
    }

    public void orientationDisable()
    {
        if(getOrientation() == null)
        {
            return;
        } else
        {
            getSensorManager().registerListener(null, getOrientation(), 1);
            setOrientation(null);
            setSlopeState(null);
            return;
        }
    }

    public void orientationEnable()
    {
        if(getSensorManager() != null && getOrientation() == null)
        {
            List list = getSensorManager().getSensorList(3);
            if(list.size() > 0)
            {
                setOrientation((Sensor)list.get(0));
                setSlopeState(new SlopeState(0.0F, 0.0F));
                getSensorManager().registerListener(this, getOrientation(), 1);
                return;
            }
        }
    }

    public void pause()
    {
        if(!isEnded() && !isPausing())
        {
            setPlaying(false);
            setPausing(true);
            setEnded(false);
            if(isGaming())
            {
                getGame().pause();
                return;
            }
        }
    }

    public float realToVirtualX(float f)
    {
        if(!isGaming())
            return 1.0F;
        else
            return getHorizontalRatioToVirtual() * f;
    }

    public float realToVirtualY(float f)
    {
        if(!isGaming())
            return 1.0F;
        else
            return getVerticalRatioToVirtual() * f;
    }

    public void run()
    {
        do
        {
            do
            {
                do
                {
                    if(isEnded())
                        return;
                    int i;
                    int j;
                    Object obj;
                    Exception exception;
                    Bitmap bitmap;
                    Object obj1;
                    Exception exception2;
                    Canvas canvas;
                    try
                    {
                        Thread.sleep(getWaitTime());
                    }
                    catch(Exception exception1) { }
                } while(isPausing() || !isGaming());
                canvas = holder.lockCanvas();
            } while(canvas == null);
            if(!getGame().update())
            {
                holder.unlockCanvasAndPost(canvas);
            } else
            {
                obj = null;
                bitmap = null;
                if(isScreenShooting())
                {
                    j = canvas.getWidth();
                    i = canvas.getHeight();
                    if(isGaming())
                    {
                        j = (int)getGame().getVirtualScreenWidth();
                        i = (int)getGame().getVirtualScreenHeight();
                    }
                    bitmap = Bitmap.createBitmap(j, i, android.graphics.Bitmap.Config.ARGB_8888);
                    obj = new Canvas(bitmap);
                }
                canvas.scale(getHorizontalRatioToReal(), getVerticalRatioToReal());
                if(isFilteringScreen())
                    canvas.drawColor(getCanvasColor());
                if(isScreenShooting())
                {
label0:
                    {
                        setScreenShooting(false);
                        getGame().draw(((Canvas) (obj)));
                        obj1 = null;
                        try
                        {
                            obj = new File(getScreenShotDirectory());
                            if(!((File) (obj)).exists())
                                ((File) (obj)).mkdirs();
                            obj = new FileOutputStream((new StringBuilder()).append(obj).append("/").append(getScreenShotFileName()).toString());
                        }
                        // Misplaced declaration of an exception variable
                        catch(Exception exception)
                        {
                            exception = obj1;
                            break label0;
                        }
                        try
                        {
                            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, ((java.io.OutputStream) (obj)));
                        }
                        // Misplaced declaration of an exception variable
                        catch(Exception exception2) { }
                    }
                    if(obj != null)
                        try
                        {
                            ((FileOutputStream) (obj)).close();
                        }
                        // Misplaced declaration of an exception variable
                        catch(Object obj) { }
                    canvas.drawBitmap(bitmap, 0.0F, 0.0F, null);
                } else
                {
                    getGame().draw(canvas);
                }
                holder.unlockCanvasAndPost(canvas);
            }
        } while(true);
    }

    public void screenShooting(String s, String s1)
    {
        setScreenShooting(true);
        setScreenShotDirectory(s);
        setScreenShotFileName(s1);
    }

    public void setCanvasColor(int i)
    {
        canvasColor = i;
    }

    public void setConfiguration(Configuration configuration1)
    {
        configuration = configuration1;
    }

    public void setDisplay(Display display1)
    {
        display = display1;
    }

    public void setFilteringScreen(boolean flag)
    {
        filteringScreen = flag;
    }

    public Game setGame(Game game1)
    {
        Game game2 = null;
        if(isGaming())
            game2 = game;
        game = game1;
        game.setEngine(this);
        game.initialize();
        return game2;
    }

    public void setGameTouchListener(GameTouchListener gametouchlistener)
    {
        gameTouchListener = gametouchlistener;
    }

    public void setResources(Resources resources1)
    {
        resources = resources1;
    }

    public void setScreenShooting(boolean flag)
    {
        screenShooting = flag;
    }

    public void setScreenShotDirectory(String s)
    {
        screenShotDirectory = s;
    }

    public void setScreenShotFileName(String s)
    {
        screenShotFileName = s;
    }

    public void setWaitTime(int i)
    {
        waitTime = i;
    }

    public void start()
    {
        if(!isEnded() && !isPlaying())
        {
            if(!isPausing())
                getThread().start();
            setPlaying(true);
            setPausing(false);
            setEnded(false);
            if(isGaming())
            {
                getGame().start();
                return;
            }
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        setRealScreenWidth(j);
        setRealScreenHeight(k);
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
    }

    public void touchable(boolean flag)
    {
        if(isTouchable())
        {
            return;
        } else
        {
            setTouchable(true);
            setTouchState(new TouchState());
            setOnTouchListener(this);
            return;
        }
    }

    public void unTouchable()
    {
        if(!isTouchable())
        {
            return;
        } else
        {
            setTouchable(false);
            setOnTouchListener(null);
            setTouchState(null);
            return;
        }
    }

    public float virtualToReadY(float f)
    {
        if(!isGaming())
            return 1.0F;
        else
            return getVerticalRatioToReal() * f;
    }

    public float virtualToRealX(float f)
    {
        if(!isGaming())
            return 1.0F;
        else
            return getHorizontalRatioToReal() * f;
    }

    private int canvasColor;
    private Configuration configuration;
    private Display display;
    private boolean ended;
    private boolean filteringScreen;
    private Game game;
    private GameTouchListener gameTouchListener;
    private SurfaceHolder holder;
    private Sensor orientation;
    private boolean pausing;
    private boolean playing;
    private int realScreenHeight;
    private int realScreenWidth;
    private Resources resources;
    private boolean screenShooting;
    private String screenShotDirectory;
    private String screenShotFileName;
    private SensorManager sensorManager;
    private SlopeState slopeState;
    private Thread thread;
    private TouchState touchState;
    private boolean touchable;
    private int waitTime;
    private WindowManager windowManager;
}
