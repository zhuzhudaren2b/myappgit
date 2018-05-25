package com.example.zhangzhu.myapplication;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhangzhu.myapplication.CustomView.SuccessCatchPushView;
import com.example.zhangzhu.myapplication.Util.CommonUtils;
import com.example.zhangzhu.myapplication.Util.DialerToast;
import com.example.zhangzhu.myapplication.Util.networktest.HttpUtilImprove;
import com.example.zhangzhu.myapplication.receiver.HomeButtonCallBackReceiver;
import com.example.zhangzhu.myapplication.rx.RxJavaTest;
import com.example.zhangzhu.myapplication.service.TestService;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    Button btn;
    TextView textView;
    TextView textView2;
    TestPoPLayout tpp;
    SuccessCatchPushView mSuccessCatchPushView;
    boolean isShow = false;

    private HomeButtonCallBackReceiver mHomeButtonCallBackReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
        initMethodEntry();
    }

    /*初始化控件*/
    private void initView() {
        btn = findViewById(R.id.jumpButton);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView_2);
        btn.setOnClickListener(this);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);

        tpp = (TestPoPLayout) findViewById(R.id.test_pop_layout);
        mSuccessCatchPushView = (SuccessCatchPushView) findViewById(R.id.success_catch_push);
    }

    @Override
    public void onClick(View v) {
        //something to do
        switch (v.getId()) {
            case R.id.jumpButton:
//                DialerToast.showMessage(MainActivity.this, "1", 1);
                break;
            case R.id.textView:
//                DialerToast.showMessage(MainActivity.this, "2", 1);
                break;
            case R.id.textView_2:
//                DialerToast.showMessage(MainActivity.this, "3", 1);
                break;
            default:
                break;
        }
    }

    public void initMethodEntry() {
        /*测试各类功能activity的入口*/
//        startIndexActivity(1);

        /*测试6.0权限*/
//        getPermission();
//        new CheckPermission(this).checkPermission();

        /*测试联网*/
//        httpSendTest();

         /*测试fragment dialog蒙版*/
//        ProfitGuideDialogFragment fragment = ProfitGuideDialogFragment.newInstance(0);
//        getSupportFragmentManager().beginTransaction().add(fragment, ProfitGuideDialogFragment.class.getSimpleName()).commitAllowingStateLoss();

        /*测试homekey receiver*/
//        mHomeButtonCallBackReceiver = new HomeButtonCallBackReceiver();
//        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
//        registerReceiver(mHomeButtonCallBackReceiver, intentFilter);

        /*测试service*/
//        MyApplication.context.startService(new Intent(MyApplication.context, TestService.class));

        /*测试notification*/
//        testNotification();

        /*测试toast*/
//        DialerToast.showMessage(MainActivity.this, "Me TEST bottom:"+ Gravity.BOTTOM+", center:"+Gravity.CENTER, 0, Gravity.BOTTOM, 0,500);

        /*自定义view和动画相关*/
//        hideOrShow();
//        playAnimator(tpp);

        RxJavaTest.start();
    }

    /*测试各类功能activity的入口*/
    public void startIndexActivity(int index) {
        Intent startIndexActivity;
        switch(index){
            case 1:
                startIndexActivity = new Intent(MainActivity.this, RecyclerViewTestActivity.class);
                break;
            case 2:
                startIndexActivity = new Intent(MainActivity.this, ConversionActivity.class);
                break;
            case 3:
                startIndexActivity = new Intent(MainActivity.this, FragmentTestActivity.class);
                break;
            case 4:
                startIndexActivity = new Intent(MainActivity.this, SencerActivity.class);
                break;
            case 5:
                startIndexActivity = new Intent(MainActivity.this, FragmentTestActivity.class);
                break;
            case 6:
                startIndexActivity = new Intent(MainActivity.this, FragmentTestActivity.class);
                break;
            default:
                startIndexActivity = new Intent(MainActivity.this, RecyclerViewTestActivity.class);
        }
        startActivityForResult(startIndexActivity, 110);
    }

    private void testNotification() {
        AppNotification an = new AppNotification(this);
        an.notifyStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                CommonUtils.showToast(this,"add_item",0);
                CommonUtils.showAlertDialog(this);
                break;
            case R.id.remove_item:
                CommonUtils.showToast(this,"Remove_item",0);
                CommonUtils.showProgressDialog(this);
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){
            case 110:
                if(resultCode == RESULT_OK)
                    CommonUtils.Log("onActivityResult");
                break;
            default:
        }

    }

    /*启动相机*/
    public void startCamera(){
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivity(intent);
    }

    /*自定义view弹框*/
    public void someOneCatchTheDoll() {
        String url = "http://cootek-dialer-download.oss-cn-hangzhou.aliyuncs.com/social_head/head/14128675938765421684.png";
        String dollName = "大皮卡丘";
        String nickName = "张竹";
        mSuccessCatchPushView.showPushContent(mSuccessCatchPushView,url,nickName,dollName);
    }

    public void playAnimator(final TestPoPLayout view){
        view.setVisibility(View.VISIBLE);
        view.setAlpha(1);
        ObjectAnimator valueAnimatorMe = ObjectAnimator.ofFloat(view, "translationX", 0,50,-50,0);;
        valueAnimatorMe.setDuration(800);
        valueAnimatorMe.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setEndAnim(view);
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
        valueAnimatorMe.start();

    }

    public void hideOrShow(){

        Log.d("zhangzhu","hideOrShow isShow "+isShow);
        if(!isShow){
            tpp.setAlpha(1);
            tpp.setVisibility(View.VISIBLE);
            setStartAnim();
            isShow = true;
        }else{
//            setEndAnim();

        }
    }

    public void setStartAnim(){
        ObjectAnimator valueAnimatorMe = ObjectAnimator.ofFloat(tpp, "translationX", 0,50,-50,0);;
        valueAnimatorMe.setDuration(800);
        valueAnimatorMe.start();
    }

    public void setEndAnim(final TestPoPLayout view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", 0, -300);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "alpha", 1, 0);
        animator.setDuration(1000);
        animator2.setDuration(1000);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mHomeButtonCallBackReceiver);
    }

    public void getPermission(){
        Log.d("zhangzhu","get permission item");
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_CONTACTS},
                11);
    }

    public void httpSendTest() {
        HttpUtilImprove.sendOkHttpRequest("www.baidu.com",new okhttp3.Callback(){
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().toString();
            }
        });
    }
}
