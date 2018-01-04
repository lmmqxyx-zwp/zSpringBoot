package com.by.z.test.t;

/**
 * 11、实现线程安全的单例模式（高并发下线程安全的单例模式）
 *
 * 懒汉式
 */
public class C {

    // ---------------------------------------------------------
    static class MySingleton {

        private static MySingleton instance = null;

        private MySingleton(){}

        public static MySingleton getInstance() {
            if(instance == null){// 懒汉式
                instance = new MySingleton();
            }
            return instance;
        }
    }
    // ---------------------------------------------------------

    // 这里实现了懒汉式的单例，但是熟悉多线程并发编程的朋友应该可以看出，在多线程并发下这样的实现是
    // 无法保证实例实例唯一的，甚至可以说这样的失效是完全错误的，下面我们就来看一下多线程并发下的执
    // 行情况，这里为了看到效果，我们对上面的代码做一小点修改：

    // ---------------------------------------------------------
    static class MySingleton2 {

        private static MySingleton2 instance = null;

        private MySingleton2() {
        }

        public static MySingleton2 getInstance() {
            try {
                if (instance != null) {//懒汉式

                } else {
                    //创建实例之前可能会有一些准备性的耗时工作
                    Thread.sleep(300);
                    instance = new MySingleton2();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return instance;
        }
    }
    // ---------------------------------------------------------

    // 这里假设在创建实例前有一些准备性的耗时工作要处理，多线程调用：

    class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(MySingleton.getInstance().hashCode());
        }
    }

    public static void main(String[] args) {

        C c = new C();

        MyThread[] mts = new MyThread[10];
        for(int i = 0 ; i < mts.length ; i++){
            mts[i] = c.new MyThread();
        }

        for (int j = 0; j < mts.length; j++) {
            mts[j].start();
        }
    }
}
