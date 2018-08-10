package com.example.admin.openwpsdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.admin.openwpsdemo.R;

public class GlideActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        initView();
    }

    private void initView() {
        img = findViewById(R.id.img);
        String url = "https://www.baidu.com/img/bd_logo1.png";
        Glide.with(this).load(url).into(img);

    }
}
