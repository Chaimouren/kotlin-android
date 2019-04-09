package com.example.basicdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basicdemo.activity.SecordActivity;

public class MainActivity extends AppCompatActivity {

    /**
     * 生命周期 - 创建
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //R 表示一个类 layout是一个内部类 activity_main是一个int类型的常量
        setContentView(R.layout.activity_main);

        //代码中找到id为textview
        TextView textView = findViewById(R.id.textview);
        //设置字体内容
        textView.setText("通过代码TextView设置内容");

        //设置button
        Button button = findViewById(R.id.button);
        //创建监听
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //提示信息
                Toast.makeText(MainActivity.this, "button 点击事件", Toast.LENGTH_SHORT).show();
            }
        });

        Button button2 = findViewById(R.id.button2);
        //创建监听
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //提示信息
                Toast.makeText(MainActivity.this, "button 跳转", Toast.LENGTH_SHORT).show();
                //跳转
                Intent intent = new Intent(MainActivity.this, SecordActivity.class);
                startActivity(intent);
            }
        });


    }


}
