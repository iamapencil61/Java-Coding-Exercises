import java.lang.Math;
import java.util.Scanner;

import static java.lang.Math.sqrt;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distFrom(Point otherPoint) {
        return sqrt(Math.pow(this.x - otherPoint.x, 2) + Math.pow(this.y - otherPoint.y, 2));
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point p1 = new Point(scanner.nextInt(), scanner.nextInt());
        Point p2 = new Point(scanner.nextInt(), scanner.nextInt());

        double distance = p1.distFrom(p2);
        System.out.println(distance);
    }
}