package com.example.zhangzhu.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

/**
 * Created by zhangzhu on 2018/4/28.
 */

public class AppNotification {
    private NotificationManager mNotiManager;
    private static int APP_UPDATER_ID = 99;
    private Context mCtx;
    private String test = "这是一个测试";

    public AppNotification(Context context){
        mCtx = context;
    }

    public void notifyStart() {
        if (mNotiManager == null) {
            mNotiManager = (NotificationManager) mCtx
                    .getSystemService(Context.NOTIFICATION_SERVICE);
        }
        mNotiManager.cancel(APP_UPDATER_ID);

        Notification mNotification = newNotification(
                test, 30);
        mNotification.contentView.setTextViewText(R.id.text,
                test);
        mNotiManager.notify(APP_UPDATER_ID, mNotification);
    }

    private Notification newNotification(String reminderText,
                                         int progressRate) {
        Notification noti = null;
        if (Build.VERSION.SDK_INT > 10) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(
                    mCtx);
            builder.setSmallIcon(R.mipmap.apple_pic);
            noti = builder.build();

        } else {
            noti = new Notification(R.mipmap.apple_pic,
                    reminderText,
                    System.currentTimeMillis());
            Intent pending = new Intent();
            final PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    mCtx, 0, pending, PendingIntent.FLAG_UPDATE_CURRENT);
            noti.contentIntent = pendingIntent;
        }
        Intent intent = new Intent("com.cootek.smartdialer.update_cancel");
        final PendingIntent deleteIntent = PendingIntent.getBroadcast(
                mCtx, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        noti.deleteIntent = deleteIntent;
        noti.contentView = new RemoteViews(mCtx.getPackageName(),
                R.layout.download_progress_widget);
        noti.contentView.setProgressBar(R.id.process, 100,
                progressRate, false);
        return noti;
    }
}
