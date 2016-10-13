package com.czw.base.thread;

/**
 * 使用interrupt停止线程,stop...作废
 * break停止，return停止和异常捕捉停止
 *
 * 在循环中设置synchronized(str){}也能达到同步字段的作用类似volatile
 *
 * 建议抛出异常，便于上层处理...
 *
 * @author ZeviChen , 2016/10/12.
 */
public class InterruptedThread {
    public static void main(String[] args) {
//        interrupte();
//        stopByInterrupt();
//        stopByException1();
//        stopByException2();
        stopByException3();
    }

    /**
     * t1.interrupt()设置的是线程的停止状态，当线程在循环到
     * isInterrupted是通过break退出
     *
     */
    public static void stopByInterrupt(){
        try{
            Thread1 t1 = new Thread1();
            t1.start();
            Thread.sleep(1000);
            t1.interrupt();
        }catch (InterruptedException e){
            System.out.println("异常捕捉");
            e.printStackTrace();
        }

    }

    /**
     * 通过弹出异常终止线程执行
     */
    public static void stopByException1(){
        try{
            Thread2 t2 = new Thread2();
            t2.start();
            Thread.sleep(10);
            t2.interrupt();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程sleep时执行interrupt，不需要状态判断或异常捕捉就可以退出线程
     */
    public static void stopByException2(){
        try{
            Thread3 t3 = new Thread3();
            t3.start();
            Thread.sleep(20);
            t3.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch exception.");
            e.printStackTrace();
        }
    }

    public static void stopByException3(){
        try{
            Thread4 t4 = new Thread4();
            t4.start();
            Thread.sleep(20);
            t4.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch exception.");
            e.printStackTrace();
        }
    }

    public static void interrupte(){

        try {

            Thread1 t = new Thread1();
            t.start();
            Thread.sleep(1000);
            t.interrupt();
            System.out.println("t - isInterrupted : " + t.isInterrupted());
            Thread.sleep(2000);
            Thread.currentThread().interrupt();

            //第二次调用Thread.interrupted后会清除状态,所以会打印false
            //第二次调用isInterrupted已经不会修改状态了,都是true
//        System.out.println("main - interrupted1："+Thread.interrupted());
//        System.out.println("main - interrupted2："+Thread.interrupted());
            System.out.println("main - isInterrupted1:" + Thread.currentThread().isInterrupted());
            System.out.println("main - isInterrupted2:" + Thread.currentThread().isInterrupted());
            System.out.println("end main");
        }catch (InterruptedException e){
            System.out.println("main catching");
            e.printStackTrace();
        }
    }


}

class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            //这种退出方式通过状态改变来改变run中的执行逻辑达到退出的目的
            //如果for后面还有代码依旧会执行到
            if(this.isInterrupted()){
                System.out.println("线程已经是停止状态，退出!!");
                break;
            }
            System.out.println("i = " + (i + 1));
        }
        System.out.println("break只是退出循环，该打印语句还是会执行到！");
    }
}
class Thread2 extends Thread{
    @Override
    public void run() {
        try{
            for (int i = 0; i < 50000; i++) {
                //这种退出方式通过状态改变来改变run中的执行逻辑达到退出的目的
                //如果for后面还有代码依旧会执行到
                if(this.isInterrupted()){
                    System.out.println("线程已经是停止状态，退出!!");
                    throw new InterruptedException();
                }
                System.out.println("i = " + (i + 1));
            }
            System.out.println("break只是退出循环，该打印语句还是会执行到！");

        }catch (InterruptedException e){
            System.out.println("异常捕捉，不再执行for之后的语句");
            e.printStackTrace();
        }
    }
}

/**
 * 在沉睡中直接停止了
 */
class Thread3 extends Thread{
    @Override
    public void run() {
        try{
            System.out.println("Thread3 running");
            Thread.sleep(20000);
            System.out.println("Thread3 end.");
        } catch (InterruptedException e) {
            System.out.println("Thread3 catch exception."+this.isInterrupted());//false
            e.printStackTrace();
        }
    }
}

/**
 * 如果线程中有这种，会执行完在停止
 */
class Thread4 extends Thread{
    @Override
    public void run() {
        try{
            for (int i = 0; i < 50000; i++) {
                System.out.println("i = " + (i + 1));
            }
            System.out.println("for之外的语句");
            Thread.sleep(30000);
            System.out.println("Thread4 end.");
        } catch (InterruptedException e) {
            System.out.println("Thread4 catch exception.");
            e.printStackTrace();
        }
    }
}
