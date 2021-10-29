package MainTasks;

import java.util.InputMismatchException;
import java.util.Scanner;

// Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.

public class MainFifthTask {
    public static void main(String[] args) {
        newIntInput();
    }

    public static void printResult(int amount) {
        switch (amount) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("Please, try again...");
        }
        newIntInput();
    }

    public static void diapasonCheck(int amount) {
        if (amount < 13 && amount > 0) {
            printResult(amount);
        } else {
            System.out.println("Please enter a number between 1 and 12!");
            newIntInput();
        }
    }

    public static void newIntInput() {
        System.out.println("Enter a number from 1 to 12, and I'll say the name of the month:");

        int amount;
        Scanner in = new Scanner(System.in);

        try {
            amount = in.nextInt();
            diapasonCheck(amount);
        } catch (InputMismatchException e) {
            System.out.println("Please enter integer!");
            newIntInput();
        }
    }
}
