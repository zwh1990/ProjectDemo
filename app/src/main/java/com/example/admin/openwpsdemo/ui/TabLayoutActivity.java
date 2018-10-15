package com.example.admin.openwpsdemo.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.adapter.ControlDetailPagerAdapter;
import com.example.admin.openwpsdemo.weight.TabLayoutHelper;

import butterknife.BindView;

public class TabLayoutActivity extends AppCompatActivity {

    @BindView(R.id.tabs)
    TabLayout mTabLayout;
    @BindView(R.id.vp_view)
    ViewPager mViewPager;

    private ControlDetailPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        initView();
    }

    private void initView() {

        mTabLayout = findViewById(R.id.tabs);
        mViewPager = findViewById(R.id.vp_view);


        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mAdapter = new ControlDetailPagerAdapter(getSupportFragmentManager());

        mAdapter.addFragment(TabLayoutFragment.newInstance());
        mAdapter.addFragment(TabLayoutFragment.newInstance());
        mAdapter.addFragment(TabLayoutFragment.newInstance());


        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.getTabAt(0).setText("A");
        mTabLayout.getTabAt(1).setText("B");
        mTabLayout.getTabAt(2).setText("C");

        mViewPager.setOffscreenPageLimit(3);

        setTabLayout();

    }

    private void setTabLayout() {
        new TabLayoutHelper.Builder(mTabLayout)
                .setIndicatorColor(Color.BLUE)
                .setIndicatorHeight(6)
                .setIndicatorWith(100)
                .setTabItemMarginLeft(20)
                .setIndicatorDrawable(R.drawable.bg_tab_red)
                .setNormalTextColor(Color.GRAY)
                .setSelectedTextColor(Color.RED)
                .setSelectedBold(true)
                .setIndicatorMargin(40)
                .setTabItemPadding(20)
                .build();
    }



}
