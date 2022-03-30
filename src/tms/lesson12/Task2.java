package tms.lesson12;

import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("test2.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result.txt"))) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine().trim();
                String[] strings = string.replaceAll(",", "").replace(".", "").split(" ");
                if (TextFormatter.wordCount(strings) || TextFormatter.isThereAPalindrome(strings)) {
                    bufferedWriter.write(string + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
