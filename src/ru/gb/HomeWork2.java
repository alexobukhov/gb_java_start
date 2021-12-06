package ru.gb;

public class HomeWork2 {

    public static void main(String[] args) {

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

    private static boolean checkSum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber >= 10 && firstNumber + secondNumber <= 20;
    }

    private static void checkIfNumberPositiveOrNegativeConsole(int checkNumber) {
        String stringToPrint = "Число";
        if (checkNumber < 0) {
            System.out.println(stringToPrint + " отрицательное");
        } else {
            System.out.println(stringToPrint + " положительное");
        }
    }

    private static boolean checkIfNumberPositiveOrNegativeBoolean(int checkNumber) {
        return checkNumber < 0;
    }

    private static void printString(String stringToPrint, int printCount) {
        for (int i = 0; i < printCount; i++) {
            System.out.print(stringToPrint + " ");
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
