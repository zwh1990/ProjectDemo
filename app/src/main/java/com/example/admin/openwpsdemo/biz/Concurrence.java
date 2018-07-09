package com.example.admin.openwpsdemo.biz;

/**
 * @Created by zwh.
 * @description：高并发
 * @date 2018/7/9 14:26
 * @邮箱：zhaowh@zgjzd.cn
 */
public class Concurrence {

    int count = 0;

    public void increase() {
        try {
            Thread.sleep(200);
            count ++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
