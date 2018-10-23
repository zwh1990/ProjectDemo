package com.example.admin.openwpsdemo.ui;

import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;

public class BottomSheetActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = BottomSheetActivity.class.getSimpleName();
    private Button btn_bottom_sheet_control;
    private LinearLayout tab_layout;
    private BottomSheetBehavior<LinearLayout> bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

        btn_bottom_sheet_control = findViewById(R.id.btn_bottom_sheet_control);
        tab_layout = findViewById(R.id.tab_layout);

        btn_bottom_sheet_control.setOnClickListener(this);
        bottomSheetBehavior = BottomSheetBehavior.from(tab_layout);
        bottomSheetBehavior.setPeekHeight(0);
        LOGUtils.w(TAG,"bottomSheetBehavior--->" + bottomSheetBehavior);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_bottom_sheet_control) {
            if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            } else if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        }
    }
}
