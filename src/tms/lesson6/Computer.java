package tms.lesson6;

import java.util.Random;
import java.util.Scanner;

public class Computer {
    private String cpu;
    private int ram;
    private int hardDrive;
    private int cycles = 5;

    public void printInfo() {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Hard Drive: " + hardDrive);
        System.out.println("On-Off cycles: " + cycles);
    }

    public void on() {
        if (inputData() && cycles > 0) {
            System.out.println("Компьютер загружается...");
            cycles--;
        } else {
            System.out.println("Компьютер сгорел");
        }
    }

    public void off() {
        if (inputData() && cycles > 0) {
            System.out.println("Компьютер выключается...");
            cycles--;
        } else {
            System.out.println("Компьютер сгорел");
        }
    }

    public boolean inputData() {
        int value;
        Random random = new Random();
        value = random.nextInt(1);

        int number;
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();

        return value == number;
    }
}

