package com.example.zhangzhu.myapplication.observer;

/**
 * Created by zhangzhu on 2018/10/22.
 */

public interface SubjectInterface {
    void addObserver(ObserverInterface sc);
    void removeObserver(ObserverInterface sc);
    void notifyAllObserver();
}
