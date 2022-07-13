package tms.servlet.dao;

import tms.servlet.entity.Operation;
import tms.servlet.entity.User;

import java.util.List;

public interface OperationDao {

    public Operation createOperation(double num1, double num2, String operationName, String result, User currentUser);

    public void save(Operation operation);

    public List<Operation> findAllOperationByUsername(String requiredUsername);

}
