package com.by.z.test.t;

/**
 * 11、实现线程安全的单例模式（高并发下线程安全的单例模式）
 *
 * 饿汉式
 */
public class B {

    // 饿汉式
    static class MySingleton {

        private static MySingleton instance = new MySingleton();

        private MySingleton() {
        }

        public static MySingleton getInstance() {
            return instance;
        }

    }

    // 下面看看饿汉式在多线程中
    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(MySingleton.getInstance().hashCode()); //取得哈希码
        }
    }

    public static void main(String[] args) {

        B b = new B();

        // 创建10个线程
        MyThread[] mts = new MyThread[10];
        for(int i = 0 ; i < mts.length ; i++){
            mts[i] = b.new MyThread();
        }

        // 启动线程
        for (int j = 0; j < mts.length; j++) {
            mts[j].start();
        }
    }

}
