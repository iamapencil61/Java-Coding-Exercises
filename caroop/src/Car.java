public class Car {
    String brand;
    int year;

    Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    String getInfo() {
        return brand + " (" + year + ")";
    }
}