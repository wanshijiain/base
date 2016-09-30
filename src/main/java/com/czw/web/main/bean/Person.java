package com.czw.web.main.bean;

import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

/**
 * @author ZeviChen
 * @Date 2016-08-08 14:17:26
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -5016013585164593387L;

    public interface WithoutPasswordView {};
    public interface WithPasswordView extends WithoutPasswordView {};

    private String id;
    @JsonView(WithoutPasswordView.class)
    private String userName;
    @JsonView(WithPasswordView.class)
    private String password;
    private Integer age;
    private String email;
    private String address;
    private String gender;
    private String datetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
