package com.company;

import java.lang.reflect.Field;

public class Test3{
    private  String s="a";
    public static void main(String[] args) throws ClassNotFoundException {
        Class clas=Class.forName("com.company.SafePubish");
        Field[] fileds=clas.getFields();
        for(Field f:fileds){
            System.out.println(f);
        }
    }
}
class User{
    public String s;
    public User user;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        user=this;
        System.out.println(Thread.currentThread().getPriority()+","+"finalize()方法被执行");
    }
}


