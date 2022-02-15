package ru.gb.core_1.lesson7.string;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class StringFile {

    public static void main(String[] args) throws IOException {
//        File file = new File("X:\\Ya.Disk\\work\\Lessons\\java1_251121\\src\\main\\resources\\lib\\text.txt");
        File file = new File("src/main/resources/lib/text.txt");

/*        if (file.exists()) {
            file.delete();
        } else {
            file.createNewFile();
        }*/

        var is = new BufferedInputStream(new FileInputStream(file));
//        System.out.println(new String(is.readAllBytes()));

        int size = is.available();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append((char)is.read());
        }

        System.out.println(sb.toString());

    }
}
