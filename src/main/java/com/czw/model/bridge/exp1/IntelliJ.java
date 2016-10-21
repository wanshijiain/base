package com.czw.model.bridge.exp1;


/**
 * IntelliJ开发工具的主题和快捷键的设置,
 * intellij有windows版和linux版...
 * @author ZeviChen , 2016/10/21 14:16
 */
public abstract class IntelliJ {
    protected Theme theme;
    protected Keymap keymap;

    public void setKeymap(Keymap keymap) {
        this.keymap = keymap;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    //配置
    public abstract void setting();

}
