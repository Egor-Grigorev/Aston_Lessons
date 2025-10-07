package GeometricShapes;

public class Main {
    public static void main(String[] args) {
        // Создаем объекты разных фигур
        Circle circle = new Circle(5);   // Радиус круга равен 5
        Rectangle rectangle = new Rectangle(4, 6); // Ширина 4, высота 6
        Triangle triangle = new Triangle(3, 4, 5); // Стороны равны 3, 4, 5

        // Задали разные цвета заливки и границы
        circle.setFillColor("Light Blue");
        circle.setBorderColor("Dark Blue");

        rectangle.setFillColor("Orange");
        rectangle.setBorderColor("Purple");

        triangle.setFillColor("Pink");
        triangle.setBorderColor("Brown");

        // Выводим характеристики каждой фигуры
        System.out.println("Характеристики круга:");
        circle.printDetails();

        System.out.println("\nХарактеристики прямоугольника:");
        rectangle.printDetails();

        System.out.println("\nХарактеристики треугольника:");
        triangle.printDetails();
    }
}
