package com.by.z.test.t;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 算法
 */
public class Q {

    public static void main(String[] args) {
//        System.out.println("请输入数字，用逗号隔开：");
//        Scanner scanner = new Scanner(System.in);
//        String readStr = scanner.next();
//        System.out.println("请输入排序方式（ASC | DESC）：");
//        String sortType = scanner.next().toUpperCase();
//        String[] s = readStr.split(",");
//        int[] a = stringArrayToIntArray(s);
//        System.out.println("排序方式为：" + sortType);
//        System.out.println("排序前：");
//        display(a);
//        sort(a, sortType);
//        System.out.println("排序后：");
//        display(a);

        //1,45,2,77,43,22,45,88,1,33,56
        Scanner scanner = new Scanner(System.in);
        String readStr = scanner.next();
        String[] s = readStr.split(",");
        Arrays.sort(s);
        String sortType = scanner.next().toUpperCase();
        if("DESC".equals(sortType)) {
            for (int i = s.length - 1; i >= 0; i--) {
                if(i == 0) {
                    System.out.print(s[i]);
                } else {
                    System.out.print(s[i] + ", ");
                }
            }
        } else {
            for (int i = 0; i < s.length; i++) {
                if(i == s.length - 1) {
                    System.out.print(s[i]);
                } else {
                    System.out.print(s[i] + ", ");
                }
            }
            System.out.println();
        }

    }

    //显示函数
    public static void display(int[] a) {
        System.out.println("---");
        for (int i = 0; i < a.length; i++) {
            if(i == a.length - 1) {
                System.out.print(a[i]);
            } else {
                System.out.print(a[i] + ", ");
            }
        }
        System.out.println();
    }

    //转换函数
    public static int[] stringArrayToIntArray(String[] s) {
        int[] a = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        return a;
    }

    //排序函数
    public static void sort(int[] a, String sortType) {
        for(int i = 0; i < a.length; i++) {
            int max = i;
            for(int j = max + 1; j < a.length; j++) {
                if("DESC".equals(sortType)) {
                    if (a[max] < a[j]) {
                        max = j;
                    }
                } else {
                    if(a[max] > a[j]) {
                        max = j;
                    }
                }
            }
            if(max != i) {
                //交换
                a[max] = a[max] + a[i];
                a[i] = a[max] - a[i];
                a[max] = a[max] - a[i];
            }
        }
    }

}
