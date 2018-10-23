package com.example.admin.openwpsdemo.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.adapter.ControlDetailPagerAdapter;
import com.example.admin.openwpsdemo.weight.tablayout.TabLayout;

public class TabLayoutActivity extends AppCompatActivity {

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

        mTabLayout = findViewById(R.id.tab_layout);
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
//        mTabLayout.removeAllTabs();
//
//        for (int i = 0; i < 3; i++) {
//            View view = LayoutInflater.from(this).inflate(R.layout.item_skill_tab, null, false);
//            TextView tvName = view.findViewById(R.id.tv_name);
//            tvName.setText("郭果果" + i);
//            TabLayout.Tab tab = mTabLayout.newTab().setCustomView(view);
//            //设置第一个默认选中Tab
//            if (i == 0) {
//                mTabLayout.addTab(tab, true);
//            } else {
//                mTabLayout.addTab(tab);
//            }
//        }

        mTabLayout.getTabAt(0).setText("郭果果");
        mTabLayout.getTabAt(1).setText("郭果果");
        mTabLayout.getTabAt(2).setText("郭果果");
        mTabLayout.getTabAt(3).setText("郭果果");
        mTabLayout.getTabAt(4).setText("郭果果");

        mViewPager.setOffscreenPageLimit(3);

    }



}
