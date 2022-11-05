package com.example.wqlbs;

import android.app.Application;
import android.content.Context;

/**
 * ************************************
 * 项目名称: WQLBS
 *
 * @Author xushu
 * 创建时间: 2022/11/5 14:04
 * 用途：获取全局上下文
 * 修改记录：
 *************************************/
public class MyApplication extends Application {
    private static Context appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this.getApplicationContext();
    }

    public static Context getAppContext(){
        return appContext;
    }
}
