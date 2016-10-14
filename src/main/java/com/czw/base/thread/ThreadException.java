package com.czw.base.thread;

/**
 * @author ZeviChen 2016/10/14 17:00
 */
public class ThreadException {
    public static void main(String[] args){
        Thread t19 = new Thread19();
        t19.setName("thread-1");
        t19.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName()+" - 产生了为捕捉的异常");
                e.printStackTrace();
            }
        });
        t19.start();
    }


}
class Thread19 extends Thread{
    @Override
    public void run() {
        String s = null;
        System.out.println("thread19 start.");
        System.out.println(s.hashCode());
        System.out.println("thread19 end.");
    }
}
