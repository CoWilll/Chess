package pieces;

import java.awt.Color;
import java.awt.Point;

public class Queen extends Piece{

	public Queen(Point location, Color color, char letterRepresentation) {
		super(location, color, letterRepresentation);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean validateMovementPattern(Point newlocation) {
		// TODO Auto-generated method stub
		return false;
	}

}
