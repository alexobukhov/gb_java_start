package ru.gb.core_2.lesson1.model;

public interface Runable extends Obstacle {

    @Override
    default void doAction() {
        System.out.println("успешно пробежал");
    };
}
