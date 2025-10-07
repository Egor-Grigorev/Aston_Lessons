package Animal;

public class Main {
    public static void main(String[] args) {
        Bowl commonBowl = new Bowl(20); // общая миска с 20 единицами еды

        Cat[] cats = {
                new Cat("Барсик"),
                new Cat("Мурзик"),
                new Cat("Василий")
        };

        for (Cat cat : cats) {
            cat.eat(commonBowl, 10); // каждый кот хочет съесть по 10 единиц еды
        }

        for (Cat cat : cats) {
            System.out.println(cat.isSatiety() ? cat.getName() + " - сытый." : cat.getName() + " - голодный.");
        }

        System.out.println("\nОбщее число животных: " + Animal.getAnimalCount());
        System.out.println("Число собак: " + Dog.getDogCount());
        System.out.println("Число кошек: " + Cat.getCatCount());
    }
}
