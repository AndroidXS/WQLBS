package model

import okhttp3.*
import java.io.IOException

/**
 *************************************
 *项目名称: GraduationProject
 *@Author xushu
 *创建时间: 2022/3/10 21:18
 *用途：okhttp通信工具类
 *修改记录：①删除handler 会报错
 *************************************/
class OkHttpUtil private constructor(){

    fun postData(url:String,map:HashMap<String,String>,error:(IOException?)->Unit,suc:(String?)->Unit){
        val body = FormBody.Builder()
        map.forEach{
            body.add(it.key,it.value)
        }
        val requestBody = body.build()
        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()
        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call?, e: IOException?) {
                error(e)
            }

            override fun onResponse(call: Call?, response: Response?) {
                suc(response?.body()?.string())
            }

        })

    }

    companion object{
        private val instance = OkHttpUtil()
        private val client = OkHttpClient()
        fun getInstance():OkHttpUtil{
            return instance
        }
    }
}
