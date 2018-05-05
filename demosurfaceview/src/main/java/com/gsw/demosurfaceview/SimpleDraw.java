package com.gsw.demosurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @author gaoshiwei
 * @date 2017/11/28
 * 使用SurfaceView实现的画图板Demo
 */

public class SimpleDraw extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private Canvas mCanvas;
    private boolean mIsDrawing;
    private SurfaceHolder mHolder;


    private Paint mPaint;
    private Path mPath;


    public SimpleDraw(Context context) {
        super(context);
        init();
    }

    public SimpleDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SimpleDraw(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mHolder = getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);

        //
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(40);


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

        long startTime = System.currentTimeMillis();

        while (mIsDrawing) {
            draw();
        }

        long endTime = System.currentTimeMillis();
        if (endTime - startTime < 100) {
            try {
                Thread.sleep(100 - (endTime - startTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     */
    private void draw() {
        try {
            mCanvas = mHolder.lockCanvas();
            // 背景绘制
            mCanvas.drawColor(Color.BLACK);
            mCanvas.drawPath(mPath, mPaint);

        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (mCanvas != null) {
                mHolder.unlockCanvasAndPost(mCanvas);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //
        int x = (int) event.getX();
        int y = (int) event.getY();
        //
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return true;

    }
}
