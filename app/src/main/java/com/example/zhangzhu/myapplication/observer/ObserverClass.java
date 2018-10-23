package com.example.zhangzhu.myapplication.observer;

import android.util.Log;

/**
 * Created by zhangzhu on 2018/10/22.
 */

public class ObserverClass extends ObserverAbsClass implements ObserverInterface {

    public ObserverClass(int index) {
        m = index;
    }

    @Override

    public ObserverClass setIndex(int index) {
        m = m*index;
        return this;
    }

    @Override
    public void update() {
//        Log.i("zzzzz", "update " + m);
    }
}
