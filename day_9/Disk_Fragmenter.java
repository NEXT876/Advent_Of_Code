// Disk_Fragmenter.java

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Disk_Fragmenter {


    public static void main(String[] args) {

        int id = 0;
        int n = 1;
        char point;
        char replace;
        long checksum = 0;
        try {
            File file = new File("day_9/input.txt");
            Scanner scanner = new Scanner(file);

            String input = scanner.next();
            StringBuilder rearangedInput = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                if ((i % 2) == 0) {
                    for (int j = 0; j < input.charAt(i) - '0'; j++) {
                        rearangedInput.append(id);
                    }
                    id++;
                } else {
                    for (int j = 0; j < input.charAt(i) - '0'; j++) {
                        rearangedInput.append(".");
                    }
                }
            } // rearranging input

            //String numbers = rearangedInput.toString();
            //numbers = numbers.replace(".", "");
            //System.out.println(numbers);
            System.out.println(rearangedInput);
            int i = 0;
            while (i < rearangedInput.length()) {

                if (rearangedInput.charAt(i) == '.') {
                    //   System.out.println(rearangedInput);
                    point = rearangedInput.charAt(i);

                    //replace = numbers.charAt(numbers.length() - n);
                    do {
                        replace = rearangedInput.charAt(rearangedInput.length() - n);
                        n++;

                    } while (replace == '.' && n >= 0);

                    rearangedInput.setCharAt(i, replace);
                    rearangedInput.setCharAt(rearangedInput.length() - n -1, point);
                } else {
                    i++;
                }
            } // switch mit Ende Zahlen
            System.out.println(rearangedInput);
            id = 0;
            for (int j = 0; j < rearangedInput.length(); j++) {
                if (rearangedInput.charAt(j) != '.') {
                    checksum += (long) id * (rearangedInput.charAt(j) - '0');
                    id++;
                }
            } // berechne checksum
            System.out.println(checksum);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Die Datei konnte nicht gefunden werden: " + e.getMessage());
            return;
        }
    }
}