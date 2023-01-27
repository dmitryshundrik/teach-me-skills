package tms.servlet.entity;

import java.util.Date;

public class Operation {
    private double num1;
    private double num2;
    private String operation;
    private String result;
    private User user;
    private Date date;

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        String stringOperation = "";
        switch (operation) {
            case "sum":
                stringOperation = "+";
                break;
            case "sub":
                stringOperation = "-";
                break;
            case "mul":
                stringOperation = "*";
                break;
            case "div":
                stringOperation = "/";
                break;

        }
        return date + " " + num1 + " " + stringOperation + " " + num2 + " = " + result;
    }
}
