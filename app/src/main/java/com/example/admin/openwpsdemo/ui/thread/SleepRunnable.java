package com.example.admin.openwpsdemo.ui.thread;

import com.example.admin.openwpsdemo.LOGUtils;

/**
 * @Created by zwh.
 * @description：
 * @date 2018/7/10 18:12
 * @邮箱：zhaowh@zgjzd.cn
 */
public class SleepRunnable extends LiftOffRunnable {

    @Override
    public void run() {
        while (countDown -- > 0){
            LOGUtils.w(TAG,"status--->" + status());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
