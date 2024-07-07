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
					if (j == 1 || j == 7) {
						board[i][j] = new Rook(new Point(i,j), Color.white, 'R', this, 1);
					}
				//Setting up rooks - Black
				} else if (i == 7) {
					if (j == 0 || j == 7) {
						board[i][j] = new Rook(new Point(i,j), Color.black, 'R', this, 2);
					}
				}
				
//				//Setting up pawn - White 
//				if (i == 1) {
//					board[i][j] = new Pawn(new Point(i,j), Color.white, 'P', this);	
//				
//				//Setting up pawn - Black
//				} else  
					if (i == 6)
					board[i][j] = new Pawn(new Point(i,j), Color.black, 'P', this, 2);	
				
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

//==========================================================
/*			Chess Board (Double Array)                 =======================
			[0,0][0,1][0,2][0,3][0,4][0,5][0,6][0,7]   == Player One's Side ==
			[1,0][1,1][1,2][1,3][1,4][1,5][1,6][1,7]   =======================
			[2,0][2,1][2,2][2,3][2,4][2,5][2,6][2,7]
			[3,0][3,1][3,2][3,3][3,4][3,5][3,6][3,7]
			[4,0][4,1][4,2][4,3][4,4][4,5][4,6][4,7]
			[5,0][5,1][5,2][5,3][5,4][5,5][5,6][5,7]
			[6,0][6,1][6,2][6,3][6,4][6,5][6,6][6,7]   =======================
			[7,0][7,1][7,2][7,3][7,4][7,5][7,6][7,7]   == Player Two's Side ==
			                                           =======================
*/
