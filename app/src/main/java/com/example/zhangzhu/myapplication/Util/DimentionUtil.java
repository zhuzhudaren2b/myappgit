package com.example.zhangzhu.myapplication.util;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.example.zhangzhu.myapplication.MyApplication;

import java.util.Locale;

public class DimentionUtil {
	private static float ratio;
	private static int sWidth;
	private static int sHeight;
	public static final String MODEL = Build.MODEL.toLowerCase(Locale.US);
	static {
		calcuateRatio();
	}

	public static int getDimen(int resId) {
		float size = MyApplication.context.getResources()
				.getDimension(resId);
		return (int)size;
	}
	
	public static int getTextSize(int resId) {
		float size = MyApplication.context.getResources()
				.getDimension(resId);
		return scaleDimen(size);
	}

	public static int scaleDimen(float size) {
		return Math.round(size * ratio);
	}
	
	public static void calcuateRatio() {
		ratio = 1;
		DisplayMetrics metrics = new DisplayMetrics();
		WindowManager windM = (WindowManager) MyApplication.context
				.getSystemService(Context.WINDOW_SERVICE);
		windM.getDefaultDisplay().getMetrics(metrics);
		float xdpi = metrics.xdpi;
		float ydpi = metrics.ydpi;
		int xpixel = metrics.widthPixels;
		int ypixel = metrics.heightPixels;
		sWidth = xpixel;
		sHeight = ypixel;

	}
	
	public static int getFullWidth() {
		return sWidth;
	}
	
	public static int getFullHeight() {
		return sHeight;
	}

	public static int dp2px(float dpValue) {
		float scale = MyApplication.context.getResources().getDisplayMetrics().density;
		return (int)(dpValue * scale + 0.5F);
	}

}
