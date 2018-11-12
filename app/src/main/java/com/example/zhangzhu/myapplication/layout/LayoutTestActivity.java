package com.example.zhangzhu.myapplication.layout;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.zhangzhu.myapplication.BaseActivity;
import com.example.zhangzhu.myapplication.R;

/**
 * Created by zhangzhu on 2018/11/10.
 */

public class LayoutTestActivity extends BaseActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //first load method
        Button button = new Button(this);
        button.setText("test1");
        RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rl.addRule(RelativeLayout.CENTER_IN_PARENT);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        RelativeLayout mRoot = (RelativeLayout)layoutInflater.inflate(R.layout.gesture_layout, null);
        mRoot.addView(button, rl);
        setContentView(mRoot);

        //second load method
        //先setContentView(R.layout.gesture_layout);再findviewbyid 最后addview；

    }

    public void createClockDialog() {
        mediaPlayer = MediaPlayer.create(this, R.mipmap.apple_pic);
        mediaPlayer.start();

        new AlertDialog.Builder(this).setTitle("clock").setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mediaPlayer.stop();
                LayoutTestActivity.this.finish();
            }
        }).show();
    }
}
