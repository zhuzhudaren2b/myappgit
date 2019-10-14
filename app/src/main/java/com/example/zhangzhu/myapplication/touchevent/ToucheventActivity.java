package com.example.zhangzhu.myapplication.touchevent;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.zhangzhu.myapplication.R;

public class ToucheventActivity extends Activity {

    public static final String TAG = "TouchEventTestTag";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touchevent_layout);
        TextView textView = findViewById(R.id.my_textview);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "ToucheventActivity textView onClick!!");
            }
        });
        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "ToucheventActivity textView onTouch~~");
                return false;
            }
        });
    }
}
