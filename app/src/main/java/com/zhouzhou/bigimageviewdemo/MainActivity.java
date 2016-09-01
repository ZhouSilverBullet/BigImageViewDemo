package com.zhouzhou.bigimageviewdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = (ImageView) findViewById(R.id.iv);
        ImageView iv1 = (ImageView) findViewById(R.id.iv1);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.tomcat);
        iv.setImageBitmap(bitmap);

        Bitmap copyBitmap = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),bitmap.getConfig());
        Canvas canvas = new Canvas();
        Paint paint = new Paint();
        Matrix matrix = new Matrix();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;

        canvas.drawBitmap(copyBitmap,matrix,paint);
        iv1.setImageBitmap(bitmap);

        //获取屏幕的两种方式
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
//        DisplayMetrics displayMetrics1 = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics1);
//        int widthPixels1 = displayMetrics1.widthPixels;
//        int heightPixels1 = displayMetrics1.heightPixels;
//        Bitmap.createBitmap()
        BitmapFactory.Options options1 = new BitmapFactory.Options();
        options1.inJustDecodeBounds =true;  //进行获取元素
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.tomcat, options1);
        int outHeight = options1.outHeight;
        int outWidth = options1.outWidth;
        int scaleWidth = outWidth/widthPixels;
        int scaleHeight = outHeight/heightPixels;
        int reatScale = scaleHeight>scaleWidth?scaleHeight:scaleWidth;
        if (reatScale > 1) {
            options1.inSampleSize = reatScale;
        }
        options1.inJustDecodeBounds =false;
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.mipmap.tomcat,options1);


    }
}
