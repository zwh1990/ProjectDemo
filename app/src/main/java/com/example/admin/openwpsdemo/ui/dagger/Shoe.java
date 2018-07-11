package com.example.admin.openwpsdemo.ui.dagger;

import javax.inject.Inject;

/**
 * @Created by zwh.
 * @description：
 * @date 2018/7/11 14:30
 * @邮箱：zhaowh@zgjzd.cn
 */
public class Shoe {

    private String name;

    @Inject
    public Shoe() {
        this.name = "红蜻蜓皮鞋";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "name='" + name + '\'' +
                '}';
    }
}
