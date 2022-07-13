package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyMap<String, String> myMap = new MyHashMap<>();
        myMap.put("1", "one");
        myMap.put("2", "two");
        myMap.put("3", "three");
        myMap.put("Key", "Value");
        myMap.put("4", "four");
        myMap.put("5", "five");
        myMap.put("6", "six");
        myMap.put("Value", "Key");

        System.out.println(myMap);

        myMap.remove("2");

        System.out.println(myMap);
    }
}
