package com.by.z.test.t;

import java.util.Scanner;
import java.util.UUID;

/**
 * 求高于平均分的学生学号及成绩（学号和成绩人工输入）
 */
public class W {

    public static void main(String[] args) {
        Student[] students = new Student[3];
        //初始化
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<students.length; i++) {
            students[i] = new Student();
            students[i].setXh(UUID.randomUUID().toString());
            System.out.println("输入学号是 [ " + students[i].getXh() + " ] 的成绩：");
            students[i].setCj(sc.nextDouble());
        }

        display(students);

        double avg = avg(students);
        System.out.println("平均成绩：" + avg);

        System.out.println("高于平均分的学生学号及成绩");
        for (Student s: students
             ) {
            if (s.getCj() > avg) {
                System.out.println("学号：" + s.getXh());
                System.out.println("成绩：" + s.getCj());
                System.out.println("==============================");
            }
        }

    }

    public static double avg(Student[] students) {
        double sum = 0;
        for (Student s: students
             ) {
            sum += s.getCj();
        }

        return sum/students.length;
    }

    public static void display(Student[] students) {
        System.out.println("学生信息：");
        for (Student s: students
             ) {
            System.out.println("学号：" + s.getXh());
            System.out.println("成绩：" + s.getCj());
            System.out.println("==============================");
        }
    }

}

class Student {
    private String xh;
    private Double cj;

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public Double getCj() {
        return cj;
    }

    public void setCj(Double cj) {
        this.cj = cj;
    }
}