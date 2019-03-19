package com.example.admin.openwpsdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalActivity extends AppCompatActivity {

    private static final String TAG = ThreadLocalActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_local);

        Thread tA = new Thread(new ThreadDemo(), "A");
        Thread tB = new Thread(new ThreadDemo(), "B");
        Thread tC = new Thread(new ThreadDemo(), "C");
        tA.start();
        tB.start();
        tC.start();
    }

    class ThreadDemo implements Runnable {

        @Override
        public void run() {
            // 线程的id是在它第一次run的时候才分配的，它run，它请求分配id，系统给它一个id
            UniqueThreadIdGenerator uniqueThreadIdGenerator = new UniqueThreadIdGenerator();
            int id = uniqueThreadIdGenerator.getCurrentThreadId();
            LOGUtils.w(TAG, Thread.currentThread().getName() + " is running, its ID is: " + id);
        }
    }


    public class UniqueThreadIdGenerator {

        private AtomicInteger uniqueId = new AtomicInteger(0);

        private ThreadLocal<Integer> uniqueNum = new ThreadLocal<Integer>() {
            @Override
            // 如果当前线程是第一次请求id的分配则给它赋一个初始值
            protected Integer initialValue() {
                return uniqueId.getAndIncrement();
            }
        };

        // 给当前线程返回它的id
        public int getCurrentThreadId() {
            return uniqueNum.get();
        }

        // 设置当前线程的id
        public void setCurrentThreadId(int id) {
            uniqueNum.set(id);
        }

    }
}
