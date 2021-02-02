import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Car[] schools = {
                new Car("BMW", "БМВ", 500, 50, 10000000),
                new Car("Toyota", "Тойота", 400, 50, 5000000),
                new Car("Audi", "Ауді", 1600, 250, 160400000),
                new Car("Apollo", "Аполло", 100, 20, 2000000),
                new Car("Bentley", "Бентлі", 600, 120, 60000000),
                new Car("Tesla", "Тесла", 800, 50, 10000000)
        };
        System.out.println("Сила у порядку зростання: ");
        Arrays.stream(schools).sorted(Comparator.comparingInt(o -> -o.power)).forEach(System.out::println);
        System.out.println("Гроші у порядку спадання: ");
        Arrays.stream(schools).sorted(Comparator.comparingInt(o -> o.money)).forEach(System.out::println);
    }
}
