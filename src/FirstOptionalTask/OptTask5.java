package FirstOptionalTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.

public class OptTask5 {
    public static void main(String[] args) {
        printInstructions();
        newIntInput();
    }

    public static void printInstructions() {
        System.out.println("---------------------------------");
        System.out.println("Enter multiple integers into the console.");
        System.out.println("Will be found the number of numbers that contain only even numbers and numbers that contain the same number of even and odd numbers.");
        System.out.println("Separate numbers with spaces.");
        System.out.println("---------------------------------");
    }

    public static void newIntInput() {
        Scanner in = new Scanner(System.in);

        try {
            int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            findCountInt(arr);
        } catch (NumberFormatException e) {
            System.out.println("Please enter numbers in the range -2.147.483.648 to 2.147.483.648!");
            newIntInput();
        }
    }

    public static void findCountInt(int[] arr) {
        int[] onlyEvenDigIndex = new int[arr.length];
        List<String> onlyEvenDigList = new ArrayList<>();
        List<String> evenOddDigits = new ArrayList<>();

        String[] strArr = arrToString(arr);

        for (int i = 0; i < strArr.length; i++) {
            boolean evenCheck = false;

            for (int j = 0; j < strArr[i].length() - 1; j++) {
                int digCheck = strArr[i].charAt(j);
                if (digCheck % 2 == 0) {
                    evenCheck = true;
                } else {
                    evenCheck = false;
                    break;
                }
            }
            if (evenCheck) {
                onlyEvenDigList.add(strArr[i]);
                onlyEvenDigIndex[i] = 1;
            }
        }

        for (int i = 0; i < strArr.length; i++) {
            if (onlyEvenDigIndex[i] != 1) {
                int oddCheck = 0;
                int evenCheck = 0;
                for (int j = 0; j < strArr[i].length(); j++) {
                    int digCheck = Integer.parseInt(String.valueOf(strArr[i].charAt(j)));
                    if (digCheck % 2 == 0) {
                        evenCheck++;
                    }else {
                        oddCheck++;
                    }
                }
                if (oddCheck == evenCheck) {
                    evenOddDigits.add(strArr[i]);
                }
            }
        }
        printResult(onlyEvenDigList, evenOddDigits);
    }

    public static String[] arrToString(int[] arr) {
        // Array to String array
        String[] arrStr = new String[arr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arrStr[i] = String.valueOf(arr[i]);
            if (arr[i] < 0) {
                arrStr[i] = arrStr[i].substring(1);
            }
        }
        return arrStr;
    }

    public static void printResult(List<String> onlyEvenDigList, List<String> evenOddDigits) {
        System.out.println("*********************");
        System.out.println("Result:");
        System.out.println("Numbers consisting only of even numbers - " + onlyEvenDigList.size());
        System.out.println("Here they are: " + onlyEvenDigList);
        System.out.println("Numbers with the same number of even and odd numbers - " + evenOddDigits.size());
        System.out.println("Here they are: " + evenOddDigits);
    }
}
