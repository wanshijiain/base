package com.czw.model.builder;

/**
 * @author ZeviChen , 2016/10/18.
 */
public class Actor {
    private String type;
    private String face;
    private String hairstyle;

    public Actor(){
        System.out.println("class.Actor");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getHairstyle() {
        return hairstyle;
    }

    public void setHairstyle(String hairstyle) {
        this.hairstyle = hairstyle;
    }
}
