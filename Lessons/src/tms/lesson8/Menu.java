package tms.lesson8;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final static String REGISTRATION = "РЕГИСТРАЦИЯ";
    private final static String AUTHORIZATION = "АВТОРИЗАЦИЯ";
    private final static String HISTORY = "ИСТОРИЯ";
    private final static String EXIT = "ВЫХОД";
    private Scanner scanner = new Scanner(System.in);
    private Calculator calculator = new CalculatorImpl();

    private User currentUser;

    static {
        DataBase.dataBaseDownload();
    }

    public void start() {
        System.out.println("Введите АВТОРИЗАЦИЯ для входа, РЕГИСТРАЦИЯ для создания пользователя или ВЫХОД, чтобы" +
                " завершить программу:");
        String string = scanner.nextLine().trim();
        if (REGISTRATION.equalsIgnoreCase(string)) {
            registration();
        } else if (AUTHORIZATION.equalsIgnoreCase(string)) {
            authorization();
        } else if (EXIT.equalsIgnoreCase(string)) {
            DataBase.dataBaseUnload();
            System.out.println("До свидания!");
        } else {
            System.out.println("Введите корректные данные!");
            start();
        }
    }

    private void registration() {
        while (true) {
            System.out.println("Создайте ЛОГИН:");
            String login = scanner.nextLine().trim();
            if (isEqualWithComplete(login)) {
                start();
                break;
            }
            if (!"".equals(login) && DataBase.getUser(login) == null) {
                System.out.println("Создайте ПАРОЛЬ:");
                String password = scanner.nextLine().trim();
                if (isEqualWithComplete(password)) {
                    start();
                    break;
                }
                if (!"".equals(password)) {
                    System.out.println("Создайте ИМЯ:");
                    String name = scanner.nextLine().trim();
                    if (isEqualWithComplete(name)) {
                        start();
                        break;
                    }
                    if (!"".equals(name)) {
                        DataBase.setUser(new User(login, password, name));
                        System.out.println("Вы успешно зарегистрировались!");
                        start();
                        break;
                    } else {
                        System.out.println("Имя недопустимого формата!");
                    }
                } else {
                    System.out.println("Пароль недопустимого формата!");
                }
            } else {
                System.out.println("Логин недопустимого формата или уже существует!");
            }
        }
    }

    private void authorization() {
        while (true) {
            System.out.println("Ваш ЛОГИН:");
            String login = scanner.nextLine().trim();
            if (isEqualWithComplete(login)) {
                start();
                break;
            }
            System.out.println("Ваш ПАРОЛЬ:");
            String password = scanner.nextLine().trim();
            if (isEqualWithComplete(password)) {
                start();
                break;
            }
            User user = DataBase.getUser(login);
            if (user != null && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Добро пожаловать, " + currentUser.getName());
                verificationOperation();
                break;
            } else {
                System.out.println("Неверный логин или пароль!");
            }
        }
    }

    private void verificationOperation() {
        while (true) {
            System.out.println("Введите данные для операции, ИСТОРИЯ для просмотра списка результатов или ВЫХОД," +
                    " чтобы вернуться в основное меню:");
            String firstNumber = scanner.nextLine().trim();
            if (isEqualWithComplete(firstNumber)) {
                start();
                break;
            } else if (isEqualWithHistory(firstNumber)) {
                currentUser.printValues();
                continue;
            }
            String secondNumber = scanner.nextLine().trim();
            if (isEqualWithComplete(secondNumber)) {
                start();
                break;
            } else if (isEqualWithHistory(secondNumber)) {
                currentUser.printValues();
                continue;
            }
            String operation = scanner.nextLine().trim();
            if (isEqualWithComplete(operation)) {
                start();
                break;
            } else if (isEqualWithHistory(operation)) {
                currentUser.printValues();
                continue;
            }
            executeOperation(firstNumber, secondNumber, operation);
        }
    }

    private void executeOperation(String firstNumber, String secondNumber, String operation) {
        if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
            try {
                calculator.operation(currentUser, Double.parseDouble(firstNumber), Double.parseDouble(secondNumber), operation);
            } catch (Exception e) {
                System.out.println("Введите корректные числа!");
            }
        } else {
            System.out.println("Введите корректный оператор!");
        }
    }

    private boolean isEqualWithComplete(String string) {
        return (EXIT.equalsIgnoreCase(string));
    }

    private boolean isEqualWithHistory(String string) {
        return (HISTORY.equalsIgnoreCase(string));
    }
}