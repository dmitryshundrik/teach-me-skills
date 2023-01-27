package by.tms.lesson41homework.dao;

import by.tms.lesson41homework.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryOperationDao implements OperationDao<Operation> {
    private final List<Operation> operations = new ArrayList<>();

    public void save(Operation operation) {
        operations.add(operation);
    }

    public List<Operation> findAllOperations() {
        return operations;
    }


}
