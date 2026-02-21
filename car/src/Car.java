public class Car {
    private final String brand;
    private final int year;

    public Car(String brand, int year) {
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

    public String info() {
        return  "Brand: " + this.brand + ", Year: " + this.year;
    }
}