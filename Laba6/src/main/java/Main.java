import java.util.ArrayList;

public class Main {
    static final float MIN_VALUE = 123F;
    static final float MAX_VALUE = 250F;

    public static void main(String[] args) {
        ArrayList<Plane> company = new ArrayList<>(); // моя авіакомпанія
        company.add(new PlaneOne());
        company.add(new PlaneTwo());
        company.add(new PlaneThree());
        float fullWeight = 0F;
        for (Plane plane : company) {
            fullWeight += plane.maxWeight;
        }
        System.out.println("Суммарний макс. вантаж: " + fullWeight);

        int fullPassengers = 0;
        for (Plane plane : company) {
            fullPassengers += plane.passengers;
        }
        System.out.println("Макс. пасажирів: " + fullPassengers);

        for (Plane plane : company) {
            if (plane.costFuel >= MIN_VALUE && plane.costFuel <= MAX_VALUE) {
                System.out.println("Літак, що відповідає діапазону споживання пального: " + plane);
                break;
            }
        }
    }
}
