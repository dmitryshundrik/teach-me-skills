package tms.lesson7.transport;

public class Ground extends Transport {
    private int wheelCount;
    private int fuelConsumption;

    public Ground(int power, int maxSpeed, int weight, String brand, int wheelCount, int fuelConsumption) {
        super(power, maxSpeed, weight, brand);
        this.wheelCount = wheelCount;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return super.toString() + ", wheelCount=" + wheelCount + ", fuelConsumption=" + fuelConsumption;
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
