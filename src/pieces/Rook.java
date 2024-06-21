package pieces;

import java.awt.Color;
import java.awt.Point;

import backend.Data;

/**
 * Class represents a piece in chess that can move any number of squares
 * horizontally or vertically without jumping.
 * 
 * This class extends <code>Piece</code> which is an abstract class.
 * 
 * @arthor Collin Williams
 */
public class Rook extends Piece {

	/**
	 * Constructs a rook.
	 * 
	 * @param location             - the location of data type point
	 * @param color                - Color of the Piece
	 * @param letterRepresentation - A letter that represents the piece
	 */
	public Rook(Point location, Color color, char letterRepresentation) {
		super(location, color, letterRepresentation);
	}

	/**
	 * Rook Piece Moves horizontally or vertically. Method will verify that
	 * there are not pieces in the way and that movement is indeed
	 * horizontal or vertical.
	 *---------------------------------------------------------
	 *TODO: IF KING IS IN CHECK NEED TO VERIFY ROOK IS EITHER
	 *PROTECTING KING OR SHOULDN"T MOVE.
	 *DOESN'T TAKE INTO ACCOUNT PLAYER 1 OR PLAYER TWO PIECES.
	 *CAN'T JUMP OWN PIECES.
	 *DOES NOT CHECK IF PIECE IS OUT OF BOUNDS...
	 *---------------------------------------------------------
	 */
	@Override
	public boolean validateMovementPattern(Point newLocation, Data data) {
		boolean sameX = newLocation.x == location.x;
		boolean sameY = newLocation.y == location.y;
		boolean pieceInWay = pieceInWay(sameX, newLocation, data);
		
		/*
		 * If the new position is same as old or
		 * the movements is both horizontal and vertical
		 * (meaning both sameX and sameY are false)
		 * return false for not valid movement.
		 */
		if (sameX == sameY)
			return false;

		// if  horizontal or vertical movement return if there true is not piece in way.
		return !pieceInWay;
		
	}
	
	
	/**
	 * 
	 * Method will return true if there is a piece in the way otherwise it will return false.
	 * 
	 * @param xIsSame
	 * @param newLocation - Always Original location +/- 1 depending on ending cord.
	 * @param oldLocation
	 * @return
	 */
	private boolean pieceInWay (boolean xIsSame, Point newLocation, Data data) {
		
		// New and old numbers decide whether to use 
		int newNum = (xIsSame ? newLocation.y : newLocation.x);
		int oldNum = (xIsSame ? location.y : location.x);
		
		//Variable to hold whether the new location is larger - will be true if larger.
		boolean newLocationLarger = newNum > oldNum;
		
		
		/*
		 * === i is initialized by condition below===
		 * if new number is larger than old number:
		 * 		Start searching at old location + 1.
		 * else if new number is smaller:
		 * 		Start searching at old location - 1.
		 *(The conditions above are to avoid checking itself)
		 * 
		 * ===Loop ending condition below===
		 * if new number is larger than old number:
		 * 		compare to ensure i < new number
		 * else if new number is smaller:
		 * 		compare to ensure i > new number
		 * (This is done because i will either increment or decrement)
		 */
		for (int i = (newLocationLarger ? oldNum + 1 : oldNum - 1); 
		             (newLocationLarger ? i < newNum : i > newNum ); 
		         i = (newLocationLarger ? i + 1      : i - 1)) {
			
			//If x is same keep x coord else keep y coord.
			Piece pieceToCompare = (xIsSame ? 
					data.getBoard()[location.x][i] : 
					data.getBoard()[i][location.y]);
			
			//If the piece is not null meaning there is a piece there
			//then return true because piece is no the way.
			if (pieceToCompare != null) return true;
			
		}
		return false;
	}
}