// Mull_It_Over.java

package day_3;

import java.util.Scanner;

public class Mull_It_Over_Part_two {

    public static void main(String[] args) {
        StringBuilder list = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            list.append(scanner.nextLine());
        }
        int amount = 0;
        boolean mul = true;
        for (int i = 0; i < list.length(); i++) {
            if (list.charAt(i) == 'd') {
                mul = checkFordoAndDont(i, list);
            }
            if (mul && i + 3 < list.length() && list.substring(i, i + 4).equals("mul(")) {
                int closingBracket = list.indexOf(")", i + 3);
                if (closingBracket != -1) {
                    String content = list.substring(i + 3, closingBracket + 1);
                    if (content.matches("\\(\\d{1,3},\\d{1,3}\\)")) {
                        StringBuilder number1 = new StringBuilder();
                        StringBuilder number2 = new StringBuilder();
                        boolean active_number = true;
                        for (int k = 1; k < content.length(); k++) {
                            if (content.charAt(k) == ')') {
                                break;
                            }
                            if (content.charAt(k) == ',') {
                                active_number = false;
                            }
                            if (!(content.charAt(k) == ',')) {
                                if (active_number) {
                                    number1.append(content.charAt(k));
                                } else {
                                    number2.append(content.charAt(k));

                                }
                            }
                        }
                        amount += Integer.parseInt(number1.toString()) * Integer.parseInt(number2.toString());
                    }
                }
            }
        }
        System.out.println(amount);
        list.setLength(0);
        scanner.close();
    }

    public static boolean checkFordoAndDont(int i, StringBuilder list) {

        if (i + 3 < list.length() && list.subSequence(i, i + 4).equals("do()")) {
            return true;
        }
        return i + 6 >= list.length() || !list.subSequence(i, i + 7).equals("don't()");
    }
}