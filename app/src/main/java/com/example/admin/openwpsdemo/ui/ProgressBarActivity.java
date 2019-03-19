package com.example.admin.openwpsdemo.ui;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.ui.thread.ThreadActivity;

public class ProgressBarActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progressDialog.setProgress(msg.what);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("正在同步数据");
        progressDialog.setCancelable(false);
        progressDialog.setMax(100);
        progressDialog.show();

        Thread threadA = new Thread(new DemoARunnable(), "A");
        threadA.start();

    }

    class DemoARunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 101; i++) {
                try {
                    Thread.sleep(200);
                    handler.sendEmptyMessage(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
