package MainTasks;

import java.util.InputMismatchException;
import java.util.Scanner;

// Вывести заданное количество случайных чисел с переходом и без перехода на новую строку.

public class MainThirdTask {
    public static void main(String[] args) {
        System.out.println("Write how many numbers i should generate for you:");
        newIntInput();
    }

    public static void newIntInput() {
        int amount;
        Scanner in = new Scanner(System.in);

        try {
            amount = in.nextInt();
            generateRandomInt(amount);
            newIntInput();
        } catch (InputMismatchException e) {
            System.out.println("Please enter integer!");
            newIntInput();
        }
    }

    public static void generateRandomInt(int amount) {
        String[] randomInteger = new String[amount];
        for (int i = 0; i < amount; i++) {
            double random = Math.random() * 1000;
            int randomInt = (int) random;
            randomInteger[i] = new String(String.valueOf(randomInt));
        }
        printResult(randomInteger);
    }

    public static void printResult(String[] result) {
        System.out.println("Result in one line:");
        System.out.println(String.join(", ", result));

        System.out.println("");

        System.out.println("Result on different lines:");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        newIntInput();
    }
}
