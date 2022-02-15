package ru.gb.core_1.lesson7.oop;

public class Plate {

    private int foodCount;

    public Plate(int foodCount) {
        this.foodCount = foodCount;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Plate{" + "foodCount=" + foodCount + '}';
    }

    public Boolean decreaseFood(int catEatFoodCount) {
        Boolean catSatiety = foodCount >= catEatFoodCount;
        foodCount -= catSatiety ? catEatFoodCount : 0;
        return catSatiety;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    public void addFood(int addFood) {
        foodCount += addFood;
    }
}
