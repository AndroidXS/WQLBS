package com.example.wqlbs.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.wqlbs.MyApplication;

/**
 * ************************************
 * 项目名称: WQLBS
 *
 * @Author xushu
 * 创建时间: 2022/11/5 14:00
 * 用途：键值对存储
 * 修改记录：
 *************************************/
public class SPUtil {
    static private final SPUtil instance = new SPUtil();
    static SPUtil getInstance(){
        return instance;
    }
    private final SharedPreferences share = MyApplication.getAppContext().getSharedPreferences("WQLBS", Context.MODE_PRIVATE);
    private final SharedPreferences.Editor editor = share.edit();
    private SPUtil(){

    }

    void setString(String key,String value){
        editor.putString(key,value);
        editor.apply();
    }
    void setInt(String key,int value){
        editor.putInt(key,value);
        editor.apply();
    }
    void setBoolean(String key,Boolean value){
        editor.putBoolean(key,value);
        editor.apply();
    }

    String getString(String key,String def){
        return share.getString(key,def);
    }
    int getInt(String key,int def){
        return share.getInt(key,def);
    }
    boolean getString(String key,Boolean def){
        return share.getBoolean(key,def);
    }

}
