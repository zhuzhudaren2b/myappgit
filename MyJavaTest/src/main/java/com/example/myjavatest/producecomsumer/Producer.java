package com.example.myjavatest.producecomsumer;

/**
 * Created by zhangzhu on 2018/11/7.
 */

public class Producer implements Runnable {
    public PublicResource mPublicResource;
    public String mThreadName;
    public Producer(PublicResource publicResource, String name) {
        mPublicResource = publicResource;
        mThreadName = name;

    }
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            try {
                Thread.sleep((long)Math.random()*1000);
                mPublicResource.increase(mThreadName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
