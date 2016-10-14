package com.czw.model.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author ZeviChen 2016/10/14 15:18
 */
public class SeriaStaticSingleton implements Serializable{
    private SeriaStaticSingleton(){}
    private static class InnerStaticSingleton{
        private final static SeriaStaticSingleton sss = new SeriaStaticSingleton();

    }
    public static SeriaStaticSingleton getInstance(){
        return InnerStaticSingleton.sss;
    }

    /**
     * 解决在范序列化是对象不一致的问题
     * @return
     * @throws ObjectStreamException
     */
    protected Object readResolve() throws ObjectStreamException{
        return InnerStaticSingleton.sss;
    }

}
