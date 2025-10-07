import java.time.LocalDate;


public class Product {
    private String name;
    private LocalDate productionDate;
    private String manufacturer;
    private String countryOfProduction;
    private double price;
    private boolean bookingStatus;
    public Product(String name, LocalDate productionDate, String manufacturer,
                   String countryOfProduction, double price, boolean bookingStatus) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfProduction = countryOfProduction;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    public void informationOutput() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfProduction);
        System.out.println("Цена: " + price);

        if (bookingStatus)
            System.out.println("Состояние бронирования покупателем: Товар забронирован");
        else
            System.out.println("Состояние бронирования покупателем: Товар свободен для покупки");
    }


    /*    public String toString() { // 1 вариант
            return "Название: " + name +
                    "\nДата производства: " + productionDate +
                    "\nПроизводитель: " + manufacturer +
                    "\nСтрана происхождения: " + countryOfProduction +
                    "\nЦена: " + price +
                    "\nСостояние бронирования покупателем: " + (bookingStatus ? "Товар забронирован" : "Товар свободен для покупки");
        }
    */
    public static void main(String[] args) {
        // Создание экземпляра товара
        Product product = new Product(
                "Приборная панель",
                LocalDate.of(2025, 12, 15),
                "ЗАО \"Автоприбор\"",
                "Россия",
                15485.50,
                true
        );


        //System.out.println(product.toString()); // 1 вариант через public String toString()
        //System.out.println(product); // 1 вариант
        product.informationOutput(); // вызываем метод informationOutput()
    }
}






/*Создать класс "Товар" с полями: название, дата производства, производитель,
страна происхождения, цена, состояние бронирования покупателем.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Товар» написать метод, который выводит
информацию об объекте в консоль.*/

