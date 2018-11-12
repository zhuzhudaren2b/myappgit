package com.example.zhangzhu.myapplication.rx;

import android.util.Log;
import android.widget.Toast;

import com.example.zhangzhu.myapplication.MyApplication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import rx.Notification;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.MainThreadSubscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by zhangzhu on 2018/5/11.
 */

public class RxJavaTest {

    public static void start(){
        //create
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("start");
            }
        });

        //just
        Observable<String> observable1 = Observable.just("start");

        //from
        List<String> list = new ArrayList<String>();
        for(int i = 0;i<=50;i++){
            list.add("start"+i);
        }
        Observable<String> observable2 = Observable.from(list);

        //from
        final Observable<Integer> observable3= Observable.just(1,2,3,4,5,6,7,8);

        //defer
        Observable<Integer> observable4= Observable.defer(new Func0<Observable<Integer>>() {
            @Override
            public Observable<Integer> call() {
                return observable3;
            }
        });


        //===================observer=====================

        //observer
        Observer<Object> observer = new Observer<Object>() {

            @Override
            public void onCompleted() {
                Log.d("zhangzhuRxTest", "onCompleted ~");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("zhangzhuRxTest", "onError : " + e.getMessage());
            }

            @Override
            public void onNext(Object s) {
                if (s instanceof String) {
                    Log.d("zhangzhuRxTest", "onNext String : " + s);
                } else if (s instanceof Integer) {
                    Log.d("zhangzhuRxTest", "onNext2 Integer : " + s);
                } else if (s instanceof Long) {
                    Log.d("zhangzhuRxTest", "onNext3 Long : " + s);
                } else if (s instanceof Boolean) {
                    Log.d("zhangzhuRxTest", "onNext3 Boolean : " + s);
                }

            }
        };

        //===================start=====================

//        observable2
//                .doOnNext(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.d("zhangzhuRxTest", "doOnNext :"+s);
//                    }
//                })
//                .reduce(new Func2<String, String, String>() {
//                    @Override
//                    public String call(String s, String s2) {
//                        return s + ", "+s2;
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);

//        Observable.concat(observable2, observable3)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer2);

        class ComposeClass<T> implements Observable.Transformer<T, T> {

            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.subscribeOn(Schedulers.io())
                        .unsubscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        }

        Observable
                .just(3,4)
                .materialize()
                .compose(new ComposeClass())
                .subscribe(new Action1<Notification<Integer>>() {
                    @Override
                    public void call(Notification<Integer> integerNotification) {
                        Log.d("zhangzhuRxTest", "result : " + integerNotification.getKind()+", "+integerNotification.getValue());
                    }
                });


//        Observable
//                .create(new Observable.OnSubscribe<Integer>() {
//                    @Override
//                    public void call(Subscriber<? super Integer> subscriber) {
//                        subscriber.onNext(1);
//                        try {
//                            Thread.sleep(10000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        subscriber.onNext(2);
//                    }
//                }).timeout(5, TimeUnit.SECONDS, Observable.<Integer>empty()).subscribe(observer);

    }
}
