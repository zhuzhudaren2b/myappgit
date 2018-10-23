package com.example.myjavatest;

/**
 * Created by zhangzhu on 2018/10/23.
 */

public class MyException extends Exception {
    private int id; // 异常码
    public MyException(String message, int id) {
        super(message);
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
