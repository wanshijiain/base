package com.czw.model.builder;

/**
 * @author ZeviChen , 2016/10/18 23:33
 */
class AngelBuilder extends ActorBuilder
{
    public  void buildType()
    {
        actor.setType("天使");
    }
    public  void buildFace()
    {
        actor.setFace("漂亮");
    }
    public  void buildHairstyle()
    {
        actor.setHairstyle("披肩长发");
    }
}
