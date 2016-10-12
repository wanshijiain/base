package com.czw.base.thread;

import com.czw.util.ComUtils;

/**
 * 场景:售票
 *
 * 多线程共享数据,线程执行的顺序是随机的,count的值并不会随机打印.
 * @author Administrator , 2016/10/12.
 */
public class ThreadSharedData extends Thread {

    public static void main(String[] args) {
        SharedData sd = new SharedData();
        Thread a = new Thread(sd,"a");
        System.out.println("a isAlive-before :"+a.isAlive());
        a.start();
        //此处显式为true是因为a准备执行,main已经执行到了这行,所以是true,所以这个结果也有可能是false
        System.out.println("a isAlive-after :"+a.isAlive());
        new Thread(sd,"b").start();
        new Thread(sd,"c").start();
        new Thread(sd,"d").start();
        new Thread(sd,"e").start();
        new Thread(sd,"f").start();
        new Thread(sd,"g").start();
        new Thread(sd,"h").start();
        new Thread(sd,"i").start();
        new Thread(sd,"j").start();
        new Thread(sd,"k").start();

    }
}

/**
 * volatile字段并不能达到线程并发中的字段实时更新
 * 只是说明线程在修改字段之后会线程副本中的count值同步
 * 到主内存中
 *
 * Thread.currentThread().isAlive()和this.isAlive()是有差异的
 *
 */
class SharedData extends Thread {

    //volatile依旧不安全
    private volatile int count = 5;
    /*@Override
    public synchronized void run() {
//        super.run();
        count--;
        System.out.println(Thread.currentThread().getName() + "\t" + count);
    }*/
    @Override
    public void run() {
//        super.run();
        count--;
        System.out.println(Thread.currentThread().getName() + "\t" + count+"\t thread="+Thread.currentThread().isAlive()+",this="+this.isAlive());

        //i--是在println之前执行,所以可能会出现线程安全问题
        //System.out.println(i--);

    }
}
