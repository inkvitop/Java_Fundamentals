package FirstOptionalTask;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Задание. Ввести n чисел с консоли.
// Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.

public class OptTask4 {
    public static void main(String[] args) {
        System.out.println("---------------------------------");
        System.out.println("Enter multiple integers into the console. I will find a number in which the number of different digits is minimal. Separate numbers with spaces.");
        newIntInput();
    }

    public static void newIntInput() {
        Scanner in = new Scanner(System.in);
        try {
            int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            findIntDifferentDigits(arr);
            newIntInput();
        } catch (NumberFormatException e) {
            System.out.println("Please enter numbers in the range -2.147.483.648 to 2.147.483.648!");
            newIntInput();
        }
    }

    public static void findIntDifferentDigits(int[] arr) {
        int[] diffDigitsArr = new int[arr.length];

        // Array to String array
        String[] arrStr = new String[arr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arrStr[i] = String.valueOf(arr[i]);
        }

        // Check different digits
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arrStr[i] = arrStr[i].substring(1);
            }

            int matcherResult = 0;
            for (int j = 0; j < arrStr[i].length(); j++) {
                Pattern pattern = Pattern.compile(String.valueOf(arrStr[i].charAt(j)));
                Matcher matcher = pattern.matcher(arrStr[i]);
                while (matcher.find())
                    matcherResult++;
            }
            diffDigitsArr[i] = matcherResult - arrStr[i].length();
        }

        printResult(arr, diffDigitsArr);
    }

    public static void printResult(int[] intArr, int[] diffDigArr) {
        int checker = 0;
        OptionalInt max = Arrays.stream(diffDigArr).max();
        for (int i = 0; i < max.getAsInt() - 1; i++) {
            if (diffDigArr[i] == checker) {
                System.out.println("Found the first number with the minimum number of distinct digits! \nHere it is = " + intArr[i]);
                newIntInput();
                break;
            } else {
                checker++;
            }
        }
    }
}
