package com.by.z.test.t;

/**
 * 整数运算
 */
public class H {

     // "A5" + 1 = "A6"
    public String specialInteger(String specInt) {

//        0 - 48
//        9 - 57
//        A - 65
//        Z - 90
//        a - 97
//        z - 122

        char[] c = specInt.toCharArray();
        String head = "";
        String nubber = "";
        for (char i: c
             ) {
            int k = (int)i;
            if(k < 48 || k >57) {
                head += i;
            } else {
                nubber += i;
            }
        }

        Integer i = new Integer(nubber);
        i += 1;

        return head + i;
    }

    public static void main(String args[]) {

        String r = new H().specialInteger("AE5");

        System.out.println(r);

        display();
    }

    /**
     * 输出ACII
     */
    public static void display() {
        for(int i = 1; i < 128; i++) {
            char c = (char) i;
            if('0' == c || '9' == c || 'a' == c || 'z' == c || 'A' == c || 'Z' == c) {
                System.out.println(c + " - " + i);
            }
        }

    }
}
