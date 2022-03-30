package tms.lesson11;

public class Solution {
    public static void main(String[] args) {
        Car car = new Car();
        try {
            car.startTheCar();
        } catch (CarException e) {
            e.printStackTrace();
        }
    }
}
