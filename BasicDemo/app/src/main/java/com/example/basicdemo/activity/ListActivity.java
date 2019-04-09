package com.example.basicdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.basicdemo.R;
import com.example.basicdemo.adapter.ListAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //设置recyclerview 高度不变 提高性能
        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        //设置布局垂直或者水平 默认为垂直
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //创建数据
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 100 ; i++) {
            strings.add("展示数据：下标->"+i);
        }

        ListAdapter listAdapter = new ListAdapter(this, strings);
        recyclerView.setAdapter(listAdapter);
    }
}
