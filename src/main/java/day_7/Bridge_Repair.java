// Bridge_Repair.java

package day_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Bridge_Repair {


    public static void main(String[] args) {

        ArrayList<Long> result = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        long add = 0;

        try {
            File file = new File("src/main/resources/Inputs/day_7.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String next = scanner.next();
                if (next.endsWith(":")) {
                    next = next.substring(0, next.length() - 1); // Entferne das endende ":"
                }
                result.add(Long.parseLong(next));
                while (scanner.hasNextInt()) {
                    numbers.add(scanner.nextInt());
                }
                if (numbers.size() <= 2) {
                    add += berechne("*", result, numbers);
                    add += berechne("+", result, numbers);
                    add += berechne("|", result, numbers);

                } else {
                    StringBuilder combinations = combinations(numbers);
                    add += berechne(combinations, result, numbers);
                }

                result.clear();
                numbers.clear();
            }
            scanner.close();

            System.out.println(add);
        } catch (FileNotFoundException e) {
            System.out.println("Die Datei konnte nicht gefunden werden: " + e.getMessage());
        }
    }

    private static long berechne(String operator, ArrayList<Long> result, ArrayList<Integer> numbers) {
        long sum = 0;
        long add = 0;
        String combine = "";

        switch (operator) {
            case "*":
                add = numbers.get(0);
                for (int i = 1; i < numbers.size(); i++) {
                    add *= numbers.get(i);
                }
                if (add == result.getFirst()) {
                    sum += add;
                }
                break;
            case "+":
                for (int i = 0; i < numbers.size(); i++) {
                    add += numbers.get(i);
                }
                if (add == result.getFirst()) {
                    sum += add;
                }
                break;
            case "|":
                for (int i = 0; i < numbers.size(); i++) {
                    combine += numbers.get(i).toString();
                }
                if (Integer.parseInt(combine) == result.getFirst()) {
                    sum += Integer.parseInt(combine);
                }
                break;
        }

        return sum;
    }

    private static long berechne(StringBuilder combinations, ArrayList<Long> result, ArrayList<Integer> numbers) {

        long addieren = 0;

        Scanner scanner = new Scanner(combinations.toString());
        while (scanner.hasNext()) {
            String next = scanner.next();
            //  System.out.println(next);
            if (next.isEmpty()) {
                break;
            }
            // System.out.println(numbers);
            addieren = numbers.getFirst();
            //  System.out.println(addieren);

            for (int i = 0; i < next.length(); i++) {
                if (next.charAt(i) == '*') {
                    addieren *= numbers.get(i + 1);
                } else if (next.charAt(i) == '+') {
                    addieren += numbers.get(i + 1);
                } else if (next.charAt(i) == '|') {
                    String combine = Long.toString(addieren);
                    combine += numbers.get(i + 1).toString();
                    addieren = Long.parseLong(combine);
                }
                //  System.out.println(addieren);

            }
            if (addieren == result.getFirst()) {
                return addieren;
            } else {
                addieren = 0;
            }
        }

        scanner.close();
        return addieren;
    }

    private static StringBuilder combinations(ArrayList<Integer> numbers) {

        char[] letters = {'+', '*', '|'}; // Die beiden Buchstaben
        int length = numbers.size() - 1; // Die gewünschte Länge
        int totalCombinations = (int) Math.pow(letters.length, length); // 2^8 Kombinationen
        StringBuilder sb = new StringBuilder();
        StringBuilder combinations = new StringBuilder();

        for (int i = 0; i < totalCombinations; i++) {
            sb.setLength(0); // Lösche den vorherigen Inhalt
            int current = i;
            for (int j = 0; j < length; j++) {
                sb.append(letters[current % letters.length]); // Füge den Buchstaben hinzu
                current /= letters.length; // Bewege dich zur nächsten Stelle
            }
            combinations.append(sb.append(" "));
        }
        // System.out.println(combinations);
        return combinations; // Gib die Kombination aus
    }
}