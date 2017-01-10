package com.example.pojos;

/**
 * Created by ALex on 02/01/2017.
 */
public class User {

    private long id;
    private String Name;
    private Integer Age;

    public long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    @Override
    public String toString(){

        return id+" "+Name+" "+Age;
    }
}
