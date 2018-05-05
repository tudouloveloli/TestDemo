package com.gsw.demosurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @author gaoshiwei
 * @date 2017/11/28
 */

public class SurfaceViewTemPlate extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private static final String TAG = "SurfaceViewTemPlate";
    // SurfaceHolder
    private SurfaceHolder mHolder;
    // 绘图的Canvas
    private Canvas mCanvas;
    // 子线程标志位
    private boolean mIsDrawing;


    public SurfaceViewTemPlate(Context context) {
        super(context);
        initView();
    }

    public SurfaceViewTemPlate(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SurfaceViewTemPlate(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        // 初始化surfaceView 所需
        mHolder = getHolder();
        mHolder.addCallback(this);
        // Set whether this view can receive the focus.
        setFocusable(true);
        //Set whether this view can receive focus while in touch mode.
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);


    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing = false;

    }

    @Override
    public void run() {
        // 有些情况下并不需要一直绘制 所以可以加入一下的的优化方案 startTime endTime
        long startTime = System.currentTimeMillis();

        while (mIsDrawing) {
            draw();
        }

        long endTime = System.currentTimeMillis();
        // 100ms 是个大概的经验值
        if (endTime - startTime < 100) {
            try {
                Thread.sleep(100 - (endTime - startTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 绘制
     */
    private void draw() {
        try {
            // SurfaceHolder对象通过 lockCanvas()获得Canvas对象
            mCanvas = mHolder.lockCanvas();
            // 拿到 Canvas后就开始搞事情把   draw something ... （绘制逻辑）

        } catch (Exception e) {
            Log.d(TAG, "异常信息：" + e.getMessage());
        } finally {
            if (mCanvas != null) {
                // SurfaceHolder对象通过 unlockCanvasAndPost()对画布的内容进行提交。
                mHolder.unlockCanvasAndPost(mCanvas);
            }
        }

    }
}
