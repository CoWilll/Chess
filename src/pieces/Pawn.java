package pieces;

import java.awt.Color;
import java.awt.Point;

public class Pawn extends Piece {

	public Pawn(Point location, Color color, char letterRepresentation) {
		super(location, color, letterRepresentation);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean validateMovementPattern(Point newlocation) {
		// TODO Auto-generated method stub
		return false;
	}

}
