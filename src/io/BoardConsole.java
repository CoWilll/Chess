package io;

import java.awt.Color;

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
		String element = " ";
		StringBuilder sb = new StringBuilder();
		
		for (int j = 0; j < length; j++) {
			sb.append("____");
		} 
		sb.append("_");
		
		
		System.out.print("\n" + sb.toString() + "\n\n");
		//For loop to print all the rows.
		for (int x = 0; x < length; x++) {
			for (int y = 0; y < length; y++) {
				
				//Check to see if piece is in spot
				if (data.getBoard()[x][y] != null) {
					element = data.getBoard()[x][y].getLetterRepresentation() + "";
					if (data.getBoard()[x][y].getColor() == Color.white)
						element = String.format("w=%s=w", element);
					else
						element = String.format("b=%s=b", element);
						
				} else 
				{
					element = String.format("(%d,%d)", x,y);
				}
				
				System.out.printf("| %s ", element);
			}
			
			System.out.print("|\n" + sb.toString() + "\n\n");
			
		}
	}

}
