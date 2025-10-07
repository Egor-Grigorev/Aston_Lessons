package GeometricShapes;

public class Triangle implements Shape {
    private final double sideA;
    private final double sideB;
    private final double sideC;
    private String fillColor = "Yellow";
    private String borderColor = "Red";

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2; // Полупериметр
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC)); // Формула Герона
    }

    @Override
    public void printDetails() {
        Shape.super.printDetails(); // Используем метод из интерфейса
    }
}
