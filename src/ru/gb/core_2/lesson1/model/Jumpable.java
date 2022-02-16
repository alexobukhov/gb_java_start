package ru.gb.core_2.lesson1.model;

public interface Jumpable extends Obstacle {

    @Override
    default void doAction() {
        System.out.println("успешно перегрыгнул");
    };
}
