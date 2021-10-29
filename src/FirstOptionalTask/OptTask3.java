package FirstOptionalTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Задание. Ввести n чисел с консоли.
// Вывести на консоль те числа, длина которых меньше средней длины по всем числам, а также длину.

public class OptTask3 {
    public static void main(String[] args) {
        newIntInput();
    }

    public static void newIntInput() {
        System.out.println("---------------------------------");
        System.out.println("Enter positive multiple integers into the console. I will output to the console those that are shorter than average. Separate numbers with spaces.");

        Scanner in = new Scanner(System.in);
        try {
            int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            findIntBelowAverLong(arr);
        } catch (NumberFormatException e) {
            System.out.println("Please enter numbers in the range 0 to 2.147.483.648!");
            newIntInput();
        }
    }

    public static void findIntBelowAverLong(int[] arr) {
        String[] arrIntStr = new String[arr.length];
        for (int i = 0; i < arrIntStr.length; i++) {
            arrIntStr[i] = String.valueOf(arr[i]);
        }

        int averIntLength = findAverageLength(arrIntStr);

        List<String> resultArr = new ArrayList<>();
        for (String s : arrIntStr) {
            if (s.length() < averIntLength) {
                resultArr.add(s);
            }
        }
        printResult(averIntLength, resultArr);
    }

    public static int findAverageLength(String[] arr) {
        double averageLength;
        double lengthSum = 0;
        int result;

        for (String s : arr) {
            lengthSum += s.length();
        }

        averageLength = lengthSum / arr.length;
        System.out.println("averageLength " + averageLength);

        result = (int) Math.round(averageLength);
        return result;
    }

    private static void printResult(int averageLength, List<String> resultList) {
        System.out.println("---------------------------");
        System.out.println("Average length = " + averageLength);
        System.out.println(resultList.size());
        if (resultList.size() != 0) {
            System.out.println("The numbers whose length is less than the average:");
            System.out.println(resultList);
        } else {
            System.out.println("Can't find numbers below average length. Please, try again");
        }
    }
}
