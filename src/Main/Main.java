package Main;

import backend.Data;
import io.BoardConsole;

/**
 * The starting class that initiates the chess game
 * via the <code>main</code> method.
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
		
		//TESTING
		BoardConsole.printBoard(data);
		//TESTING
	}

}
