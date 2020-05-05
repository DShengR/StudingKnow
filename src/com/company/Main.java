package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        char[] chaArr=str.toCharArray();
        char[] arr=new char[chaArr.length];
        int cnt=0;
        for(int i=0;i<chaArr.length;i++){
            if(")".equals(String.valueOf(chaArr[i])) && arr.length==0){
                System.out.println(chaArr[i]);

                continue;
            }else if("(".equals(String.valueOf(chaArr[i]))){
                if(i<chaArr.length-1&&")".equals(String.valueOf(chaArr[i+1]))){
                    cnt++;
                }else{
                    arr[i]=chaArr[i];
                }
            }else{
                arr[i]=chaArr[i];
            }
        }
        System.out.println("类价钱："+cnt);

        int leftCnt=0,rightCnt=0;
        for(int i=0;i<arr.length;i++){
            System.out.println("："+arr[i]);
            if("(".equals(String.valueOf(arr[i]))){
                leftCnt++;
            }else if(")".equals(String.valueOf(arr[i]))){
                rightCnt++;
            }
        }
        cnt+=(leftCnt<rightCnt?leftCnt:rightCnt);
        System.out.println(cnt*2);
    }
}
