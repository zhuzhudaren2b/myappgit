package com.example.zhangzhu.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by zhangzhu on 2018/8/30.
 */

public class MyRelativeLayout extends RelativeLayout {
    int lastX;
    int lastY;
    boolean intercepted = false;

    public MyRelativeLayout(Context context) {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return super.onInterceptTouchEvent(ev);
//        Log.i("zhangzhu123","onInterceptTouchEvent "+intercepted);
//
//        if (intercepted) {
//            intercepted = false;
//            return true;
//        } else {
//            return false;
//        }
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return false;
            case MotionEvent.ACTION_MOVE:   //表示父类需要
                return false;
            case MotionEvent.ACTION_UP:
                return false;
            default:
                break;
        }
        return false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("TAG", "You down layout");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("TAG", "You up layout");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("TAG", "You move layout");
        }
        return super.onTouchEvent(event);
    }
}
