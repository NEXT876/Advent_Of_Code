// Guard_Gallivant.java


import java.util.ArrayList;
import java.util.Scanner;

public class Guard_Gallivant {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<String> lines = new ArrayList<>();

		int zeile = 0;
		int position = 0;
		int j = 0;

//get input and ^ beginning  position
		while (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine();
			if (nextLine.isEmpty()) {
				break;
			}
			j++;
			for (int i = 0; i < nextLine.length(); i++) {
				if (nextLine.charAt(i) == '^') {
					position = i;
					zeile = j;
				}
			}
			lines.add(nextLine);
		}
		System.out.println(zeile);
		System.out.println(position);
		//System.out.println(String.join("\n", lines));


		//move

		int i = zeile;
		String direction = "^";
		move:
		while (true) {

				switch (direction) {
				case "^": // move up
				{
					while (!((lines.get(i - 1).charAt(position)) == '#')) {
						i--;
						if (lines.get(i).isEmpty()) {
							break move;
						}
					}
					direction = ">";
				}
				case "v": // move down
				{
					while (!((lines.get(i + 1).charAt(position)) == '#')) {
						i++;
						if (lines.get(i).isEmpty()) {
							break move;
						}
					}
					direction = "<";
				}
				case "<": // move left
				{
					while (lines.get(i).charAt(position - 1) != '#') {
						position--;
						if (position <= 0) {
							break move;
						}
					}
					direction = "^";
				}
				case ">": // move right
				{
					while (lines.get(i).charAt(position + 1) != '#') {
						position++;
						if (position >= lines.get(i).length() - 1) {
							break move;
						}
					}
					direction = "v";
				}


			}
		}


	}

}



