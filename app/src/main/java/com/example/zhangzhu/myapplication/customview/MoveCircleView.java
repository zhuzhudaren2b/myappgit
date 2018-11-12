package com.example.zhangzhu.myapplication.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zhangzhu on 2018/11/11.
 */

public class MoveCircleView extends View {
    private Paint mPaint = new Paint();
    float X;
    float Y;
    public MoveCircleView(Context context) {
        super(context);
    }

    public MoveCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MoveCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(X,Y,60,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        X = event.getX();
        Y = event.getY();
        postInvalidate();
        return true;
    }
}
