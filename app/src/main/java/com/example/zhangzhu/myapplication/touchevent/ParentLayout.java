package com.example.zhangzhu.myapplication.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class ParentLayout extends RelativeLayout {
    public static final String TAG = "TouchEventTestTag";

    public ParentLayout(Context context) {
        super(context);
    }

    public ParentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ParentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "ParentLayout--dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "ParentLayout--dispatchTouchEvent ACTION_UP");
                break;
            default:
                break;
        }
//        return true;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "ParentLayout--onInterceptTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "ParentLayout--onInterceptTouchEvent ACTION_UP");
                break;
            default:
                break;
        }
        return false;
//        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "ParentLayout--onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "ParentLayout--onTouchEvent ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return true;
//        return super.onTouchEvent(event);
    }
}
