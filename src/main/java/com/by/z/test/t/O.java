package com.by.z.test.t;

/**
 * Created by byvai on 2017/12/29.
 *
 * 递归求和
 */
public class O {

    public static void main(String[] args) {

        int sum = dd(100);

        System.out.println(sum);

        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));
        System.out.println(Math.round(-11.6));
    }

    public static int dd(int a) {
        if(a > 0) {
            return a + dd(a - 1);
        } else {
            return 0;
        }
    }

}
