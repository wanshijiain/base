package com.czw.base.thread;

/**
 * 线程内部循环，加入组,重载线程组异常处理方法
 *
 * 异常传递：实现异常处理类的子类
 *
 * @author ZeviChen 2016/10/14 17:04
 */
public class ThreadGroupException {
    public static void main(String[] args){
        //具体不写了... ...
    }
}
class Thread20 extends Thread{
    public Thread20() {
        super();
    }

    public Thread20(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        while(true){
            //...
        }
    }
}
class MyThreadGroup extends ThreadGroup{

    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        super.uncaughtException(t, e);
        this.interrupt();//如果一个线程出现异常，就停止所有的组内线程
    }
}
