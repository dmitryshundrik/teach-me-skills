package tms.lesson12;

import java.io.*;

public class Task3 {
    public static void main(String[] args) {
        int countWords = 0;
        StringBuilder text = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("test3.txt"));
             BufferedReader blacklist = new BufferedReader(new FileReader("blacklist.txt"))) {
            String[] forbiddenWords = blacklist.readLine().trim().split(" ");
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine().trim();
                for (String word : forbiddenWords) {
                    if (string.contains(word)) {
                        string = string.replace(word, "специальная военная операция");
                        countWords++;
                    }
                }
                text.append(string).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(countWords == 0 ? "Текст прошел цензуру" : "Запрещенные слова: " + countWords + "\n" +
                "Текст после цензуры: \n" + text);
    }
}
