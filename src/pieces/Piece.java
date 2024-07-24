package pieces;

import java.awt.Color;
import backend.*;

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
	
	// Will only have player one and player two.
	protected int player;
	
	// If the piece has been moved since the game started.
	protected boolean firstMovedUsed;

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
	public Piece(Point location, Color color, char letterRepresentation, Data boardData, int player) {
		this.oldLocation = location;
		this.color = color;
		this.letterRepresentation = letterRepresentation;
		this.boardData = boardData;
		this.player = player;
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
	
	public void updateMove(Point newCoords) {
		oldLocation = newCoords;
	}

	public char getLetterRepresentation() {
		return letterRepresentation;
	}

	public Color getColor() {
		return color;
	}
	
	/**
	 * Method will check if there is a piece in the way diagonally for a decreasing
	 * diagonal line, so the end checked spots would create a line the goes down as 
	 * you move from left to right.
	 * 
	 * Methods assumes that old and new points are NOT the same spot.
	 * 
	 * @param oldCoords
	 * @param newCoords
	 * @param lastSpotInclusive
	 * @return If there is a piece in the way.
	 */
	protected boolean pieceInWayDiagonallyDecreasing(Point oldCoords, Point newCoords, boolean lastSpotInclusive) {
		boolean pieceInWay = false;
		boolean oldRowIsSmaller = oldCoords.getRow() < newCoords.getRow();
		boolean oldColumnIsSmaller = oldCoords.getColumn() < newCoords.getColumn();
		boolean oldCoordsIsSmaller = oldRowIsSmaller && oldColumnIsSmaller;
		int newFinalRowPosition = newCoords.getRow();
		int currentRow = oldCoords.getRow();
		int currentColumn = oldCoords.getColumn();
		
		//Modify current rows and columns by +1/-1 to avoid checking itself.
		currentRow = oldCoordsIsSmaller ? currentRow + 1 : currentRow - 1;
		currentColumn = oldCoordsIsSmaller ? currentColumn + 1: currentColumn - 1;
		
		if (lastSpotInclusive)
			newFinalRowPosition = oldColumnIsSmaller ? newFinalRowPosition + 1 : newFinalRowPosition - 1;
		
		//Going left to right - Increasing i and j each time
		// if the old coords are both smaller than the new coords.
		if (oldCoordsIsSmaller) {
			
			//Iterate number of squares from old to new Coords.
			for (int i = oldCoords.getRow(); i < newFinalRowPosition; i++) {
				Piece pieceToCompare = boardData.getBoard()[currentRow++][currentColumn++];
				
				if (pieceToCompare != null) {
					pieceInWay = true;
					break;
				}
				
			}
			
			
		//Going right to left - decreasing i and j each time
		// if the old coords are bigger than the new coords.
		} else if (!oldColumnIsSmaller) {
			for (int i = oldCoords.getRow(); i > newFinalRowPosition; i--) {
				
				Piece pieceToCompare = boardData.getBoard()[currentRow--][currentColumn--];
				
				if (pieceToCompare != null) {
					pieceInWay = true;
					break;
				}
			}
		}
		
		
		return pieceInWay;
	}

	/**
	 * Methods will determine if there is a piece in the way vertically.
	 * 
	 * This method excludes the original spot the piece is in 
	 * and will only check the last spot if <code>lastSpotInclusive</code>
	 * is true.
	 * 
	 * @return True is there is a piece in the way vertically.
	 */
	protected boolean pieceInWayVertical(int oldRow, int newRow, boolean lastSpotInclusive) {

		boolean newRowBelowOldRow = newRow > oldRow;
		boolean pieceInWay = false;
		
		//Modify xCoordOld by +1/-1 to avoid checking itself.
		oldRow = newRowBelowOldRow ? oldRow + 1 : oldRow - 1;
		
		if (lastSpotInclusive)
			newRow = newRowBelowOldRow ? newRow + 1 : newRow - 1;
		
		
		if (newRowBelowOldRow) {
			for (int i = oldRow; i < newRow; i++) {
				
				Piece pieceToCompare = boardData.getBoard()[i][oldLocation.getColumn()];
				
				if (pieceToCompare != null) {
					pieceInWay = true;
					break;
				}
			}
		} else {
			for (int i = oldRow; i > newRow; i--) {
				
				Piece pieceToCompare = boardData.getBoard()[i][oldLocation.getColumn()];
				
				if (pieceToCompare != null) {
					pieceInWay = true;
					break;
				}
			}
		}
		
		return pieceInWay;
	}

	/**
	 * 
	 * @param oldColumn
	 * @param newColumn
	 * @param lastSpotInclusive
	 * @return
	 */
	protected boolean pieceInWayHorizontal(int oldColumn, int newColumn, boolean lastSpotInclusive) {

		boolean newColumnRightOfOldColumn = newColumn > oldColumn;
		boolean pieceInWay = false;
		
		//Modify xCoordOld by +1/-1 to avoid checking itself.
		oldColumn = newColumnRightOfOldColumn ? oldColumn + 1 : oldColumn - 1;
		//Adjust columns to include last spot of needed.
		if (lastSpotInclusive)
			newColumn = newColumnRightOfOldColumn ? newColumn + 1 : newColumn - 1;
		
		if (newColumnRightOfOldColumn) {
			for (int i = oldColumn; i < newColumn; i++) {
				
				Piece pieceToCompare = boardData.getBoard()[oldLocation.getRow()][i];
				
				if (pieceToCompare != null) {
					pieceInWay = true;
					break;
				}
			}
		} else {
			for (int i = oldColumn; i > newColumn; i--) {
				
				Piece pieceToCompare = boardData.getBoard()[oldLocation.getRow()][i];
				
				if (pieceToCompare != null) {
					pieceInWay = true;
					break;
				}
			}
		}
		
		return pieceInWay;
	}

}
