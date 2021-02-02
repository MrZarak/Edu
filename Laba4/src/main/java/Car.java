public class Car {
    String name;//Name of school
    String ukraineName;//Ukrainian name
    int power;//Power amount
    int fuel;//Fuel amount
    int money;//Money

    public Car(String name, String ukraineName, int power, int fuel, int money) {//Constructor
        this.name = name;
        this.ukraineName = ukraineName;
        this.power = power;
        this.fuel = fuel;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", ukraineName='" + ukraineName + '\'' +
                ", power=" + power +
                ", fuel=" + fuel +
                ", money=" + money +
                '}';
    }
}
