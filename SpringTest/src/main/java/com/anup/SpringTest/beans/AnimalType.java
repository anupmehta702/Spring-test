package com.anup.SpringTest.beans;

public class AnimalType implements Animal {
    public String type = "";
    public String sound = "Duh";

    public AnimalType(String type, String sound) {
        this.type = type;
        this.sound = sound;
    }

    @Override
    public String sound() {
        return sound;
    }

    @Override
    public String getType() {
        return type;
    }
}
