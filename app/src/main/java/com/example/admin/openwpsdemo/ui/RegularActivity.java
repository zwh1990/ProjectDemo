package com.example.admin.openwpsdemo.ui;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = RegularActivity.class.getSimpleName();
    private EditText editText;
    private Button bt_regular;

    private FrameLayout fl_content;
    private LinearLayout ll;
    private TextView tv_content;

    private List<View> container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular);

        editText = findViewById(R.id.editText);
        bt_regular = findViewById(R.id.bt_regular);
        fl_content = findViewById(R.id.fl_content);
        tv_content = findViewById(R.id.tv_content);
        ll = findViewById(R.id.ll);


        tv_content.setText("JKSDGGKGAJG");

        bt_regular.setOnClickListener(this);
        container = new ArrayList<>();

        for (int i = 0; i <3 ; i++) {
            TextView tv = new TextView(this);
            tv.setText("jfdakjg");
            ll.addView(tv);
            container.add(tv);
        }

    }

    @Override
    public void onClick(View view) {

        String input = editText.getText().toString().trim();
        Pattern p = Pattern.compile("^[0-9]+([.]{1}[0-9]+){0,1}$");
        Matcher m = p.matcher(input);
        boolean matches = m.matches();

        if (matches) {
            ToastUtil.showInfo(this, "正确");
        } else {
            ToastUtil.showInfo(this, "错误");
        }

        for (int i = 0; i < container.size(); i++) {
            LOGUtils.w(TAG,"--->" + container.get(i).getHeight());
        }

    }

}