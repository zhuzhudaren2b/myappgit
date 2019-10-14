package com.example.zhangzhu.myapplication.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class GrandpaLayout extends RelativeLayout {
    public static final String TAG = "TouchEventTestTag";

    public GrandpaLayout(Context context) {
        super(context);
    }

    public GrandpaLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GrandpaLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "GrandpaLayout--dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "GrandpaLayout--dispatchTouchEvent ACTION_UP");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "GrandpaLayout--onInterceptTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "GrandpaLayout--onInterceptTouchEvent ACTION_UP");
                break;
            default:
                break;
        }
        return false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "GrandpaLayout--onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "GrandpaLayout--onTouchEvent ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return super.onTouchEvent(event);
    }
}
