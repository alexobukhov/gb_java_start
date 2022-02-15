package ru.gb.core_1.lesson6;

public class Animal {

    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " метров.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " метров.");
    }
}
