package tms.lesson15;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        list.stream()
                .filter(value -> value % 2 == 0)
                .forEach(System.out::println);

        list.stream()
                .sorted()
                .forEach(System.out::println);

        list.stream()
                .sorted((t1, t2) -> t2 - t1)
                .forEach(System.out::println);

        list.stream()
                .min(Integer::compareTo)
                .ifPresent(System.out::println);

        list.stream()
                .max(Integer::compareTo)
                .ifPresent(System.out::println);

        list.stream()
                .filter(value -> value > 20)
                .sorted()
                .forEach(value -> System.out.println(value * 10));

        list.stream()
                .skip(5)
                .limit(10)
                .distinct()
                .max(Integer::compareTo)
                .ifPresent(System.out::println);

        list.stream()
                .skip(5)
                .limit(10)
                .map(value -> value * 10)
                .sorted((integer, t1) -> t1 - integer)
                .forEach(value -> System.out.println(value + 5));
    }
}
