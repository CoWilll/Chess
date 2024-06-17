package backend;

import java.awt.Color;
import java.awt.Point;

import pieces.Piece;
import pieces.Rook;

/**
 * 
 * This class holds the backend data for chess such as the double array
 * of all the pieces.
 * 
 * @author Collin Williams
 */
public class Data {
	private int length = 8;
	private Piece[][] board = new Piece[length][length];
	
	public Data() {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				//Setting up rooks - initial position
				if((i == 0 || i == 7) && (j == 0 || j == 7)){
					board[i][j] = new Rook(new Point(i,j), Color.white, 'R');
				}
				
			}
			
		}
	}

	public Piece[][] getBoard() {
		return board;
	}
	
	
	
}
