package com.example.zhangzhu.myapplication.CustomView;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.zhangzhu.myapplication.R;
import com.example.zhangzhu.myapplication.Util.GlideCircleTransform;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by zhangzhu on 2018/1/5.
 */

public class SuccessCatchPushView extends RelativeLayout {

    private Context mContext;
    private ImageView headImageView;
    private TextView nickNameTextView;
    private TextView dollNameTextView;

    public SuccessCatchPushView(Context context) {
        super(context);
        initView(context);
    }

    public SuccessCatchPushView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public SuccessCatchPushView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context){
        mContext = context;
        View view = inflate(mContext, R.layout.view_doll_catch_push, this);
        headImageView = (ImageView) findViewById(R.id.img_head);
        nickNameTextView = (TextView) findViewById(R.id.catch_content);
        dollNameTextView = (TextView) findViewById(R.id.catch_content2);
    }

    public void showPushContent(SuccessCatchPushView pushView, String url, String nickName, String dollName){
        pushView.setVisibility(View.VISIBLE);
        pushView.setAlpha(1);
//        Glide.with(mContext.getApplicationContext()).load(url)
//                .error(R.drawable.catch_doll_push_default)
//                .placeholder(R.drawable.catch_doll_push_default)
//                .into(headImageView);

        Glide.with(mContext.getApplicationContext())
                .load(url)
                .error(R.drawable.catch_doll_push_default)
                .transform(new GlideCircleTransform(headImageView.getContext()))
                .into(headImageView);
        changeTextContent(nickName, dollName);
//        startAnimator(pushView);
    }

    public void changeTextContent(String nickName, String dollName){
        String str="<font color='#92622f'>成功抓到了</font>";
        StringBuilder sb = new StringBuilder(str);
        sb.append(dollName).append("!");
        nickNameTextView.setText(nickName);
        dollNameTextView.setText(Html.fromHtml(sb.toString()));
    }

    public void startAnimator(final SuccessCatchPushView pushView){
        pushView.setVisibility(View.VISIBLE);
        pushView.setAlpha(1);
        ObjectAnimator animator = ObjectAnimator.ofFloat(pushView, "translationX", 0,50,-50,0);
        animator.setDuration(800);
        animator.start();
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                pushView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        endAnimator(pushView);
                    }
                },3000);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }

    public void endAnimator(final SuccessCatchPushView pushView){
        ObjectAnimator animator = ObjectAnimator.ofFloat(pushView, "translationX", 0, -300);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(pushView, "alpha", 1,0);
        animator.setDuration(1000);
        animator2.setDuration(1000);
        animator2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                pushView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animator, animator2);
        set.start();
    }
}
