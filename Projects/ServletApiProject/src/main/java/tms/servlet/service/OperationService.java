package tms.servlet.service;

import tms.servlet.entity.Operation;

import java.util.List;

public interface OperationService {

    public double calculate(double num1, double num2, String operationName);

    List<Operation> findOperations(int page);

}
