package com.czw.model.bridge.exp1;


/**
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
