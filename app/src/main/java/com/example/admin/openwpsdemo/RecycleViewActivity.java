package com.example.admin.openwpsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.openwpsdemo.adapter.RecAdapter;

import java.util.ArrayList;

public class RecycleViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        
        initView();
    }

    private void initView() {

        recyclerView = findViewById(R.id.recyclerView);

        RecAdapter recAdapter = new RecAdapter(this,new ArrayList<String>());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setItemViewCacheSize(1);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recAdapter);
    }


}
