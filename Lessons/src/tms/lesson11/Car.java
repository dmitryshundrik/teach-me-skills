package tms.lesson11;

public class Car {
    private String brand;
    private int speed;
    private int price;

    public void startTheCar() throws CarException {
        int value = (int) (Math.random() * 20);
        if (value % 2 == 0) {
            throw new CarException();
        } else {
            System.out.print("Автомобиль " + getBrand() + " завелся");
        }
    }

    public Car() {

    }

    public Car(String brand, int speed, int price) {
        this.brand = brand;
        this.speed = speed;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
