package com.czw.toolkit.jackson.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * @author ZeviChen
 * @Date 2016-08-25 13:22:05
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = As.PROPERTY, property = "@class")
public class Zoo {
 
    public String name;
    public String city;
    public List<Animal> animals;
 
    @JsonCreator
    public Zoo(@JsonProperty("name") String name, @JsonProperty("city") String city) {
        this.name = name;
        this.city = city;
    }
 
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
 
    @Override
    public String toString() {
        return "Zoo [name=" + name + ", city=" + city + ", animals=" + animals + "]";
    }
 
}
