package com.example.zhangzhu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.zhangzhu.myapplication.RecycleViewBean.Fruit;
import com.example.zhangzhu.myapplication.RecycleViewBean.FruitAdapter;
import com.example.zhangzhu.myapplication.Util.CommonUtils;

import java.util.ArrayList;
import java.util.Random;

public class RecyclerViewTestActivity extends BaseActivity implements View.OnClickListener{
    private ArrayList<Fruit> fruitList = new ArrayList<Fruit>();
    private RecyclerView recyclerView;
    private FruitAdapter adapter;
    private Button add_button;
    private Button del_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initFruits();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        add_button = (Button) findViewById(R.id.add_button);
        del_button = (Button) findViewById(R.id.del_button);
        add_button.setOnClickListener(this);
        del_button.setOnClickListener(this);
        /*push*/
//        StaggeredGridLayoutManager layoutManager = new
//                StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        /*ver+hor*/
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        /*hor*/
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit(getRandomLengthName("Apple"), R.mipmap.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("Banana"), R.mipmap.banana_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit(getRandomLengthName("Orange"), R.mipmap.orange_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"), R.mipmap.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear = new Fruit(getRandomLengthName("Pear"), R.mipmap.pear_pic);
            fruitList.add(pear);
            Fruit grape = new Fruit(getRandomLengthName("Grape"), R.mipmap.grape_pic);
            fruitList.add(grape);
            Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"), R.mipmap.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"), R.mipmap.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit(getRandomLengthName("Cherry"), R.mipmap.cherry_pic);
            fruitList.add(cherry);
            Fruit mango = new Fruit(getRandomLengthName("Mango"), R.mipmap.mango_pic);
            fruitList.add(mango);
        }
    }

    private void insertItem(){
        Fruit apple = new Fruit(getRandomLengthName("TEST"), R.mipmap.apple_pic);
        adapter.addItem(apple, 0);
    }

    private void delItem(){
        adapter.removeItem();
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
//        int length = random.nextInt(20) + 1;
        int length = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }

    @Override
    public void onBackPressed() {
        CommonUtils.showToast(this,"goback",0);
        Intent intent = new Intent();
        setResult(RESULT_OK,intent);
        finish();
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.add_button:
                insertItem();
                break;
            case R.id.del_button:
                delItem();
                break;
            default:break;
        }
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(keyCode == KeyEvent.KEYCODE_BACK){
//            return false;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
