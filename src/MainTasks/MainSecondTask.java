package MainTasks;

import java.util.Scanner;

// Отобразить в окне консоли аргументы командной строки в обратном порядке.

public class MainSecondTask {
    public static void main(String[] args) {
        printResult(newArrayInput());
    }

    public static char[] newArrayInput() {
        System.out.println("Enter the arguments and I'll revert them:");

        String arguments;

        Scanner in = new Scanner(System.in);
        arguments = in.nextLine();
        return revertArguments(arguments);
    }

    public static char[] revertArguments(String arg) {
        char[] chars = arg.toCharArray();
        char[] revertChars = new char[chars.length];

        for (int i = 0, k = chars.length - 1; i < chars.length; i++, k--) {
            revertChars[i] = chars[k];
        }
        return revertChars;
    }

    public static void printResult(char[] revertArg) {
        String newArr = new String(revertArg);
        System.out.println("Result: " + newArr);
    }
}
