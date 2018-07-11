package com.example.admin.openwpsdemo.ui.dagger;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @Created by zwh.
 * @description：
 * @date 2018/7/11 11:07
 * @邮箱：zhaowh@zgjzd.cn
 */

@Module
public class ClothModule {

    @Provides
    @Named("red")
    public Cloth getRedCloth(){
        Cloth cloth = new Cloth();
        cloth.setColor("红色");
        return  cloth;
    }

    @Provides
    @Named("blue")
    public Cloth getBlueCloth(){
        Cloth cloth = new Cloth();
        cloth.setColor("蓝色");
        return  cloth;
    }

}
