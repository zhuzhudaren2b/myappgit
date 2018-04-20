package com.example.zhangzhu.myapplication;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by zhangzhu on 2018/1/5.
 */

public class TestPoPLayout extends RelativeLayout {
    private Context mContext;
    private CircleImageView headImageView;
    private TextView headText;
    public TestPoPLayout(Context context) {
        super(context);
        initView(context);
    }

    public TestPoPLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TestPoPLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context){
        mContext = context;
        View view = inflate(getContext(), R.layout.popup_layout, this);
        headImageView = (CircleImageView) findViewById(R.id.img_first);
        headText = (TextView) findViewById(R.id.text_first_linear);
        String str="<font color='#92622f'>抓到了</font>";
        StringBuilder sb = new StringBuilder("小红帽");
        sb.append(str).append("小黄鸭!");
//        headText.setText(Html.fromHtml(sb.toString()));
    }
}
