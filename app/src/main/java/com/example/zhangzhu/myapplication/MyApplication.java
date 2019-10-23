package com.example.zhangzhu.myapplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by zhangzhu on 2017/12/24.
 */

public class MyApplication extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
