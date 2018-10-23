package com.example.admin.openwpsdemo.ui;

import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.adapter.RecAdapter;

import java.util.ArrayList;

/**
 * @Created by zwh.
 * @description：RecycleView带有BottomSheet
 * @date ${DATE} ${HOUR}:${MINUTE}
 * @邮箱：zhaowh@zgjzd.cn
 */
public class RecycleViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private static final String TAG = RecycleViewActivity.class.getSimpleName();
    private LinearLayout tab_layout;
    private BottomSheetBehavior<LinearLayout> bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        initView();
    }

    private void initView() {

        recyclerView = findViewById(R.id.recyclerView);

        RecAdapter recAdapter = new RecAdapter(this, new ArrayList<String>());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setItemViewCacheSize(1);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recAdapter);

        tab_layout = findViewById(R.id.tab_layout);

        bottomSheetBehavior = BottomSheetBehavior.from(tab_layout);
        bottomSheetBehavior.setPeekHeight(0);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LOGUtils.w(TAG,"dy--->" + dy);
                if(dy > 10 && bottomSheetBehavior.getState()==BottomSheetBehavior.STATE_EXPANDED){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }else if(dy < -10 && bottomSheetBehavior.getState()==BottomSheetBehavior.STATE_COLLAPSED){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }

            }
        });
    }

}
