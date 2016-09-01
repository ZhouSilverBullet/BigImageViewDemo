package com.zhouzhou.bigimageviewdemo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zhouzhou.bigimageviewdemo.holder.BaseHolder;

import java.util.List;

/**
 * Created by zhousaito on 2016/9/1.
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {
    private List<T> mList;

    public MyBaseAdapter(List<T> list) {
        mList = list;
    }

    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }

    @Override
    public T getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseHolder baseHolder;
        if (convertView == null) {
            baseHolder = getHolder();
        }else {
            baseHolder = (BaseHolder) convertView.getTag();
        }
        baseHolder.setData(getItem(position));
        return baseHolder.getRootView();
    }

    public abstract BaseHolder getHolder();
}
