package com.by.z.test.t;

import java.util.Collections;

/**
 * 选择排序
 */
public class N {

    public static void main(String[] args) {

        int[] a = {1, 7, 8, 9, 3, 2, 7, 5, 4, 6};
        System.out.println("排序前序列：");
        displayArrays(a);

        sort(a);
        System.out.println("排序后序列：");
        displayArrays(a);

    }

    public static void sort(int[] a) {
        for(int i = 0; i<a.length; i++) {
            int k = i;
            for(int j = k + 1; j<a.length; j++) {
                if(a[j] < a[k]) {
                    k = j;
                }
            }
            if (i != k) {
                a[i] = a[i] + a[k];
                a[k] = a[i] - a[k];
                a[i] = a[i] - a[k];
            }

            System.out.println("第 [ " + (i + 1) + " ] 排序：");;
            displayArrays(a);
        }
    }

    public static void displayArrays(int[] a) {

        int lengthCount = 0;
        for (int i: a
             ) {
            if(lengthCount == a.length - 1) {
                System.out.print(i);
            } else {
                System.out.print(i + ", ");
            }
            lengthCount ++;
        }
        System.out.println();

    }

}