package tms.servlet.storage;

import tms.servlet.entity.Operation;
import tms.servlet.entity.User;
import tms.servlet.service.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationStorage {

    private final DatabaseConnection databaseConnection = new DatabaseConnection();
    private final UserStorage userStorage = new UserStorage();

    public Operation createOperation(double num1, double num2, String operationName, String result, User currentUser) {
        Operation operation = new Operation();
        operation.setNum1(num1);
        operation.setNum2(num2);
        operation.setOperation(operationName);
        operation.setResult(result);
        operation.setUser(currentUser);
        operation.setDate(new Date());
        return operation;
    }

    public void save(Operation operation) {
        try {
            PreparedStatement prepareStatement = databaseConnection.connection().
                    prepareStatement("insert into operations values (?,?,?,?,?,?, default)");
            prepareStatement.setDouble(1, operation.getNum1());
            prepareStatement.setDouble(2, operation.getNum2());
            prepareStatement.setString(3, operation.getOperation());
            prepareStatement.setString(4, operation.getUser().getUsername());
            prepareStatement.setDate(5, new java.sql.Date(operation.getDate().getTime()));
            prepareStatement.setString(6, operation.getResult());
            prepareStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Operation> findAllOperationByUsername(String requiredUsername) {
        List<Operation> operations = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = databaseConnection.connection().
                    prepareStatement("select * from operations where username = ?");
            preparedStatement.setString(1, requiredUsername);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Operation operation = new Operation();
                operation.setNum1(resultSet.getDouble(1));
                operation.setNum2(resultSet.getDouble(2));
                operation.setOperation(resultSet.getString(3));
                operation.setUser(userStorage.findByUsername(resultSet.getString(4)).get());
                operation.setDate(resultSet.getDate(5));
                operation.setResult(resultSet.getString(6));
                operations.add(operation);
            }
            return operations;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
