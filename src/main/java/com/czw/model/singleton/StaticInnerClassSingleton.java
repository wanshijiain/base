package com.czw.model.singleton;

/**
 * 静态内部类是线程安全的
 *
 * @author Zevi Chan
 * @Date 2016-07-27 11:02:44
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {
    }

    private static class SingletonHolder {
        private final static StaticInnerClassSingleton singletonHolder = new StaticInnerClassSingleton();

    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.singletonHolder;
    }
}
