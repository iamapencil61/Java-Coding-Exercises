import java.util.List;

interface Insurable {
    double premium();
}

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

    public abstract String info();
}

class Car extends Vehicle implements Insurable {
    public Car(String brand, int year) {
        super(brand, year);
    }

    @Override
    public String info() {
        return "Car -> Brand: " + getBrand() + ", Year: " + getYear();
    }

    @Override
    public double premium() {
        double base = 1000;
        int age = 2026 - getYear();
        return base + age * 50;
    }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String brand, int year) {
        super(brand, year);
    }

    @Override
    public String info() {
        return "Bike -> Brand: " + getBrand() + ", Year: " + getYear();
    }

    @Override
    public double premium() {
        double base = 500;
        int age = 2026 - getYear();
        return base + age * 20;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = List.of(new Car("Toyota", 2020), new Bike("Yamaha", 2022));

        for (Vehicle v : vehicles) {
            System.out.println(v.info());

            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.printf("Premium: %.2f%n", ins.premium());
            }
        }
    }
}
