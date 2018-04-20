package com.example.zhangzhu.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.zhangzhu.myapplication.receiver.HomeButtonCallBackReceiver;

/**
 * Created by zhangzhu on 2018/4/2.
 */

public class TestService extends Service {

    private HomeButtonCallBackReceiver mHomeButtonCallBackReceiver;
    private String TAG = "zhangzhu2";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "TestService onCreate");
        mHomeButtonCallBackReceiver = new HomeButtonCallBackReceiver();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        registerReceiver(mHomeButtonCallBackReceiver, intentFilter);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
