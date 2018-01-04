package com.by.z.test.t;

/**
 * 11、实现线程安全的单例模式（高并发下线程安全的单例模式）
 *
 * 针对某些重要的代码来进行单独的同步（可能非线程安全）
 */
public class F {

    static class MySingleton {

        private static MySingleton instance = null;

        private MySingleton(){}

        public static MySingleton getInstance() {
            try {
                if(instance != null){//懒汉式

                }else{
                    //创建实例之前可能会有一些准备性的耗时工作
                    Thread.sleep(300);
                    synchronized (MySingleton.class) {
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

        F f = new F();

        MyThread[] mts = new MyThread[10];
        for(int i = 0 ; i < mts.length ; i++){
            mts[i] = f.new MyThread();
        }

        for (int j = 0; j < mts.length; j++) {
            mts[j].start();
        }
    }
}
