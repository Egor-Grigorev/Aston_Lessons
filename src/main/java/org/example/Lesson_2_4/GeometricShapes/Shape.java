package GeometricShapes;

public interface Shape {
    // Методы для задания цветов
    void setFillColor(String fillColor);
    String getFillColor();

    void setBorderColor(String borderColor);
    String getBorderColor();

    // Дефолтные методы для вывода подробностей и расчёта общих атрибутов
    default double calculatePerimeter() { return 0.0; }
    default double calculateArea() { return 0.0; }
    default void printDetails() {
        System.out.println("Периметр: " + this.calculatePerimeter());
        System.out.println("Площадь: " + this.calculateArea());
        System.out.println("Цвет заливки: " + this.getFillColor());
        System.out.println("Цвет границы: " + this.getBorderColor());
    }
}
