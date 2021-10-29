package MainTasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

// Приветствовать любого пользователя при вводе его имени через командную строку.

public class MainFirstTask {
    public static void main(String[] args) {
        System.out.println("Please, enter your name:");
        newNameInput();
    }
    public static boolean regexCheck(String name) {
        String regex = "\\W+|\\d";
        boolean flag;

        //  Only text check
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        flag = matcher.find();
        return flag;
    }
    public static void newNameInput() {
        boolean regexCheckFlag;
        String name;

        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        regexCheckFlag = regexCheck(name);

        if (!regexCheckFlag) {
            System.out.println("Greetings " + name + "!");
        } else  {
            System.out.println("The name must consist of letters. Please try again!");
            newNameInput();
        }
    }
}
