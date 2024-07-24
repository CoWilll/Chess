package pieces;

import java.awt.Color;
import backend.*;

public class King extends Piece{

	public King(Point location, Color color, char letterRepresentation, Data boardData, int player) {
		super(location, color, letterRepresentation, boardData, player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validateMovementPattern(Point newlocation) {
		// TODO Auto-generated method stub
		return false;
	}

}
