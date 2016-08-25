package com.czw.toolkit.jackson.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ZeviChen
 * @Date 2016-08-25 13:23:59
 */
public class Elephant extends Animal {
	 
    @JsonProperty
    private String name;
 
    @JsonCreator
    public Elephant(@JsonProperty("name") String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
    public String getSound() {
        return "trumpet";
    }
 
    public String getType() {
        return "herbivorous";
    }
 
    public boolean isEndangered() {
        return false;
    }
 
    @Override
    public String toString() {
        return "Elephant [name=" + name + ", getName()=" + getName() + ", getSound()=" + getSound() + ", getType()=" + getType()
                + ", isEndangered()=" + isEndangered() + "]";
    }
 
}
