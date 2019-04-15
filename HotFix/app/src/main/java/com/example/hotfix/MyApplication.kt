package com.example.hotfix

import android.app.Application
import android.os.Environment
import com.alipay.euler.andfix.patch.PatchManager
import java.io.File

class MyApplication:Application(){

    //参照文档https://github.com/alibaba/AndFix

    override fun onCreate(){
        super.onCreate()

        //初始化 patchManager
        val patchManager =  PatchManager(this);
        patchManager.init("1.0")//current version

        patchManager.loadPatch()

        //合并文件
        var path = File(Environment.getExternalStorageDirectory(),"fixbug.apatch")
        if(path.exists()){
            patchManager.addPatch(path.absolutePath)//path of the patch file that was downloaded
        }


    }

}