class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.println("(" + x + ", " + y + ")");
    }
}

public void main(String[] args) {
    Point p = new Point(1, 2);
    p.print();
}