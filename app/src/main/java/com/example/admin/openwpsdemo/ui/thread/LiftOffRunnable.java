package com.example.admin.openwpsdemo.ui.thread;

import com.example.admin.openwpsdemo.LOGUtils;

/**
 * @Created by zwh.
 * @description： 多线程 Runnable
 * @date 2018/7/10 16:18
 * @邮箱：zhaowh@zgjzd.cn
 */
public class LiftOffRunnable implements Runnable{

    public static final String TAG = LiftOffRunnable.class.getSimpleName();

    protected int countDown =  10;
    private static int taskCount = 0;
    private final int id = taskCount ++;

    public LiftOffRunnable() {
        LOGUtils.w(TAG,"id--->" + id);
    }

    public LiftOffRunnable(int countDown) {
        this.countDown = countDown;
    }

    public String status(){
        return "#"+ id + "(" +
                (countDown > 0 ? countDown : "LiftOffRunnable") +")";
    }

    @Override
    public void run() {
        while (countDown -- > 0){
            LOGUtils.w(TAG,"status--->" + status());
            Thread.yield();
        }
    }
}
