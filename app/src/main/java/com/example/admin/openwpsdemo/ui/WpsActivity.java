package com.example.admin.openwpsdemo.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.openwpsdemo.R;

import java.io.File;
import java.util.List;

public class WpsActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = WpsActivity.class.getSimpleName();
    private Button bt_wps;
    private boolean isInstall;

    private StringBuffer sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wps);

        initView();
    }

    private void initView() {
        bt_wps = findViewById(R.id.bt_wps);
        bt_wps.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String path = Environment.getExternalStorageDirectory().getPath() + "/PDF2.pdf";
        if(isInstall()){
            openFile(path);
        }else {
            Toast.makeText(this,"wps未安装",Toast.LENGTH_SHORT).show();
        }
    }

    public boolean openFile(String path) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setClassName("cn.wps.moffice_eng",
                "cn.wps.moffice.documentmanager.PreStartActivity");
        File file = new File(path);
        if (file == null || !file.exists()) {
            return false;
        }
        Uri uri = Uri.fromFile(file);
        Log.w(TAG,"uri--->" +uri);
        intent.setData(uri);
        intent.putExtras(bundle);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // 判断是否安装wps
    public boolean isInstall() {

        List<PackageInfo> list = getPackageManager().getInstalledPackages(
                PackageManager.GET_PERMISSIONS);

        sb = new StringBuffer();

        Log.w(TAG, "list--->" + list.size());
        for (PackageInfo packageInfo : list) {

            sb.append(packageInfo.packageName + "\n");

            if ("cn.wps.moffice_eng".equals(packageInfo.packageName)) {
                isInstall = true;
            }
        }
        Log.w(TAG, "sb--->" + sb);
        Log.w(TAG, "isInstall--->" + isInstall);
        return isInstall;

    }

}
