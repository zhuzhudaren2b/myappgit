package com.example.zhangzhu.myapplication.Util;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhangzhu.myapplication.R;

public class DialerToast {

	private static Handler sHandler = new Handler();
    private static Runnable sRunnable = new Runnable() {
        @Override
        public void run() {
            sToast = null;
            sMessage = null;
            sIsShowing = false;
        }
    };

	private static boolean sIsShowing = false;
    private static Toast sToast;
    private static String sMessage;

    public static final int SHORT_DELAY = 1000;
	public static final int LONG_DELAY = 3000;

	public static void showMessage(final Context act, final int msgRes, final int len) {
        String msg = act.getString(msgRes);
        showMessage(act, msg, len);
	}

	public static void showMessage(final Context act, final String msg, final int len) {
        showMessage(act, msg, len, Gravity.BOTTOM, 0, 64);
	}

    public static void showMessage(final Context act, final int msgRes, final int len,
                                   final int gravity, final int xOffset, final int yOffset) {
        String msg = act.getString(msgRes);
        showMessage(act, msg, len, gravity, xOffset, yOffset);
    }

    public static void showMessage(final Context act, final String msg, final int len,
                                   final int gravity, final int xOffset, final int yOffset) {
        if (sToast != null && !TextUtils.isEmpty(sMessage)) {
            if (sMessage.equals(msg)) {
                return;
            }
            sToast.cancel();
            sToast = null;
            sMessage = null;
            sIsShowing = false;
            sHandler.removeCallbacks(sRunnable);
        }
        if (!sIsShowing) {
            sMessage = msg;
            sToast = Toast.makeText(act, msg, len);
            sToast.setGravity(gravity, xOffset, yOffset);
            sToast.show();
            sIsShowing = true;
            int delay = len < Toast.LENGTH_LONG ? SHORT_DELAY : LONG_DELAY;
            sHandler.postDelayed(sRunnable, delay);
        }
    }

    public static void showToast(String text, boolean isAlert, Context context) {
        if (context == null) {
            return;
        }

        RelativeLayout layout = new RelativeLayout(context);
        RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setBackgroundResource(isAlert ? R.drawable.toast_error_background : R.drawable.toast_background);
        TextView message = new TextView(context);
        message.setText(text);
        message.setSingleLine(true);
        message.setTextColor(Color.WHITE);
        message.setTextSize(TypedValue.COMPLEX_UNIT_PX, 36);
        int padding = 5;
        message.setPadding(2 * padding, padding, 2 * padding, padding);
        message.setGravity(Gravity.CENTER_VERTICAL);
        layout.addView(message,
                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
        Toast tm = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        tm.setView(layout);
        tm.setGravity(Gravity.CENTER, 0, padding);
        tm.show();
    }

    public static void  showToastWithPic(Context context) {
        Toast toast=Toast.makeText(context, "显示带图片的toast", 3000);
        toast.setGravity(Gravity.CENTER, 0, 0);
        //创建图片视图对象
        ImageView imageView= new ImageView(context);
        //设置图片
        imageView.setImageResource(R.mipmap.apple_pic);
        //获得toast的布局
        LinearLayout toastView = (LinearLayout) toast.getView();
        //设置此布局为横向的
        toastView.setOrientation(LinearLayout.HORIZONTAL);
        //将ImageView在加入到此布局中的第一个位置
        toastView.addView(imageView, 0);
        toast.show();
    }

    public static void reset(){
        sToast = null;
        sMessage = null;
        sIsShowing = false;
	}
	
}