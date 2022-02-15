package ru.gb.core_1.lesson7.oop;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Cat> catArrayList = new ArrayList<>();
        Cat cat0 = new Cat("Мартин Лютер Кот");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Бармалей");
        Cat cat3 = new Cat("Обормотик");
        Cat cat4 = new Cat("Лео");
        Cat cat5 = new Cat("Назар");
        catArrayList.add(cat0);
        catArrayList.add(cat1);
        catArrayList.add(cat2);
        catArrayList.add(cat3);
        catArrayList.add(cat4);
        catArrayList.add(cat5);
        Plate plate = new Plate(40);
        plate.printInfo();

        /*while (plate.getFoodCount() > 0) {
            cat.setFullness(cat.eat(plate) ? true : false);
            plate.printInfo();
            Thread.sleep(3000);
        }*/

        for (Cat cat : catArrayList) {
            cat.setSatiety(cat.eat(plate) ? true : false);
            plate.printInfo();
            cat.printSatiety();
        }
    }
}
