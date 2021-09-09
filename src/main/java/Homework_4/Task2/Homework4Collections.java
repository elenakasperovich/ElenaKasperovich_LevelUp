package Homework_4.Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Homework4Collections {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        ArrayList<Integer> arrayList = new ArrayList();
        ArrayList<Integer> listDivided2 = new ArrayList();
        ArrayList<Integer> listDivided3 = new ArrayList();
        ArrayList<Integer> listDivided5 = new ArrayList();
        ArrayList<Integer> listDivided7 = new ArrayList();

        //Список последовательных чисел
        for (int i = 0; i < 1001; i++) {
            arrayList.add(i);
        }
        Collections.shuffle(arrayList);
        System.out.println(arrayList);

        for (Integer integer : arrayList) {
            if (!hashSet.add(integer)) {
                System.out.println("Не все уникальны");
                break;
            }
        }

        for (Integer integer : arrayList) {
            if (integer % 2 == 0) {
                listDivided2.add(integer);
            } else if (integer % 3 == 0) {
                listDivided3.add(integer);
            } else if (integer % 5 == 0) {
                listDivided5.add(integer);
            } else if (integer % 7 == 0) {
                listDivided7.add(integer);
            }
        }
        System.out.println("\nЭлементы делятся на 2");
        System.out.println(listDivided2);
        System.out.println("\nЭлементы делятся на 3");
        System.out.println(listDivided3);
        System.out.println("\nЭлементы делятся на 5");
        System.out.println(listDivided5);
        System.out.println("\nЭлементы делятся на 7");
        System.out.println(listDivided7);
    }
}
