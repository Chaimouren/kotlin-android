package com.example.smartappupdate

import android.app.ProgressDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import com.example.smartappupdate.utils.PatchUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.io.File

class MainActivity : AppCompatActivity() {
    //增量更新demo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //findById
        btn_update.onClick {
            //集成增量更新
            update()
        }
    }

    //通过懒加载初始化
    private val mDialog : ProgressDialog by lazy {
        ProgressDialog(this)
    }

    //更新方法:通过旧版本+patch包生成新apk
    fun update(){
        //获取包管理器
        var pm : PackageManager = packageManager
        //获取包名
        //应用程序信息
        var appInfo = pm.getApplicationInfo("com.ss.android.article.news",0)
        //获取旧版本
        var oldPatch :String  = appInfo.sourceDir

        //指定patch 文件保存路径
        var patchFile = File(Environment.getExternalStorageDirectory(),"toutiao.patch")

        //设置新版本apk保存路径
        var newApkFile = File(Environment.getExternalStorageDirectory(),"toutiao_new.apk")

        //手动合成增量更新，需要jni知识点
        //合并生成新代码

        //显示进度条
        mDialog.show()
        //子线程
        doAsync {

            //合并完成 主线程
            var result = PatchUtils.patch(oldPatch,newApkFile.absolutePath,patchFile.absolutePath)
            if(result == 0){
                runOnUiThread{
                    //进度条
                    mDialog.dismiss()

                    //安装新版本apk 系统包安装器
                    val intent = Intent()
                    //设置action 数据
                    intent.action = "android.intent.action.View"
                    intent.addCategory("android.intent.category.DEFAULT")
//                    intent.setDataAndType(Uri.parse(""))
                    startActivity(intent)
                }
            }


        }

    }


}
