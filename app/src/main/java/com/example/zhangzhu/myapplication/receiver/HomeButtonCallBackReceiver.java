package com.example.zhangzhu.myapplication.receiver;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.example.zhangzhu.myapplication.MainActivity;
import com.example.zhangzhu.myapplication.RecyclerViewTestActivity;

import java.util.List;

/**
 * Created by zhangzhu on 2018/3/27.
 */

public class HomeButtonCallBackReceiver extends BroadcastReceiver {
    public static final String SYSTEM_REASON = "reason";
    public static final String SYSTEM_HOME_KEY = "homekey";
    private String TAG = "zhangzhu2";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
            String reason = intent.getStringExtra(SYSTEM_REASON);
            Log.d(TAG, "onReceive reason is "+reason);
            Log.d(TAG, "onReceive result is "+TextUtils.equals(reason, SYSTEM_HOME_KEY));
            if (TextUtils.equals(reason, SYSTEM_HOME_KEY)) {
                Log.d(TAG, "SYSTEM_HOME_KEY");
//                FeedsHomeManager.getInst().OpenFeedsHomeActivity(context);
//                isDialerExecuteHome(context);

//                Intent startIndexActivity = new Intent(context, RecyclerViewTestActivity.class);
//                context.startActivity(startIndexActivity);

                startOtherActivity(context);
            }
        }
    }

    private boolean isDialerExecuteHome(Context context){
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> cn = am.getRunningTasks(10);
        if (cn != null && cn.size() > 0) {
            ActivityManager.RunningTaskInfo taskInfo = cn.get(0);
//            ComponentName componentName = taskInfo.topActivity;
            ComponentName componentName = taskInfo.baseActivity;
            Log.d(TAG, "isDialerExecuteHome topActivity : "+componentName.getPackageName()+", String : "+componentName.toString());
            if (!componentName.getPackageName().equals(context.getPackageName())){
                Log.d(TAG, "execute HomeKey in Other app");
                return true;
            } else {

            }
        }

        Log.d(TAG, "execute HomeKey in SmartDialer");
        return false;
    }

    public void startOtherActivity(Context context){
        Log.d(TAG, "startOtherActivity");
        Intent intent = new Intent(context, RecyclerViewTestActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

//        context.startActivity(intent);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        try {
            pendingIntent.send(); // 监听到Home键按下后立即调用startActivity启动Activity会有5s延迟
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
    }
}
