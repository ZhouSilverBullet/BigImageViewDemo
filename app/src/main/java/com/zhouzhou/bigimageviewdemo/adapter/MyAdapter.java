package com.zhouzhou.bigimageviewdemo.adapter;

import com.zhouzhou.bigimageviewdemo.bean.MeiShiBean;
import com.zhouzhou.bigimageviewdemo.holder.BaseHolder;
import com.zhouzhou.bigimageviewdemo.holder.MyHolder;

import java.util.List;

/**
 * Created by zhousaito on 2016/9/1.
 */
public class MyAdapter extends MyBaseAdapter<MeiShiBean.ObjBean.DataBean>{
    public MyAdapter(List<MeiShiBean.ObjBean.DataBean> list) {
        super(list);
    }

    @Override
    public BaseHolder getHolder() {
        return new MyHolder();
    }
}
