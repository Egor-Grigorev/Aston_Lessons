package GeometricShapes;

public class Circle implements Shape {
    private final double radius;
    private String fillColor = "White";
    private String borderColor = "Black";

    public Circle(double radius) {
        this.radius = radius;
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
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void printDetails() {
        Shape.super.printDetails(); // Используем метод из интерфейса
    }
}
