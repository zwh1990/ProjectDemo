package com.example.admin.openwpsdemo.biz;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.admin.openwpsdemo.BR;

/**
 * @Created by zwh.
 * @description： dataBinding 的实体类
 * @date 2018/11/1 14:57
 * @邮箱：zhaowh@zgjzd.cn
 */
public class User extends BaseObservable {

    private String name;
    private String age;
    private String IDNumber;


    public User() {
    }


    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getAge() {
        return age;
    }

    @Bindable
    public String getIDNumber() {
        return IDNumber;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }


    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
        notifyPropertyChanged(BR.iDNumber);
    }
}
