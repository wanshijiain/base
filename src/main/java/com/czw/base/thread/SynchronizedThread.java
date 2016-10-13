package com.czw.base.thread;

/**
 * @author ZeviChen ${datetime}
 */
public class SynchronizedThread {
    public static void main(String[] args){
//        synchronizedBlock();
        synchronizedBlock2();
    }

    /**
     * 同步代码块是锁定当前对象的,所以一个线程阻塞在代码块中，另一个
     * 线程是无法调用其他代码块的.
     *
     * 这种锁的机制主要受代码块定义的什么锁决定调用结果
     *
     */
    public static void synchronizedBlock(){
        Bean1 b1 = new Bean1();
        Thread7 t7 = new Thread7(b1);
        Thread8 t8 = new Thread8(b1);
        t7.start();
        t8.start();
    }

    /**
     * synchronized加到static方法上,那么锁就是该类,同步方法会阻塞
     */
    public static void synchronizedBlock2(){
        new Thread9().start();
        new Thread10().start();

    }

}

class Bean1{
    public void met1() throws InterruptedException {
        synchronized (this){
            System.out.println("Bean1 - met1:长时间占用,start : "+Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("Bean1 - met1:长时间占用,end : "+Thread.currentThread().getName());
        }
    }
    public void met2(){
        synchronized (this){
            System.out.println("Bean1 - met2:短时运行,start : "+Thread.currentThread().getName());
            System.out.println("Bean1 - met2:短时运行,end : "+Thread.currentThread().getName());

        }
    }

    synchronized public static void met3() throws InterruptedException {
        System.out.println("Bean1.static - met3:长时间占用,start : "+Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("Bean1.static - met3:长时间占用,end : "+Thread.currentThread().getName());
    }
    synchronized public static void met4(){
        System.out.println("Bean1.static - met4:短时运行,start : "+Thread.currentThread().getName());
        System.out.println("Bean1.static - met4:短时运行,end : "+Thread.currentThread().getName());
    }

}

class Thread7 extends Thread{
    private Bean1 b1;
    Thread7(Bean1 b1){
        this.b1 = b1;
    }

    @Override
    public void run() {
        try {
            b1.met1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Thread8 extends Thread{
    private Bean1 b1;
    Thread8(Bean1 b1){
        this.b1 = b1;
    }

    @Override
    public void run() {
        b1.met2();
    }
}
class Thread9 extends Thread{

    @Override
    public void run() {
        try {
            Bean1.met3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Thread10 extends Thread{
    @Override
    public void run() {
        Bean1.met4();
    }
}
