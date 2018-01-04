package com.by.z.test.t;

import java.util.Scanner;

/**
 * 递归实现回文判断（如：abcdedbca就是回文，判断一个面试者对递归理解的简单程序）
 */
public class X {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入字符串：");
        String s = scanner.next();
        System.out.println("原始字符串：" + s + " - " + (dg(s, 0, true)?"是回文字符串":"不是回文字符串"));
    }

    public static boolean dg(String s, int h, boolean f) {
        if(s.length()/2 <= h + 1) {
            f = true;
        } else {
            if (s.charAt(h) == s.charAt(s.length() - h - 1)) {
                dg(s, h + 1, f);
            } else {
                f = false;
            }
        }

        return f;
    }

}
