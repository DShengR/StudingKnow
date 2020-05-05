package com.company.juc;

import java.util.concurrent.CountDownLatch;

public class LatchTest {

        public static void main(String[] args){
            final CountDownLatch latch=new CountDownLatch(10);
/*            for(int i=0;i<10;i++){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            latch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"start");
                    }
                },""+i).start();
                latch.countDown();
            }*/
            for(int i=0;i<100;i++){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"start");
                        latch.countDown();
                    }
                },""+i).start();
            }
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main end");
        }
}
