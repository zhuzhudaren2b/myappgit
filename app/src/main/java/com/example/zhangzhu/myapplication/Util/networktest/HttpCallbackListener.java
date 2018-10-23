package com.example.zhangzhu.myapplication.util.networktest;

public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);

}