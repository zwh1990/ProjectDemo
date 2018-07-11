package com.example.admin.openwpsdemo.ui.daggerTwo;

/**
 * @Created by zwh.
 * @description：
 * @date 2018/7/11 17:11
 * @邮箱：zhaowh@zgjzd.cn
 */
public class Person {

    Student student;

    public Person(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
