// Ceres_Search.java

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ceres_Search {

	//private static final Scanner scanner = new Scanner(System.in);


	public static void main(String[] args) throws IOException {
		ArrayList<Character> line1 = new ArrayList<>();
		ArrayList<Character> line2 = new ArrayList<>();
		ArrayList<Character> line3 = new ArrayList<>();
		ArrayList<Character> line4 = new ArrayList<>();
		int anzahl = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		reader.mark(20000);
		String currentLine1;
		String currentLine2;
		String currentLine3;
		String currentLine4;
		String newLine;
		while ((currentLine1 = reader.readLine()) != null) {
			for (int i = 0; i < currentLine1.length(); i++) {
				line1.add(currentLine1.charAt(i));
			}
			anzahl += checkOnXMAS(line1);//in Line check
			anzahl += checkOnSAMX(line1);//in Line check backwards
			line1.clear();
		}

		reader.reset();


		currentLine1 = reader.readLine();
		for (int i = 0; i < currentLine1.length(); i++) {
			line1.add(currentLine1.charAt(i));
		}
		currentLine2 = reader.readLine();
		for (int i = 0; i < currentLine2.length(); i++) {
			line2.add(currentLine2.charAt(i));
		}
		currentLine3 = reader.readLine();
		for (int i = 0; i < currentLine3.length(); i++) {
			line3.add(currentLine3.charAt(i));
		}
		currentLine4 = reader.readLine();
		for (int i = 0; i < currentLine4.length(); i++) {
			line4.add(currentLine4.charAt(i));
		}
		anzahl += checkOnDiagonal(line1, line2, line3, line4);
		anzahl += checkOnVertikal(line1, line2, line3, line4);
		line1.clear();
		line2.clear();
		line3.clear();
		line4.clear();
		System.out.println(anzahl);

		while ((newLine = reader.readLine()) != null) {

			currentLine1 = currentLine2;
			for (int i = 0; i < currentLine1.length(); i++) {
				line1.add(currentLine1.charAt(i));
			}
			currentLine2 = currentLine3;
			for (int i = 0; i < currentLine2.length(); i++) {
				line2.add(currentLine2.charAt(i));
			}
			currentLine3 = currentLine4;
			for (int i = 0; i < currentLine3.length(); i++) {
				line3.add(currentLine4.charAt(i));
			}
			currentLine4 = newLine;
			for (int i = 0; i < currentLine4.length(); i++) {
				line4.add(currentLine4.charAt(i));
			}
			anzahl += checkOnDiagonal(line1, line2, line3, line4);
			anzahl += checkOnVertikal(line1, line2, line3, line4);
			line1.clear();
			line2.clear();
			line3.clear();
			line4.clear();
		}
		System.out.println(anzahl);
	}

	private static int checkOnXMAS(ArrayList<Character> line1) {
		int anzahl = 0;
		for (int i = 0; i + 3 < line1.size(); i++) {
			if (line1.get(i) == 'X' && line1.get(i + 1) == 'M' && line1.get(i + 2) == 'A' && line1.get(i + 3) == 'S') {
				anzahl++;
			}
		}
		return anzahl;
	}

	private static int checkOnSAMX(ArrayList<Character> line1) {
		int anzahl = 0;
		for (int i = 0; i + 3 < line1.size(); i++) {
			if (line1.get(i) == 'S' && line1.get(i + 1) == 'A' && line1.get(i + 2) == 'M' && line1.get(i + 3) == 'X') {
				anzahl++;
			}
		}
		return anzahl;
	}

	private static int checkOnDiagonal(ArrayList<Character> line1, ArrayList<Character> line2, ArrayList<Character> line3, ArrayList<Character> line4) {
		int anzahl = 0;
		for (int i = 0; i + 3 < line1.size(); ++i) {
			if (line1.get(i) == 'X' && line2.get(i + 1) == 'M' && line3.get(i + 2) == 'A' && line4.get(i + 3) == 'S') {
				anzahl++;
			}
			if (line1.get(i) == 'S' && line2.get(i + 1) == 'A' && line3.get(i + 2) == 'M' && line4.get(i + 3) == 'X') {
				anzahl++;
			}
		}
		for (int i = 3; i < line1.size(); ++i) {
			if (line1.get(i) == 'X' && line2.get(i - 1) == 'M' && line3.get(i - 2) == 'A' && line4.get(i - 3) == 'S') {
				anzahl++;
			}
			if (line1.get(i) == 'S' && line2.get(i - 1) == 'A' && line3.get(i - 2) == 'M' && line4.get(i - 3) == 'X') {
				anzahl++;
			}
		}
		return anzahl;
	}

	private static int checkOnVertikal(ArrayList<Character> line1, ArrayList<Character> line2, ArrayList<Character> line3, ArrayList<Character> line4) {
		int anzahl = 0;
		for (int i = 0; i < line1.size(); i++) {
			if (line1.get(i) == 'X' && line2.get(i) == 'M' && line3.get(i) == 'A' && line4.get(i) == 'S') {
				anzahl++;
			}
			if (line1.get(i) == 'S' && line2.get(i) == 'A' && line3.get(i) == 'M' && line4.get(i) == 'X') {
				anzahl++;
			}
		}

		return anzahl;

	}
}

