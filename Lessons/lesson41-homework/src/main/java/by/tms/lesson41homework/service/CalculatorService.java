package by.tms.lesson41homework.service;

import by.tms.lesson41homework.dao.OperationDao;
import by.tms.lesson41homework.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    private OperationDao inMemoryOperationDao;

    public String executeOperation(Operation operation) {
        int firstNumber = Integer.parseInt(operation.getFirstNumber());
        int secondNumber = Integer.parseInt(operation.getSecondNumber());
        int result = 0;
        switch (operation.getOperation()) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
        }
        return String.valueOf(result);
    }

    public void save(Operation operation) {
        inMemoryOperationDao.save(operation);
    }

    public List<Operation> findAllOperations() {
        return inMemoryOperationDao.findAllOperations();
    }
}
