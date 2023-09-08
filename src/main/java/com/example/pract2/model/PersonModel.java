package com.example.pract2.model;
public class PersonModel {
    private int id;
    private String name;
    private int age;
    private String email;

    public PersonModel() {}

    public PersonModel(String name, double age, String email) {
        this.name = name;
        this.age = (int) age;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}