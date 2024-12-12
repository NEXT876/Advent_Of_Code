//Part_Two.java

package day_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Part_Two {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //ArrayList<Integer>
        ArrayList<Integer> liste1, liste2;
        liste1 = new ArrayList<>();
        liste2 = new ArrayList<>();

        while (scanner.hasNext()) {
            liste1.add(scanner.nextInt());
            liste2.add(scanner.nextInt());
        }

        int similarity = 0;
        for (int i = 0; i < liste1.size(); ++i) {
            int anzahl = 0;
            for (Object item2 : liste2) { // Iterate over liste2 directly
                if (liste1.get(i).equals(item2)) {
                    anzahl++;
                }
            }
            similarity += anzahl * liste1.get(i);
        }
        System.out.println(similarity);


    }
}