package MainTasks;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.

public class MainFourthTask {
    public static void main(String[] args) {
        newIntInput();
    }

    public static void calculateSum(String integers) {
        int sum = 0;
        String[] strArr = integers.split(" ");

        for (String integer : strArr) {
            sum += Double.parseDouble(integer);
        }

        System.out.println("Result: " + sum);
    }

    public static boolean regexCheck(String name) {
        String regex = "\\p{Punct}+|[a-zA-Z]";
        boolean flag;

        //  Only text check
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        flag = matcher.find();
        return flag;
    }

    public static void newIntInput() {
        System.out.println("Enter the numbers and I'll sum them up. Separate numbers with spaces.");

        boolean intCheckFlag;
        String integers;

        Scanner in = new Scanner(System.in);
        integers = in.nextLine();
        intCheckFlag = regexCheck(integers);

        if (!intCheckFlag) {
            calculateSum(integers);
        } else  {
            System.out.println("Enter only numbers. Please try again!");
        }
        newIntInput();
    }
}
