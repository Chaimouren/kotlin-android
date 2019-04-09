package com.example.basicdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basicdemo.R;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<String> stirngs;
    private final LayoutInflater layoutInflater;

    /**
     * 创建构造方法
     * @param context
     * @param stirngs
     */
    public ListAdapter(Context context, ArrayList<String> stirngs) {
        this.context = context;
        this.stirngs = stirngs;
        layoutInflater = LayoutInflater.from(context);
    }

    /**
     * 根据显示内容创建一个viewholder
     * @param viewGroup
     * @param i
     * @return
     */
    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(layoutInflater.inflate(android.R.layout.simple_list_item_1,viewGroup,false));
    }

    /**
     * 当对应数据显示到viewholder
     * @param viewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder viewHolder, int i) {
        //传递到的数据index
        viewHolder.bindData(stirngs.get(i));
    }

    /**
     * 显示有多少条数据
     * @return
     */
    @Override
    public int getItemCount() {
        return 0;
    }

    /**
     * 创建内部构造器
     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.list_view);
        }

        public void bindData(String s) {
            textView.setText(s);
        }
    }
}
