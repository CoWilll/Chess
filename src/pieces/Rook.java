package pieces;

import java.awt.Color;
import backend.*;

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
	public Rook(Point location, Color color, char letterRepresentation, Data boardData, int player) {
		super(location, color, letterRepresentation, boardData, player);
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
		boolean sameRow = newLocation.getRow() == oldLocation.getRow();
		boolean sameColumn = newLocation.getColumn() == oldLocation.getColumn();
		
		//Moving Horizontally
		if (sameRow && !sameColumn) {
			pieceInWay = pieceInWayHorizontal(oldLocation.getColumn(),newLocation.getColumn(), false);
			
		//Moving Vertically
		} else if (!sameRow && sameColumn) {
			pieceInWay = pieceInWayVertical(oldLocation.getRow(), newLocation.getRow(), false);
		}
		
		return !pieceInWay;
	}
	
}