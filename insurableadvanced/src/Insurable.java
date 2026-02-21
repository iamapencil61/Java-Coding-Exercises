import java.util.ArrayList;
import java.util.List;

interface Insurable {
    public double premium();
}

interface Electric {
    public int batteryCapacityKWh();

    default boolean isLongRange() {
        return batteryCapacityKWh() >= 60;
    }
}

abstract class Vehicle {
    private final String id;
    private final String brand;
    private final int year;
    private final int mileageKm;

    public Vehicle(String id, String brand, int year, int mileageKm) {

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid id");
        }

        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid brand");
        }

        if (year < 1886) {
            throw new IllegalArgumentException("Invalid year");
        }

        if (mileageKm < 0) {
            throw new IllegalArgumentException("Invalid mileage");
        }

        this.id = id;
        this.brand = brand;
        this.year = year;
        this.mileageKm = mileageKm;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public int age() {
        return 2026 - year;
    }

    public int getMileageKm() {
        return mileageKm;
    }

    public abstract String info();
}

class Car extends Vehicle implements Insurable {
    private final int seats;

    public Car(String id, String brand, int year, int mileageKm, int seats) {
        super(id, brand, year, mileageKm);

        if (seats < 1) {
            throw new IllegalArgumentException("Invalid seats");
        }

        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    public double premium() {
        int base = 800;
        int ageFactor = age() * 40;
        int mileageFactor = (getMileageKm() / 10000) * 30;
        int seatFactor = seats > 5 ? 50 : 0;

        return base + ageFactor + mileageFactor + seatFactor;

    }

    @Override
    public String info() {
        return String.format("Car[id=%s, brand=%s, year=%d, mileage=%d, seats=%d]", getId(), getBrand(), getYear(), getMileageKm(), seats);
    }
}

class Bike extends Vehicle implements Insurable {
    private final int engineCc;

    public Bike(String id, String brand, int year, int mileageKm, int engineCc) {
        super(id, brand, year, mileageKm);

        if (engineCc < 50) {
            throw new IllegalArgumentException("Invalid engine cc");
        }

        this.engineCc = engineCc;
    }

    @Override
    public double premium() {
        int base = 300;
        int ageFactor = age() * 15;
        int ccFactor = engineCc >= 600 ? 60 : 20;

        return base + ageFactor + ccFactor;
    }

    @Override
    public String info() {
        return String.format("Bike[id=%s, brand=%s, year=%d, mileage=%d, cc=%d]", getId(), getBrand(), getYear(), getMileageKm(), engineCc);
    }
}

class ElectricCar extends Car implements Electric {

    private final int batteryCapacityKWh;

    public ElectricCar(String id, String brand, int year, int mileageKm, int seats, int batteryCapacityKWh) {
        super(id, brand, year, mileageKm, seats);

        if (batteryCapacityKWh < 10) {
            throw new IllegalArgumentException("Invalid battery");
        }

        this.batteryCapacityKWh = batteryCapacityKWh;
    }


    @Override
    public int batteryCapacityKWh() {
        return batteryCapacityKWh;
    }

    @Override
    public double premium() {
        double basePremium = super.premium();

        double batteryFactor = isLongRange() ? 120 : 60;

        return basePremium + batteryFactor;
    }

    @Override
    public String info() {
        return String.format("ElectricCar[id=%s, brand=%s, year=%d, mileage=%d, seats=%d, battery=%dkWh, longRange=%b]",
                getId(), getBrand(), getYear(), getMileageKm(), getSeats(), batteryCapacityKWh, isLongRange());
    }
}

class Fleet {
    private final List<Vehicle> vehicles;

    public Fleet() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle v) {
        if (v == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }

        for (Vehicle existing : vehicles) {
            if (existing.getId().equals(v.getId())) {
                throw new IllegalArgumentException("Duplicate id");
            }
        }

        vehicles.add(v);
    }

    public Vehicle findById(String id) {
        for (Vehicle v : vehicles) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public double totalPremium() {
        double total = 0;
        for (Vehicle v : vehicles) {
            if (v instanceof Insurable) {
                total += ((Insurable) v).premium();
            }
        }
        return total;
    }

    public List<Vehicle> electricOnly() {
        List<Vehicle> electrics = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v instanceof Electric) {
                electrics.add(v);
            }
        }
        return electrics;
    }

    public void printReport() {
        for (Vehicle v : vehicles) {
            System.out.println(v.info());
            if (v instanceof Insurable) {
                System.out.printf("Premium: %.2f%n", ((Insurable) v).premium());
            }
        }
        System.out.printf("Total premium: %.2f%n", totalPremium());
    }
}