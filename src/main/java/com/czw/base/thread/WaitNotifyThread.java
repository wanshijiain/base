package com.czw.base.thread;


/**
 * notify如果过早也是个问题
 * 另外wait后的条件变化也会产生逻辑错误,一种解决方式循环判断
 *
 * @author ZeviChen , 2016/10/13.
 */
public class WaitNotifyThread {
    public static void main(String[] args) throws InterruptedException {
        onlyOneNotify();

    }
    public static void onlyOneNotify() throws InterruptedException {
        Object lock = new Object();
        new Thread11(lock).start();
        new Thread12(lock).start();
        new Thread13(lock).start();
        Thread.sleep(5000);
        System.out.println("main - start,random notify");
        synchronized (lock){
            lock.notifyAll();//必须在同步代码块中执行
            //lock.notify();  //随机唤醒一个线程
        }
        System.out.println("main - end,random notify");
    }
}
class Thread11 extends Thread{
    private Object lock;
    Thread11(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+" - start");
                lock.wait(1000);
                System.out.println(Thread.currentThread().getName()+" - end");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Thread12 extends Thread{
    private Object lock;
    Thread12(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+" - start");
                lock.wait();
                System.out.println(Thread.currentThread().getName()+" - end");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Thread13 extends Thread{
    private Object lock;
    Thread13(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+" - start");
                lock.wait();
                System.out.println(Thread.currentThread().getName()+" - end");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

