package com.example.admin.openwpsdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;

public class BaiduMapActivity extends AppCompatActivity {

    private static final String TAG = BaiduMapActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidu_map);

        retTest("dksakf");
    }

    private <T> void retTest(T t) {

        if(t instanceof String){

        }

        LOGUtils.w(TAG,"return--->");
    }
}
