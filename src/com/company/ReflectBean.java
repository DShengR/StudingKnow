package com.company;

import java.util.List;

public class ReflectBean {
    private String field1;
    public Integer field2;
    Object field3;
    protected List<Object> field4;
    private ReflectBean(){
        System.out.println("ReflectBean()");
    }
    ReflectBean(String field1,List<Object> list){
        this.field1=field1;
        this.field4=list;
        System.out.println("ReflectBean(str,list)");
    }
    public void test(){
        System.out.println("test()");
    }
    private void test(String arg){
        System.out.println(arg);
    }
    String test(String arg,int arg2){
        return arg+arg2+",reflect";
    }

}
