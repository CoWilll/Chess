package pieces;

import java.awt.Color;
import java.awt.Point;

import backend.Data;

public class Pawn extends Piece {

	public Pawn(Point location, Color color, char letterRepresentation, Data boardData) {
		super(location, color, letterRepresentation, boardData);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validateMovementPattern(Point newlocation) {
		// TODO Auto-generated method stub
		return false;
	}

}
