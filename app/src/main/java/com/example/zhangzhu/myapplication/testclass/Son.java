package com.example.zhangzhu.myapplication.testclass;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by zhangzhu on 2018/7/5.
 */

public class Son extends Father {
    public String name;
    public void play(){
        this.name = "";
        super.name = "good";
    }


}
