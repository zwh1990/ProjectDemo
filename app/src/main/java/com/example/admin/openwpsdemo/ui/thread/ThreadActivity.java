package com.example.admin.openwpsdemo.ui.thread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.MIN_PRIORITY;
import static java.lang.Thread.NORM_PRIORITY;

//线程测试页面

public class ThreadActivity extends AppCompatActivity {

    private static final String TAG = ThreadActivity.class.getSimpleName();
    private ExecutorService executorService;

    private TextView tv_lable;
    private List<String> datas;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv_lable.setText(String.valueOf(datas.size()));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        tv_lable = findViewById(R.id.tv_lable);
        datas = new ArrayList<>();

        initRunable();

    }

    private void initRunable() {

        Thread threadA = new Thread(new DemoARunnable(), "A");
        Thread threadB = new Thread(new DemoBRunnable(), "B");


        threadA.start();
        threadB.start();

    }


    class DemoARunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(1000);
                    handler.sendEmptyMessage(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class DemoBRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(500);
                    datas.add("元素" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
