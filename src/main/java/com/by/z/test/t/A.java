package com.by.z.test.t;

/**
 * 外部类、内部类
 *
 * A：外部类
 * B：静态内部类
 * C：内部类
 */
public class A {

    private int iA = 1;

    public static class B {
        private int iB = 2;
    }

    class C {
        private int iC = 3;

        public int getiC() {
            return iC;
        }
    }

    public static void main(String[] args) {
        A a = new A();
        A.B b = new A.B();
        C c = a.new C();

        System.out.println(c.getiC());

        System.out.println("---");
        String s1 = new String("s");
        String s2 = new String("s");
        System.out.println(s1 == s2);

        String s3 = "s";
        String s4 = "s";
        System.out.println(s3 == s4);

        System.out.println(s3.equals(s4));
        System.out.println(s1.equals(s2));

        A a2 = new A();

        System.out.println(a == a2);
        System.out.println(a.equals(a2));

        System.out.println("---");
        short short1 = 1;
//        short1 = short1 + 1;
        short1 += 1;

        System.out.println(Math.round(15.7));
        System.out.println(Math.round(-15.7));

        int x = 3, y = 5;
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("交换");
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("x = " + x + ", y = " + y);
    }
}
