package ru.gb.core_2.lesson1.model;

public interface Participant extends Jumping, Running {

    String getName();

    int getMaxDistance();

    int getMaxHeight();
}
