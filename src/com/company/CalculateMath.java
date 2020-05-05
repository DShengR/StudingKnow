package com.company;

public class CalculateMath {
    public static void main(String[] args){

        System.out.println(calculate(1.35,6));
    }
    public static double calculate(double x,double y){
        double molecule=3*x+4*Math.sqrt(exp(x,2)+2*exp(y,2));
        double denominator=1+exp(x,-y);
        return molecule/denominator;
    }
    public static double exp(double x,double y){
        if(y>0){
            return x*exp(x,y-1);
        }else if(y<0){
            return 1/(x*exp(x,-y-1));
        }else{
            return 1;
        }
    }
}
