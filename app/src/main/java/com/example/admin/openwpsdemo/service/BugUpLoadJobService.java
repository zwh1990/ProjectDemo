package com.example.admin.openwpsdemo.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.util.Log;

import com.example.admin.openwpsdemo.LOGUtils;

/**
 * @Created by zwh.
 * @description： 上传错误日志的JobScheduler
 * @date 2018/6/1 17:23
 * @邮箱：zhaowh@zgjzd.cn
 */
public class BugUpLoadJobService extends JobService {

    private static final String TAG = BugUpLoadJobService.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service created");
    }

    /**
     * When the app's MainActivity is created, it starts this service. This is so that the
     * activity and this service can communicate back and forth. See "setUiCallback()"
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        LOGUtils.w(TAG,"onStartJob params--->");
        //TODO 上传错误日志



        jobFinished(params, false);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        LOGUtils.w(TAG,"onStopJob params--->");
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service destroyed");
    }


}
