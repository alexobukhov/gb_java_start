package ru.gb.core_1.lesson7.oop;

import java.util.concurrent.ThreadLocalRandom;

public class Cat {

    private String name;

    private Boolean satiety;

    public Cat(String name) {
        this.name = name;
        this.satiety = false;
    }

    public void setSatiety(Boolean satiety) {
        this.satiety = satiety;
    }

    public Boolean eat(Plate plate) {
        return plate.decreaseFood(ThreadLocalRandom.current().nextInt(4) + 3);
    }

    public void printSatiety() {
        if (satiety) {
            System.out.println(name + " сытый!");
        } else {
            System.out.println(name + " голодный.");
        }
    }
}
