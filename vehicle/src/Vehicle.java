import java.util.List;

abstract class Vehicle {

    private final String brand;
    private final int year;

    public Vehicle(String brand, int year) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid brand");
        }

        if (year < 1886) {
            throw new IllegalArgumentException("Invalid year");
        }

        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    abstract public String info();

    static class Car extends Vehicle {

        Car(String brand, int year) {
            super(brand, year);
        }

        @Override
        public String info() {
            return "Car -> Brand: " + getBrand() + ", Year: " + getYear();
        }
    }

    static class Bike extends Vehicle {
        Bike(String brand, int year) {
            super(brand, year);
        }
        @Override
        public String info() {
            return "Bike -> Brand: " + getBrand() + ", Year: " + getYear();
        }
    }

    public static void main(String[] args) {

        List<Vehicle> vehicles;
        vehicles = List.of(new Car("Toyota", 2020), new Bike("Yamaha", 2022));
        for (Vehicle v : vehicles) System.out.println(v.info());


    }
}
