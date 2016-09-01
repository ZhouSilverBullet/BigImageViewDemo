package com.zhouzhou.bigimageviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhouzhou.bigimageviewdemo.adapter.MyAdapter;
import com.zhouzhou.bigimageviewdemo.bean.MeiShiBean;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.http.app.RequestTracker;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main3)
public class Main3Activity extends AppCompatActivity {
    @ViewInject(R.id.listView)
    private ListView mListView;
    @ViewInject(R.id.download)
    private Button mDownloadButton;
    private MyAdapter mMyAdapter;
    private List<MeiShiBean.ObjBean.DataBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        x.Ext.init(getApplication());
        x.view().inject(this);
//       setContentView(R.layout.activity_main3);
        //http://api102.meishi.cc/v5/class_list1.php?lon=&source=android&cid=0&vk=ed6ffbc3acc04a6a2eebce047f17bb15&sort_sc=asc&sort=default&lat=&page=1&bcid=13&format=json
        mList = new ArrayList<>();
        mMyAdapter = new MyAdapter(mList);
        mListView.setAdapter(mMyAdapter);
    }
    @Event(value = {R.id.download})
    private void download(View view){
        switch (view.getId()) {
            case R.id.download:
                RequestParams requestParams = new RequestParams("http://api102.meishi.cc/v5/class_list1.php?lon=&source=android&cid=0&vk=ed6ffbc3acc04a6a2eebce047f17bb15&sort_sc=asc&sort=default&lat=&page=1&bcid=13&format=json");
                x.http().get(requestParams, new Callback.CacheCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("自定义标签", "类名==Main3Activity" + "方法名==onSuccess=====:" + Thread.currentThread().getName());
                        Log.e("自定义标签", "onSuccess() called with: " + "result = [" + result + "]");
                    }

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

                    @Override
                    public boolean onCache(String result) {
//                        Log.e("自定义标签", "onCache() called with: " + "result = [" + result + "]");
                        MeiShiBean meiShiBean = new Gson().fromJson(result, MeiShiBean.class);
                        List<MeiShiBean.ObjBean.DataBean> classes = meiShiBean.getObj().getData();
                        mList.addAll(classes);
                        mMyAdapter.notifyDataSetChanged();
                        return true;
                    }
                });
            break;
        }
    }
}
