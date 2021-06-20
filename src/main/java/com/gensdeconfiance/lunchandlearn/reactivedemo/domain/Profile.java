package com.gensdeconfiance.lunchandlearn.reactivedemo.domain;

public class Profile {
    private String id;
    private int number;

    public Profile() {
    }

    public Profile(int number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
