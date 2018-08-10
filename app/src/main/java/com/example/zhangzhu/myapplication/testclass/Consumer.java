package com.example.zhangzhu.myapplication.testclass;

import android.util.Log;

import com.example.zhangzhu.myapplication.MainActivity;

/**
 * Created by zhangzhu on 2018/7/17.
 */

public class Consumer implements Runnable {
    @Override
    public synchronized void run() {
        // TODO Auto-generated method stub
        int count = 10;
        while(count > 0) {
            synchronized (MainActivity.obj) {

                Log.i("zzzzz", "B");
                count --;
                MainActivity.obj.notify(); // 主动释放对象锁

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
