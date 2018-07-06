package com.example.admin.openwpsdemo;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Messenger;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.openwpsdemo.service.BugUpLoadJobService;

public class UpLoadBugActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = UpLoadBugActivity.class.getSimpleName();
    private Button bt_upLoadBug;

    private ComponentName mServiceComponent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_load_bug);

        initView();
    }

    private void initView() {

        bt_upLoadBug = findViewById(R.id.bt_upLoadBug);
        mServiceComponent = new ComponentName(this, BugUpLoadJobService.class);
        bt_upLoadBug.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Start service and provide it a way to communicate with this class.
        Intent startServiceIntent = new Intent(this,
                BugUpLoadJobService.class);
        startService(startServiceIntent);
    }

    @Override
    protected void onStop() {
        stopService(new Intent(this, BugUpLoadJobService.class));
        super.onStop();
    }

    @Override
    public void onClick(View v) {

        JobInfo.Builder builder = new JobInfo.Builder(100, mServiceComponent);
        builder.setOverrideDeadline(5 * 1000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setRequiresDeviceIdle(false);
        builder.setRequiresCharging(false);

        // Schedule job
        Log.d(TAG, "Scheduling job");
        JobScheduler tm = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        tm.schedule(builder.build());

    }

}
