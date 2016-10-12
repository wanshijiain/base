package com.czw.base.thread;


/**
 * 在多线程中的竞态条件：
 * 1.先检查后运行
 * 2.惰性初始化中的竞态条件(饿汉式单例)
 * <p>
 * 多线程并发，获取到的就不是单例了
 *
 * @author ZeviChen ${datetime}
 */
public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread() {
                @Override
                public void run() {
//                    System.out.println(Thread.currentThread().getName()+" - "+ SingletonConcurrency.getInstance());
                    SingletonConcurrency.getInstance();
                }
            }.start();
        }
    }

}

class SingletonConcurrency {
    private static Bean instance = null;

    public static Bean getInstance() {
        /*synchronized (SingletonConcurrency.class) {
            if (instance == null)
                instance = new Bean();
        }*/
        if (instance == null)
            instance = new Bean();
        return instance;
    }
}

class Bean {
    Bean() {
        System.out.println("当前线程new了Bean对象:" + Thread.currentThread().getName());
    }
}
