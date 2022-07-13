package tms.servlet.service;

import tms.servlet.dao.OperationValueLIstHandler;
import tms.servlet.dao.ValueListIterator;
import tms.servlet.entity.Operation;

import java.util.List;

public class OperationServiceImpl implements OperationService{

    private static volatile OperationServiceImpl instance;

    public static OperationServiceImpl getInstance() {
        synchronized (OperationServiceImpl.class) {
            if (instance == null) {
                instance = new OperationServiceImpl();
            }
            return instance;
        }
    }

    public double calculate(double num1, double num2, String operationName) {
        double result = 0;
        switch (operationName) {
            case "sum":
                result = num1 + num2;
                break;
            case "sub":
                result = num1 - num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "div":
                result = num1 / num2;
                break;
        }
        return result;
    }

    private final ValueListIterator<Operation> valueListHandler = new OperationValueLIstHandler();

    @Override
    public List<Operation> findOperations(int page) {
        return null;
    }
}
