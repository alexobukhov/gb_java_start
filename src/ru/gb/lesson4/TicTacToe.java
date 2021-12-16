package ru.gb.lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 3;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';

    private static final char[][] MAP = new char[SIZE][SIZE];
    private static final Scanner in = new Scanner(System.in);
    private static final Random random = new Random();

    private static final String HEADER_FIRST_SYMBOL = "♥";
    private static final String SPACE_MAP = " ";

    private static int turnsCount;
    private static int[] positionCurrent;

    public static void turnGame() {
        do {
            System.out.println("\n\nИгра начинается!");
            init();
            printMap();
            playGame();
        } while (isContinueGame());
        endGame();
    }

    private static void init() {
        turnsCount = 0;
        initMap();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeaderMap();
        printBodyMap();
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + SPACE_MAP);
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP);
            }
            System.out.println();
        }
    }

    private static void playGame() {

        while (true) {
            positionCurrent = turnHuman();
            printMap();
            if (checkEnd(DOT_HUMAN, positionCurrent)) {
                break;
            }

            positionCurrent = turnAI();
            printMap();
            if (checkEnd(DOT_AI, positionCurrent)) {
                break;
            }
        }

    }

    private static int[] turnHuman() {
        System.out.println("ХОД ЧЕЛОВЕКА");
        int rowNumber, columnNumber;
        int[] position = new int[1];

        while (true) {
            rowNumber = getValidNumberFromUser() - 1;
            columnNumber = getValidNumberFromUser() - 1;
            if (isCellFree(rowNumber, columnNumber)) {
                break;
            }
            System.out.println("\nВы выбрали занятую ячейку!");
        }

        position[0] = rowNumber;
        position[1] = columnNumber;
        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        turnsCount++;

        return position;
    }

    private static int getValidNumberFromUser() {
        while (true) {
            System.out.print("Введите координату(1-" + SIZE + "): ");
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if(isNumberValid(n)) {
                    return n;
                }
                System.out.println("\nПроверьте значение координаты. Должно быть от 1 до " + SIZE);
            } else {
                in.next();
                System.out.println("\nВвод допускает лишь целые числа!");
            }
        }
    }

    private static boolean isNumberValid(int n) {
        return n >= 1 && n <= SIZE;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static int[] turnAI() {
        System.out.println("ХОД КОМУКТЕРА");
        int rowNumber, columnNumber;
        int[] position = new int[1];

        do {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);

        } while (!isCellFree(rowNumber, columnNumber));

        position[0] = rowNumber;
        position[1] = columnNumber;
        MAP[rowNumber][columnNumber] = DOT_AI;
        turnsCount++;
        return position;
    }

    private static boolean checkEnd(char symbol, int[] positionCurrent) {
        if (checkWin(symbol, positionCurrent)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("\nУраааааааааааааа!! Вы победили!");
            } else {
                System.out.println("\nВосстание близко... ИИ победил");
            }
            return true;
        }

        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static boolean checkDraw() {
        return turnsCount >= SIZE * SIZE;
    }

    private static boolean checkWin(char symbol, int[] positionCurrent) {
        // Проверка ряда
        for (int i = 0; i < SIZE; i++) {
            if (MAP[positionCurrent[0]][i] != symbol) {
                return false;
            }
        }
        // Проверка колонки
        for (int i = 0; i < SIZE; i++) {
            if (MAP[i][positionCurrent[1]] != symbol) {
                return false;
            }
        }
        // Проверка диагоналей
        if (checkRightBottomDiagonal(positionCurrent, symbol) && checkLeftUpperDiagonal(positionCurrent, symbol)) {
            return true;
        };
        if (checkRightUpperDiagonal(positionCurrent, symbol) && checkLeftBottomDiagonal(positionCurrent, symbol)) {
            return true;
        }
        /*if (MAP[0][0] == symbol && MAP[0][1] == symbol && MAP[0][2] == symbol) {
            return true;
        }
        if (MAP[1][0] == symbol && MAP[1][1] == symbol && MAP[1][2] == symbol) {
            return true;
        }
        if (MAP[2][0] == symbol && MAP[2][1] == symbol && MAP[2][2] == symbol) {
            return true;
        }

        if (MAP[0][0] == symbol && MAP[1][0] == symbol && MAP[2][0] == symbol) {
            return true;
        }
        if (MAP[0][1] == symbol && MAP[1][1] == symbol && MAP[2][1] == symbol) {
            return true;
        }
        if (MAP[0][2] == symbol && MAP[1][2] == symbol && MAP[2][2] == symbol) {
            return true;
        }

        if (MAP[0][0] == symbol && MAP[1][1] == symbol && MAP[2][2] == symbol) {
            return true;
        }
        if (MAP[0][2] == symbol && MAP[1][1] == symbol && MAP[2][0] == symbol) {
            return true;
        }*/

        return true;
    }

    private static boolean checkRightBottomDiagonal(int[] positionCurrent, char symbol) {
        int checkColumn = positionCurrent[1];
        for (int i = positionCurrent[0]; i < SIZE; i++) {
            if (MAP[i][checkColumn] != symbol) {
                return false;
            }
            checkColumn++;
            if (checkColumn == SIZE) {
                break;
            }
        }
        return true;
    }

    private static boolean checkLeftUpperDiagonal(int[] positionCurrent, char symbol) {
        int checkColumn = positionCurrent[1];
        for (int i = positionCurrent[0]; i < 0; i--) {
            if (MAP[i][checkColumn] != symbol) {
                return false;
            }
            checkColumn--;
            if (checkColumn < 0) {
                break;
            }
        }
        return true;
    }

    private static boolean checkRightUpperDiagonal(int[] positionCurrent, char symbol) {
        int checkColumn = positionCurrent[1];
        for (int i = positionCurrent[0]; i < 0; i--) {
            if (MAP[i][checkColumn] != symbol) {
                return false;
            }
            checkColumn++;
            if (checkColumn == SIZE) {
                break;
            }
        }
        return true;
    }

    private static boolean checkLeftBottomDiagonal(int[] positionCurrent, char symbol) {
        int checkColumn = positionCurrent[1];
        for (int i = positionCurrent[0]; i < SIZE; i++) {
            if (MAP[i][checkColumn] != symbol) {
                return false;
            }
            checkColumn--;
            if (checkColumn < 0) {
                break;
            }
        }
        return true;
    }

    private static boolean isContinueGame() {
        System.out.println("Хотите продолжить? y\\n");
        return switch (in.next()) {
            case "y", "yes", "+", "да", "конечно" -> true;
            default -> false;
        };
    }

    private static void endGame() {
        in.close();
        System.out.println("Ты заходи, если что");
    }
}
