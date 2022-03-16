package tms.lesson7.transport;

public class Air extends Transport {
    private int wingspan;
    private int minRunwayLength;

    public Air(int power, int maxSpeed, int weight, String brand, int wingspan, int minRunwayLength) {
        super(power, maxSpeed, weight, brand);
        this.wingspan = wingspan;
        this.minRunwayLength = minRunwayLength;
    }

    @Override
    public String toString() {
        return super.toString() + ", wingspan=" + wingspan + ", minRunwayLength=" + minRunwayLength;
    }

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    public int getMinRunwayLength() {
        return minRunwayLength;
    }

    public void setMinRunwayLength(int minRunwayLength) {
        this.minRunwayLength = minRunwayLength;
    }
}
