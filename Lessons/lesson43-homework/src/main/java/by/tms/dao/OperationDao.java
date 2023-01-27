package by.tms.dao;

import by.tms.entity.Operation;

import java.util.List;

public interface OperationDao {

    void save(Operation operation);
    List<Operation> findAll();
}
