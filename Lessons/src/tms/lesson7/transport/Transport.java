package tms.lesson7.transport;

public class Transport {
    private int power;
    private int maxSpeed;
    private int weight;
    private String brand;

    public Transport(int power, int maxSpeed, int weight, String brand) {
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.brand = brand;
    }

    private double powerToWatts() {
        return this.power * 0.74;
    }

    @Override
    public String toString() {
        return "power=" + power + " / " + powerToWatts() + ", maxSpeed=" + maxSpeed + ", weight=" + weight + ", brand= " + brand;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
