package com.company.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    static Thread t1=null;
    static Thread t2=null;
    public static void main(String[] args){
        List list=new ArrayList<>();

        t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    if(i==5){
                        LockSupport.unpark(t2);
                        LockSupport.park();
                    }
                    System.out.println(Thread.currentThread().getName()+",add:"+i);
                    list.add(new Object());

                }
            }
        },"T1");
        t2=new Thread(new Runnable() {
            @Override
            public void run() {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName()+"run..");
                LockSupport.unpark(t1);
            }
        },"T2");
        t1.start();
        t2.start();
    }
}
