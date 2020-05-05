package com.company;

public class SafePubish {
   public HoldeFactory factory=new HoldeFactory();
    public static void main(String[] args){
        SafePubish pubish=new SafePubish();
        pubish.init();
        Thread[] threadArrw=new Thread[10000];
        for (int i=0;i<threadArrw.length;i++){
            int finalI = i;
            Thread th=new Thread(){
                public void run(){
                    pubish.test(finalI);
                }
            };
            threadArrw[i]=th;
        }
        for(int i=0;i<threadArrw.length;i++){
            threadArrw[i].start();
        }
    }
    public void test(int n){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<1000;i++) {
            if(i==100||i==500||i==700){
                factory.initHolder(n);
            }
            factory.holder.assertSanity();
        }
    }
    public void init (){
        factory.initHolder(10);
    }

    class Holder{
        private final int n;
        public Holder(int n){
            this.n=n;
        }
        public void assertSanity(){
            if(n!=n){
                System.out.println("method is false");
            }else{
                //System.out.println(this.n);
            }

        }
    }
   class HoldeFactory{
        public Holder holder;
        public void initHolder(int n){
            holder=new Holder(n);
        }
    }
}
