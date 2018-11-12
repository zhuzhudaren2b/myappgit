package com.example.myjavatest.producecomsumer;

/**
 * Created by zhangzhu on 2018/11/7.
 */

public class Consumer implements Runnable {
    public PublicResource mPublicResource;
    public String mThreadName;
    public Consumer(PublicResource publicResource, String name) {
        mPublicResource = publicResource;
        mThreadName = name;
    }
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            try {
                Thread.sleep((long)Math.random()*1000);
                mPublicResource.decrease(mThreadName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
