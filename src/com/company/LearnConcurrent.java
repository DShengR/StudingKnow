package com.company;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class LearnConcurrent {
    Thread t=new Thread();
    Timer timer=new Timer();
    //Executor线程池 只支持Runnable任务
    Executor exe= Executors.newFixedThreadPool(10);
    //ExecutorService实现Executor接口 支持Runnable任务和Callable任务
    ExecutorService execService=Executors.newFixedThreadPool(10);
    Future future=execService.submit(new Runnable() {
        @Override
        public void run() {

        }
    },"str");
    FutureTask futureTask=new FutureTask(new Callable(){

        @Override
        public Object call() throws Exception {
            return null;
        }
    });

     public LearnConcurrent(int a){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        },1);
    }
    public static void main(String[] args){
        long nCpu=Runtime.getRuntime().availableProcessors();
        System.out.println(nCpu);
        CountDownLatch latch=new CountDownLatch(4);
        //latch.await();
        latch.countDown();
        ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
        readWriteLock.readLock().tryLock();
        readWriteLock.writeLock().tryLock();
        ExecutorService execService=Executors.newFixedThreadPool(10);
        CompletionService comService=new ExecutorCompletionService(execService);
        Future comFuture=comService.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("done");
                return null;
            }
        });
     }
}
class   FutureRender{
    ExecutorService execService=Executors.newFixedThreadPool(10);
    public  void test() {
        Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        };
       Future<Object> future=execService.submit(callable);
        try {
            Object obj=future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            future.cancel(true);
        } catch (ExecutionException e) {
            e.getCause();
        }
    }
}
