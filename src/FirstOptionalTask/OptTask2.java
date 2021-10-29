package FirstOptionalTask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Задание. Ввести n чисел с консоли.
// Вывести числа в порядке возрастания (убывания) значений их длины.

public class OptTask2 {
    public static void main(String[] args) {
        System.out.println("---------------------------------");
        System.out.println("Enter positive multiple integers into the console. I will sort them by length from smallest to largest. Separate numbers with spaces.");
        newIntInput();
    }

    public static void newIntInput() {
        Scanner in = new Scanner(System.in);
        try {
            int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sortArray(arr);
            newIntInput();
        } catch (NumberFormatException e) {
            System.out.println("Please enter numbers in the range 0 to 2.147.483.648!");
            newIntInput();
        }
    }

    public static void sortArray(int[] arr) {
        String[] arrIntStr = new String[arr.length];

        for (int i = 0; i < arrIntStr.length; i++) {
            arrIntStr[i] = String.valueOf(arr[i]);
        }

        List<String> listIntStr = Arrays.asList(arrIntStr);

        // SORT
        listIntStr.sort(Comparator.comparingInt(s -> Math.abs(s.length())));

        System.out.println(listIntStr);
    }
}
