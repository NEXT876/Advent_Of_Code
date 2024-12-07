// Guard_Gallivant.java


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
            File file = new File("day_6/input.txt");
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
        char direction = '^';
        int amount = 0;
        move:
        while (true) {
            switch (direction) {
                case '^': // move up

                    while (line > 0 && (lines.get(line - 1).charAt(position)) != '#') {
                        line--;


                        if (lines.get(line).charAt(position) == '-') {
                            char replacer = '+';
                            lines.set(line, replaceWay(lines, line, position, replacer));

                        } else if (lines.get(line).charAt(position) != '|') {
                            char replacer = '|';
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

                    while ((line < lines.size() - 1 && (lines.get(line + 1).charAt(position)) != '#')) {
                        line++;
                        if (lines.get(line).charAt(position) == '-') {
                            char replacer = '+';
                            lines.set(line, replaceWay(lines, line, position, replacer));

                        } else if (lines.get(line).charAt(position) != '|') {
                            char replacer = '|';
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

                    while (position > 0 && (lines.get(line).charAt(position - 1) != '#')) {
                        position--;
                        if (lines.get(line).charAt(position) == '|') {
                            char replacer = '+';
                            lines.set(line, replaceWay(lines, line, position, replacer));

                        } else if (lines.get(line).charAt(position) != '-') {
                            char replacer = '-';
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

                    while ((position < lines.get(line).length() - 1) && lines.get(line).charAt(position + 1) != '#') {
                        position++;
                        if (lines.get(line).charAt(position) == '|') {
                            char replacer = '+';
                            lines.set(line, replaceWay(lines, line, position, replacer));

                        } else if (lines.get(line).charAt(position) != '-') {
                            char replacer = '-';
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
        System.out.println(String.join("\n", lines));
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