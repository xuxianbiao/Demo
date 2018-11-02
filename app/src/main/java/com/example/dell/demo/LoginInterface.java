package com.example.dell.demo;

/**
 * Created by BandOfBrothersZTS on 2017/8/22.
 */

public interface LoginInterface {
    /**
     * 接口View  “即Activity（Fragment）的所实现类“
     */
    interface View{
        //setData方法是为了  Activity实现View接口之后 重写这个方法就可以直接拿到str 给TextView赋值

        void setData(String str);
    };
    /**
     * 接口Presenter 是LoginPresenter的所实现类
     */
    interface Presenter{
        //我们所要做的就是 给一个TextView 赋值，所以Presenter 中需要有一个方法loadData()
        // 调用 model的网络请求
        void loadData();
    };
    /**
     * 温馨提示 ：你也可以吧interface Presenter{} 抽象接口换成 abstract class Presenter{}
     * 这样的话Presenter 是LoginPresenter的父类   LoginPresenter extends Presenter 即可
     * 但是本着“单继承，多实现的原则” 我还是喜欢实现  因为你可能还有别的基类对不对
     */
    //TODO  不要问我mvp模式   m层在哪   不要忘了咱们第一步曲 是把m层剥离出去了
    //TODO   但是这并不影响， 因为Model 是通过Presenter来调用的  看看mvc和mvp的对比图就明白了
    //TODO   所以第一步曲的特点在于： 通过Presenter 来直接调用静态类 进行异步请求
}