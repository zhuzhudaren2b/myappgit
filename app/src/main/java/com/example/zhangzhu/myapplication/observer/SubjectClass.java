package com.example.zhangzhu.myapplication.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangzhu on 2018/10/22.
 */

public class SubjectClass implements SubjectInterface {
    public List<ObserverInterface> mList = new ArrayList<>();

    @Override
    public void addObserver(ObserverInterface oc) {
        mList.add(oc);
    }

    @Override
    public void removeObserver(ObserverInterface oc) {
        mList.remove(oc);
    }

    @Override
    public void notifyAllObserver() {
        for (ObserverInterface oc: mList) {
            oc.update();
        }
    }
}
