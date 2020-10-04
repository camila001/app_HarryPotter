package com.camila.app_harrypotter.model;

import java.util.List;

public class Character {
    public String name;
    public String species;
    public String gender;
    public String house;
    public String dateOfBirth;
    public String ancestry;
    public String patronus;
    public String actor;
    public String alive;
    public String image;


    public Character(){

    }

    public Character(String name, String species, String gender, String house, String dateOfBirth, String ancestry, String patronus, String actor, String alive, String image) {
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.house = house;
        this.dateOfBirth = dateOfBirth;
        this.ancestry = ancestry;
        this.patronus = patronus;
        this.actor = actor;
        this.alive = alive;
        this.image = image;
    }

}
