package backend;

import java.awt.Color;
import java.awt.Point;
import pieces.*;

/**
 * 
 * This class holds the backend data for chess such as the double array
 * of all the pieces.
 * 
 * @author Collin Williams
 */
public class Data {
	private int length = 8;
	private boolean kingInCheck;
	private Piece[][] board = new Piece[length][length];
	
	/**
	 * Constructor will create a two dimensional array will all the chess pieces
	 * in their proper starting location.
	 */
	public Data() {
		//Loop through whole board setting up pieces.
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				
				//Setting up rooks - White
				if (i == 0) {
					if (j == 0 || j == 7) {
						board[i][j] = new Rook(new Point(i,j), Color.white, 'R');
					}
				//Setting up rooks - Black
				} else if (i == 7) {
					if (j == 0 || j == 7) {
						board[i][j] = new Rook(new Point(i,j), Color.black, 'R');
					}
				}
				
				//Setting up pawn - White 
				if (i == 1) {
					board[i][j] = new Pawn(new Point(i,j), Color.white, 'P');	
				
				//Setting up pawn - Black
				} else  if (i == 6)
					board[i][j] = new Pawn(new Point(i,j), Color.black, 'P');	
				
			}
		}
	}

	public Piece[][] getBoard() {
		return board;
	}
	
	public boolean getKingInCheck() {
		return kingInCheck;
	}
	
	
	
}
