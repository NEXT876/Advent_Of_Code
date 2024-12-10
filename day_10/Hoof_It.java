// Hoof_It.java


import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Hoof_It {

    public static void main(String[] args) {

        ArrayList<String> InputZeilen = new ArrayList<>();


        try {
            File file = new File("day_10/input.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                InputZeilen.add(scanner.nextLine());
            }
            for (int i = 0; i < InputZeilen.size(); i++) {
                System.out.println(InputZeilen.get(i));
            }
            System.out.println();
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Die Datei konnte nicht gefunden werden: " + e.getMessage());
            return;
        }

        for (int i = 0; i < InputZeilen.size(); i++) {
            String aktuelleZeile = InputZeilen.get(i);
            for (int j = 0; j < aktuelleZeile.length(); j++) {
                if (aktuelleZeile.charAt(j) == '0') {

                    // prüfe nach rechts
                    int n = 0;
                    int jj = j;
                    if (jj + 1 < aktuelleZeile.length() && aktuelleZeile.charAt(j) - '0' + 1 == aktuelleZeile.charAt(jj + 1) - '0') {
                        System.out.print("nach rechts: ");
                        while (jj < aktuelleZeile.length() && (aktuelleZeile.charAt(j) - '0') + n == aktuelleZeile.charAt(jj) - '0') {
                            System.out.print(aktuelleZeile.charAt(jj));
                            n++;
                            jj = j + n;
                        }
                        System.out.println();
                    }
                    // prüfe nach links
                    n = 0;
                    jj = j;
                    if (jj - 1 >= 0 && aktuelleZeile.charAt(j) - '0' + 1 == aktuelleZeile.charAt(jj - 1) - '0') {
                        System.out.print("nach links: ");
                        while (jj >= 0 && (aktuelleZeile.charAt(j) - '0') + n == aktuelleZeile.charAt(jj) - '0') {
                            System.out.print(aktuelleZeile.charAt(jj));
                            n++;
                            jj = j - n;
                        }
                        System.out.println();
                    }
                    // prüfe nach unten
                    n = 0;
                    int ii = i;
                    if (ii + 1 < InputZeilen.size() && InputZeilen.get(i).charAt(j) - '0' + 1 == InputZeilen.get(ii + 1).charAt(j) - '0') {
                        System.out.print("nach unten: ");
                        while (ii < InputZeilen.size() && InputZeilen.get(i).charAt(j) - '0' + n == InputZeilen.get(ii).charAt(j) - '0') {
                            System.out.print(InputZeilen.get(ii).charAt(j));
                            n++;
                            ii = i + n;
                        }
                        System.out.println();
                    }
                    // prüfe nach oben
                    n = 0;
                    ii = i;
                    if (ii - 1 >= 0 && InputZeilen.get(i).charAt(j) - '0' + 1 == InputZeilen.get(ii - 1).charAt(j) - '0') {
                        System.out.print("nach oben: ");
                        while (ii - 1 >= 0 && InputZeilen.get(i).charAt(j) - '0' + n == InputZeilen.get(ii).charAt(j) - '0') {
                            System.out.print(InputZeilen.get(ii).charAt(j));
                            n++;
                            ii = i - n;
                        }
                        System.out.println();
                    }

                    //System.out.println(aktuelleZeile);
                }
            }


        }


    }
}