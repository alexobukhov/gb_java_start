package ru.gb.core_2.lesson1.model;

public interface Jumping {

    default void jump() {
        System.out.println("Прыгаю");
    }
}
