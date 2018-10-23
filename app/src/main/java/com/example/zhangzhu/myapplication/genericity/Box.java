package com.example.zhangzhu.myapplication.genericity;

import java.util.List;

/**
 * Created by zhangzhu on 2018/10/22.
 */

public class Box<T> {
    private T data;

    public Box() {

    }

    public Box(T t) {
        this();
        data = t;
    }
    public T getData() {
        return data;
    }

    //单独的泛型方法申明
    public final <V extends String> List<V> func(List<V> v) {
        return v;
    }
    //单独的泛型方法申明2
    public <E> int func2(E e) {
        if (e instanceof Integer)
        return 1;
        return 0;
    }
    //单独的泛型方法申明3
    public <K, V> void func3(K k, V v) {

    }

}
