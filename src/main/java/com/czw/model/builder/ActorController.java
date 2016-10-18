package com.czw.model.builder;

/**
 * @author ZeviChen , 2016/10/18 23:34
 */
class ActorController
{
    //逐步构建复杂产品对象
    public Actor construct(ActorBuilder ab)
    {
        Actor actor;
        ab.buildType();
        ab.buildFace();
        ab.buildHairstyle();
        actor=ab.createActor();
        return actor;
    }
}