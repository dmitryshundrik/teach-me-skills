package tms.lesson13.university.util;

import tms.lesson8.DataBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {

    public static void pressEnter() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Для продолжения нажмите ENTER");
        while (true) {
            String string;
            try {
                string = bufferedReader.readLine().trim();
                if ("".equalsIgnoreCase(string)) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
