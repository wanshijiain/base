package com.czw.base.thread;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 原子类型是安全的，但是在非同步方法上使用就会出现问题,所以方法需要同步
 *
 * @author ZeviChen ${datetime}
 */
public class AtomicTypeThread {
    public static void main(String[] args){
//        typeAtomic();
        methodAtomic();
    }

    /**
     * add()方法加上synchronized才能达到同步效果
     */
    public static void methodAtomic(){
        AtomicOps2 ao2 = new AtomicOps2();
        new Thread(ao2).start();
        new Thread(ao2).start();
        new Thread(ao2).start();
        new Thread(ao2).start();
        /**
         * output:
         * Thread-1 - 100
         * Thread-3 - 301
         * Thread-4 - 200
         * Thread-2 - 403
         *
         */
    }

    public static void typeAtomic(){
        AtomicOps ao = new AtomicOps();
        new Thread(ao).start();
        new Thread(ao).start();
        new Thread(ao).start();
        new Thread(ao).start();
    }
}
class AtomicOps extends Thread{
    private AtomicLong al = new AtomicLong(0);

    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+" - "+al.incrementAndGet());
        }
    }
}class AtomicOps2 extends Thread{
    private AtomicLong al = new AtomicLong(0);

    public void add() {
        System.out.println(Thread.currentThread().getName() + " - " + al.addAndGet(100));
        al.addAndGet(1);
    }
    @Override
    public void run() {
        add();
    }

}