package com.company.juc;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    public static void main(String[] args){
        ExecutorService service=new ThreadPoolExecutor(0,100,
                60L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1000),Executors.defaultThreadFactory());
        service.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
