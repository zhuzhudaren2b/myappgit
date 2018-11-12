package com.example.myjavatest.producecomsumer;

/**
 * Created by zhangzhu on 2018/11/7.
 */

public class PublicResource {
    public int num = 0;
    public int size = 3;
    public synchronized void increase(String threadName) throws InterruptedException {
        while (num >= size) {
            wait();
        }
        num ++;
        System.out.println("Producer "+threadName+" product one:  "+num);
        notify();
    }
    public synchronized void decrease(String threadName) throws InterruptedException {
        while (num <= 0) {
            wait();
        }
        num --;
        System.out.println("Consumer "+threadName+" consume one:  "+num);
        notify();
    }
}
