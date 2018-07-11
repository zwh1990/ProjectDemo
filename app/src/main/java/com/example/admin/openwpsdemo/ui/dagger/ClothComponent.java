package com.example.admin.openwpsdemo.ui.dagger;

import dagger.Component;

/**
 * @Created by zwh.
 * @description：
 * @date 2018/7/11 11:26
 * @邮箱：zhaowh@zgjzd.cn
 */

@Component(modules = ClothModule.class)
public interface ClothComponent {

    void inject(ClothDaggerActivity clothDaggerActivity);

}
