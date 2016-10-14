package com.czw.base.thread;

import com.czw.util.DateUtils;

import java.util.Date;

/**
 * ThreadLocal获取当前线程存储的数据
 *
 *
 * @author ZeviChen 2016/10/14 11:19
 */
public class TestThreadLocal {
    public static void main(String[] args) {
        tle();
        itle();
    }

    public static void tle() {
        for (int i = 0; i < 100; i++) {
            if (Tools.tle.get() == null) {
                Tools.tle.set(Thread.currentThread().getName() + " - 得到null，设置初始值.");
            }
            System.out.println(Thread.currentThread().getName() + " - get:" + Tools.tle.get());
        }
        new Thread17().start();
    }

    public static void itle() {
        for (int i = 0; i < 100; i++) {
            if (Tools.itle.get() == null) {
                Tools.itle.set(Thread.currentThread().getName() + " - 得到null，设置初始值.");
            }
            System.out.println(Thread.currentThread().getName() + " - get:" + Tools.itle.get());
        }
        new Thread18().start();
    }

}


class Thread17 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (Tools.tle.get() == null) {
                Tools.tle.set(Thread.currentThread().getName() + " - 得到null，设置初始值.");
            }
            System.out.println(Thread.currentThread().getName() + " - get:" + Tools.tle.get());
        }
    }
}

class Thread18 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (Tools.itle.get() == null) {
                Tools.itle.set(Thread.currentThread().getName() + " - 得到null，设置初始值.");
            }
            System.out.println(Thread.currentThread().getName() + " - get:" + Tools.itle.get());
        }
    }
}

class ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue() {
        return Thread.currentThread().getName() + " - " + DateUtils.dtts(new Date());
    }
}

class InheritableThreadLocalExt extends ThreadLocalExt {
    @Override
    protected Object initialValue() {
        return Thread.currentThread().getName() + " - " + DateUtils.dtts(new Date()
        );
    }


}

class Tools {
    public static InheritableThreadLocalExt itle = new InheritableThreadLocalExt();
    public static ThreadLocalExt tle = new ThreadLocalExt();
}
