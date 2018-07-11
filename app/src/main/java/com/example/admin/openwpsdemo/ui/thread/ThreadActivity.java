package com.example.admin.openwpsdemo.ui.thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;

import java.util.ArrayList;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        //测试实现Runnable 的代码
//        run();

        //测试实现Callable 的代码
//        try {
//            callable();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //测试sleep()方法
//            sleep();

        //测试线程的优先级  优先级的设置不管用
        priority();

    }

    private void priority() {

        Thread threadA = new Thread(new DemoRunnable(), "A");
        Thread threadB = new Thread(new DemoRunnable(), "B");
        Thread threadC = new Thread(new DemoRunnable(), "C");

        threadA.setPriority(MAX_PRIORITY);
        threadB.setPriority(NORM_PRIORITY);
        threadC.setPriority(MIN_PRIORITY);

        threadA.start();
        threadB.start();
        threadC.start();
    }

    //测试sleep()方法
    private void sleep() {
        for (int i = 0; i < 3 ; i++) {
            executorService = Executors.newSingleThreadExecutor();
            executorService.execute(new SleepRunnable());
        }
        executorService.shutdown();
        LOGUtils.w(TAG,"开启线程---->");
    }

    //测试实现Callable 的代码
    private void callable() throws ExecutionException, InterruptedException {
        ExecutorService executorService =  Executors.newFixedThreadPool(10);
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            results.add(executorService.submit(new LiftOffCallable(i)));
        }

        for (Future<String> future:results){
            String call = future.get();
            LOGUtils.w(TAG,"call--->" + call);
        }
    }

    //测试实现Runnable 的代码
    private void run() {
        for (int i = 0; i < 3 ; i++) {
            executorService = Executors.newSingleThreadExecutor();
            executorService.execute(new LiftOffRunnable());
        }
        executorService.shutdown();
        LOGUtils.w(TAG,"开启线程---->");
    }

    class DemoRunnable implements Runnable {
        @Override
        public void run() {

            for (int i = 0; i < 1000 ; i++) {
                LOGUtils.w(TAG,"DemoRunnable--->" + Thread.currentThread().getName() + ","+ i);
            }
        }
    }

}
