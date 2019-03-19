package com.example.admin.openwpsdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.time.SlideDateTimeListener;
import com.example.admin.openwpsdemo.time.SlideDateTimePicker;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 时间选择
 */
public class PickTimeActivity extends AppCompatActivity {

    @BindView(R.id.tv_time)
    TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_time);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.tv_time)
    public void onViewClicked() {
        new SlideDateTimePicker.Builder(getSupportFragmentManager())
                .setListener(listener)
                .setInitialDate(new Date())
                .setIs24HourTime(true)
                .build()
                .show();
    }

    private SlideDateTimeListener listener = new SlideDateTimeListener() {

        @Override
        public void onDateTimeSet(Date date) {
            tvTime.setText(date.toString());
        }

        @Override
        public void onDateTimeCancel() {

        }

    };
}
