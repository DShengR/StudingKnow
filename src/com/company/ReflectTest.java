package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException {
        AtomicInteger ai=new AtomicInteger(0);
        ai.incrementAndGet();
        Class clas=Class.forName("com.company.ReflectBean");
        //getFields只能拿到public的
        Field[] fileds=clas.getFields();
        for(Field f:fileds){
            //System.out.println(f.getName());
        }
        Field[] fields2=clas.getDeclaredFields();
        for(Field f:fields2){
            //System.out.println(f.getName()+","+f.getGenericType()+","+f.getType()+",");
        }
        Field tFiled=clas.getDeclaredField("field4");
        //System.out.println(tFiled);
        Constructor[] constructors=clas.getDeclaredConstructors();

        for(Constructor con:constructors){
            //System.out.println(con);
        }

        Constructor con=clas.getDeclaredConstructor(String.class, List.class);
        //System.out.println(con);
        ReflectBean obj=(ReflectBean)con.newInstance("hello",new ArrayList<Object>());
        System.out.println(obj);
        obj.test();
        Method method=clas.getDeclaredMethod("test",String.class);
        System.out.println(method);
        method.setAccessible(true);
        method.invoke(obj,"");
    }
}
