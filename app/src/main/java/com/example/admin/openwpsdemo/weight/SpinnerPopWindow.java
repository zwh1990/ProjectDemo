package com.example.admin.openwpsdemo.weight;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.adapter.SpinnerPopWindowAdapter;

import java.util.List;

/**
 * @Created by zwh.
 * @description：
 * @date 2018/8/6 10:17
 * @邮箱：zhaowh@zgjzd.cn
 */
public class SpinnerPopWindow extends PopupWindow {

    private LayoutInflater inflater;
    private RecyclerView rc;
    private List<String> mDatas;
    private SpinnerPopWindowAdapter mAdapter;

    public SpinnerPopWindow(Context context, List<String> mDatas) {
        super(context);
        inflater=LayoutInflater.from(context);
        this.mDatas = mDatas;

        init();
    }

    private void init(){
        View view = inflater.inflate(R.layout.spinner_pop_wondow, null);
        setContentView(view);

        setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0x00);
        setBackgroundDrawable(dw);
        rc = view.findViewById(R.id.rc);
        mAdapter = new SpinnerPopWindowAdapter(mDatas,R.layout.item_spinner_pop_wondow);
        rc.setLayoutManager(new LinearLayoutManager(rc.getContext()));
        rc.setAdapter(mAdapter);

    }

}
