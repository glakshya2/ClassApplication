package com.example.classapplication.recycler;

public class Person {
    String name, email, image;
    int age;

    public Person(String name, String email, String image, int age) {
        this.name = name;
        this.email = email;
        this.image = image;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
