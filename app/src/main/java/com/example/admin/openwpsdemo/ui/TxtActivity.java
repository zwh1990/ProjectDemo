package com.example.admin.openwpsdemo.ui;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.SuperFileView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TxtActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = TxtActivity.class.getSimpleName();

    private Button bt_txt;

    private SuperFileView superView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txt);

        initView();

    }



    private void initView() {
        bt_txt = findViewById(R.id.bt_txt);
        superView = findViewById(R.id.superView);

        bt_txt.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        //开启线程下载文件
//        newThreadLoadText();

        //读取本地文件
        try {
            readLocalText();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readLocalText() throws IOException {
//        final String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/text.txt";
        final String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test.docx";
//        InputStream assetsInputStream = Utility.getAssetsInputStream(this, "text.txt");
        superView.post(new Runnable() {
            @Override
            public void run() {
                superView.displayFile(new File(path));
            }
        });
    }

    private void newThreadLoadText() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    downLoadDoc();
                } catch (IOException e) {
                    LOGUtils.w(TAG, "e.toString-->" + e.toString());
                }
            }
        }).start();
    }

    private void downLoadDoc() throws IOException {
        download("http://192.168.1.101:8081/zh_hczz/api/zcqk/downfile.htm");
    }

    public void download(String url) throws IOException {
        URL urlGet = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlGet.openConnection();
        InputStream inputStream = conn.getInputStream();
        String headerField = conn.getHeaderField("Content-Disposition");
        LOGUtils.w(TAG,"headerField--->" + headerField);
        String[] split = headerField.split("=");
        String fileName = split[1];

        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        final String downloadUpdateApkFilePath = filePath + File.separator + "hczz"+ File.separator + fileName;
        final File file = new File(downloadUpdateApkFilePath);
        FileOutputStream fos = new FileOutputStream(file);
        byte[] b = new byte[1024];
        while((inputStream.read(b)) != -1){
            fos.write(b);
        }
        inputStream.close();
        fos.close();

        superView.post(new Runnable() {
            @Override
            public void run() {
                superView.displayFile(file);
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LOGUtils.w(TAG,"FileDisplayActivity-->onDestroy");
        if (superView != null) {
            superView.onStopDisplay();
        }
    }


}
