package com.by.z.test.t;

/**
 * 11、实现线程安全的单例模式（高并发下线程安全的单例模式）
 *
 * 线程安全的懒汉式单例 解决C中出现的问题 同步块的实现
 */
public class E {

    static class MySingleton {

        private static MySingleton instance = null;

        private MySingleton(){}

        //public synchronized static MySingleton getInstance() {
        public static MySingleton getInstance() {
            try {
                synchronized (MySingleton.class) {
                    if(instance != null){//懒汉式

                    }else{
                        //创建实例之前可能会有一些准备性的耗时工作
                        Thread.sleep(300);
                        instance = new MySingleton();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return instance;
        }
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(MySingleton.getInstance().hashCode());
        }
    }

    public static void main(String[] args) {

        E e = new E();

        MyThread[] mts = new MyThread[10];
        for(int i = 0 ; i < mts.length ; i++){
            mts[i] = e.new MyThread();
        }

        for (int j = 0; j < mts.length; j++) {
            mts[j].start();
        }
    }

}
