package com.example.admin.openwpsdemo.ui.thread;

import com.example.admin.openwpsdemo.LOGUtils;

import java.util.concurrent.Callable;

/**
 * @Created by zwh.
 * @description： 多线程 Runnable
 * @date 2018/7/10 16:18
 * @邮箱：zhaowh@zgjzd.cn
 */
public class LiftOffCallable implements Callable<String>{

    private int id;

    public LiftOffCallable(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        return "result of taskWithResult" + id;
    }

}
