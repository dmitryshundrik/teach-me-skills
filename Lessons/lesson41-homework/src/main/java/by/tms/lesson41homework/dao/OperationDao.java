package by.tms.lesson41homework.dao;

import java.util.List;

public interface OperationDao<T> {
    void save(T t);
    List<T> findAllOperations();
}
