package GeometricShapes;

public class Rectangle implements Shape {
    private final double width;
    private final double height;
    private String fillColor = "Green";
    private String borderColor = "Blue";

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
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
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public void printDetails() {
        Shape.super.printDetails(); // Используем метод из интерфейса
    }
}
