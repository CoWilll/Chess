package io;

import backend.Data;

/**
 * Class represents a chess board but will be printed in the console 
 * and is used for testing purposes.
 * 
 * 
 * @author Collin Williams
 */
public class BoardConsole {
	
	//Length will represent how many rows and columns exist
	//due to the fact that the chess board is a square.
	private static int length = 8;
	
	public static void printBoard(Data data) {
		char element = ' ';
		StringBuilder sb = new StringBuilder();
		
		for (int j = 0; j < length; j++) {
			sb.append("____");
		} 
		sb.append("_");
		
		
		System.out.print("\n" + sb.toString() + "\n\n");
		//For loop to print all the rows.
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				//Check to see if piece is in spot
				if (data.getBoard()[i][j] != null) {
					element = data.getBoard()[i][j].getLetterRepresentation();
				} else {
					element = ' ';
				}
					
				
				System.out.printf("| %s ", element);
			}
			System.out.print("|\n" + sb.toString() + "\n\n");
			
		}
	}

}
