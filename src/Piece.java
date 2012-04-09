import java.awt.Point;

/**
 * Piece - keep track of pieces on checkers game board.
 * 
 * @author Haoran Ma (mahaoran1020@gmail.com), Adam Steinberger
 *         (steinz08@gmail.com)
 * 
 */
public class Piece {

	/**
	 * color = 0 --> black piece. color = 1 --> white piece.
	 */
	private int color;
	private Point position = new Point(0, 0);
	private boolean isKing = false;

	public Piece(int c) {
		this.color = c;
	} // end constructor

	public Piece(int c, Point p) {
		this.color = c;
		this.position = p;
	} // end constructor

	@Override
	public String toString() {
		return "[Piece color=" + color + ", position=" + position + ", isKing="
				+ isKing + "]";
	} // end toString()

	/**
	 * color = 0 --> black piece. color = 1 --> white piece.
	 */
	public int getColor() {
		return this.color;
	} // end getColor()

	public void setColor(int c) {
		this.color = c;
	} // end setColor()

	public Point getPosition() {
		return this.position;
	} // end getPosition()

	public void setPosition(Point p) {
		this.position = p;
	} // end setPosition()

	public boolean isKing() {
		return this.isKing;
	} // end isKing()

	public void setKing(boolean k) {
		this.isKing = k;
	} // end setKing()

} // end class
