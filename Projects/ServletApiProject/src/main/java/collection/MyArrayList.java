package collection;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
    private Object[] array = new Object[10];
    private int size = 0;

    private void grow() {
        Object[] newArray = new Object[(int) (array.length * 1.5)];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public void add(T o) {
        if (size == array.length) {
            grow();
        }
        array[size++] = o;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public T remove(int index) {
        Object element = array[index];
        for (int i = index; i < array.length; i++) {
            if (i < (array.length - 1)) {
                array[i] = array[i + 1];
            }
        }
        array[size - 1] = null;
        size--;
        return (T) element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < size; i++) {
            string.append(array[i]).append(" ");
        }
        return string.toString();
    }
}
