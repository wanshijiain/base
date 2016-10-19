package com.czw.model.builder;

/**
 * @author ZeviChen , 2016/10/18 23:33
 */
class HeroBuilder1 extends ActorBuilder1
{
    public HeroBuilder1(){
        System.out.println("class.HeroBuilder");
    }
    
    public  void buildType()
    {
        actor.setType("英雄");
    }
    public  void buildFace()
    {
        actor.setFace("英俊");
    }
    public  void buildHairstyle()
    {
        actor.setHairstyle("飘逸");
    }

    /**
     * 钩子方法实现,就可以控制角色的实现
     */
    @Override
    public boolean isBareheaded() {
        return true;
    }
}
