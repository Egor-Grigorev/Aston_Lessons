package Lesson_2_3;

public class Park {
    public static class Information {
        private final String name;
        private final String workingHours;
        private final double price;

        public Information(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void informationOutput() {
            System.out.println("Название: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Цена: " + price);
        }

    }

    public static void main(String[] args) {
        Information information = new Information(
                "Африканские горки",
                "8:00 - 20:00",
                400
        );
        information.informationOutput();
    }
}










/*Создать класс Park с внутренним классом,
 с помощью объектов которого можно хранить информацию об аттракционах,
  времени их работы и стоимости.
 */