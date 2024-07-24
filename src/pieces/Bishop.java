package pieces;

import java.awt.Color;
import backend.*;

public class Bishop extends Piece{

	public Bishop(Point location, Color color, char letterRepresentation, Data boardData, int player) {
		super(location, color, letterRepresentation, boardData, player);
	}

	@Override
	public boolean validateMovementPattern(Point newLocation) {
		//Check to see if the bishop make a valid diagonal move
			//Row and columns must both be different
			//And Row and columns differences must be the same for old and new pos
		
		//ONLY VALIDATING DECREASING MOVEMENT LEFT TO RIGHT.....
		int rowDifference = oldLocation.getRow() - newLocation.getRow();
		int colDifference = oldLocation.getColumn() - newLocation.getColumn();
		boolean moveIsValidPattern = false;
		boolean pieceInWay = false;
		
		//if same difference for rows and columns and not same spot
		if (rowDifference == colDifference && rowDifference != 0) {
			moveIsValidPattern = true;
			pieceInWay = pieceInWayDiagonallyDecreasing(oldLocation, newLocation, false);
		}
		
		return moveIsValidPattern && !pieceInWay;
	}

}
