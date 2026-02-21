public class Calculator {
    private String name;
    private double memory;
    private int operationCount;

    public Calculator(String name) {
        this.name = name;
        this.memory = 0.0;
        this.operationCount = 0;
    }

    public Calculator() {
        this("Default Calculator");
    }

    public String getName() {
        return this.name;
    }

    public double getMemory() {
        return this.memory;
    }

    public int getOperationCount() {
        return this.operationCount;
    }

    public double add(double a, double b) {
        double result = a + b;
        this.memory = result;
        this.operationCount += 1;
        return result;
    }

    public double subtract(double a, double b) {
        double result = a - b;
        this.operationCount += 1;
        return result;
    }

    public double multiply(double a, double b) {
        double result = a * b;
        this.operationCount += 1;
        return result;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            this.operationCount += 1;
            return 0;
        }

        double result = a / b;
        this.operationCount += 1;
        return result;
    }

    public double power(double a, double b) {
        double result = Math.pow(a, b);
        this.operationCount += 1;
        return result;
    }
}