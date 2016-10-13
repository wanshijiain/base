package com.czw.base.thread;

import com.czw.util.ComUtils;

/**
 * 防止线程独占资源
 *
 * @author ZeviChen ${datetime}
 */
public class YieldThread {
    public static void main(String[] args){
        yield();
    }
    public static void yield(){
        Thread6 t6 = new Thread6();
        t6.start();
    }

}
class Thread6 extends Thread{
    @Override
    public void run() {
        ComUtils.start();
        for(int i = 0;i<10000;i++){
            Thread.yield();
            System.out.println(Thread.currentThread()+" , i = "+i);
        }
        ComUtils.end();
    }
}