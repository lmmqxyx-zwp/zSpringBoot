package com.by.z.test.t;

import org.hibernate.boot.jaxb.SourceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by byvai on 2017/12/31.
 */
public class R {

    public static void main(String[] args) {
        //输入数字转成大写
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字：");
        try {
            String s = sc.next();
            //数字个位、十位、百位、千位、万位...       区别
            List<String> nums = getNumsByDouble(s);
            display(nums);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("请输入正确的数字！");
        }

    }

    public static void display(List<String> l) {
        System.out.println("输出结果：");
        System.out.println("===");
        for (String s: l
             ) {
            System.out.print(s);
        }
        System.out.println();
        System.out.println("===");
    }

    public static List<String> getNumsByDouble(String s) {
        List<String> nums = new ArrayList<String>();

        String[] t1 = s.split("\\.");

        if (t1.length == 2) {
            //说明是有小数点
            String zs = t1[0];
            String xs = t1[1];
            char[] _zs = zs.toCharArray();
            char[] _xs = xs.toCharArray();
            zsOperation(nums, _zs, true);
            xsOperation(nums, _xs);
        } else if(t1.length == 0) {
            //没有小数点
            char[] _zs = s.toCharArray();
            zsOperation(nums, _zs, false);
        }

        return nums;
    }

    //整数部分的操作
    public static void zsOperation(List<String> nums, char[] _zs, boolean f) {
        int length = _zs.length;
        List<String> r = getHighNum(length);

        for(int i = 0; i < _zs.length; i++) {
            nums.add(replace( _zs[i]));
            nums.add(r.get(i));
        }

        if(f) {
            nums.add("点");
        }
    }

    //小数部分的操作
    public static void xsOperation(List<String> nums, char[] _xs) {
        for (int i = 0; i < _xs.length; i++) {
            nums.add(replace(_xs[i]));
        }
    }

    public static List<String> getHighNum(int length) {
        List<String> s = new ArrayList<String>();
        switch (length) {
            case 1:
                s.add("");
                break;
            case 2:
                s.add("拾");
                s.add("");
                break;
            case 3:
                s.add("百");
                s.add("拾");
                s.add("");
                break;
            case 4:
                s.add("千");
                s.add("百");
                s.add("拾");
                s.add("");
                break;
            case 5:
                s.add("万");
                s.add("千");
                s.add("百");
                s.add("拾");
                s.add("");
                break;
        }

        return s;
    }

    //替换数字
    public static String replace(char c) {
        String s = "■";
        switch (c) {
            case '0':
                s = "零";
                break;
            case '1':
                s = "壹";
                break;
            case '2':
                s = "贰";
                break;
            case '3':
                s = "叁";
                break;
            case '4':
                s = "肆";
                break;
            case '5':
                s = "伍";
                break;
            case '6':
                s = "陆";
                break;
            case '7':
                s = "柒";
                break;
            case '8':
                s = "扒";
                break;
            case '9':
                s = "玖";
                break;
        }

        return s;
    }
}
