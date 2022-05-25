package tms.lesson13.university.controller;

import tms.lesson13.university.service.AppService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final String EXIT = "ВЫХОД";
    private static final String ADD = "ДОБАВИТЬ";
    private static final String DELETE = "УДАЛИТЬ";
    private static final String INFORMATION = "ИНФО";
    private static final String BACK = "НАЗАД";
    private AppService appService = new AppService();

    public static void main(String[] args) {
        new Menu().start();
    }

    private void start() {
        appService.initializationDataBase();
        System.out.println("\nДобро пожаловать в программу Университет! Для навигации по меню вводите только нужный раздел /" +
                " слово, написанные в верхнем регистре или цифровое ID.");
        while (true) {
            System.out.printf("ОСНОВНОЕ МЕНЮ:\n1 %s\n2 %s\n3 %s\n4 %s\n", EntityType.STUDENT.getName(),
                    EntityType.GROUP.getName(), EntityType.UNIVERSITY.getName(), EXIT);
            try {
                String string = bufferedReader.readLine().trim();
                if (EntityType.STUDENT.getName().equalsIgnoreCase(string)) {
                    options(EntityType.STUDENT);
                } else if (EntityType.GROUP.getName().equalsIgnoreCase(string)) {
                    options(EntityType.GROUP);
                } else if (EntityType.UNIVERSITY.getName().equalsIgnoreCase(string)) {
                    options(EntityType.UNIVERSITY);
                } else if (EXIT.equalsIgnoreCase(string)) {
                    appService.recordData();
                    System.out.println("До свидания!");
                    break;
                } else {
                    System.out.println("Введите корректные данные!\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void options(EntityType entityType) {
        while (true) {
            System.out.printf("%s:\n1 %s\n2 %s\n3 %s\n4 %s\n", entityType.getName(), ADD, DELETE, INFORMATION, BACK);
            try {
                String string = bufferedReader.readLine().trim();
                if (ADD.equalsIgnoreCase(string)) {
                    appService.add(entityType);
                    break;
                } else if (DELETE.equalsIgnoreCase(string)) {
                    appService.delete(entityType);
                    break;
                } else if (INFORMATION.equalsIgnoreCase(string)) {
                    appService.getInformation(entityType);
                    break;
                } else if (BACK.equalsIgnoreCase(string)) {
                    break;
                } else {
                    System.out.println("Введите корректные данные!\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
