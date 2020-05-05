package com.company.juc;

import java.util.ArrayList;
import java.util.List;

public class ProceAndConsuSynTest {
    public static void main(String[] args){
        MyContainer container=new MyContainer();
        //生产者线程
        for(int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true){
                            container.add(new Object());
                            System.out.println(Thread.currentThread().getName()+",add");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"P"+i).start();
        }
        //消费者线程
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true){
                            container.get();
                            System.out.println(Thread.currentThread().getName()+",get");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"C"+i).start();
        }
    }
    static class MyContainer<T>{
        List<T> list=new ArrayList<T>();
        static final int MAX_CNT=10;
        int size;
        public  synchronized  void add(T obj) throws InterruptedException {
            while(size()>=MAX_CNT){
                wait();
            }
            list.add(obj);
            size++;
            notifyAll();
        }
        public synchronized T get() throws InterruptedException {
            while(size()<=0){
                wait();
            }
            T obj=list.remove(size()-1);
            size--;
            notifyAll();
            return obj;
        }
        public synchronized int size(){
            return list.size();
        }
    }
}
