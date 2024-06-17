package pieces;

import java.awt.Color;
import java.awt.Point;

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

	@Override
	boolean validateMovementPattern(Point newlocation) {
		// TODO Auto-generated method stub
		return false;
	}

}
