package com.example.zhangzhu.myapplication.invoke;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by zhangzhu on 2018/10/23.
 */

public class InvokeTestUtil {
    public InvokeTestUtil() {
        init();
    }

    private void init() {
        Log.i("zzzzz", "InvokeTestUtil init");
        Class<?> c = null;
        try {
            c = Class.forName("com.example.zhangzhu.myapplication.invoke.TestClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
//            Object p = c.newInstance();

            Constructor<?> con = c.getConstructor(String.class);
            Object p = con.newInstance("123");

            Field name = c.getDeclaredField("index");
            name.set(p, "456");


            Method set = c.getMethod("getIndex");
            set.invoke(p);
            Method set2 = c.getMethod("printIndex", String.class);
            set2.invoke(p, "hahaha");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
