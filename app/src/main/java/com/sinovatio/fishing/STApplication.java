package com.sinovatio.fishing;

import android.app.Application;

import android.widget.Toast;


import com.sinovatio.fishing.data.AppDataBase;
import com.sinovatio.fishing.utils.WifiUtil;

public class STApplication extends Application {
    public  static Application application;
    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        AppDataBase.getInstance();//数据库实例
        WifiUtil.getIns().init(application);//wifi工具类实例


    }

    public static void toastShow(String text){
        Toast.makeText(application,text,Toast.LENGTH_SHORT).show();
    }

}
