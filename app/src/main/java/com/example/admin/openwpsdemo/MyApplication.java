package com.example.admin.openwpsdemo;

import android.app.Application;

import com.example.admin.openwpsdemo.utils.CrashHandler;

/**
 * @Created by zwh.
 * @description：
 * @date 2019/2/26 13:51
 * @邮箱：zhaowh@zgjzd.cn
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler= CrashHandler.getInstance();
        crashHandler.init(this);
    }
}
