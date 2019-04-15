package com.example.hotfix

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //热修复demo

    //懒加载初始化view
    val tvResult:TextView by lazy{
        tv_result
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult.text = "有bug版本"
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
