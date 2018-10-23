package com.example.zhangzhu.myapplication.genericity;

import android.util.Log;

/**
 * Created by zhangzhu on 2018/10/23.
 */

public class Box2<K, V> {
    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }

    private K k;
    private V v;
    public Box2(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public static void main(String[] args) {
        Box2<Integer, String> box = new Box2<>(23, "jodan");
        Log.i("Box2", "result is : " + box.getK() + box.getV());
    }
}
