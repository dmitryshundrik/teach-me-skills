package tms.lesson17;

import java.util.List;

public class SelectionSort implements Runnable {
    private List<Integer> list;

    public SelectionSort(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < list.size(); i++) {
            int min = list.get(i);
            int minId = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < min) {
                    min = list.get(j);
                    minId = j;
                }
            }
            int temp = list.get(i);
            list.set(i, min);
            list.set(minId, temp);
        }
        System.out.println("Сортировка вы: " + list);
    }
}
