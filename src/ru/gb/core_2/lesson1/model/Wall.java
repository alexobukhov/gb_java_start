package ru.gb.core_2.lesson1.model;

public class Wall implements Jumpable {

    private int maxHeight;

    public Wall(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public int getMaxHeight() {
        return this.maxHeight;
    }

    @Override
    public int getMaxDistance() {
        return 0;
    }
}
