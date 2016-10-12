package com.example.lesson1_retofit.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.lesson1_retofit.R;
import com.example.lesson1_retofit.coreimpl.GetGithubUserInfo;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("开始打印ssssss");
        //GetGithubUserInfo userInfo = new GetGithubUserInfo();
        //userInfo.getUserInfo();
        //printStringByRxJava();
        //printInteger();
        //transfromTest();
    }

//    private void transfromTest() {
//
//
//    }

    private void printInteger() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println(integer);
                    }
                });

        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {

            }
        }).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<Drawable>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Drawable drawable) {

            }
        });

    }

    private void printStringByRxJava() {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("完成啦");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("完成啦");
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onStart() {
                super.onStart();
                System.out.println("新一次的开始");
            }

            @Override
            public void onCompleted() {
                System.out.println("完成啦");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("出错啦");
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };
        String[] array = {"RxJava", "RxAndroid", "Retrofit", "Afinal", "Volly", "xUtils", "HttpClient"};
        Observable<String> observable = Observable.from(array);
        Observable<String> observable1 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                // 通过OnSubscribe对象创建被观察者
            }
        });
        observable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i("string", s);
            }
        });
        System.out.println("订阅Observer对象");
        observable.subscribe(subscriber);
        System.out.println("订阅Subscriber对象");
        observable.subscribe(observer);
    }
}
