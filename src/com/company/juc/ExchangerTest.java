package com.company.juc;

import java.util.ArrayList;
import java.util.concurrent.Exchanger;

public class ExchangerTest {
    public static void main(String[] args){
        Exchanger<ArrayList> exchanger=new Exchanger<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String str="T1";
                ArrayList list=new ArrayList();
                list.add(str);
                list.add("123");
                try {
                    list=exchanger.exchange(list);
                    System.out.println(Thread.currentThread().getName()+","+list);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String str="T2";
                ArrayList list=new ArrayList();
                list.add(str);
                list.add("123");
                try {
                    list=exchanger.exchange(list);
                    System.out.println(Thread.currentThread().getName()+","+list);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T2").start();
    }
}
