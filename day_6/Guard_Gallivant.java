// Guard_Gallivant.java


import java.util.ArrayList;
import java.util.Scanner;

public class Guard_Gallivant {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
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
					position = i ;
					line = j ;
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
				{
					while ((lines.get(line - 1).charAt(position)) != '#') {
						line--;
						if (line <= 0) {
							break move;
						}
						amount++;


					}
					direction = '>';
				}
				break;
				case 'V': // move down
				{
					while ((lines.get(line + 1).charAt(position)) != '#') {
						line++;
						if (line >= lines.size() - 1) {
							break move;
						}
						amount++;

					}
					direction = '<';
				}
				break;
				case '<': // move left
				{
					while (lines.get(line).charAt(position - 1) != '#') {
						position--;

						if (position <= 0) {
							break move;
						}
						amount++;

					}
					direction = '^';
				}
				break;
				case '>': // move right
				{
					while (lines.get(line).charAt(position + 1) != '#') {
						position++;

						if (position >= lines.get(line).length() - 1) {
							break move;
						}
						amount++;

					}
					direction = 'V';
				}
				break;


			}
		}

		System.out.println(amount);


	}

}



