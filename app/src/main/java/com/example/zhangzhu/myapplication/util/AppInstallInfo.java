package com.example.zhangzhu.myapplication.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangzhu on 2018/11/19.
 */

public class AppInstallInfo {
    private static String[] appArray = {"com.sina.weibo", "com.google.android.youtube", "com.tencent.mm",
            "com.android.camera", "com.huawei.appmarket", "com.tencent.mobileqq", "com.qzone",
            "com.taobao.taobao", "com.jingdong.app.mall", "com.ss.android.article.news",
            "com.ss.android.ugc.aweme", "com.smile.gifmaker", "com.qiyi.video", "com.mt.mtxx.mtxx",
            "com.eg.android.AlipayGphone", "com.dianping.v1", "com.autonavi.minimap"};

    public static void startTest(Context context) {
        List<String> appList = new ArrayList();
        appList = Arrays.asList(appArray);
        for (String app : appList) {
            isAppInstalled(context, app);
        }
    }

    private static boolean isAppInstalled(Context context, String packagename)
    {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packagename, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        } catch (RuntimeException e) {
            packageInfo = null;
        }

        if(packageInfo ==null){
            Log.i("AppInstallInfo",packagename + " 没有安装");
            return false;
        }else{
            Log.i("AppInstallInfo",packagename + " 已经安装");
            return true;
        }
    }

}
