package com.example.basicdemo.activity;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.basicdemo.MainActivity;
import com.example.basicdemo.R;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SecordActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secord);

        //获取button
        Button close_button = findViewById(R.id.close_btn);
        //创建button 监听
        close_button.setOnClickListener(this);//填入this alt+enter创建继承方法


        //获取 edittext
        final EditText editText = findViewById(R.id.et_username);
        Button button = findViewById(R.id.edit_button);
        //给button 绑定事件获取输入文本
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputtext = editText.getText().toString().trim();
                if(TextUtils.isEmpty(inputtext)){
                    Toast.makeText(SecordActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(SecordActivity.this,"您输入的用户名是："+inputtext,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    /**
     * 展示图片
     * @param view
     */
    public void showImg(View view) {
        Intent intent = new Intent(this,ImageActivity.class);
        startActivity(intent);
    }

    /**
     * 展示列表
     * @param view
     */
    public void showList(View view) {
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
    }

    /**
     * 获取网络请求
     * @param view
     */
    public void getNetWorkData(View view) {
        OkHttpClient client = new OkHttpClient();

        //创建一个线程发起请求，android 中不允许在主线程中请求网络
        new Thread(){
            @Override
            public void run() {
                super.run();

                //创建请求
                Request request = new Request.Builder().url("https://www.baidu.com").build();
                //通过new call方法调用
                try {
                    Response response = client.newCall(request).execute();
                    String result = response.body().toString();

                    Log.d("Tag",result);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }
}
