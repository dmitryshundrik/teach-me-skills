package tms.lesson17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    private static List<Integer> list = createList();

    public static void main(String[] args) {
        Thread bubbleSort = new Thread(new BubbleSort(new ArrayList<>(list)));
        Thread insertionSort = new Thread(new InsertionSort(new ArrayList<>(list)));
        Thread selectionSort = new Thread(new SelectionSort(new ArrayList<>(list)));

        System.out.println(list);

        bubbleSort.start();
        insertionSort.start();
        selectionSort.start();
    }

    public static List<Integer> createList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }
}
