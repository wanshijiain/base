package com.czw.model.adapter.ref;

/**
 * @author ZeviChen , 2016/10/19 23:56
 */
public class RefAdapter implements Target {
    private Adaptee adaptee;
    public RefAdapter(){
        adaptee = new Adaptee();
    }
    @Override
    public void request(){
        System.out.println("adapter - before");
        adaptee.response();
        System.out.println("adapter - after");
    }
}
