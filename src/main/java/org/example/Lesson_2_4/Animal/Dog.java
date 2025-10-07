package Animal;

public class Dog extends Animal {
    private static int dogCount = 0;
    private String name;

    public Dog(String name) {
        super();
        this.name = name;
        dogCount++;
    }

    @Override
    void run(int distance) {
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " метров.");
        } else {
            System.out.println(name + " не смог пробежать такое расстояние!");
        }
    }

    @Override
    void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " метров.");
        } else {
            System.out.println(name + " не смог проплыть такое расстояние!");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}