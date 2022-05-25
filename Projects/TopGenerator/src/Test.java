import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> list = new ArrayList<>();
        String fileName = "C:\\Users\\user\\Desktop\\test.txt";
        generator(fileName);
    }

    private static void generator(String string) throws IOException, InterruptedException {
        List<String> list = new ArrayList<>();
        List<String> questions = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(string));
        while (reader.ready()) {
            String line = reader.readLine();
            list.add(line);
            hashMap.put(line, 0);
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size() - 1; j++) {
                questions.add((list.get(i) + "или" + list.get(j + 1)).trim());
            }
        }
        Collections.shuffle(questions);
        System.out.println("Проголосуй за свои любимые песни:");
        Thread.sleep(500);
        int count = 1;
        int allCount = questions.size();
        for (String question : questions) {
            String[] strings = question.split("или");
            System.out.println(count + "/" + allCount + " Что лушче? " + strings[0] + "  или  " + strings[1]);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String answer = bufferedReader.readLine();
            if (answer.equals("1")) {
                hashMap.put(strings[0], hashMap.get(strings[0]) + 1);
                hashMap.put(strings[1], hashMap.get(strings[1]));
            } else if (answer.equals("2")) {
                hashMap.put(strings[0], hashMap.get(strings[0]));
                hashMap.put(strings[1], hashMap.get(strings[1]) + 1);
            }
            count++;
        }
        list.clear();
        for (Map.Entry<String, Integer> map : hashMap.entrySet()) {
            list.add(map.getValue() + " " + map.getKey());
        }
        Collections.sort(list);
        System.out.println();
        Thread.sleep(500);
        System.out.println("Твой список лучших песен:");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }
}
