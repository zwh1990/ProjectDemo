package com.example.admin.openwpsdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;

import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.adapter.RecAdapter;

import java.util.ArrayList;

public class FlexActivity extends AppCompatActivity {

    private RecyclerView rc_content;
    private RecAdapter recAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flex);


        initView();
    }

    private void initView() {
        rc_content = findViewById(R.id.rc_content);

        recAdapter = new RecAdapter(this,new ArrayList<String>());
        rc_content.setLayoutManager(new GridLayoutManager(this,2));
        rc_content.setAdapter(recAdapter);

    }
}
