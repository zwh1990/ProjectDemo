package com.example.admin.openwpsdemo.ui;

import android.content.ContentResolver;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;

import cn.com.cybertech.models.User;
import cn.com.cybertech.pdk.UserInfo;

public class UserInfoActivity extends AppCompatActivity {


    private TextView tv_name;
    private TextView tv_passWord;
    private static final String TAG = UserInfoActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        initView();

    }

    private void initView() {

        tv_name = findViewById(R.id.tv_name);
        tv_passWord = findViewById(R.id.tv_passWord);

        User user = UserInfo.getUser(this);

        if(user != null){
            String account = user.getAccount();
            String password = user.getPassword();
            String name = user.getName();

            LOGUtils.w(TAG,"name--->" + name);
            LOGUtils.w(TAG,"account--->" + account);
            LOGUtils.w(TAG,"password--->" + password);

            tv_name.setText("账号是:"+ account+",用户是:"+ name);
            tv_passWord.setText("密码是:"+ password);
        }


//        fetchAllContacts();

    }

    public void fetchAllContacts() {
        ContentResolver contentResolver = this.getContentResolver();
        Cursor cursor = contentResolver.query(android.provider.ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);
        cursor.getCount();
        while(cursor.moveToNext()) {
            LOGUtils.w(TAG,"id--->"+cursor.getString(cursor.getColumnIndex(android.provider.ContactsContract.Contacts._ID)));
            LOGUtils.w(TAG,"name--->"+cursor.getString(cursor.getColumnIndex(android.provider.ContactsContract.Contacts.DISPLAY_NAME)));
        }
        cursor.close();
    }


}
