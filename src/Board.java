import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Board - Keeps track of piece interactions on the checkers game board.
 * 
 * @author Haoran Ma (mahaoran1020@gmail.com), Adam Steinberger
 *         (steinz08@gmail.com)
 * 
 */
public class Board {

	private ArrayList<Piece> blackPieces = new ArrayList<Piece>();
	private ArrayList<Piece> whitePieces = new ArrayList<Piece>();

	public Board() {

		// initialize white pieces on board
		for (int row = 0; row < 3; row++) {
			int colStart = 1;
			if (row == 1)
				colStart = 0;
			for (int col = colStart; col < 8; col += 2) {
				Point l = new Point(row, col);
				Piece p = new Piece(1, l);
				this.addPiece(l, p);
			} // end for
		} // end for

		// initialize black pieces on board
		for (int row = 5; row < 8; row++) {
			int colStart = 0;
			if (row == 6)
				colStart = 1;
			for (int col = colStart; col < 8; col += 2) {
				Point l = new Point(row, col);
				Piece p = new Piece(0, l);
				this.addPiece(l, p);
			} // end for
		} // end for

	} // end constructor

	public void removePiece(Point pos) {
		Piece p = this.getPiece(pos);
		int index = this.getPieceIndex(pos);
		int c = p.getColor();
		if (c == 0)
			this.blackPieces.remove(index);
		else if (c == 1)
			this.whitePieces.remove(index);
		this.cleanPieces();
	} // end removePiece()

	public void addPiece(Point pos, Piece pc) {
		int c = pc.getColor();
		if (c == 0)
			this.blackPieces.add(pc);
		else if (c == 1)
			this.whitePieces.add(pc);
		this.cleanPieces();
	} // end addPiece()

	public void cleanPieces() {

		ArrayList<Point> positions = new ArrayList<Point>();
		ArrayList<Piece> pieces = new ArrayList<Piece>();

		for (int i = 0; i < this.whitePieces.size(); i++) {
			Piece piece = this.whitePieces.get(i);
			Point pos = piece.getPosition();
			if (!positions.contains(pos)) {
				positions.add(pos);
				pieces.add(piece);
			} // end if
		} // end for

		this.whitePieces = pieces;
		positions = new ArrayList<Point>();
		pieces = new ArrayList<Piece>();

		for (int i = 0; i < this.blackPieces.size(); i++) {
			Piece piece = this.blackPieces.get(i);
			Point pos = piece.getPosition();
			if (!positions.contains(pos)) {
				positions.add(pos);
				pieces.add(piece);
			} // end if
		} // end for

		this.blackPieces = pieces;

	} // end cleanPieces()

	public void setPiece(Point pos, Piece pc) {

		int index = this.getPieceIndex(pos);

		if (index != -1)
			this.removePiece(pos);

		this.addPiece(pos, pc);

	} // end setPiece()

	public int getPieceIndex(Point p) {

		for (int i = 0; i < this.whitePieces.size(); i++) {
			Piece piece = this.whitePieces.get(i);
			Point pos = piece.getPosition();
			if (pos.equals(p))
				return i;
		} // end for

		for (int i = 0; i < this.blackPieces.size(); i++) {
			Piece piece = this.blackPieces.get(i);
			Point pos = piece.getPosition();
			if (pos.equals(p))
				return i;
		} // end for

		return -1;

	} // end getPieceIndex()

	public Piece getPiece(Point p) {
		Iterator<Piece> it = this.whitePieces.iterator();
		while (it.hasNext()) {
			Piece next = it.next();
			Point pos = next.getPosition();
			if (pos.equals(p))
				return next;
		} // end while
		it = this.blackPieces.iterator();
		while (it.hasNext()) {
			Piece next = it.next();
			Point pos = next.getPosition();
			if (pos.equals(p))
				return next;
		} // end while
		Piece nullPiece = new Piece(-1);
		return nullPiece;
	} // end getPiece()

	@Override
	public String toString() {

		String[][] board = new String[8][8];

		Iterator<Piece> it = this.whitePieces.iterator();
		while (it.hasNext()) {
			Piece next = it.next();
			Point p = next.getPosition();
			if (next.isKing())
				board[p.x][p.y] = "W";
			else
				board[p.x][p.y] = "w";
		} // end while

		it = this.blackPieces.iterator();
		while (it.hasNext()) {
			Piece next = it.next();
			Point p = next.getPosition();
			if (next.isKing())
				board[p.x][p.y] = "B";
			else
				board[p.x][p.y] = "b";
		} // end while

		String result = "  0 1 2 3 4 5 6 7\n";
		for (int row = 0; row < 8; row++) {

			result += Integer.toString(row) + " ";

			for (int col = 0; col < 8; col++) {

				String cell = " ";
				if (board[row][col] != null)
					cell = board[row][col];
				result += cell + " ";

			} // end for

			result += "\n";

		} // end for

		return result;

	} // end toString()

	public ArrayList<Piece> getBlackPieces() {
		return this.blackPieces;
	} // end getBlackPieces()

	public void setBlackPieces(ArrayList<Piece> bp) {
		this.blackPieces = bp;
	} // end setBlackPieces()

	public ArrayList<Piece> getWhitePieces() {
		return this.whitePieces;
	} // end getWhitePieces()

	public void setWhitePieces(ArrayList<Piece> wp) {
		this.whitePieces = wp;
	} // end setWhitePieces()

} // end class
