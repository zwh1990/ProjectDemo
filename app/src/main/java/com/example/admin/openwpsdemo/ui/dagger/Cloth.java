package com.example.admin.openwpsdemo.ui.dagger;

import javax.inject.Inject;

/**
 * @Created by zwh.
 * @description：  布料
 * @date 2018/7/11 11:05
 * @邮箱：zhaowh@zgjzd.cn
 */
public class Cloth {

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cloth{" +
                "color='" + color + '\'' +
                '}';
    }
}
