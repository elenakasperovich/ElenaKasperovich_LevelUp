package Homework_3.task_1;

public class Product {
    String name;
    int calories;

    public Product(String name, int calories) {
        this.name = getProductName(name);
        this.calories = calories;
    }

    // пример инкапсуляции
    private String getProductName(String name) {
        return "Продукт " + name;
    }
}
