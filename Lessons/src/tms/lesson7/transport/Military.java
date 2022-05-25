package tms.lesson7.transport;

public class Military extends Air {
    private boolean isEjectionSystemAvailable;
    private int rocketCount;

    public Military(int power, int maxSpeed, int weight, String brand, int wingspan, int minRunwayLength, boolean isEjectionSystemAvailable, int rocketCount) {
        super(power, maxSpeed, weight, brand, wingspan, minRunwayLength);
        this.isEjectionSystemAvailable = isEjectionSystemAvailable;
        this.rocketCount = rocketCount;
    }

    public void shot() {
        System.out.println(rocketCount > 0 ? "Ракета пошла" : "Боеприпасы отсутствуют");
    }

    public void ejection() {
        System.out.println(isEjectionSystemAvailable ? "Катапультирование прошло успешно" : "У вас нет такой системы");
    }

    @Override
    public String toString() {
        return super.toString() + ", isEjectionSystemAvailable=" + isEjectionSystemAvailable + ", rocketCount=" + rocketCount;
    }

    public boolean isEjectionSystemAvailable() {
        return isEjectionSystemAvailable;
    }

    public void setEjectionSystemAvailable(boolean ejectionSystemAvailable) {
        isEjectionSystemAvailable = ejectionSystemAvailable;
    }

    public int getRocketCount() {
        return rocketCount;
    }

    public void setRocketCount(int rocketCount) {
        this.rocketCount = rocketCount;
    }
}
