package ru.gb.core_2.lesson1.model;

public class Tread implements Runable {

    private int maxDistance;

    public Tread(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    @Override
    public int getMaxDistance() {
        return this.maxDistance;
    }

    @Override
    public int getMaxHeight() {
        return 0;
    }
}
