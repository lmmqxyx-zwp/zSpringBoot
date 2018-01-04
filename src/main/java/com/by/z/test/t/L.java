package com.by.z.test.t;

/**
 * Created by byvai on 2017/12/27.
 */
public class L {

    public static void main(String[] args) throws Exception{
        String s = "我是ABC";
        System.out.println(s.length());
        System.out.println(s.getBytes("UTF-8").length);
        System.out.println(s.getBytes("GBK").length);
    }

}
