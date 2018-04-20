package com.example.zhangzhu.myapplication.CustomView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.zhangzhu.myapplication.R;

/**
 * Created by zhangzhu on 2017/12/23.
 */

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button button = (Button)findViewById(R.id.title_back);
    }
}
