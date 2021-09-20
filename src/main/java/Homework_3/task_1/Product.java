package Homework_3.task_1;

public class Product {
    private String name;
    private int calories;

    public Product(String name, int calories) {
        this.name = getProductName(name);
        this.calories = calories;
    }

    // пример инкапсуляции
    private String getProductName(String name) {
        return name;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }
}
