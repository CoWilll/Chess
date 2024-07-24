package backend;

/**
 * This class will represent a point on the chess board in terms of rows and columns.
 * 
 * @author Collin Williams
 */
public class Point {
	
	private int row, column;
	
	public Point(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

}
