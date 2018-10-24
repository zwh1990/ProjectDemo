package com.example.admin.openwpsdemo.ui;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.adapter.RecAdapter;

import java.util.ArrayList;

public class BottomSheetActivity extends AppCompatActivity{

    private RecyclerView recyclerView;

    private static final String TAG = RecycleViewActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

        initView();

    }

    private void initView() {

        recyclerView = findViewById(R.id.recyclerView);

        RecAdapter recAdapter = new RecAdapter(this, new ArrayList<String>());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setItemViewCacheSize(1);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recAdapter);

    }




}
