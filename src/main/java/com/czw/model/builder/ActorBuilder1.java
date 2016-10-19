package com.czw.model.builder;

/**
 * @author ZeviChen , 2016/10/19 12:19
 */
abstract class ActorBuilder1
{
    protected  Actor actor = new Actor();

    public  abstract void buildType();
    public  abstract void buildFace();
    public  abstract void buildHairstyle();
    
    /**
     * 钩子方法:定义于抽象类中,用于设置默认值
     * 在子类中override可以影响构建角色
     */
    public boolean isBareheaded(){
        return false;
    }

    public Actor construct()
    {
        this.buildType();
        this.buildFace();
        if(!isBareheaded())
            this.buildHairstyle();
        return actor;
    }
}
