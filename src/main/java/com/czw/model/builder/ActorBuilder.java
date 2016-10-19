package com.czw.model.builder;

/**
 * @author Administrator , 2016/10/18.
 */
public abstract class ActorBuilder {
    protected Actor actor = new Actor();
    
    public ActorBuilder(){
        System.out.println("abstractClass.ActorBuilder");
    }
    
    public abstract void buildType();
    public abstract void buildFace();
    public abstract void buildHairstyle();

    public Actor createActor(){
        return actor;
    }

}
