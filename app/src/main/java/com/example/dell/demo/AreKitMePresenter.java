package com.example.dell.demo;

public class AreKitMePresenter implements AreKitMeInterface.HelloTime{
    private AreKitMeInterface.EndTime endTime;
    AreKitMeInterface areKitMeInterface;
    public AreKitMePresenter(AreKitMeInterface.EndTime endTime,AreKitMeInterface areKitMeInterface){
        this.endTime = endTime;
        this.areKitMeInterface = areKitMeInterface;
    }
    @Override
    public void hello(){
        endTime.end(LoginModel.getData());
        areKitMeInterface.showTime();
    }
}
