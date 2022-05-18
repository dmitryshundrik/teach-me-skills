package tms.lesson17;

import java.util.List;

public class InsertionSort implements Runnable {
    private List<Integer> list;

    public InsertionSort(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            int j = i - 1;
            while (j >= 0 && current < list.get(j)) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, current);
        }
        System.out.println("Сортировка вс: " + list);
    }
}
