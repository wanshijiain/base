package com.czw.model.bridge;

import com.czw.model.bridge.exp1.*;

import java.sql.Ref;

/**
 * 桥接模式:当一个产品具有两种不同的扩展方向
 * 通过引用接口的方式,有点类似适配器
 *
 * @author ZeviChen , 2016/10/21 14:01
 */
public class MainTest {
    public static void main(String[] args){
        //感觉spring的refresh()方法就类似这个
        Theme darcular = new DarculaTheme();
        Keymap eclipse = new EclipseKeymap();
        RefinedIntelliJ win = new WindowsIntelliJ();
        win.setTheme(darcular);
        win.setKeymap(eclipse);
        win.setting();//调用抽象类的方法实现

        System.out.println("---------------------------------");
        Theme intellijTheme = new IntelliJTheme();
        Keymap intellijKeymap = new IntelliJKeymap();
        RefinedIntelliJ linux = new LinuxIntelliJ();
        linux.setTheme(intellijTheme);
        linux.setKeymap(intellijKeymap);
        linux.setting();


    }
}
