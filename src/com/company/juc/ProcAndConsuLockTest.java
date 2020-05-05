package com.company.juc;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProcAndConsuLockTest {
    static ReentrantLock lock=new ReentrantLock();
    static Condition procCondition=lock.newCondition();
    static Condition consuCondition=lock.newCondition();
    static ThreadLocal t1=new ThreadLocal();
    public static void main(String[] args) {
        t1.set(new Object());
        MyContainer container = new MyContainer();
        //生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            container.add(new Object());
                            System.out.println(Thread.currentThread().getName() + ",add");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "P" + i).start();
        }
        //消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            container.get();
                            System.out.println(Thread.currentThread().getName() + ",get");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "C" + i).start();
        }
    }
    static class MyContainer<T>{
        static final int MAX_CNT=10;
        LinkedList<T> list=new LinkedList<T>();
        int size;
        public  void add(T t) throws InterruptedException {
            try{
                lock.lock();
                while(size>=MAX_CNT){
                    procCondition.await();
                }
                list.add(t);
                size++;
                consuCondition.signalAll();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }


        }
        public synchronized int getSize(){
            return size;
        }
        public T get() throws InterruptedException {
            T t=null;
            try{
                lock.lock();
                while(size<=0){
                    consuCondition.await();
                }
                t=list.removeFirst();
                size--;
                procCondition.signalAll();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }

            return t;
        }
    }
}
