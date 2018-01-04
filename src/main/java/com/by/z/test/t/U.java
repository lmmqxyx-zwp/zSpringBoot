package com.by.z.test.t;

/**
 * 设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。写出程序。
 */
public class U {

    private int j;

    public class Inc implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    public class Dec implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }

    private synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + "+inc" + j);
    }

    private synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + "-dec" + j);
    }

    public static void main(String args[]){
        U u=new U();
        Inc inc=u.new Inc();
        Dec dec=u.new Dec();
        for(int i=0;i<2;i++){
            Thread t=new Thread(inc);
            t.start();
            t=new Thread(dec);
            t.start();
        }
    }


}
