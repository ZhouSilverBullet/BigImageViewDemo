package com.zhouzhou.bigimageviewdemo.holder;

import android.view.View;
import android.widget.BaseAdapter;

/**
 * Created by zhousaito on 2016/9/1.
 */
public abstract class BaseHolder<T> {
    public T data;
    public View mRootView;

    public BaseHolder() {
        mRootView = initView();
        mRootView.setTag(this);
    }

    public View getRootView() {
        return mRootView;
    }

    public void setData(T data) {
        this.data = data;
        refreshView(data);
    }

    public T getData() {
        return data;
    }

    public abstract View initView();
    public abstract void refreshView(T data);
}
