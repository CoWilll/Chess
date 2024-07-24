package backend;

import java.awt.Color;
import java.awt.Point;
import pieces.*;

/**
 * 
 * This class holds the backend data for chess such as the double array of all
 * the pieces.
 * 
 * @author Collin Williams
 */
public class Data {
	private int length = 8;
	private boolean kingInCheck;
	private Piece[][] board = new Piece[length][length];

	/**
	 * Constructor will create a two dimensional array will all the chess pieces in
	 * their proper starting location.
	 * 
	 * White player is player number 1. Black player is player number 2.
	 */
	public Data() {
		// Loop through whole board setting up pieces.
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {

				setUpRooks(i, j);
				setUpPawns(i, j);
				setUpBishops(i, j);

			}
		}
	}

	private void setUpBishops(int i, int j) {
		if (j == 2 || j == 5) {
			// White Bishops
			if (i == 0) {
				board[i][j] = new Bishop(new Point(i, j), Color.white, 'B', this, 1);
				// Black Bishops
			} else if (i == 7) {
				board[i][j] = new Bishop(new Point(i, j), Color.black, 'B', this, 2);
			}
		}
	}

	private void setUpPawns(int i, int j) {
		// Setting up pawn - White
		if (i == 1) {
			board[i][j] = new Pawn(new Point(i, j), Color.white, 'P', this, 1);

		// Setting up pawn - Black
		} else if (i == 6) {
			board[i][j] = new Pawn(new Point(i, j), Color.black, 'P', this, 2);
		}
	}

	private void setUpRooks(int i, int j) {

		if (j == 0 || j == 7) {
			// Setting up White rooks
			if (i == 0) 
				board[i][j] = new Rook(new Point(i, j), Color.white, 'R', this, 1);
			// Setting up Black rooks
			else if (i == 7)
				board[i][j] = new Rook(new Point(i, j), Color.black, 'R', this, 2);
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
/*
 * Chess Board (Double Array) =======================
 * [0,0][0,1][0,2][0,3][0,4][0,5][0,6][0,7] == Player One's Side ==
 * [1,0][1,1][1,2][1,3][1,4][1,5][1,6][1,7] =======================
 * [2,0][2,1][2,2][2,3][2,4][2,5][2,6][2,7]
 * [3,0][3,1][3,2][3,3][3,4][3,5][3,6][3,7]
 * [4,0][4,1][4,2][4,3][4,4][4,5][4,6][4,7]
 * [5,0][5,1][5,2][5,3][5,4][5,5][5,6][5,7]
 * [6,0][6,1][6,2][6,3][6,4][6,5][6,6][6,7] =======================
 * [7,0][7,1][7,2][7,3][7,4][7,5][7,6][7,7] == Player Two's Side ==
 * =======================
 */
