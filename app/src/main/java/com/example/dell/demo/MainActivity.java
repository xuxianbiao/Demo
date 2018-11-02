package com.example.dell.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoginInterface.View,AreKitMeInterface,AreKitMeInterface.EndTime {

    private LoginInterface.Presenter mPresenter;
    private TextView dataTv;
    private AreKitMeInterface.HelloTime helloTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        /**
         * 注意了：：：：：：：：：：：：
         * 向下转型 实例化LoginPresenter
         * 为什么这么写？  因为LoginInterface才是桥梁！！！
         */
        mPresenter = new LoginPresenter(this);
        helloTime = new AreKitMePresenter(this,this);
    }
    private void initView() {
        dataTv = (TextView) findViewById(R.id.data_tv);
        dataTv.setOnClickListener(new View.OnClickListener() {//点击请求数据
            @Override
            public void onClick(View v) {
//                mPresenter.loadData();
                helloTime.hello();
            }
        });
    }
    @Override
    public void setData(String str) {
        Log.i("testtest","setData--->"+str);
        dataTv.setText(str);
    }
    @Override
    public void showTime() {
        Log.i("testtest","showTime");
        dataTv.setText(dataTv.getText()+"HHHH");
    }
    @Override
    public void end(String str) {
        Log.i("testtest","end-->"+str);
        dataTv.setText(str);
    }
}
