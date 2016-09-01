package com.zhouzhou.bigimageviewdemo.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhouzhou.bigimageviewdemo.MyApplication;
import com.zhouzhou.bigimageviewdemo.R;
import com.zhouzhou.bigimageviewdemo.bean.MeiShiBean;

import org.xutils.x;

/**
 * Created by zhousaito on 2016/9/1.
 */
public class MyHolder extends BaseHolder<MeiShiBean.ObjBean.DataBean>{
    private ImageView mImageView;
    private TextView mTextView;

    @Override
    public View initView() {
        View view = View.inflate(MyApplication.getContext(), R.layout.list_item,null);
        mImageView = ((ImageView) view.findViewById(R.id.iv_image));
        mTextView = ((TextView) view.findViewById(R.id.tv_textView));
        return view;
    }

    @Override
    public void refreshView(MeiShiBean.ObjBean.DataBean data) {
        x.image().bind(mImageView,data.getTitlepic(),MyApplication.getImageOptions());
        mTextView.setText(data.getSmalltext());
    }
}
