package com.example.zhangzhu.myapplication.invoke;

import android.util.Log;

/**
 * Created by zhangzhu on 2018/10/23.
 */

public class TestClass {
    public String index;
    public TestClass() {
        Log.i("zzzzz", "TestClass()");
    }
    public TestClass(String s) {
        Log.i("zzzzz", String.format("TestClass('%s')", s));
        index = s;
    }

    public String getIndex() {
        Log.i("zzzzz", "getIndex() index: "+index);
        return index;
    }

    private String printIndex(String s) {
        Log.i("zzzzz", String.format("printIndex('%s')",s));
        return index;
    }

}
