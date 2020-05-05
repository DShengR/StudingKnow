package com.company;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class CheckMail {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str=replaceNameX("的盛");

        System.out.println(str);
    }
    public static String replaceNameX(String str)  {
        // 获取姓名长度
        String custName = str;
        byte[] nameByte=custName.getBytes(Charset.forName("GBK"));
        int length = nameByte.length;
        byte[] showByte = new byte[0];
        if(length>4){
            showByte=new byte[4];
            System.arraycopy(nameByte,length-4,showByte,0,4);

        }else{
            showByte=new byte[2];
            System.arraycopy(nameByte,length-2,showByte,0,2);
        }
        String showName =new String(showByte,Charset.forName("GBK"));
        return "*"+showName;
    }
}
