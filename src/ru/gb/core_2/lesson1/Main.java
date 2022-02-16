package ru.gb.core_2.lesson1;

import ru.gb.core_2.lesson1.model.*;

public class Main {
    public static void main(String[] args) {
        Man timofei = new Man("Тимофей", 500, 2);
        Cat tema = new Cat("Тема", 200, 3);
        Robot verter = new Robot("Вертер", 1000, 10);

        Participant[] participants = {timofei, tema, verter};

        Tread tread = new Tread(700);
        Wall wall = new Wall(3);

        Obstacle[] obstacles = {tread, wall};

        for (Participant member : participants) {
            for (Obstacle challenge : obstacles) {
                System.out.print(member.getName() + " ");
                challenge.doAction();
            }
        }

        System.out.println();

        boolean participantCanGoOn;
        for (Participant participant : participants) {
            participantCanGoOn = true;
            for (Obstacle obstacle : obstacles) {
                if (obstacle.getMaxDistance() > 0 && participantCanGoOn) {
                    if (obstacle.getMaxDistance() <= participant.getMaxDistance()) {
                        System.out.println(participant.getName() + " успешно пробежал " + obstacle.getMaxDistance());

                    } else {
                        participantCanGoOn = false;
                        System.out.println(participant.getName() + " сошел с дистанции");
                        break;
                    }
                }
                if (obstacle.getMaxHeight() > 0 && participantCanGoOn) {
                    if (obstacle.getMaxHeight() <= participant.getMaxHeight()) {
                        System.out.println(participant.getName() + " успешно перепрыгнул " + obstacle.getMaxHeight());
                    } else {
                        participantCanGoOn = true;
                        System.out.println(participant.getName() + " сошел с дистанции");
                        break;
                    }
                }
            }
        }
    }
}
