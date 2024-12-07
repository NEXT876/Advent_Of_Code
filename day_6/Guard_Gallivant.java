// Guard_Gallivant.java


import java.util.ArrayList;
import java.util.Scanner;

public class Guard_Gallivant {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long start = System.currentTimeMillis(); // Startzeit in Millisekunden
        ArrayList<String> lines = new ArrayList<>();

        int line = 0;
        int position = 0;
        int j = 0;

        //get input and ^ beginning  position
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.isEmpty()) {
                break;
            }

            for (int i = 0; i < nextLine.length(); i++) {
                if (nextLine.charAt(i) == '^') {
                    // nextLine = nextLine.replace('^', '.');
                    position = i;
                    line = j;
                }
            }
            j++;
            lines.add(nextLine);
        }
        System.out.println(line);
        System.out.println(position);
        System.out.println(String.join("\n", lines));


        //move
        char direction = '^';
        int amount = 0;
        move:
        while (true) {
            switch (direction) {
                case '^': // move up

                    while (line > 0 && (lines.get(line - 1).charAt(position)) != '#') {
                        line--;
                        if (lines.get(line).charAt(position) != 'X') {
                            String aktuelleZeile = lines.get(line);
                            StringBuilder sb = new StringBuilder(aktuelleZeile);
                            sb.setCharAt(position, 'X'); // Ersetzt das Zeichen an der angegebenen Position
                            aktuelleZeile = sb.toString();
                            lines.set(line, aktuelleZeile);
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
                        if (lines.get(line).charAt(position) != 'X') {
                            String aktuelleZeile = lines.get(line);
                            StringBuilder sb = new StringBuilder(aktuelleZeile);
                            sb.setCharAt(position, 'X'); // Ersetzt das Zeichen an der angegebenen Position
                            aktuelleZeile = sb.toString();
                            lines.set(line, aktuelleZeile);
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
                        if (lines.get(line).charAt(position) != 'X') {
                            String aktuelleZeile = lines.get(line);
                            StringBuilder sb = new StringBuilder(aktuelleZeile);
                            sb.setCharAt(position, 'X'); // Ersetzt das Zeichen an der angegebenen Position
                            aktuelleZeile = sb.toString();
                            lines.set(line, aktuelleZeile);
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
                        if (lines.get(line).charAt(position) != 'X') {
                            String aktuelleZeile = lines.get(line);
                            StringBuilder sb = new StringBuilder(aktuelleZeile);
                            sb.setCharAt(position, 'X'); // Ersetzt das Zeichen an der angegebenen Position
                            aktuelleZeile = sb.toString();
                            lines.set(line, aktuelleZeile);
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

        System.out.println(amount);
        System.out.println(String.join("\n", lines));

        long end = System.currentTimeMillis(); // Endzeit in Millisekunden

        // Umrechnen der Zeit von Millisekunden in Sekunden
        double timeInSeconds = (end - start) / 1000.0;
        System.out.println("Ausführungszeit: " + timeInSeconds + " Sekunden");
    }

}