package com.by.z.test.t;

/**
 * Created by byvai on 2017/12/29.
 */
public class P {

    public static void main(String[] args) {

        P1 p = new P1("name");
        System.out.println(p.getName());
        p = ff(p);
        System.out.println(p.getName());
    }

    public static P1 ff(final P1 p) {
        p.setName("finalName");
        return p;
    }

}


class P1 {

    public P1(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}