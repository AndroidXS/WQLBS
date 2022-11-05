package com.example.wqlbs.util;

import android.util.Log;

/**
 * ************************************
 * 项目名称: WQLBS
 *
 * @Author xushu
 * 创建时间: 2022/11/5 17:05
 * 用途：打印日志
 * 修改记录：
 *************************************/
public class LogUtils {
    static void d(String tag,Object msg){
        if(msg == null){
            Log.d(tag,"null");
        }else {
            Log.d(tag,msg.toString());
        }
    }
    static void d(Object msg){
        if(msg == null){
            Log.d("WQLBS","null");
        }else {
            Log.d("WQLBS",msg.toString());
        }
    }
}
