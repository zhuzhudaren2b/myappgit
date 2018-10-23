package com.example.zhangzhu.myapplication.observer;

/**
 * Created by zhangzhu on 2018/10/22.
 */

public class ObserverTestUtil {
    public ObserverTestUtil() {
        init();
    }

    private void init() {
        SubjectClass sc = new SubjectClass();
        ObserverInterface oi_1 = new ObserverClass(1);
        ObserverInterface oi_2 = new ObserverClass(2);
        ObserverInterface oi_3 = new ObserverClass(3);
        sc.addObserver(oi_1);
        sc.addObserver(oi_2);
        sc.addObserver(oi_3);
        sc.removeObserver(oi_2);
        sc.notifyAllObserver();
    }
}
