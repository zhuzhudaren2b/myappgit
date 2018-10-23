package com.example.zhangzhu.myapplication.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangzhu on 2018/10/23.
 */

public class PoolUtils {
    public ExecutorService es = Executors.newFixedThreadPool(3);
    public Runnable mRunnable = new Runnable() {
        @Override
        public void run() {

        }
    };
    public PoolUtils() {
        es.execute(mRunnable);
        es.shutdown();
    }
}
