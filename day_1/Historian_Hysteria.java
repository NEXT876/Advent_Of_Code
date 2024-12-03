//Historian_Hysteria.java


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
/** erstes Rätsel.*/
 public class Historian_Hysteria {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Integer> liste1 = new ArrayList<>();
        ArrayList<Integer> liste2 = new ArrayList<>();


        while (scanner.hasNext()) {
            liste1.add(scanner.nextInt());
            liste2.add(scanner.nextInt());
        }

        int distance = 0;

        bubbleSort(liste1);
        bubbleSort(liste2);

        for (int i = 0; i < liste1.size(); i++) {
            distance += Math.abs(liste1.get(i) - liste2.get(i));
        }

        System.out.println(distance);


    }

    public static void bubbleSort(ArrayList<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    // Tauschen mit Collections.swap()
                    Collections.swap(list, j, j + 1);
                }
            }
        }
    }

}





