package com.example.admin.openwpsdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.biz.GsonBean;
import com.example.admin.openwpsdemo.utils.DemoUtils;
import com.example.admin.openwpsdemo.utils.JSONUitl;
import com.example.admin.openwpsdemo.utils.LOGUtils;

public class GsonActivity extends AppCompatActivity {

    private static final String TAG = GsonActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        initView();
    }

    //获取本地json
    private void initView() {

        String json = DemoUtils.getAssetsJson(this,"test.json");
        GsonBean gsonBean = JSONUitl.getInstance().jsonToBean(json, GsonBean.class);
        LOGUtils.w(TAG,"gsonBean--->" + gsonBean.getCOUNT());

    }

}
