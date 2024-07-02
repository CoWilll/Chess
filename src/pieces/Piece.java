package pieces;

import java.awt.Color;
import java.awt.Point;

import backend.Data;

/**
 * Abstract class that will represent a piece and serve as a superclass to all
 * the chess pieces (Rook, Knight, Bishep, King, Queen, and Pawn.)
 * 
 * Note*: This class is abstract due to the fact that there is no need to
 * instantiate it in any circumstance in this program.
 * 
 * @author Collin Williams
 */
public abstract class Piece {

	// Every piece will have access to see the board.
	protected Data boardData;

	// In location x will represent the rows and Y will represent the columns.
	protected Point oldLocation;

	// Colors of pieces can either be white or black.
	protected Color color;

	// If the piece has left the game then the boolean value will be true.
	protected boolean hasLeftGame;

	// A letter to represent the piece on the console board.
	protected char letterRepresentation;

	/**
	 * Constructor that will take in the location, color and letter.
	 */
	public Piece(Point location, Color color, char letterRepresentation, Data boardData) {
		this.oldLocation = location;
		this.color = color;
		this.letterRepresentation = letterRepresentation;
		this.boardData = boardData;

	}

	/**
	 * Method will (based on the type of piece) see whether the movement is allowed
	 * for what every type of piece is being used. This abstract method will let the
	 * programmer polymorphically validate all pieces movements with an overridden
	 * method.
	 * 
	 * @param Takes in a point that is the new location to verify.
	 * 
	 * @return true if the movement is allowed for the particular piece such as a
	 *         King moving only one space or a Rook moving horizontally and
	 *         vertically.
	 */
	public abstract boolean validateMovementPattern(Point newlocation);

	public char getLetterRepresentation() {
		return letterRepresentation;
	}

	public Color getColor() {
		return color;
	}

	/**
	 * Methods will determine if there is a piece in the way vertically.
	 * This method excludes the original spot the piece is in 
	 * and the last spot it will check because of jumping possi
	 * 
	 * @return True is there is a piece in the way vertically.
	 */
	protected boolean pieceInWayVertical(int xCoordOld, int xCoordNew) {

		boolean newXBelowOriginal = xCoordNew > xCoordOld;
		boolean pieceInWay = false;
		
		//Modify xCoordOld by +1/-1 to avoid checking itself.
		xCoordOld = newXBelowOriginal ? xCoordOld + 1 : xCoordOld - 1;
		
		if (newXBelowOriginal) {
			for (int i = xCoordOld; i < xCoordNew; i++) {
				
				Piece pieceToCompare = boardData.getBoard()[i][oldLocation.y];
				
				if (pieceToCompare != null) {
					pieceInWay = true;
					break;
				}
			}
		} else {
			for (int i = xCoordOld; i > xCoordNew; i--) {
				
				Piece pieceToCompare = boardData.getBoard()[i][oldLocation.y];
				
				if (pieceToCompare != null) {
					pieceInWay = true;
					break;
				}
			}
		}
		
		return pieceInWay;
	}

	protected boolean pieceInWayHorizontal() {
		return false;
	}

	protected boolean pieceInWayOneAnyDirection() {
		return false;
	}

	protected boolean pieceInWayOneFoward() {
		return false;
	}

//	protected boolean pieceInWayDiagonalLeft() {
//		return false;
//	}
//	
//	protected boolean pieceInWayDiagonalLeft() {
//		return false;
//	}

}
