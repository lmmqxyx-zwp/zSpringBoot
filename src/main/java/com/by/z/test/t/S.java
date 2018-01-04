package com.by.z.test.t;

/**
 * 任意数字序列“123456”之类，输出它们所有的排列组合
 */
public class S {

    public static void main(String[] args) {
        char[] c = "123456".toCharArray();
        int count = 0;
        for(int i1 = 1; i1 < 7; i1 ++) {
            for (int i2 = 1; i2 < 7; i2 ++) {
                for(int i3 = 1; i3 < 7; i3 ++) {
                    for (int i4 = 1; i4 < 7; i4 ++) {
                        for (int i5 = 1; i5 < 7; i5 ++) {
                            for (int i6 = 1; i6 < 7; i6 ++) {
                                if(i1 != i2 &&
                                        i1 != i3 &&
                                        i1 != i4 &&
                                        i1 != i5 &&
                                        i1 != i6 &&
                                        i2 != i3 &&
                                        i2 != i4 &&
                                        i2 != i5 &&
                                        i2 != i6 &&
                                        i3 != i4 &&
                                        i3 != i5 &&
                                        i3 != i6 &&
                                        i4 != i5 &&
                                        i4 != i6 &&
                                        i5 != i6) {
                                    System.out.println("" + i1 + i2 + i3 + i4 + i5 + i6);
                                    count ++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("=================================");
        System.out.println(count);
    }

}
