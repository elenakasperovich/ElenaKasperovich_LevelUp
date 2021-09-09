package Homework_3.task_1;

public class ExceptionsDemo {

    public static void main(String[] args) {
        Product cookie = new Product("Печенье", -20);
        Product avocado = new Product("Авокадо", 10000);
        Product cake = new Product(null, 200);
        try {
            if (cookie.getCalories() < 0) {
                throw new LessThanZeroException("Меньше нуля");
            }
        } catch (LessThanZeroException error) {
            System.err.println(cookie.getName() + " калорийностью " + cookie.getCalories() + " " + error.getMessage());
        }
        try {
            if (avocado.getCalories() > 9999) {
                throw new LargeCaloriesException("Слишком большое значение");
            }
        } catch (LargeCaloriesException error) {
            System.err.println(avocado.getName() + " калорийностью " + avocado.getCalories() + " " + error.getMessage());
        }
        try {
            if (cake.getName() == null) {
                throw new NullNameException("Не может быть null");
            }
        } catch (NullNameException error) {
            System.err.println("Имя " + error.getMessage());
        }
    }
}

