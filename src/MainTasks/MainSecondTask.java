package MainTasks;

import java.util.Scanner;

// Отобразить в окне консоли аргументы командной строки в обратном порядке.

public class MainSecondTask {
    public static void main(String[] args) {
        System.out.println("Enter the arguments and I'll revert them:");
        newArrayInput();
    }
    public static void revertArguments(String arg) {
        char[] chars = arg.toCharArray();
        char[] revertChars = new char[chars.length];

        for (int i = 0, k = chars.length - 1; i < chars.length; i++, k--) {
            revertChars[i] = chars[k];
        }

        String newArr = new String(revertChars);
        System.out.println("Result: " + newArr);

        newArrayInput();
    }
    public static void newArrayInput() {
        String arguments;

        Scanner in = new Scanner(System.in);
        arguments = in.nextLine();

        revertArguments(arguments);
    }
}
