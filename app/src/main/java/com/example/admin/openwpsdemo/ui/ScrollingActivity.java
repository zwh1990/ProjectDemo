package com.example.admin.openwpsdemo.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.adapter.RecAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class ScrollingActivity extends AppCompatActivity {

    private RecyclerView rc;
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    private ConvenientBanner mConvenientBanner;

    private String[] images = {"http://img2.imgtn.bdimg.com/it/u=3093785514,1341050958&fm=21&gp=0.jpg",
            "http://img2.3lian.com/2014/f2/37/d/40.jpg",
            "http://img2.3lian.com/2014/f2/37/d/39.jpg",
            "http://www.8kmm.com/UploadFiles/2012/8/201208140920132659.jpg",
            "http://f.hiphotos.baidu.com/image/h%3D200/sign=1478eb74d5a20cf45990f9df460b4b0c/d058ccbf6c81800a5422e5fdb43533fa838b4779.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/09fa513d269759ee50f1971ab6fb43166c22dfba.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        appBarLayout = findViewById(R.id.app_bar);
        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        mConvenientBanner = findViewById(R.id.banner);
        setSupportActionBar(toolbar);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    toolbar.setTitleTextColor(getResources().getColor(R.color.white));
                    collapsingToolbarLayout.setTitle("AppbarLayout");
                } else {
                    collapsingToolbarLayout.setTitle("");
                }
            }
        });

        initView();
    }

    private void initView() {

        rc = findViewById(R.id.rc);

        RecAdapter recAdapter = new RecAdapter(this, new ArrayList<String>());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        rc.setLayoutManager(linearLayoutManager);
        rc.setAdapter(recAdapter);

        mConvenientBanner.setPages(
                new CBViewHolderCreator() {
                    @Override
                    public NetworkImageHolderView createHolder(View itemView) {
                        return new NetworkImageHolderView(itemView);
                    }

                    @Override
                    public int getLayoutId() {
                        return R.layout.item_localimage;
                    }
                }, Arrays.asList(images))
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                .setPointViewVisible(true)
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mConvenientBanner.startTurning(2000);// 2s 换一张
    }

    @Override
    protected void onPause() {
        super.onPause();
        mConvenientBanner.stopTurning();
    }


    public class NetworkImageHolderView extends Holder<String> {
        private ImageView imageView;

        public NetworkImageHolderView(View itemView) {
            super(itemView);
        }

        @Override
        protected void initView(View itemView) {
            imageView = itemView.findViewById(R.id.ivPost);
        }

        @Override
        public void updateUI(String data) {
            Glide.with(ScrollingActivity.this)
                    .load(data)
                    .into(imageView);
        }
    }
}
