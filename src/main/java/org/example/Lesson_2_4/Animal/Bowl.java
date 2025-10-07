package Animal;

// Файл Bowl.java
public class Bowl {
    private int food;

    public Bowl(int initialFood) {
        this.food = initialFood;
    }

    public int getFood() {
        return food;
    }

    public void takeFood(int amount) {
        if (amount > food) {
            food = 0;
        } else {
            food -= amount;
        }
    }

    public void addFood(int amount) {
        food += amount;
    }
}
