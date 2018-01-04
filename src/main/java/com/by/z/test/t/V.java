package com.by.z.test.t;

/**
 * 将一整数逆序后放入一数组中（要求递归实现）
 */
public class V {

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7};
        int b[] = new int[a.length];
        display(a);
        dg(a, b, a.length);
        display(b);
    }

    public static void display(int[] a) {
        for(int i = 0; i<a.length; i++) {
            if(i == a.length - 1) {
                System.out.print(a[i]);
            } else {
                System.out.print(a[i] + ", ");
            }
        }
        System.out.println();
    }

    public static void dg(int[] a, int[] b, int length) {
        if(length == 0) {
            return;
        } else {
            b[a.length - length] = a[length - 1];
            dg(a, b, length - 1);
        }
    }

}
