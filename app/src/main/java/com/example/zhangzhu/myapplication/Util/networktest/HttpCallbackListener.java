package com.example.zhangzhu.myapplication.Util.networktest;

public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);

}