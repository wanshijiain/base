package com.czw.model.builder;

/**
 * @author ZeviChen , 2016/10/18 23:34
 */
class DevilBuilder extends ActorBuilder
{
    public  void buildType()
    {
        actor.setType("恶魔");
    }
    public  void buildFace()
    {
        actor.setFace("丑陋");
    }
    public  void buildHairstyle()
    {
        actor.setHairstyle("光头");
    }
}
