package com.example.zhangzhu.myapplication.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhangzhu.myapplication.R;

/**
 * Created by zhangzhu on 2018/3/14.
 */

public class ProfitGuideDialogFragment extends DialogFragment implements View.OnClickListener{

    private View backgroundView;
    private View firstStepSpace;
    private View secondStepSpace;
    private View thirdStepSpace;
    private TextView discoveryTxt;
    private TextView profitTxt;
    private TextView step1Txt;
    private TextView step2Txt;
    private TextView centerGoldText;
    private TextView closeGuide;
    int screenWidth;
    int screenHeight;

    public static ProfitGuideDialogFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("type", type);
        ProfitGuideDialogFragment fragment = new ProfitGuideDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getAndroiodScreenProperty();
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View view = inflater.inflate(R.layout.frag_dialog_enter_profit_guide, container, false);
        backgroundView = view.findViewById(R.id.backgroundView);
        firstStepSpace = view.findViewById(R.id.firstStepSpace);
        secondStepSpace = view.findViewById(R.id.secondStepSpace);
        thirdStepSpace = view.findViewById(R.id.thirdStepSpace);
        discoveryTxt = view.findViewById(R.id.discoveryTxt);
        profitTxt = view.findViewById(R.id.profitTxt);
        step1Txt = view.findViewById(R.id.step1Txt);
        step2Txt = view.findViewById(R.id.step2Txt);
        centerGoldText = view.findViewById(R.id.centerGoldText);
        closeGuide = view.findViewById(R.id.closeGuide);

        backgroundView.setOnClickListener(this);
        discoveryTxt.setOnClickListener(this);
        closeGuide.setOnClickListener(this);
        int type = getArguments().getInt("type");
        initView(type);

        setViewLocation();
        //        changeWordsColor("步骤一：点击首页底部\"发现\"按钮","\"发现\"",step1Txt);
        return view;
    }

    private void setViewLocation(){
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)discoveryTxt.getLayoutParams();
        layoutParams.rightMargin = dip2px(getActivity(), screenWidth * 3 / 8 - 30);
        discoveryTxt.setLayoutParams(layoutParams);
    }

    private void initView(int type){

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.closeGuide:
                dismissAllowingStateLoss();
                break;
            case R.id.backgroundView:
                Toast.makeText(getContext(), "click outside", Toast.LENGTH_SHORT).show();
                break;
            case R.id.discoveryTxt:
        }
    }

    public void getAndroiodScreenProperty() {
        WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        int height = dm.heightPixels;       // 屏幕高度（像素）
        float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = dm.densityDpi;     // 屏幕密度dpi（120 / 160 / 240）
        // 屏幕宽度算法:屏幕宽度（像素）/屏幕密度
        screenWidth = (int) (width / density);  // 屏幕宽度(dp)
        screenHeight = (int) (height / density);// 屏幕高度(dp)

    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public void changeWordsColor(String str , String words , TextView view){
        @SuppressLint("ResourceType")
//        String str=getActivity().getResources().getString(R.id.step1Txt);
        int fstart=str.indexOf(words);
        int fend=fstart+words.length();
        SpannableStringBuilder style=new SpannableStringBuilder(str);
        style.setSpan(new ForegroundColorSpan(Color.RED),fstart,fend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        view.setText(style);
    }
}
