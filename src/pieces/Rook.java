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
	public Rook(Point location, Color color, char letterRepresentation, Data boardData) {
		super(location, color, letterRepresentation, boardData);
	}

	/**
	 * Rook Piece Moves horizontally or vertically. Method will verify that
	 * there are not pieces in the way and that movement is indeed
	 * horizontal or vertical.
	 * 
	 * Note*: This method assumes that the new location are in bounds.
	 *---------------------------------------------------------
	 *TODO: IF KING IS IN CHECK NEED TO VERIFY ROOK IS EITHER
	 *PROTECTING KING OR SHOULDN"T MOVE.
	 *DOESN'T TAKE INTO ACCOUNT PLAYER 1 OR PLAYER TWO PIECES.
	 *CAN'T JUMP OWN PIECES.
	 *DOES NOT CHECK IF PIECE IS OUT OF BOUNDS...
	 *---------------------------------------------------------
	 */
	@Override
	public boolean validateMovementPattern(Point newLocation) {
		
		boolean pieceInWay = false;
		boolean sameX = newLocation.x == oldLocation.x;
		boolean sameY = newLocation.y == oldLocation.y;
		
		//Moving Horizontally
		if (sameX && !sameY) {
			pieceInWay = pieceInWayHorizontal(oldLocation.y,newLocation.y);
			
		//Moving Vertically
		} else if (!sameX && sameY) {
			pieceInWay = pieceInWayVertical(oldLocation.x, newLocation.x);
		}
		
		return !pieceInWay;
	}
	
}