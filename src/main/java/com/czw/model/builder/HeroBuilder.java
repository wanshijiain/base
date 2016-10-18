package com.czw.model.builder;

/**
 * @author ZeviChen , 2016/10/18 23:33
 */
class HeroBuilder extends ActorBuilder
{
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
}
