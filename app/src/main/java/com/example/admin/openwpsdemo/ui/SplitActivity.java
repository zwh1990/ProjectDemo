package com.example.admin.openwpsdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;

public class SplitActivity extends AppCompatActivity {


    private static final String TAG = SplitActivity.class.getSimpleName();
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split);

        tv = findViewById(R.id.tv);

//        String content = "。</br></br><br><br><font color='#303F9F'>问：</font></br></br><br><br>答：。</br></br>";
//        int index = content.indexOf("<font");
//        String split = content.substring(index , content.length());
//        LOGUtils.w(TAG,"split --->" + split);

        String content = "/pubstxx/ajst/ajJbxx/formSasp.html?spbh=42010277000020180800003&roleName=ksdld&xxid=42010277000020180800000000000003&ajbh=A4201027700002017080001";
        int index = content.lastIndexOf("=");
        String substring = content.substring(index + 1, content.length());

        tv.setText(substring);


    }
}
