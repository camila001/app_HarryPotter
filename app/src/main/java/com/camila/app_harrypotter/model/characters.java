package com.camila.app_harrypotter.model;

import java.util.List;

public class characters {
    public String name ;
    public String species;
    public String gender;
    public String house;
    public String dateOfBirth;
    public String ancestry;
    public String wand;
    public String patronus;
    public String actor;
    public String alive;
    public String image;


    public characters(){

    }

    public characters(String name, String species, String gender, String house, String dateOfBirth, String ancestry, String wand, String patronus, String actor, String alive, String image) {
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.house = house;
        this.dateOfBirth = dateOfBirth;
        this.ancestry = ancestry;
        this.wand = wand;
        this.patronus = patronus;
        this.actor = actor;
        this.alive = alive;
        this.image = image;
    }

}
