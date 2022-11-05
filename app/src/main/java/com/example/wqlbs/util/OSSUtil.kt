package model

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.alibaba.sdk.android.oss.ClientException
import com.alibaba.sdk.android.oss.OSSClient
import com.alibaba.sdk.android.oss.ServiceException
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask
import com.alibaba.sdk.android.oss.model.GetObjectResult
import com.alibaba.sdk.android.oss.model.PutObjectRequest
import com.alibaba.sdk.android.oss.model.PutObjectResult

/**
 *************************************
 *项目名称: GraduationProject
 *@Author xushu
 *创建时间: 2022/3/11 20:15
 *用途：
 *修改记录：
 *************************************/
class OSSUtil {
    private val handler = Handler(Looper.myLooper()!!)
    private var upTask: OSSAsyncTask<PutObjectResult>? = null
    private var downTask:OSSAsyncTask<GetObjectResult>? = null
    private val ossProvider by lazy {
        OSSPlainTextAKSKCredentialProvider("LTAI5tL9kxZhAfdnf2sJHcmq",
            "Rf25mjLlTcQD2IVptY3shcpiFQTvQT")
    }
    /**
     * 上传文件
     * @param context 上下文
     * @param bucketName Bucket名称
     * @param objectName 上传后文件的名称
     * @param uploadFilePath 被上传文件在手机里的路径
     * @param suc 上传成功回调方法
     * @param error 上传失败回调方法
     * @param progress 上传进程回调方法
     */
    fun upload(
        context: Context, bucketName:String,
        objectName:String, uploadFilePath:String,
        suc:(String)->Unit,
        error:()->Unit, progress: ((Long, Long) -> Unit)? = null
    ){
        val oss = OSSClient(context, "http://oss-cn-beijing.aliyuncs.com", ossProvider)
        val put = PutObjectRequest(bucketName,objectName,uploadFilePath)
        put.setProgressCallback { _, currentSize, totalSize ->
            if (progress != null) {
                progress(currentSize, totalSize)
            }
        }
        upTask = oss.asyncPutObject(put, object :
            OSSCompletedCallback<PutObjectRequest, PutObjectResult> {
            override fun onSuccess(request: PutObjectRequest?, result: PutObjectResult?) {

                upTask = null
                result?.let {
                    handler.post {
                        val url = oss.presignPublicObjectURL(bucketName,objectName)
                        suc(url)
                    }
                }
            }

            override fun onFailure(
                request: PutObjectRequest?, clientException:
                ClientException?, serviceException: ServiceException?
            ) {
                upTask = null
                clientException?.printStackTrace()
                serviceException?.printStackTrace()
                handler.post {
                    error()
                }

            }
        })

    }


}