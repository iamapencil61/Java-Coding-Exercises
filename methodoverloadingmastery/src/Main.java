public class Main {
    public static int calculateArea(int side) {
        int area = side * side;
        System.out.println("Square area with side " + side + ": " + area);
        return area;
    }

    public static int calculateArea(int length, int width) {
        int area = length * width;
        System.out.println("Rectangle area with length " + length + " and width " + width + ": " + area);
        return area;
    }

    public static double calculateArea(double radius) {
        double area = 3.14 * radius * radius;
        System.out.println("Circle area with radius " + radius + ": " + area);
        return area;
    }


    public static void main(String[] args) {
        // Test your methods with these exact values
        calculateArea(5);          // square
        calculateArea(4, 6);       // rectangle
        calculateArea(2.5);        // circle
    }
}