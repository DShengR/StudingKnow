package com.company.collection.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class QueueTest {
    public static void main(String[] args) throws InterruptedException {
/*        ConcurrentLinkedQueue concurrentLinkedQueue=new ConcurrentLinkedQueue();
        concurrentLinkedQueue.offer(new Object());
        concurrentLinkedQueue.poll();
        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(10);
        arrayBlockingQueue.put(new Object());
        arrayBlockingQueue.take();
        LinkedBlockingQueue linkedBlockingQueue=new LinkedBlockingQueue();
        linkedBlockingQueue.put(new Object());
        linkedBlockingQueue.take();*/
       // DelayQueue delayQueue=new DelayQueue();
       // delayQueue.put(new MyTask());
       // SynchronousQueue synchronousQueue=new SynchronousQueue();
        //synchronousQueue.add(new Object());
        //synchronousQueue.put(new Object());
        TransferQueue transferQueue=new LinkedTransferQueue();
        transferQueue.add("str1");
        transferQueue.put("str2");
        //transferQueue.tryTransfer(new Object());
        //System.out.println(transferQueue.size());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(transferQueue.size());
                    int i=0;
                    while(transferQueue.peek()!=null){
                        System.out.println("i:"+i);
                        Object obj=transferQueue.take();
                        System.out.println(Thread.currentThread().getName()+","+obj);
                        i++;
                    }
                    System.out.println("after:"+transferQueue.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"T1").start();
        transferQueue.transfer("str3");
    }
    static class MyTask implements Delayed {

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }
}
