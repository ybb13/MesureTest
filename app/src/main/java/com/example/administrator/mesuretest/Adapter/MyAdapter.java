package com.example.administrator.mesuretest.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.mesuretest.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/8/16.
 */

public class MyAdapter extends BaseAdapter {

    private LayoutInflater mInflater;//得到一个LayoutInfalter对象用来导入布局
    ArrayList<HashMap<String, Object>> listItem;

    //构造函数
    public MyAdapter(Context context, ArrayList<HashMap<String, Object>> listItem) {
        this.mInflater = LayoutInflater.from(context);
        this.listItem = listItem;
    }


    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder
    {
        public TextView title;
        public TextView text;
    }//声明一个外部静态类
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_listview, null);
            holder.title = (TextView)convertView.findViewById(R.id.tv1);
            holder.text = (TextView)convertView.findViewById(R.id.tv2);
            convertView.setTag(holder);
            Log.d("TGA","null="+position+"");
            System.out.println("null="+position);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
            Log.d("TGA","NOT null="+position+"");
            System.out.println("NOT null="+position);

        }
        holder.title.setText((String) listItem.get(position).get("ItemTitle"));
        holder.text.setText((String) listItem.get(position).get("ItemText"));

        return convertView;
    }

}
