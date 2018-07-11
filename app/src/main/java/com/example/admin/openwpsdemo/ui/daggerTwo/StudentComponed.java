package com.example.admin.openwpsdemo.ui.daggerTwo;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * @Created by zwh.
 * @description：
 * @date 2018/7/11 17:00
 * @邮箱：zhaowh@zgjzd.cn
 */
@Singleton
@Component(modules = StudentModule.class)
public interface StudentComponed {

    void inject(StudentActivity studentActivity);

}
