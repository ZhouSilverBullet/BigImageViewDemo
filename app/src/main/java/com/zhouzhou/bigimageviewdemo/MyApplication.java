package com.zhouzhou.bigimageviewdemo;

import android.app.Application;
import android.content.Context;
import android.widget.ImageView;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;

/**
 * Created by zhousaito on 2016/9/1.
 */
public class MyApplication extends Application{
    private static Context sContext;
    private static ImageOptions mImageOptions;
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        sContext = getApplicationContext();
        mImageOptions = new ImageOptions.Builder().
                setSize(DensityUtil.dip2px(100),DensityUtil.dip2px(100))
                .setRadius(DensityUtil.dip2px(5)).  //
                setImageScaleType(ImageView.ScaleType.CENTER_CROP)  //显示类型
                .setLoadingDrawableId(R.mipmap.ic_launcher)  //加载中的图片
                .setFailureDrawableId(R.mipmap.ic_launcher)  //加载失败后的图片
                .setUseMemCache(true)  // 是否使用缓存
                .setIgnoreGif(false)  //是否支持gif
                .setCircular(true)  //加载 圆形图
                .build();
    }

    public static Context getContext() {
        return sContext;
    }

    public static ImageOptions getImageOptions() {
        return mImageOptions;
    }
}
