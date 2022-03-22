package tms.lesson7.transport;

public class Civil extends Air {
    private int passengerCount;
    private boolean isBusinessClassAvailable;

    public Civil(int power, int maxSpeed, int weight, String brand, int wingspan, int minRunwayLength, int passengerCount, boolean isBusinessClassAvailable) {
        super(power, maxSpeed, weight, brand, wingspan, minRunwayLength);
        this.passengerCount = passengerCount;
        this.isBusinessClassAvailable = isBusinessClassAvailable;
    }

    public void isCapacityAvailable(int passengers) {
        System.out.println(passengerCount - passengers > 0 ? "Самолет загружен" : "Вам нужен самолет побольше");
    }

    @Override
    public String toString() {
        return super.toString() + ", passengerCount=" + passengerCount + ", isBusinessClassAvailable=" + isBusinessClassAvailable;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public boolean isBusinessClassAvailable() {
        return isBusinessClassAvailable;
    }

    public void setBusinessClassAvailable(boolean businessClassAvailable) {
        isBusinessClassAvailable = businessClassAvailable;
    }
}
