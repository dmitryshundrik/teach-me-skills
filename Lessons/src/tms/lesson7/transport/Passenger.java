package tms.lesson7.transport;

public class Passenger extends Ground {
    private String type;
    private int passengerCount;

    public Passenger(int power, int maxSpeed, int weight, String brand, int wheelCount, int fuelConsumption, String type, int passengerCount) {
        super(power, maxSpeed, weight, brand, wheelCount, fuelConsumption);
        this.type = type;
        this.passengerCount = passengerCount;
    }

    public void capacity(int time) {
        System.out.printf("За вермя %d ч, автомобиль %s двигаясь с максимальной скоростью %d км/ч проедет %d км и израсходует %d литров топлива.",
                time, getBrand(), getMaxSpeed(), getMaxSpeed() * time, fuelConsumption(getMaxSpeed() * time));
    }

    private int fuelConsumption(int distance) {
        return getFuelConsumption() * distance / 100;
    }

    @Override
    public String toString() {
        return super.toString() + ", type=" + type + ", passengerCount=" + passengerCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }
}
