// Red_Nosed_Reports.java


import java.util.ArrayList;
import java.util.Scanner;

public class Red_Nosed_Reports {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> line = new ArrayList<>();
		int safe = 0;
		boolean sicher;

		while (scanner.hasNextLine()) {
			String currentLine = scanner.nextLine();
			Scanner lineScanner = new Scanner(currentLine);

			while (lineScanner.hasNextInt()) {
				line.add(lineScanner.nextInt());
			}
			lineScanner.close();
			sicher = true;
			boolean absteigend = false;
			boolean aufsteigend = false;

			if (line.get(0) > line.get(1)) {
				absteigend = true;
			}
			if (line.get(0) < line.get(1)) {
				aufsteigend = true;
			}
			for (int i = 0; i + 1 < line.size(); i++) {
				int distance = Math.abs(line.get(i) - line.get(i + 1));
				if (!(distance <= 3 && (distance >= 1)) || line.get(i).equals(line.get(i + 1))) {
					sicher = false;
				}
				if (absteigend) {
					if (!(line.get(i) > line.get(i + 1))) {
						sicher = false;
					}
				}
				if (aufsteigend) {
					if (!(line.get(i) < line.get(i + 1))) {
						sicher = false;
					}
				}
			}
			if (sicher) {
				safe += 1;
			}
			line.clear();

		}
		System.out.println(safe);

	}
}
