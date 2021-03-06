package com.example.admin.openwpsdemo.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.adapter.ControlDetailPagerAdapter;

public class TabLayoutActivity extends AppCompatActivity {

    private static final String TAG = TabLayoutActivity.class.getSimpleName();
    TabLayout mTabLayout;
    ViewPager mViewPager;

    private ControlDetailPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        initView();
    }

    private void initView() {

        String s1 = "123";
        String s2 = null;
        boolean b = s1.equals(s2);
        LOGUtils.w(TAG,"b--->" + b);

        mTabLayout = findViewById(R.id.tabs);
        mViewPager = findViewById(R.id.vp_view);


        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//设置tab模式，当前为系统默认模式
        mAdapter = new ControlDetailPagerAdapter(getSupportFragmentManager());

        mAdapter.addFragment(TabLayoutFragment.newInstance());
        mAdapter.addFragment(TabLayoutFragment.newInstance());
        mAdapter.addFragment(TabLayoutFragment.newInstance());
        mAdapter.addFragment(TabLayoutFragment.newInstance());
        mAdapter.addFragment(TabLayoutFragment.newInstance());


        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。

        mTabLayout.getTabAt(0).setText("郭果果");
        mTabLayout.getTabAt(1).setText("郭果果");
        mTabLayout.getTabAt(2).setText("郭果果");
        mTabLayout.getTabAt(3).setText("郭果果");
        mTabLayout.getTabAt(4).setText("郭果果");

        mViewPager.setOffscreenPageLimit(3);

    }



}
