package com.example.zhangzhu.myapplication;

import android.view.View;

/**
 * Created by zhangzhu on 2018/4/20.
 */

public class GitTestClass {
    /*add line 1*/
    interface Action {
        void callback();
    }

    public static void showToast(View view, final Action a) {
        view.post(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    a.callback();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
