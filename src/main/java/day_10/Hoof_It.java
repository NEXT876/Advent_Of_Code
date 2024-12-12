// Hoof_It.java


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hoof_It {


    //public static int n = 1;
    public static int jj;
    public static int ii;

    public static void main(String[] args) {

        ArrayList<String> InputZeilen = Inputverarbeiten();


        for (int i = 0; i < InputZeilen.size(); i++) {
            String aktuelleZeile = InputZeilen.get(i);
            for (int j = 0; j < aktuelleZeile.length(); j++) {
                if (aktuelleZeile.charAt(j) == '0') {

                    int n = 0;
                    pruefeAufRoutenRechts(aktuelleZeile, InputZeilen, j, i, n);

                    n = 0;
                    pruefeAufRoutenLinks(aktuelleZeile, InputZeilen, j, i, n);

                    n = 0;
                    pruefeAufRoutenUnten(aktuelleZeile, InputZeilen, j, i, n);

                    n = 0;
                    pruefeAufRoutenOben(aktuelleZeile, InputZeilen, j, i, n);


                }
            }


        }


    }

    private static ArrayList<String> Inputverarbeiten() {
        ArrayList<String> inputZeilen = new ArrayList<>();
        try {
            File file = new File("day_10/input.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                inputZeilen.add(scanner.nextLine());
            }
            for (int i = 0; i < inputZeilen.size(); i++) {
                System.out.println(inputZeilen.get(i));
            }
            System.out.println();
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Die Datei konnte nicht gefunden werden: " + e.getMessage());
        }
        return inputZeilen;
    }


    private static void pruefeAufRoutenRechts(String aktuelleZeile, ArrayList<String> InputZeilen, int j, int i, int n) {
        // prüfe nach rechts
        if (j + 1 < aktuelleZeile.length() && 1 == aktuelleZeile.charAt(j + 1) - '0') {
            System.out.print("nach rechts: ");
            while (j < aktuelleZeile.length() && n == aktuelleZeile.charAt(j) - '0') {
                System.out.print(aktuelleZeile.charAt(j));
                n++;
                j++;
            }
            j--;
            pruefeAufWeitereRouten(aktuelleZeile, InputZeilen, j, i, n, "Unten");
            pruefeAufWeitereRouten(aktuelleZeile, InputZeilen, j, i, n, "Oben");

            System.out.println();
        }
    }

    private static void pruefeAufRoutenLinks(String aktuelleZeile, ArrayList<String> InputZeilen, int j, int i, int n) {

        // prüfe nach links
        if (j - 1 >= 0 && 1 == aktuelleZeile.charAt(j - 1) - '0') {
            System.out.print("nach links: ");
            while (j >= 0 && n == aktuelleZeile.charAt(j) - '0') {
                System.out.print(aktuelleZeile.charAt(j));
                n++;
                j--;
            }
            j++;
            pruefeAufWeitereRouten(aktuelleZeile, InputZeilen, j, i, n, "Unten");
            pruefeAufWeitereRouten(aktuelleZeile, InputZeilen, j, i, n, "Oben");

            System.out.println();

        }
    }

    private static void pruefeAufRoutenUnten(String aktuelleZeile, ArrayList<String> InputZeilen, int j, int i, int n) {


        // prüfe nach unten
        if (i + 1 < InputZeilen.size() && 1 == InputZeilen.get(i + 1).charAt(j) - '0') {
            System.out.print("Nach unten: ");
            while (i < InputZeilen.size() && n == InputZeilen.get(i).charAt(j) - '0') {
                System.out.print(InputZeilen.get(i).charAt(j));
                n++;
                i++;
            }

            i--;
            aktuelleZeile = InputZeilen.get(i);
            pruefeAufWeitereRouten(aktuelleZeile, InputZeilen, j, i, n, "Rechts");
            pruefeAufWeitereRouten(aktuelleZeile, InputZeilen, j, i, n, "Links");

            System.out.println();
        }
    }

    private static void pruefeAufRoutenOben(String aktuelleZeile, ArrayList<String> InputZeilen, int j, int i, int n) {


        // prüfe nach oben
        if (i - 1 >= 0 && 1 == InputZeilen.get(i - 1).charAt(j) - '0') {
            System.out.print("nach oben: ");
            while (i >= 0 && n == InputZeilen.get(i).charAt(j) - '0') {
                System.out.print(InputZeilen.get(i).charAt(j));
                n++;
                i--;
            }
            i++;
            aktuelleZeile = InputZeilen.get(i);
            pruefeAufWeitereRouten(aktuelleZeile, InputZeilen, j, i, n, "Links");
            pruefeAufWeitereRouten(aktuelleZeile, InputZeilen, j, i, n, "Rechts");

            System.out.println();
        }
    }

    private static void pruefeAufWeitereRouten(String aktuelleZeile, ArrayList<String> InputZeilen, int j, int i, int n, String direction) {


        switch (direction) {
            case "Rechts":
                if (j + 1 < aktuelleZeile.length() && n == aktuelleZeile.charAt(j + 1) - '0') {
                    j++;
                    while (j < aktuelleZeile.length() && n == aktuelleZeile.charAt(j) - '0') {
                        if (j < aktuelleZeile.length()) {
                            System.out.print(aktuelleZeile.charAt(j));
                        }
                        n++;
                        j++;

                    }
                    j--;
                    pruefeAufWeitereRouten(aktuelleZeile, InputZeilen, j, i, n, "Unten");
                    pruefeAufWeitereRouten(aktuelleZeile, InputZeilen, j, i, n, "Oben");

                }

                break;

            case "Links":
                if (j - 1 >= 0 && n == aktuelleZeile.charAt(j - 1) - '0') {
                    j--;
                    while (j >= 0 && n == aktuelleZeile.charAt(j) - '0') {
                        if (j >= 0) {
                            System.out.print(aktuelleZeile.charAt(j));
                        }
                        n++;
                        j--;

                    }
                    j++;
                    pruefeAufWeitereRouten(aktuelleZeile, InputZeilen, j, i, n, "Oben");
                    pruefeAufWeitereRouten(aktuelleZeile, InputZeilen, j, i, n, "Unten");
                }
                break;

            case "Oben":
                if (i - 1 >= 0 && j < aktuelleZeile.length() && n == InputZeilen.get(i - 1).charAt(j) - '0') {
                    i--;
                    while (i >= 0 && j < InputZeilen.get(i).length() && n == InputZeilen.get(i).charAt(j) - '0') {
                        if (i >= 0 && j < InputZeilen.get(i).length()) {
                            System.out.print(InputZeilen.get(i).charAt(j));
                        }
                        n++;
                        i--;

                    }
                    i++;
                    aktuelleZeile = InputZeilen.get(i);
                    pruefeAufWeitereRouten(aktuelleZeile, InputZeilen, j, i, n, "Links");
                    pruefeAufWeitereRouten(aktuelleZeile, InputZeilen, j, i, n, "Rechts");
                }
                break;

            case "Unten":
                if (i + 1 < InputZeilen.size() && j < aktuelleZeile.length() && n == InputZeilen.get(i + 1).charAt(j) - '0') {
                    i++;
                    while (i < InputZeilen.size() && j < InputZeilen.get(i).length() && n == InputZeilen.get(i).charAt(j) - '0') {
                        if (i < InputZeilen.size() && j < InputZeilen.get(i).length()) {
                            System.out.print(InputZeilen.get(i).charAt(j));
                        }
                        n++;
                        i++;
                    }
                    i--;
                    aktuelleZeile = InputZeilen.get(i);
                    pruefeAufWeitereRouten(aktuelleZeile, InputZeilen, j, i, n, "Rechts");
                    pruefeAufWeitereRouten(aktuelleZeile, InputZeilen, j, i, n, "Links");
                }
                break;

        }
    }

}