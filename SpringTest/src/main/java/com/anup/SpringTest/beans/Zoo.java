package com.anup.SpringTest.beans;

public class Zoo {
    public Animal animal;

    public Zoo(Animal animal) {
        this.animal = animal;
    }

    public void getZooAnimals(){
        System.out.println(animal.getType() + " making sound "+animal.sound());
    }
}
