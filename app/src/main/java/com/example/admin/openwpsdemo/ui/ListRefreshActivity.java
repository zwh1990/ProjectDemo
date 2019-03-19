package com.example.admin.openwpsdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.weight.NoHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class ListRefreshActivity extends AppCompatActivity {

    private SmartRefreshLayout srf_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_refresh);

        srf_layout = findViewById(R.id.srf_layout);
        srf_layout.setRefreshHeader(new NoHeader(this));

    }
}
