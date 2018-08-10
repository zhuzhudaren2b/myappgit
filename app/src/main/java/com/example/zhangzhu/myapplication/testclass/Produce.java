package com.example.zhangzhu.myapplication.testclass;


import android.util.Log;

import com.example.zhangzhu.myapplication.MainActivity;

/**
 * Created by zhangzhu on 2018/7/17.
 */

public class Produce implements Runnable {
    @Override
    public void run() {
        int count = 10;
        while(count > 0) {
            synchronized (MainActivity.obj) {

                //System.out.print("count = " + count);
                Log.i("zzzzz", "A");
                count--;
                MainActivity.obj.notify();

                try {
                    MainActivity.obj.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
