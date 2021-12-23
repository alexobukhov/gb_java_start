package ru.gb.lesson6;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance > 200 || distance < 0) {
            System.out.println("Значение расстояния " + distance + " не корретно." +
                    " Расстояние должно быть в предалах от 0 до 200 метров.");
        } else {
            System.out.println(name + " пробежал " + distance + " метров.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }
}
