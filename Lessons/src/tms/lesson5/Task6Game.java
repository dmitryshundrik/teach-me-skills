package tms.lesson5;

import java.util.Scanner;

public class Task6Game {
    public void startGame() {
        System.out.println("Lesson5/Task6:");
        String[][] array = ArrayUtil.createBoard();
        String player1 = "Player 1";
        String player2 = "Player 2";

        while (true) {
            updateArray(player1, array);
            ArrayUtil.printArray(array);
            if (isOver(array)) {
                System.out.printf("%s победил!", player1);
                break;
            }
            isEmpty(array);

            updateArray(player2, array);
            ArrayUtil.printArray(array);
            if (isOver(array)) {
                System.out.printf("%s победил!", player2);
                break;
            }
            isEmpty(array);
        }
    }

    private void updateArray(String player, String[][] array) {
        System.out.println(player + " делает ход:");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a > array.length || b > array.length) {
            System.out.println("Некорректные координаты!");
            updateArray(player, array);
        }
        switch (player) {
            case "Player 1":
                if (array[a][b].equals("■")) {
                    array[a][b] = "X";
                } else {
                    System.out.println("Вы попали на поле соперника, введите другие координаты.");
                    updateArray(player, array);
                }
                break;
            case "Player 2":
                if (array[a][b].equals("■")) {
                    array[a][b] = "O";
                } else {
                    System.out.println("Вы попали на поле соперника, введите другие координаты.");
                    updateArray(player, array);
                }
                break;
        }
    }

    private static void isEmpty(String[][] array) {
        boolean isEmpty = false;
        for (String[] strings : array) {
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].equals("■")) {
                    isEmpty = true;
                    break;
                }
            }
        }
        if (!isEmpty) {
            System.out.println("Игра окончена!");
        }
    }

    private static boolean isOver(String[][] array) {
        boolean isOver = false;
        if (!array[0][0].equals("■") && array[0][0].equals(array[0][1]) && array[0][1].equals(array[0][2])) {
            isOver = true;
        } else if (!array[1][0].equals("■") && array[1][0].equals(array[1][1]) && array[1][1].equals(array[1][2])) {
            isOver = true;
        } else if (!array[2][0].equals("■") && array[2][0].equals(array[2][1]) && array[2][1].equals(array[2][2])) {
            isOver = true;
        } else if (!array[0][0].equals("■") && array[0][0].equals(array[1][0]) && array[1][0].equals(array[2][0])) {
            isOver = true;
        } else if (!array[0][1].equals("■") && array[0][1].equals(array[1][1]) && array[1][1].equals(array[2][1])) {
            isOver = true;
        } else if (!array[0][2].equals("■") && array[0][2].equals(array[1][2]) && array[1][2].equals(array[2][2])) {
            isOver = true;
        } else if (!array[0][0].equals("■") && array[0][0].equals(array[1][1]) && array[1][1].equals(array[2][2])) {
            isOver = true;
        } else if (!array[0][2].equals("■") && array[0][2].equals(array[1][1]) && array[1][1].equals(array[2][0])) {
            isOver = true;
        }
        return isOver;
    }
}
