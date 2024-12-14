// Guard_Gallivant.java

package day_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Guard_Gallivant_Part_two {


    public static void main(String[] args) {

        ArrayList<String> lines = new ArrayList<>();

        int beginposition = 0;
        int beginline = 0;
        int j = 0;


        try {
            File file = new File("src/main/resources/Inputs/day_6.txt");
            Scanner scanner = new Scanner(file);

            //get input and ^ beginning  position
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                if (nextLine.isEmpty()) {
                    break;
                }

                for (int i = 0; i < nextLine.length(); i++) {
                    if (nextLine.charAt(i) == '^') {
                        beginposition = i;
                        beginline = j;
                    }
                }
                j++;
                lines.add(nextLine);
            }
            System.out.println(String.join("\n", lines));
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Die Datei konnte nicht gefunden werden: " + e.getMessage());
            return;
        }
        System.out.println("StartLine: " + beginline);
        System.out.println("StartPosition: " + beginposition);
        System.out.println("Anzahl moeglicher Schleifen: " + move(beginline, beginposition, lines));

    }

    private static String replace(ArrayList<String> lines, int line, int position, char replacer) {
        String aktuelleZeile = lines.get(line);
        StringBuilder sb = new StringBuilder(aktuelleZeile);
        sb.setCharAt(position, replacer);
        aktuelleZeile = sb.toString();
        return aktuelleZeile;

    }

    private static int move(int beginLine, int beginPosition, ArrayList<String> lines) {
        ArrayList<String> linien = new ArrayList<>();
        int line;
        int position;
        char replacer;
        char oldChar = lines.getFirst().charAt(0);
        int AnzahlSchleifen = 0; // Anzahl wie viele verschiedene Schleifen man dem Wachmann legen kann
        char naechstesZeichen;


        for (int i = 0; i < lines.size(); i++) {
            System.out.println("runden" + i);
            String aktuelleZeile = lines.get(i);
            for (int f = 0; f < lines.get(i).length(); f++) {
                linien = lines;
                System.out.println("Versuche" + f);
                char direction = '^';
                line = beginLine;
                position = beginPosition;
                if (aktuelleZeile.charAt(f) != '#') {
                    oldChar = aktuelleZeile.charAt(f);
                    replacer = 'O';
                    linien.set(line, replace(linien, i, f, replacer));
                }
                move:
                while (true) {
                    switch (direction) {
                        case '^': // move up
                            if (line <= 0) {
                                break move;
                            } else {
                                naechstesZeichen = linien.get(line - 1).charAt(position);
                                if (naechstesZeichen != '#' && naechstesZeichen != 'O') {
                                    line--;

                                    linien = updateLines(naechstesZeichen, linien, line, position);

                                    if (line == beginLine && position == beginPosition) {
                                        AnzahlSchleifen++;
                                        System.out.println(AnzahlSchleifen);
                                        break move;
                                    }

                                } else {
                                    direction = '>';

                                }
                            }
                            break;

                        case 'V': // move down
                            if (line >= linien.size() - 1) {
                                break move;
                            } else {
                                naechstesZeichen = linien.get(line + 1).charAt(position);
                                if (naechstesZeichen != '#' && naechstesZeichen != 'O') {
                                    line++;

                                    linien = updateLines(naechstesZeichen, linien, line, position);

                                    if (naechstesZeichen == '+') {
                                        AnzahlSchleifen++;
                                        System.out.println(AnzahlSchleifen);
                                        break move;
                                    }
                                } else {
                                    direction = '<';
                                }
                            }

                            break;

                        case '<': // move left
                            if (position <= 0) {

                                break move;
                            } else {
                                naechstesZeichen = linien.get(line).charAt(position - 1);
                                if (naechstesZeichen != '#' && naechstesZeichen != 'O') {
                                    position--;

                                    linien = updateLines(naechstesZeichen, linien, line, position);

                                    if (naechstesZeichen == '+') {
                                        AnzahlSchleifen++;
                                        System.out.println(AnzahlSchleifen);
                                        break move;
                                    }
                                } else {
                                    direction = '^';
                                }
                            }

                            break;

                        case '>': // move right
                            if (position >= linien.get(line).length() - 1) {
                                break move;
                            } else {
                                naechstesZeichen = linien.get(line).charAt(position + 1);
                                if (naechstesZeichen != '#' && naechstesZeichen != 'O') {
                                    position++;

                                    linien = updateLines(naechstesZeichen, linien, line, position);

                                    if (naechstesZeichen == '+') {
                                        AnzahlSchleifen++;
                                        System.out.println(AnzahlSchleifen);
                                        break move;
                                    }
                                } else {
                                    direction = 'V';
                                }
                            }
                            break;

                    }
                }

                linien.set(line, replace(linien, i, f, oldChar));
            }
        }
        return AnzahlSchleifen;
    }

    private static ArrayList<String> updateLines(char naechstesZeichen, ArrayList<String> lines, int line, int position) {

        char replacer;
        if (naechstesZeichen == '-') {
            replacer = '+';
            lines.set(line, replace(lines, line, position, replacer));

        } else if (naechstesZeichen != '|') {
            replacer = '|';
            lines.set(line, replace(lines, line, position, replacer));
        }

        return lines;
    }

}