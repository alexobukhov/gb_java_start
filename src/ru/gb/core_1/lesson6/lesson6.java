package ru.gb.core_1.lesson6;

public class lesson6 {
    public static void main(String[] args) {
        Dog dogSharik = new Dog("Шарик");
        Cat catMurzik = new Cat("Мурзик");
        Dog dogTuzik = new Dog("Тузик");
        Cat catPolosatik = new Cat("Полосатик");

        dogSharik.run(600);
        catMurzik.run(300);
        dogTuzik.run(400);
        catMurzik.run(130);
        dogSharik.swim(15);
        dogTuzik.swim(5);
        catMurzik.swim(7);

        Animal[] animals = {
                dogSharik,
                catMurzik,
                dogTuzik,
                catPolosatik
        };

        int countAnimals = 0;
        int countDogs = 0;
        int countCats = 0;
        for (Animal animal: animals) {
            if (animal instanceof Animal) {
                countAnimals++;
            };
            if (animal instanceof Dog) {
                countDogs++;
            };
            if (animal instanceof Cat) {
                countCats++;
            }
        }
        System.out.println("Всего: собак - " + countDogs + ", котов - " + countCats + ", животных - "
                + countAnimals + ".");
    }
}
