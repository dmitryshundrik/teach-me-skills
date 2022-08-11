package by.tms.service;

import by.tms.dao.HibernateOperationDao;
import by.tms.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    private HibernateOperationDao operationDao;

    public void save(Operation operation) {
        operationDao.save(operation);
    }

    public List<Operation> findAll() {
        return operationDao.findAll();
    }

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
}
