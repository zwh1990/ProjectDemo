package com.example.admin.openwpsdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.zxing.activity.CaptureActivity;

public class ZXingActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_zxing_scan;
    private static final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing);

        bt_zxing_scan = findViewById(R.id.bt_zxing_scan);
        bt_zxing_scan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //扫描结果回调
        if (resultCode == RESULT_OK) { //RESULT_OK = -1
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("qr_scan_result");
            //将扫描出的信息显示出来
            Toast.makeText(ZXingActivity.this,scanResult,Toast.LENGTH_SHORT).show();
        }
    }

}
