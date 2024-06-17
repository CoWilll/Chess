package pieces;

import java.awt.Color;
import java.awt.Point;

/**
 * Abstract class that will represent a piece and serve as a 
 * superclass to all the chess pieces (Rook, Knight, Bishep, King,
 * Queen, and Pawn.)
 * 
 * Note*: This class is abstract due to the fact that there is no need
 * to instantiate it in any circumstance in this program. 
 * 
 * @author Collin Williams
 */
public abstract class Piece {
	
	//In location x will represent the rows and Y will represent the columns.
	private Point location;
	
	//Colors of pieces can either be white or black.
	private Color color;
	
	//If the piece has left the game then the boolean value will be true.
	private boolean hasLeftGame;
	
	//A letter to represent the piece on the console board.
	private char letterRepresentation;
	
	/**
	 * Constructor that will take in the location, color and letter.
	 */
	public Piece (Point location, Color color, char letterRepresentation) {
		this.location = location;
		this.color = color;
		this.letterRepresentation = letterRepresentation;
	}
	
	/**
	 * Method will (based on the type of piece) see whether the movement is 
	 * allowed for what every type of piece is being used. This abstract method
	 * will let the programmer polymorphically validate all pieces movements with
	 * an overridden method.
	 * 
	 * @param Takes in a point that is the new location to verify.
	 * 
	 * @return true if the movement is allowed for the particular piece such as
	 * a King moving only one space or a Rook moving horizontally and vertically.
	 */
	abstract boolean validateMovementPattern(Point newlocation);

	public char getLetterRepresentation() {
		return letterRepresentation;
	}
	
	
	
}
