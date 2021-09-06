package Homework_3.task_1;

public class Sheff implements Cook {

    @Override
    public Dish cook(Product[] products, String nameOfDish) {
        int sumCalories = 0;
        for (Product product : products) {
            sumCalories = sumCalories + product.calories;
        }
        System.out.println("Блюдо " + nameOfDish + " готово. Ккал на 100г = " + sumCalories);
        return new Dish(nameOfDish, sumCalories);
    }
}
