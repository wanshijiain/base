package com.czw.model.adapter.ref;

/**
 * 双向适配器同时引用目标对象和适配对象,一般很少用
 * @author ZeviChen , 2016/10/20 0:03
 */
public class MainTest {
    public static void main(String[] args){
        RefAdapter ra = new RefAdapter();
        ra.request();
    }
}
