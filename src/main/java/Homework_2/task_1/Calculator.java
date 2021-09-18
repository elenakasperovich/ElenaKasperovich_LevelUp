package Homework_2.task_1;

import java.util.Scanner;

public class Calculator {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        int num1;
        int num2;
        int ans;
        char op;
        Scanner reader = new Scanner(System.in);
        System.out.println(ANSI_CYAN + "Добро пожаловать в калькулятор!" + ANSI_RESET);
        System.out.print(ANSI_PURPLE + "Введите первое число: " + ANSI_RESET);
        while (!reader.hasNextInt()) {
            System.out.println(ANSI_YELLOW + "Неверное значение. Попробуйте еще раз." + ANSI_RESET);
            reader.next();
        }
        num1 = reader.nextInt();

        System.out.print(ANSI_PURPLE + "Введите второе число: " + ANSI_RESET);
        while (!reader.hasNextInt()) {
            System.out.println(ANSI_YELLOW + "Неверное значение. Попробуйте еще раз." + ANSI_RESET);
            reader.next();
        }
        num2 = reader.nextInt();

        System.out.print(ANSI_PURPLE + "Введите операцию (+, -, *, /): " + ANSI_RESET);
        op = reader.next().charAt(0);
        switch (op) {
            case '+':
                ans = num1 + num2;
                break;
            case '-':
                ans = num1 - num2;
                break;
            case '*':
                ans = num1 * num2;
                break;
            case '/': {
                if (num2 == 0) {
                    System.out.println(ANSI_RED + "Ошибка! Нарушено правило деления на ноль." + ANSI_RESET);
                    return;
                } else {
                    ans = num1 / num2;
                }
            }
            break;
            default:
                System.out.println(ANSI_RED + "Ошибка! Неверная операция." + ANSI_RESET);
                return;
        }
        System.out.print(ANSI_BLUE + "Результат операции: " + ANSI_RESET);
        System.out.println(ANSI_GREEN + num1 + " " + op + " " + num2 + " = " + ans + ANSI_RESET);
    }
}


