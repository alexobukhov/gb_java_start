package ru.gb.core_2.lesson1.model;

public interface Running {

    default void run() {
        System.out.println("Бегаю");
    }
}
