package ru.gb;

public class HomeWorkApp {
    public static void main(String[] args) {

        //Проверка пункта 1 задания 1
        printThreeWords();

        //Проверка пункта 2 задания 1
        checkSumSign();

        //Проверка пункта 3 задания 1
        printColor();

        //Проверка пункта 4 задания 1
        compareNumbers();

        //Проверка пункта 1 задания 2
        Boolean checkSum = checkSum(4, 5);

        //Проверка пункта 2 задания 2
        checkIfNumberPositiveOrNegativeConsole(-5);

        //Проверка пункта 3 задания 2
        Boolean checkNumber = checkIfNumberPositiveOrNegativeBoolean(10);

        //Проверка пункта 4 задания 2
        printString("Test", 5);

        //Проверка пункта 5 задания 2
        Boolean checkYear = checkLeapYear(1905);

        System.out.println("Работа приложениия завершена.");
    }

    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    private static void checkSumSign() {
        int a = 13;
        int b = 17;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void printColor() {
        int value = 253;
        if (value < 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    private static void compareNumbers() {
        int a = 257;
        int b = 153;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    private static boolean checkSum(int firstNumber, int secondNumber) {
        if (firstNumber + secondNumber >= 10 && firstNumber + secondNumber <= 20) {
            return true;
        } else {
            return false;
        }
    }

    private static void checkIfNumberPositiveOrNegativeConsole(int checkNumber) {
        if (checkNumber < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    private static boolean checkIfNumberPositiveOrNegativeBoolean(int checkNumber) {
        if (checkNumber < 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void printString(String stringToPrint, int printCount) {
        for (int i = 0; i < printCount; i++) {
            System.out.println(stringToPrint);
        }
    }

    private static boolean checkLeapYear(int checkYear) {
        if (checkYear % 400 == 0) {
            return true;
        } else if (checkYear % 100 == 0) {
            return false;
        } else if (checkYear % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
