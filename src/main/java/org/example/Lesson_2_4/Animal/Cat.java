package Animal;

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean satiety = false; // Начальная стадия голода
    private String name;

    public Cat(String name) {
        super();
        this.name = name;
        catCount++;
    }

    @Override
    void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежала " + distance + " метров.");
        } else {
            System.out.println(name + " не смогла пробежать такое расстояние!");
        }
    }

    @Override
    void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }

    public boolean isSatiety() {
        return satiety;
    }

    public static int getCatCount() {
        return catCount;
    }

    public void eat(Bowl bowl, int foodAmount) {
        if (!this.satiety && bowl.getFood() >= foodAmount) {
            bowl.takeFood(foodAmount);
            this.satiety = true;
            System.out.println(name + " теперь сытый.");
        } else {
            System.out.println(name + " осталась голодной.");
        }
    }

    // Добавили геттер для имени
    public String getName() {
        return name;
    }
}
