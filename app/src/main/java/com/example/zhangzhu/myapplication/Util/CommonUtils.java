package com.example.zhangzhu.myapplication.util;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.example.zhangzhu.myapplication.MyApplication;
import com.example.zhangzhu.myapplication.R;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by zhangzhu on 2017/12/23.
 */

public class CommonUtils {

    /*Toast*/
    public static void showToast(Context context, String string, int type){
        if (context == null)
            return;
        if (type == 0)
            Toast.makeText(context,string,Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context,string,Toast.LENGTH_LONG).show();
    }

    /*log*/
    public static void Log(String msg){
        Log.d("Test",msg);
    }

    /*AlertDialog*/
    public static void showAlertDialog(Context context) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("This is Dialog");
        dialog.setMessage("Something important");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    public static void showProgressDialog(Context context) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setTitle("This is Dialog");
        dialog.setMessage("Something important");
        dialog.setCancelable(true);
        dialog.show();
    }

    public static void showNotification(Context context) {
//        PendingIntent pi = PendingIntent.getActivity(context, 0, intent, 0);
        NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("This is content title")
                .setContentText("This is content text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .setAutoCancel(true)
//                .setContentIntent(pi)
                //        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
                //        .setVibrate(new long[]{0, 1000, 1000, 1000})
                //        .setLights(Color.GREEN, 1000, 1000)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                //        .setStyle(new NotificationCompat.BigTextStyle().bigText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."))
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher_foreground)))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .build();
        manager.notify(1, notification);
    }

    public static void setAlarm() {
        AlarmManager manager = (AlarmManager) MyApplication.context.getSystemService(Context.ALARM_SERVICE);
        long triggerTime = SystemClock.elapsedRealtime();
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerTime,null);//pendingIntent
    }

    public static boolean isTelephonyCalling(Context mContext){
        boolean calling = false;
        TelephonyManager telephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        if(TelephonyManager.CALL_STATE_OFFHOOK==telephonyManager.getCallState()||TelephonyManager.CALL_STATE_RINGING==telephonyManager.getCallState()){
            calling = true;
        }
        return calling;
    }

    public static int getTelephonyCallState(Context mContext){
        boolean state;
        TelephonyManager telephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);

        return telephonyManager.getCallState();
    }

}
