// Guard_Gallivant.java

package day_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Guard_Gallivant_Part_two {


    public static void main(String[] args) {

        ArrayList<String> lines = new ArrayList<>();

        int line = 0;
        int position = 0;
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
                        position = i;
                        line = j;
                    }
                }
                j++;
                lines.add(nextLine);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Die Datei konnte nicht gefunden werden: " + e.getMessage());
            return;
        }
        System.out.println(line);
        System.out.println(position);

        //move
        int beginLine = line;
        int beginPositon = position;
        char replacer;
        char oldChar = lines.get(0).charAt(0);
        int counter = 0;
        int amount = 0;
        for (int i = 0; i < lines.size(); i++) {
            for (int f = 0; f < lines.get(i).length(); f++) {
                char direction = '^';
                amount = 0;
                line = beginLine;
                position = beginPositon;
                if (lines.get(i).charAt(f) != '#') {
                    oldChar = lines.get(i).charAt(f);
                    replacer = 'O';
                    lines.set(line, replaceWay(lines, i, f, replacer));
                }
                move:
                while (true) {
                    switch (direction) {
                        case '^': // move up

                            while (line > 0 && (lines.get(line - 1).charAt(position) != '#' && (lines.get(line - 1).charAt(position)) != 'O')) {
                                line--;
                                if (line == beginLine && position == beginPositon) {
                                    counter++;
                                    System.out.println(counter);
                                    break move;
                                }
                                if (lines.get(line).charAt(position) == '-') {
                                    replacer = '+';
                                    lines.set(line, replaceWay(lines, line, position, replacer));

                                } else if (lines.get(line).charAt(position) != '|') {
                                    replacer = '|';
                                    lines.set(line, replaceWay(lines, line, position, replacer));
                                    amount++;
                                }
                            }

                            if (line <= 0) {
                                amount++;
                                break move;
                            }
                            direction = '>';
                            break;

                        case 'V': // move down

                            while ((line < lines.size() - 1 && (lines.get(line + 1).charAt(position)) != '#' && (lines.get(line + 1).charAt(position)) != 'O')) {
                                line++;
                                if (line == beginLine && position == beginPositon) {
                                    counter++;
                                    System.out.println(counter);
                                    break move;
                                }
                                if (lines.get(line).charAt(position) == '-') {
                                    replacer = '+';
                                    lines.set(line, replaceWay(lines, line, position, replacer));

                                } else if (lines.get(line).charAt(position) != '|') {
                                    replacer = '|';
                                    lines.set(line, replaceWay(lines, line, position, replacer));
                                    amount++;
                                }
                            }

                            if (line >= lines.size() - 1) {
                                amount++;

                                break move;
                            }
                            direction = '<';
                            break;

                        case '<': // move left

                            while (position > 0 && (lines.get(line).charAt(position - 1) != '#' && lines.get(line).charAt(position - 1) != 'O')) {
                                position--;
                                if (line == beginLine && position == beginPositon) {
                                    counter++;
                                    System.out.println(counter);
                                    break move;
                                }
                                if (lines.get(line).charAt(position) == '|') {
                                    replacer = '+';
                                    lines.set(line, replaceWay(lines, line, position, replacer));

                                } else if (lines.get(line).charAt(position) != '-') {
                                    replacer = '-';
                                    lines.set(line, replaceWay(lines, line, position, replacer));
                                    amount++;
                                }

                            }
                            if (position == 0) {
                                amount++;

                                break move;
                            }
                            direction = '^';
                            break;

                        case '>': // move right

                            while ((position < lines.get(line).length() - 1) && (lines.get(line).charAt(position + 1) != '#' && lines.get(line).charAt(position + 1) != 'O')) {
                                position++;
                                if (line == beginLine && position == beginPositon) {
                                    counter++;
                                    System.out.println(counter);
                                    break move;
                                }
                                if (lines.get(line).charAt(position) == '|') {
                                    replacer = '+';
                                    lines.set(line, replaceWay(lines, line, position, replacer));

                                } else if (lines.get(line).charAt(position) != '-') {
                                    replacer = '-';
                                    lines.set(line, replaceWay(lines, line, position, replacer));
                                    amount++;
                                }
                            }
                            if (position >= lines.get(line).length() - 1) {
                                amount++;

                                break move;
                            }
                            direction = 'V';
                            break;

                    }
                }

                lines.set(line, replaceWay(lines, i, f, oldChar));
            }
        }
        System.out.println(counter);
        System.out.println(amount);
    }

    private static String replaceWay(ArrayList<String> lines, int line, int position, char replacer) {
        String aktuelleZeile = lines.get(line);
        StringBuilder sb = new StringBuilder(aktuelleZeile);
        sb.setCharAt(position, replacer);
        aktuelleZeile = sb.toString();
        return aktuelleZeile;

    }

}