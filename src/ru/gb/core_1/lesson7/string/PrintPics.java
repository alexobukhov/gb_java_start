package ru.gb.core_1.lesson7.string;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class PrintPics {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/lib/pics.txt");
        var pics = new String(new FileInputStream(file).readAllBytes()).split("&+");

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Введите номер картинки от 1 до " + pics.length);
            System.out.println(pics[in.nextInt() - 1]);
        }
    }
}
