package com.czw.base.thread;

/**
 * 使用suspend,resume易造成公共数据独占，所以并不是好的线程暂停方式
 *
 * @author ZeviChen ${datetime}
 */
public class SuspendThread {
    public static void main(String[] args) throws InterruptedException {
        suspend();
    }

    public static void suspend() throws InterruptedException {
        Thread5 t5 = new Thread5();
        t5.start();
        Thread.sleep(2000);
        t5.suspend();
        System.out.println(t5.getName()+" ,i = "+t5.getI());
        t5.resume();
        Thread.sleep(2000);
        t5.suspend();
        System.out.println(t5.getName()+" ,i = "+t5.getI());
        t5.resume();
        Thread.sleep(2000);
        t5.suspend();
        System.out.println(t5.getName()+" ,i = "+t5.getI());
        t5.resume();
        Thread.sleep(2000);
        t5.suspend();



    }

}

class Thread5 extends Thread{
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while(true){
            ++i;
        }
    }
}
