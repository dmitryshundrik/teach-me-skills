package tms.lesson17;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements Runnable {
    private List<Integer> list;

    public BubbleSort(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        boolean sorted = false;
        int temp;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        System.out.println("Сортировка пу: " + list);
    }
}
