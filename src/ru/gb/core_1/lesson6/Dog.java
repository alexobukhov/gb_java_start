package ru.gb.core_1.lesson6;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance > 500 || distance < 0) {
            System.out.println("Значение расстояния " + distance + " не корретно." +
                    " Расстояние должно быть в прееделах от 0 до 500 метров.");
        } else {
            System.out.println(name + " пробежал " + distance + " метров.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > 10 || distance < 0) {
            System.out.println("Значение расстояния " + distance + " не корретно." +
                    " Расстояние должно быть в предалах от 0 до 10 метров.");
        } else {
            System.out.println(name + " проплыл " + distance + " метров.");
        }
    }
}
