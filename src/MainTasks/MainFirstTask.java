package MainTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

// Приветствовать любого пользователя при вводе его имени через командную строку.

public class MainFirstTask {
    public static void main(String[] args) {
        System.out.println("Please, enter your name:");
        printResult(newNameInput());
    }

    public static boolean regexCheck(String name) {
        String regex = "\\W+|\\d";
        boolean flag;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        flag = matcher.find();
        return flag;
    }

    public static ArrayList<String> newNameInput() {
        String name;

        Scanner in = new Scanner(System.in);
        name = in.nextLine();

        ArrayList<String> result = new ArrayList<String>();
        result.add(name);
        result.add(String.valueOf(regexCheck(name)));
        return result;
    }

    public static void printResult(ArrayList<String> result) {
        System.out.println("!!!!!!!!!" + result);
        if (Objects.equals(result.get(1), "false")) {
            System.out.println("Greetings " + result.get(0) + "!");
        } else  {
            System.out.println("The name must consist of letters. Please try again!");
            System.out.println("----------------------------");
            System.out.println("Please, enter your name:");
            printResult(newNameInput());
        }
    }
}
