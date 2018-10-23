package com.example.zhangzhu.myapplication;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zhangzhu.myapplication.collect.QueueTest;
import com.example.zhangzhu.myapplication.customview.SuccessCatchPushView;
import com.example.zhangzhu.myapplication.invoke.InvokeTestUtil;
import com.example.zhangzhu.myapplication.util.CommonUtils;
import com.example.zhangzhu.myapplication.util.networktest.HttpUtilImprove;
import com.example.zhangzhu.myapplication.observer.ObserverTestUtil;
import com.example.zhangzhu.myapplication.receiver.HomeButtonCallBackReceiver;
import com.example.zhangzhu.myapplication.testclass.Consumer;
import com.example.zhangzhu.myapplication.testclass.Produce;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    Button btn;
    TextView textView;
    TextView textView2;
    TestPoPLayout tpp;
    SuccessCatchPushView mSuccessCatchPushView;
    MyRelativeLayout mTestLayout;
    TextView mTestView;
    boolean isShow = false;
    public static final Object obj = new Object();

    private HomeButtonCallBackReceiver mHomeButtonCallBackReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
        initMethodEntry();
    }

    /*初始化控件*/
    @SuppressLint("ClickableViewAccessibility")
    private void initView() {
        btn = findViewById(R.id.jumpButton);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView_2);
        mTestLayout = findViewById(R.id.layout_sub);
        mTestView = findViewById(R.id.layout_sub_jump);

        btn.setOnClickListener(this);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        mTestView.setOnClickListener(this);

        tpp = (TestPoPLayout) findViewById(R.id.test_pop_layout);
        mSuccessCatchPushView = (SuccessCatchPushView) findViewById(R.id.success_catch_push);
    }

    @Override
    public void onClick(View v) {
        //something to do
        switch (v.getId()) {
            case R.id.jumpButton:
                testNotification();
//                DialerToast.showMessage(MainActivity.this, "1", 1);
                break;
            case R.id.textView:

//                DialerToast.showMessage(MainActivity.this, "2", 1);
                break;
            case R.id.textView_2:
//                DialerToast.showMessage(MainActivity.this, "3", 1);
                break;
            case R.id.layout_sub_jump:
                Log.i("TAG","sub on click ---");
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

//        RxJavaTest.start();

        //测试回调
//        GitTestClass.showToast(textView , new GitTestClass.Action() {
//            @Override
//            public void callback() {
//                DialerToast.showMessage(MainActivity.this, "test interface",0);
//            }
//        });

        //测试同步
        testSynchronized();

        //测试序列化
//        SerializeUtil.testWrite();

        //测试观察者模式
//        new ObserverTestUtil();

        //测试反射
//        new InvokeTestUtil();

        //数据结构
//        new QueueTest();
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
        an.startNotification2();
//        an.notifyStart();
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

    public void testSynchronized() {
        new Thread(new Produce()).start();
        new Thread(new Consumer()).start();
    }
}
