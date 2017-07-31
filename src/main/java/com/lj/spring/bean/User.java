package com.lj.spring.bean;

/**
 * Created by manajay on 25/07/2017.
 */
public class User {

    private int id;
    private String name;
    private int age;
    private String password;
    private String detail;

    public User(int id, String name, int age, String password, String detail) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
        this.detail = detail;
    }

    public User(String name, int age, String password, String detail) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
