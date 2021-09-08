package Homework_3.task_1;

public class CreateDinner {
    public static void main(String[] args) {
        Product[] compoteIngredients = {
            new Fruit("Слива", 42),
            new Fruit("Нектарин", 48),
            new Fruit("Яблоко", 52),
            new Fruit("Виноград", 54),
            new Product("Water", 0)
        };
        Product[] saladIngredients;
        saladIngredients = new Product[] {
            new Vegetable("Помидор", 20),
            new Vegetable("Капуста пекинская", 16),
            new Vegetable("Болгарский перец", 26),
            new Vegetable("Лук репчатый", 41),
            new Vegetable("Оливки без косточки", 115),
            new Spice("Лимонный сок", 16),
            new Spice("Масло оливковое", 898),
            new Spice("Соль", 0),
            new Product("Брынза (соленая)", 288),
            new Product("Сухарики", 150),
            new Meat("Куриная грудка (отварная)", 113)
        };
        Product[] borschIngredients;
        borschIngredients = new Product[] {
            new Meat("Говядина", 187),
            new Product("Вода", 0),
            new Vegetable("Капуста белокачанная", 28),
            new Vegetable("Картофель", 77),
            new Vegetable("Морковь", 41),
            new Vegetable("Свекла", 49),
            new Vegetable("Петрушка", 51),
            new Vegetable("Лук репчатый", 41),
            new Vegetable("Болгарский перец", 26),
            new Product("Томатная паста", 80),
            new Spice("Уксус", 32),
            new Spice("Соль", 0),
            new Spice("Масло растительное", 900),
            new Spice("Перец черный горошком", 5),
            new Spice("Перец душистый горошком", 6),
            new Spice("Лавровый лист", 10),
            new Vegetable("Чеснок", 25),
            new Product("Сметана", 158)
        };

        Sheff sheff = new Sheff();
        sheff.cook(compoteIngredients, "Компот фруктовый");
        sheff.cook(borschIngredients, "Борщ украинский");
        Dish salad = sheff.cook(saladIngredients, "Салат с брынзой");

        //Сортировка в салате
        Product tempProduct;
        for (int i = 0; i < saladIngredients.length; i++) {
            for (int j = 1; j < saladIngredients.length - i; j++) {
                if (saladIngredients[j - 1].getCalories() > saladIngredients[j].getCalories()) {
                    tempProduct = saladIngredients[j - 1];
                    saladIngredients[j - 1] = saladIngredients[j];
                    saladIngredients[j] = tempProduct;
                }
            }
        }
        System.out.println("\n" + salad.name + " состоит из:");
        for (Product saladIngredient : saladIngredients) {
            System.out.println(
                saladIngredient.getName() + " калорийностью на 100г - " + saladIngredient.getCalories() + " ккал");
        }
        //Ищем ингрединты с ккал от 0-50
        System.out.println("\n" + "Ингредиенты в борще в диапозоне ккал от 0 до 50 ");
        for (Product borschIngredient : borschIngredients) {
            if (borschIngredient.getCalories() >= 0 && borschIngredient.getCalories() <= 50) {
                System.out.println(borschIngredient.getName());
            }
        }
    }
}
