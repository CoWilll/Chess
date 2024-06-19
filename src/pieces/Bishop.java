package pieces;

import java.awt.Color;
import java.awt.Point;

import backend.Data;

public class Bishop extends Piece{

	public Bishop(Point location, Color color, char letterRepresentation) {
		super(location, color, letterRepresentation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validateMovementPattern(Point newlocation, Data data) {
		// TODO Auto-generated method stub
		return false;
	}

}
