package main;

import backend.*;
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

		// TESTING
		while (true) {
			BoardConsole.printBoard(data);
			System.out.println("Please enter spot to move.");
			int oldX = IO.getInt("Please enter row:");
			int oldY = IO.getInt("Please enter col:");

			System.out.println("Please enter your new spot.");
			int newX = IO.getInt("Please enter row:");
			int newY = IO.getInt("Please enter col:");

			if (data.getBoard()[oldX][oldY] != null) {
				boolean valid = data.getBoard()[oldX][oldY].validateMovementPattern(new Point(newX, newY));
				
				if (valid) {
					//Fill new spot with piece from old spot.
					data.getBoard()[newX][newY] = data.getBoard()[oldX][oldY];
					//Nulify the old spot
					data.getBoard()[oldX][oldY] = null;
					//Update the back-end data for piece.
					data.getBoard()[newX][newY].updateMove(new Point(newX,newY));
				}
			
			}
		}
		// TESTING
	}

}
