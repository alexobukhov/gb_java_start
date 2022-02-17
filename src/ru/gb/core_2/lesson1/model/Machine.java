package ru.gb.core_2.lesson1.model;

public class Machine implements Participant {

    private String name;

    private int maxDistance;

    private int maxHeight;

    private boolean failed;

    public Machine(String name, int maxDistance, int maxHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
        this.failed = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxDistance() {
        return maxDistance;
    }

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }
}
