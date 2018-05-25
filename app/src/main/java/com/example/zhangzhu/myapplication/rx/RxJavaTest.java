package com.example.zhangzhu.myapplication.rx;

import android.widget.Toast;

import com.example.zhangzhu.myapplication.MyApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by zhangzhu on 2018/5/11.
 */

public class RxJavaTest {

    public static void start(){
        //basic
        Observable<String> observable1 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("start");
            }
        });

        //just
        Observable<String> observable = Observable.just("start");

        //from
        List<String> list = new ArrayList<String>();
        for(int i = 0;i<=5;i++){
            list.add("start"+i);
        }
        Observable<String> observable3 = Observable.from(list);

        Observer<String> observer = new Observer<String>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                s = Thread.currentThread().getName();
                Toast.makeText(MyApplication.context, s, Toast.LENGTH_SHORT).show();
            }
        };

        observable.filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.contains("s");
            }
        }).subscribeOn(Schedulers.io()).subscribe(observer);
    }
}
