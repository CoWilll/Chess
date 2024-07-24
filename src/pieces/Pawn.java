package pieces;

import java.awt.Color;
import backend.*;

/**
 * Class represents a Pawn which is a subclass of <code>Piece</code>.
 * 
 * @author Collin Williams
 */
public class Pawn extends Piece {

	public Pawn(Point location, Color color, char letterRepresentation, Data boardData, int player) {
		super(location, color, letterRepresentation, boardData, player);
	}

	@Override
	public boolean validateMovementPattern(Point newLocation) {
		boolean pieceInWay = false;
		boolean validPawnMove = false;
		int numberOfSpacesToMove = newLocation.getRow() - oldLocation.getRow();

		// Pawn can move one to two spaces forward.
		if (!firstMovedUsed) {

			// Player 1 pawn must have a larger x (row) by one or two in new spot.
			if (player == 1) {

				// Player one moving forward.
				if (numberOfSpacesToMove == 1 || numberOfSpacesToMove == 2) {
					pieceInWay = pieceInWayVertical(oldLocation.getRow(), newLocation.getRow(), true);
					validPawnMove = true;
				}

				// Player 2 pawn must have smaller x (row) by one or two in a new spot
			} else if (player == 2) {
				if (numberOfSpacesToMove == -1 || numberOfSpacesToMove == -2) {
					pieceInWay = pieceInWayVertical(oldLocation.getRow(), newLocation.getRow(), true);
					validPawnMove = true;
				}
			}
		} else {
			if (player == 1 && numberOfSpacesToMove == 1) {
				pieceInWay = pieceInWayVertical(oldLocation.getRow(), newLocation.getRow(), true);
				validPawnMove = true;
			} else if (player == 2 && numberOfSpacesToMove == -1) {
				pieceInWay = pieceInWayVertical(oldLocation.getRow(), newLocation.getRow(), true);
				validPawnMove = true;
			}
		}

		if (!pieceInWay && validPawnMove)
			firstMovedUsed = true;

		return !pieceInWay && validPawnMove;
	}

}
