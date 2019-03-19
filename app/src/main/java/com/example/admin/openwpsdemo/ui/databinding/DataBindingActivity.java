package com.example.admin.openwpsdemo.ui.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.biz.User;
import com.example.admin.openwpsdemo.databinding.ActivityDataBindingBindingImpl;

/**
 * @Created by zwh.
 * @description： dataBinding的使用
 * @date ${DATE} ${HOUR}:${MINUTE}
 * @邮箱：zhaowh@zgjzd.cn
 */
public class DataBindingActivity extends AppCompatActivity {

    private static final String TAG = DataBindingActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding);

        initView();
    }

    private void initView() {

        ActivityDataBindingBindingImpl impl = DataBindingUtil.setContentView(this,
                R.layout.activity_data_binding);
        User user = new User();
        user.setName("张三");
        user.setAge("20");
        user.setIDNumber("47858378495934");
        impl.setUser(user);

        user.setAge("30");

        user.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                LOGUtils.w(TAG,"propertyId--->" + propertyId);
            }
        });

    }

}
