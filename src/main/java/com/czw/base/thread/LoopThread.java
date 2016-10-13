package com.czw.base.thread;

/**
 * 同步：改变状态即可停止线程
 *
 * 异步：在server模式下的运行线程中私有字段和共有字段不共享的，
 * 所以在改变私有字段值需要同步到公共字段值，否则线程处于死循环中
 * 一直不停止(同样的代码在  JVM  -server  设置中)
 *
 *
 * @author ZeviChen ${datetime}
 */
public class LoopThread {
    public static void main(String[] args){

        syncLoop();

    }

    /**
     *
     */
    public static void syncLoop(){
        Print p = new Print();
        new Thread(p).start();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("停止循环打印 :");
        p.setLoop(false);
    }


}

class Print implements Runnable {
    private boolean loop = true;

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    private void print(){
        System.out.println("进入循环");
        while(loop){
            System.out.println(Thread.currentThread().getName()+" - "+System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("退出循环");
    }

    @Override
    public void run() {
        print();
    }
}
