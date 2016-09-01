package com.zhouzhou.bigimageviewdemo;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.common.util.DensityUtil;
import org.xutils.common.util.LogUtil;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
@ContentView(R.layout.activity_main2)
public class Main2Activity extends AppCompatActivity {
    @ViewInject(R.id.button)
    private Button mButton;
    @ViewInject(R.id.imageView)
    private ImageView mImageView;
    @ViewInject(R.id.button1)
    private Button mButton1;
    private ImageOptions mImageOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
        x.Ext.init(getApplication());
        x.view().inject(this);


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
    //通过button来点击下载
    @Event(value = {R.id.button1})
    private void loadImage(View view){
//        x.image().bind(mImageView,"https://ss0.bdstatic.com/94oJfD_bAAcT8t7" +
//                "mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1472729232&di=40142e7c7f3b67f6e65bdcaf92c12c3e&src=http://e.hiphotos.baidu.com/zhidao/pic/item/b17eca8065380cd715327439a344ad3459828132.jpg",mImageOptions);
        x.image().bind(mImageView, "https://www.baidu.c/img/bd_lo1.png", new Callback.CommonCallback<Drawable>() {
            /**
             * 加载成功的时候回调
             *
             * @param result 成功时的bitmap
             */
            @Override
            public void onSuccess(Drawable result) {
                Log.e("自定义标签", "onSuccess() called with: " + "result = [" + result + "]");
                mImageView.setImageDrawable(result);
            }

            /**
             * 加载错误
             * @param ex
             * @param isOnCallback
             */
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("自定义标签", "onError() called with: " + "ex = [" + ex + "], isOnCallback = [" + isOnCallback + "]");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("自定义标签", "onCancelled() called with: " + "cex = [" + cex + "]");
            }

            @Override
            public void onFinished() {
                Log.e("自定义标签", "onFinished() called with: " + "");

            }
        });
    }

    /**
     * 通过反射注解的方式来
     * 必须 方法 private
     *
     * @param view
     */
    @Event(value = {R.id.button}, type = View.OnClickListener.class)
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Toast.makeText(Main2Activity.this, "这是这是toast", Toast.LENGTH_SHORT).show();
//                LogUtil.e();
                break;
        }
    }
}
