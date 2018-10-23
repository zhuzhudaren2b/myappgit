package com.example.zhangzhu.myapplication.genericity;

import android.util.Log;

import java.lang.ref.SoftReference;
import java.util.List;

/**
 * Created by zhangzhu on 2018/10/22.
 */

public class BoxTestUtil {
    public BoxTestUtil() {
        init();
    }

    private final void init() {
        Box<Number> box1 = new Box<Number>(99);
        Box<Integer> box2 = new Box<Integer>(88);
        printData(box1);
        printData(box2);

        SoftReference<Box<Integer>> sb = new SoftReference<Box<Integer>>(box2);
        box2 = sb.get();
    }

    public static void printData(Box<? extends Number> box) {
        Log.i("BoxTestUtil", "data is : " + box.getData());
    }

    public Box<? extends Number> getBox() {
        return new Box<Number>(99);
    }

    public class BoxSon<T> extends Box<T> {


    }

}
