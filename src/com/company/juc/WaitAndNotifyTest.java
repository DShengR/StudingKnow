package com.company.juc;

import java.util.ArrayList;
import java.util.List;

public class WaitAndNotifyTest {
    public static void main(String[] args){
        List list=new ArrayList();
        Object obj=new Object();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    for (int i = 0; i < 10; i++) {
                        if (i == 5) {
                            try {
                                obj.notify();
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + ",add:" + i);
                        list.add(new Object());

                    }
                }
            }
        },"T1");
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName()+",run..");
                    obj.notify();
                }
            }
        },"T2");
        t1.start();
        t2.start();
    }
}
