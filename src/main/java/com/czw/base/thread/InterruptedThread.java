package com.czw.base.thread;

/**
 * @author Administrator , 2016/10/12.
 */
public class InterruptedThread {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t = new Thread1();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        System.out.println("t - interrupte : "+t.isInterrupted());
        Thread.sleep(2000);
        Thread.currentThread().interrupt();
        //第二次调用isInterrupted已经不会修改状态了,都是true
        System.out.println("main - interrupte:"+Thread.currentThread().isInterrupted());
        System.out.println("main - interrupte:"+Thread.currentThread().isInterrupted());
        System.out.println("end main");
    }

}

class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            System.out.println("i = " + (i + 1));
        }
    }
}
