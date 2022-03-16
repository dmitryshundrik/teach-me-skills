package tms.lesson7.transport;

public class Cargo extends Ground {
    private int loadCapacity;

    public Cargo(int power, int maxSpeed, int weight, String brand, int wheelCount, int fuelConsumption, int loadCapacity) {
        super(power, maxSpeed, weight, brand, wheelCount, fuelConsumption);
        this.loadCapacity = loadCapacity;
    }

    public void isCapacityAvailable(int cargoWeight) {
        System.out.println(loadCapacity - cargoWeight > 0 ? "Грузовик загружен" : "Вам нужен грузовик побольше");
        loadCapacity += cargoWeight;
    }

    @Override
    public String toString() {
        return super.toString() + ", loadCapacity=" + loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
