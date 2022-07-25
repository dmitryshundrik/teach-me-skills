package collection;

public interface MyList<T> {
    void add(T o);

    T get(int index);

    T remove(int index);

    int size();
}
