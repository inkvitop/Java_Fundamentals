package FirstOptionalTask;

import java.util.Arrays;
import java.util.Scanner;

// Задание. Ввести n чисел с консоли.
// Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

public class OptTask1 {
    public static void main(String[] args) {
        System.out.println("---------------------------------");
        System.out.println("Enter multiple integers into the console. I can find the shortest and longest one. Separate numbers with spaces.");
        newIntInput();
    }
    
    public static void printResult(String shorterInt, String longerInt, int shorterLength, int longerLength) {
        System.out.println("*************************");
        System.out.println("The shortest number is "+shorterInt+". Its length is "+shorterLength+".");
        System.out.println("***");
        System.out.println("The longest number is "+longerInt+". Its length is "+longerLength+".");
        System.out.println("*************************");
    }

    public static void lengthSearch(int[] intArr) {
        String shorterInt = null;
        int shorterIntLength = 0;

        String longerInt = null;
        int longerIntLength = 0;

        for (int i = 0; i < intArr.length; i++) {
            boolean negative = false;
            int tempInt = 0;
            if (intArr[i] < 0) {
                tempInt = intArr[i] * -1;
                negative = true;
            } else {
                tempInt = intArr[i];
            }
            String tempIntStr = String.valueOf(tempInt);
            if (i == 0) {
                longerInt = negative ? "-" + tempIntStr : tempIntStr;
                longerIntLength = tempIntStr.length();
                shorterInt = negative ? "-" + tempIntStr : tempIntStr;
                shorterIntLength = tempIntStr.length();
            } else {
                if (tempIntStr.length() <= shorterIntLength) {
                    shorterInt = negative ? "-" + tempIntStr : tempIntStr;
                    shorterIntLength = tempIntStr.length();
                } 
                if (tempIntStr.length() >= longerIntLength) {
                    longerInt = negative ? "-" + tempIntStr : tempIntStr;
                    longerIntLength = tempIntStr.length();
                }
            }
        }
        printResult(shorterInt, longerInt, shorterIntLength, longerIntLength);
    }

    public static void newIntInput() {
        Scanner in = new Scanner(System.in);
        try {
            int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            lengthSearch(arr);
            newIntInput();
        } catch (NumberFormatException e) {
            System.out.println("Please enter numbers in the range -2.147.483.648 to 2.147.483.648!");
            newIntInput();
        }
    }
}
