package ru.gb.core_1.lesson3;

public class HomeWork3 {

    public static void main(String[] args) {
        taskOne();
        taskTwo();
        taskThree();
        taskFour(6);
        taskFive(7, 17);
        taskSix();
        int[] inArrayTrue = { 1, 2, 5, 5, 10, 3};
        boolean resultTrue = taskSeven(inArrayTrue);
        int[] inArrayFalse = { 10, 1, 5, 5, 10, 3};
        boolean resultFalse = taskSeven(inArrayFalse);
        int[] inArray = createArray(7, 100);
        int[] resultArray = taskEight(inArray, 17);
    }

    /**
     * Задание 3 задача 1
     * @return int[] array
     */
    private static int[] taskOne() {
        int[] array = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        return array;
    }

    /**
     * Задание 3 задача 2
     * @return int[] array
     */
    private static int[] taskTwo() {
        int[] array = new int[100];
        int value = 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = value++;
        }

        return array;
    }

    /**
     * Задание 3 задача 3
     * @return int[] array
     */
    private static int[] taskThree() {
        int[] array = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }

        return array;
    }

    /**
     * Задание 3 задача 4
     * @param n
     * @return int[][] array
     */
    private static int[][] taskFour(int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == i || j == n - 1 - i) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
                System.out.printf("%2s", array[i][j]);
            }
            System.out.printf("%n");
        }

        return array;
    }

    /**
     * Задание 3 задача 5
     * @param len
     * @param initialValue
     * @return int[] array
     */
    private static int[] taskFive(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }

        return array;
    }

    /**
     * Задание 3 задача 6
     * @return void
     */
    private static void taskSix() {
        int resultMax = 0;
        int[] array = createArray(13, 100);
        int resultMin = array[0];
        // Нахождение в массиве максимального и минимального элемента
        for (int i = 0; i < array.length; i++) {
            if (array[i] > resultMax) {
                resultMax = array[i];
            }
            if (array[i] < resultMin) {
                resultMin = array[i];
            }
        }

        System.out.printf("Максимальное значение - %3s, минимальное значение - %3s", resultMax, resultMin);
        System.out.println("");
    }

    /**
     * Создаание массива со случаными значениями заданного размера
     * @param size
     * @param bound
     * @return int[] array
     */
    private static int[] createArray(int size, int bound) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
            System.out.printf("%3s", array[i]);
        }
        System.out.println("");

        return array;
    }

    /**
     * Задание 3 задача 7
     * @param inArray
     * @return boolean result
     */
    private static boolean taskSeven(int[] inArray) {
        boolean result = false;
        int item = inArray.length-2;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < inArray.length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                leftSum = leftSum + inArray[j];
            }
            for (int k = i + 1; k < inArray.length; k++) {
                rightSum = rightSum + inArray[k];
            }
            if (leftSum == rightSum) {
                result = true;
                break;
            } else if (leftSum > rightSum) {
                result = false;
                break;
            }
            leftSum = 0;
            rightSum = 0;
        }

        return result;
    }

    /**
     * Задание 3 задача 8
     * @param inArray
     * @param offsetNumber
     * @return int[] inArray
     */
    private static int[] taskEight(int[] inArray, int offsetNumber) {
        int remainder = 0;
        if (Math.abs(offsetNumber) > inArray.length) {
            remainder = offsetNumber % inArray.length;
        }
        if (remainder < 0) {
            for (int i = 0; i < Math.abs(remainder); i++) {
                inArray = shiftArrayLeft(inArray);
            }
        } else if (remainder > 0) {
            for (int i = 0; i < Math.abs(remainder); i++) {
                inArray = shiftArrayRight(inArray);
            }
        } else if (offsetNumber < 0) {
            for (int i = 0; i < Math.abs(remainder); i++) {
                inArray = shiftArrayLeft(inArray);
            }
        } else if (offsetNumber > 0) {
            for (int i = 0; i < Math.abs(remainder); i++) {
                inArray = shiftArrayRight(inArray);
            }
        }
        for (int item : inArray) {
            System.out.printf("%3s", item);
        }
        System.out.println("");
        return inArray;
    }

    /**
     * Смещение массива влево
     * @param inArray
     * @return int[] inArray
     */
    private static int[] shiftArrayLeft(int[] inArray) {
        int valueToRemember = inArray[0];
        for (int i = 1; i < inArray.length; i++) {
            inArray[i - 1] = inArray[i];
        }
        inArray[inArray.length - 1] = valueToRemember;

        return inArray;
    }

    /**
     * Смещениие массива вправо
     * @param inArray
     * @return
     */
    private static int[] shiftArrayRight(int[] inArray) {
        int valueToRemember = inArray[inArray.length - 1];
        for (int i = inArray.length - 2; i >= 0; i--) {
            inArray[i + 1] = inArray[i];
        }
        inArray[0] = valueToRemember;

        return inArray;
    }
}
