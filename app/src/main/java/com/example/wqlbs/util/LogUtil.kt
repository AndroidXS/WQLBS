package model

import android.util.Log

/**
 *************************************
 *项目名称: GraduationProject
 *@Author xushu
 *创建时间: 2022/4/2 21:04
 *用途：
 *修改记录：
 *************************************/
object LogUtil {
    fun d(msg:Any?){
        msg?.let {
            Log.d("WQLBS",it.toString())
            return
        }
        Log.d("WQLBS","null")
    }
}