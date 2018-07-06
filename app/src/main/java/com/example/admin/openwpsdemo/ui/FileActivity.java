package com.example.admin.openwpsdemo.ui;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;

import java.io.File;
import java.util.List;

public class FileActivity extends AppCompatActivity {

    private static final String TAG = FileActivity.class.getSimpleName();
    private List<String> files;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        initView();
    }

    private void initView() {
        //读取固定路径下的文件夹名称
        String logPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "hczz"
                + File.separator + "ajbh";
        boolean isHaveFolder = isHaveFolder(logPath,"test.pdf");
        LOGUtils.w(TAG,"isHaveFolder--->" + isHaveFolder);
    }


    public boolean isHaveFolder(String path,String fileName) {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                LOGUtils.w(TAG,"文件夹是空的!");
                return false;
            } else {
                for (File file2 : files) {
                    if(file2.getName().equals(fileName)){
                        return true;
                    }
                }
                return false;
            }
        } else {
            LOGUtils.w(TAG,"文件不存在!");
            return false;
        }

    }

}
