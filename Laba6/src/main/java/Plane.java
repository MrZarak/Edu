public class Plane {
    public int passengers;
    public float costFuel;
    public float maxWeight;

    public Plane(int passengers, float costFuel, float maxWeight) {
        this.passengers = passengers;
        this.costFuel = costFuel;
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "passengers=" + passengers +
                ", costFuel=" + costFuel +
                ", maxWeight=" + maxWeight +
                '}';
    }
}
