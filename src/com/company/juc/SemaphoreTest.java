package com.company.juc;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args){
        final Semaphore semaphore=new Semaphore(2);
        semaphore.release(2);
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+",get permit");
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        System.out.println(Thread.currentThread().getName()+",release permit");
                        semaphore.release();
                    }
                }
            },""+i).start();
        }
    }
}
