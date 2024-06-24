package com.usmansarwar.hiaichi.Models;

public class Model {
    public String key;
    public String tittle;
    public String lacture;
    public String course;
    public String videoid;


    public Model(String key,String tittle , String lacture, String course,String videoid) {
        this.key = key;
        this.tittle = tittle;
        this.lacture = lacture;
        this.course = course;
        this.videoid = videoid;

    }

    public String getKey() {
        return key;
    }

    public String getTittle() {
        return tittle;
    }

    public String getLacture() {
        return lacture;
    }

    public String getCourse() {
        return course;
    }

    public String getVideoid() {
        return videoid;
    }
}
