package com.example.admin.openwpsdemo.ui.dagger;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @Created by zwh.
 * @description： 衣服
 * @date 2018/7/11 14:50
 * @邮箱：zhaowh@zgjzd.cn
 */
public class Clothes {

    private Cloth cloth;


    public String getCloth() {

        return cloth.getColor() + "衣服";
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "cloth=" + cloth +
                '}';
    }
}
