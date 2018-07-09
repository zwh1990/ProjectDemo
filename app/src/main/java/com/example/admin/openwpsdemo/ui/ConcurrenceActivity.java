package com.example.admin.openwpsdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.biz.Concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//高并发页面

public class ConcurrenceActivity extends AppCompatActivity {


    public static final String TAG = ConcurrenceActivity.class.getSimpleName();
    private Concurrence concurrence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concurrence);

        concurrence = new Concurrence();

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100 ; i++) {

            LOGUtils.w(TAG,"i--->" + i);
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    concurrence.increase();
                    LOGUtils.w(TAG,"concurrence--->" + concurrence.getCount());
                }
            });
        }

        //关闭线程，并提交结果
        executorService.shutdown();
        //避免出现main主线程先跑完而子线程还没结束，在这里给予一个关闭时间
        try {
            executorService.awaitTermination(3000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        LOGUtils.w(TAG,"concurrence--->" + concurrence.getCount());

    }

}
