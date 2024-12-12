// Print_Queue_Part_two.java

package day_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Print_Queue_Part_two {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> vorgaben = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.isEmpty()) {
                break;
            }
            vorgaben.add(nextLine);
        }
        ArrayList<Integer> firstNumber = new ArrayList<>();
        ArrayList<Integer> secondNumber = new ArrayList<>();
        for (int i = 0; i < vorgaben.size(); i++) {
            String vorgabe = vorgaben.get(i);
            firstNumber.add(Integer.parseInt(vorgabe.substring(0, 2)));
            secondNumber.add(Integer.parseInt(vorgabe.substring(3, 5)));
        }
        vorgaben.clear();

        ArrayList<Integer> numbers = new ArrayList<>();
        int anzahl = 0;
        while (scanner.hasNextLine()) {
            String aktuelleZeile = scanner.nextLine();
            boolean line = false;
            for (int i = 0; i < aktuelleZeile.length(); i += 3) {
                String number = aktuelleZeile.substring(i, i + 2);
                numbers.add(Integer.parseInt(number));
            }
            line = ueberpruefeLine(numbers, firstNumber, secondNumber);
            if (!line) {
                numbers = sortNumbers(numbers, firstNumber, secondNumber);
                int mitte = (numbers.size() - 1) / 2;
                anzahl += numbers.get(mitte);
            }
            numbers.clear();
        }
        System.out.println(anzahl);

    }

    private static ArrayList<Integer> sortNumbers(ArrayList<Integer> numbers, ArrayList<Integer> firstNumber, ArrayList<Integer> secondNumber) {
        for (int i = 1; i < numbers.size(); i++) {
            for (int j = 0; j < firstNumber.size(); j++) {
                if (numbers.get(i).equals(firstNumber.get(j))) {
                    for (int f = i; f >= 0; f--) {
                        if (numbers.get(f).equals(secondNumber.get(j))) {
                            numbers.set(i, secondNumber.get(j));
                            numbers.set(f, firstNumber.get(j));
                            sortNumbers(numbers, firstNumber, secondNumber);
                        }
                    }
                }
            }
        }
        return numbers;
    }

    private static boolean ueberpruefeLine(ArrayList<Integer> numbers, ArrayList<Integer> firstNumber, ArrayList<Integer> secondNumber) {
        for (int i = 1; i < numbers.size(); i++) {
            for (int j = 0; j < firstNumber.size(); j++) {
                if (numbers.get(i).equals(firstNumber.get(j))) {
                    for (int f = i; f >= 0; f--) {
                        if (numbers.get(f).equals(secondNumber.get(j))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}