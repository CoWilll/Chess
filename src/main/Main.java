package main;

import java.awt.Point;

import backend.Data;
import io.BoardConsole;
import io.IO;

/**
 * The starting class that initiates the chess game via the <code>main</code>
 * method.
 * 
 * @author Collin Williams
 */
public class Main {

	/**
	 * Starting point of the program.
	 * 
	 * @param args - Configuration arguments given to the main method.
	 */
	public static void main(String[] args) {
		Data data = new Data();

		while (true) {
			// TESTING
			BoardConsole.printBoard(data);

			System.out.println("Please enter your new spot.");
			int x = IO.getInt("Please enter x:");
			int y = IO.getInt("Please enter y:");

			boolean valid = data.getBoard()[0][0].validateMovementPattern(new Point(x, y));
			if (valid) {
				data.getBoard()[x][y] = data.getBoard()[0][0];
				data.getBoard()[0][0] = null;
			}
			BoardConsole.printBoard(data);
			// TESTING

		}
	}

}
