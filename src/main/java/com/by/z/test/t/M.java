package com.by.z.test.t;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 阶乘、字符串排序
 */
public class M {

    public static void main(String[] args) {
        String s = "hfjghjdkdsaeer";
        char[] c = s.toCharArray();
        System.out.println(s); //无序
        Arrays.sort(c);
        String s2 = new String(c);
        System.out.println(s2); //有序

        System.out.println("----------------");

        // 求阶乘之和
        System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);

        int co = scanner.nextInt();
        jc(co);
    }

    public static void jc(int co) {
        int sum = 0;
        for (int i = 1; i <= co; i++) {
            int t = 1;
            for(int j = 1; j <= i; j++) {
                t *= j;
            }
            sum += t;
        }

        System.out.println("sum : " + sum);
    }

}
