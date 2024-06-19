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
	 * --------------------------------------------------------
	 *TODO: IF KING IS IN CHECK NEED TO VERIFY ROOK IS EITHER
	 *PROTECTING KING OR SHOULDN"T MOVE.
	 *---------------------------------------------------------
	 */
	@Override
	public boolean validateMovementPattern(Point newLocation, Data data) {
		boolean pieceInWay = false;
		boolean sameX = newLocation.x == location.x;
		boolean sameY = newLocation.y == location.y;
		
		//if the new position is same as old - not a valid move.
		if (sameX && sameY)
			return false;
		
		//Checking to see if their is a piece in the way
		//Does new location have same row?
		if (sameX) {
			//Piece moving up?
			if (newLocation.y < location.y) {
				
				//Start at beginning location and check every spot to new location exclusive.
				//Note*: Starts at original location minus 1 to avoid checking itself.
				for (int i = location.y-1; i > newLocation.y; i--) {
					
					//If a piece exist between the new and old Y the rook cannot make valid move.
					if (data.getBoard()[location.x][i] != null) {
						pieceInWay = true;
						break;
					}
				}
				
				
			//Piece moving down? - newLocation.y > location.y
			} else {
				
				//Start at beginning location and check every spot to new location exclusive.
				//Note*: Starts at original location plus 1 to avoid checking itself.
				for (int i = location.y+1; i < newLocation.y; i++) {
					
					//If a piece exist between the new and old Y the rook cannot make valid move.
					if (data.getBoard()[location.x][i] != null) {
						pieceInWay = true;
						break;
					}
				}
				
			}
		
		//Does new location have same column? sameY?
		} else {
			//Piece moving up?
			if (newLocation.x < location.x) {
				
				//Start at beginning location and check every spot to new location exclusive.
				//Note*: Starts at original location minus 1 to avoid checking itself.
				for (int i = location.x-1; i > newLocation.x; i--) {
					
					//If a piece exist between the new and old X the rook cannot make valid move.
					if (data.getBoard()[i][location.y] != null) {
						pieceInWay = true;
						break;
					}
				}
				
				
			//Piece moving down? - newLocation.x > location.x
			} else {
				
				//Start at beginning location and check every spot to new location exclusive.
				//Note*: Starts at original location plus 1 to avoid checking itself.
				for (int i = location.x+1; i < newLocation.x; i++) {
					
					//If a piece exist between the new and old X the rook cannot make valid move.
					if (data.getBoard()[i][location.y] != null) {
						pieceInWay = true;
						break;
					}
					
					
				}
			}
		}
		
		

		// if  horizontal movement
		if (sameX && !sameY) { 
			
			//if there is not a piece in the way.
			return !pieceInWay;

			// if  vertical movement
		} else if (sameY && !sameX) {
			
			//If there is not a piece in the way.
			return !pieceInWay;
		
		} 
		
		return false;
	}

}
