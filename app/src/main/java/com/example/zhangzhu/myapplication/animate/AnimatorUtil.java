package com.example.zhangzhu.myapplication.animate;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.widget.Button;

import com.example.zhangzhu.myapplication.MyApplication;

/**
 * Created by zhangzhu on 2018/11/12.
 */

public class AnimatorUtil {
    Button button = new Button(MyApplication.context);
    ObjectAnimator animator1 = ObjectAnimator.ofFloat(button, "alpha", 1f, 0f, 1f, 0f, 1f);
}
