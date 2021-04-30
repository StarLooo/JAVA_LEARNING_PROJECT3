package view;

import java.util.Scanner;

public class My_TSUtility {

    // set scanner for class My_TSUtility
    private static final Scanner scanner = new Scanner(System.in);

    // private static method to read at limit keys from KeyBoard
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }
            if (line.length() > limit) {
                System.out.println("输入长度(不大于" + limit + ")错误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }

    // public static method to read an Int from KeyBoard
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    // public static method to return from KeyBoard
    public static void readReturn() {
        System.out.println("按回车键继续...");
        readKeyBoard(100, true);
    }

    // public static method to get confirm from KeyBoard
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N')
                return c;
            else {
                System.out.print("选择错误，请重新输入：");
            }
        }
    }

    // public static method to read menu selection from KeyBoard
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4') {
                System.out.print("选择错误，请重新输入：");
            } else break;
        }
        return c;
    }

}

