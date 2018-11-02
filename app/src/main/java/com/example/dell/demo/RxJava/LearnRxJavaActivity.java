package com.example.dell.demo.RxJava;

import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.View;

import com.example.dell.demo.BaseActivity;
import com.example.dell.demo.R;

import org.reactivestreams.Subscriber;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LearnRxJavaActivity extends BaseActivity {
    public static String TAG = "RxJavaLog";
    public Observer<String> observer;
    @Override
    public int getContentViewResId() {
        return R.layout.rxjava_main;
    }

    @Override
    public void initView() {
        observer = new Observer<String>() {
            @Override
            public void onNext(String s) {
                Log.d(TAG, "Item: " + s);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed!");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error!");
            }

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe!"+d);
            }
        };
        getView(R.id.btn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                doSomeWork();
            }
        });
    }

    private void doSomeWork(){
        String[] words = {"Hello", "Hi", "Aloha"};
        Observable observable = Observable.just(words);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
