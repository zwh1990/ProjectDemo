package com.example.admin.openwpsdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.adapter.GlideAdapter;
import com.example.admin.openwpsdemo.biz.CustomImageSizeModel;
import com.example.admin.openwpsdemo.biz.CustomImageSizeModelImp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.Url;

public class GlideActivity extends AppCompatActivity {

   private RecyclerView rc;
   private GlideAdapter mAdapter;
   private List<CustomImageSizeModel> mDatas;

    String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535971357471&di=40ab329c05e12bd65fd530b70cfd6765&imgtype=0&src=http%3A%2F%2Fpic23.photophoto.cn%2F20120503%2F0034034456597026_b.jpg";

    String IMAGE_URL_TROCHILIDAE = "http://o9xuvf3m3.bkt.clouddn.com/trochilidae.jpg";
    String IMAGE_URL_NEW_YORK = "http://o9xuvf3m3.bkt.clouddn.com/new_york.jpg";
    String IMAGE_URL_PERU = "http://o9xuvf3m3.bkt.clouddn.com/peru.jpg";
    String IMAGE_URL_FRANCE_1 = "http://o9xuvf3m3.bkt.clouddn.com/france-217.jpg";
    String IMAGE_URL_FRANCE_2 = "http://o9xuvf3m3.bkt.clouddn.com/france-220.jpg";
    String IMAGE_URL_FRANCE_3 = "http://o9xuvf3m3.bkt.clouddn.com/france-216.jpg";
    String IMAGE_URL_FRANCE_4 = "http://o9xuvf3m3.bkt.clouddn.com/france-221.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        initView();
    }

    private void initView() {
        rc = findViewById(R.id.rc);

        rc.setLayoutManager(new GridLayoutManager(this,3));
        mAdapter = new GlideAdapter(this,getDatas(), R.layout.item_img);
        rc.setAdapter(mAdapter);

    }

    public List getDatas() {
        mDatas = new ArrayList<>();
//        mDatas.add(new CustomImageSizeModelImp(IMAGE_URL_NEW_YORK));
//        mDatas.add(new CustomImageSizeModelImp(IMAGE_URL_PERU));
//        mDatas.add(new CustomImageSizeModelImp(IMAGE_URL_TROCHILIDAE));
//        mDatas.add(new CustomImageSizeModelImp(IMAGE_URL_FRANCE_1));
//        mDatas.add(new CustomImageSizeModelImp(IMAGE_URL_FRANCE_2));
//        mDatas.add(new CustomImageSizeModelImp(IMAGE_URL_FRANCE_3));
//        mDatas.add(new CustomImageSizeModelImp(IMAGE_URL_FRANCE_4));
        mDatas.add(new CustomImageSizeModelImp(url));
        return mDatas;
    }
}
