package com.example.dell.demo;

import android.util.Log;

/**
 *Created by BandOfBrothersZTS on 2017/8/22.
 */

public class LoginPresenter implements LoginInterface.Presenter{
    /**
     *View  和   Presenter 是互通的  所以我要通过构造的方式拿到View
     * 拿到View   Presenter就可以调用View中的方法了
     * 嘿嘿，我又污了（拿到房卡  我就可以对里面姑娘为所欲为了！！！）
     */
    private LoginInterface.View view;

    public LoginPresenter(LoginInterface.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        Log.i("testtest","loadData");
        String str = LoginModel.getData();  //得到数据
        Log.i("testtest","loadData-->"+str);
        view.setData(str); //把得到的数据返回View层 供Activity用
    }
}
