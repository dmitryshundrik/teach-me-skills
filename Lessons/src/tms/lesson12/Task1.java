package tms.lesson12;

import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("test1.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result.txt"))) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine().trim();
                if (string.equalsIgnoreCase(new StringBuilder(string).reverse().toString())) {
                    bufferedWriter.write(string + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
