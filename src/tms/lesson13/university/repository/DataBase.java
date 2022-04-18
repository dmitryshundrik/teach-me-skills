package tms.lesson13.university.repository;

import java.util.Optional;

public interface DataBase<T> {

    void initialization();

    void add(T t);

    void delete(String id);

    Optional<T> get(String id);

    void getInformation();

    void record();
}
