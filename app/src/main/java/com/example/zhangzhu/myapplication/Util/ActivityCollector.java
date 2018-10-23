package com.example.zhangzhu.myapplication.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangzhu on 2017/12/23.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity a) {
        activities.add(a);
    }

    public static void removeActivity(Activity a) {
        activities.remove(a);
    }

    public static void finishAll(){
        for (Activity a:activities) {
            if(!a.isFinishing())
                a.finish();
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
