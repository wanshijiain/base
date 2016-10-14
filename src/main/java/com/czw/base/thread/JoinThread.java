package com.czw.base.thread;

/**
 * join在指定线程结束后执行
 * join和interrupt遇到会出现异常
 *
 * join(1000)类似wait(1000),时间一到会释放锁
 * sleep(1000)时间到了以后不会释放锁
 *
 * @author ZeviChen 2016/10/14 10:38
 */
public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread15 t15 = new Thread15();
        t15.start();
        Thread.sleep(100);
        new Thread16(t15).start();
    }
}
class Thread14 extends Thread{
    @Override
    public void run() {
        System.out.println("t14 start print.");
        for(int i = 0;i < Integer.MAX_VALUE;i++){
            new String("some strings");
            Math.random();
        }
        System.out.println("t14 end print.");
    }
}
class Thread15 extends Thread{

    @Override
    public void run() {
        try {
            System.out.println("t15 start.print");
            Thread14 t14 = new Thread14();
            t14.start();

            t14.join();
            System.out.println("t15 end.print t14 end.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Thread16 extends Thread{
    private Thread15 t15;
    Thread16(Thread15 t15){
        this.t15 = t15;
    }

    @Override
    public void run() {
        System.out.println("t16 start interrupt...");
        t15.interrupt();
        System.out.println("t16 end interrupt.");
    }
}