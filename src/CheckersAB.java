import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 * Checkers - different tests to run checkers
 * 
 * @author Haoran Ma (mahaoran1020@gmail.com), Adam Steinberger
 *         (steinz08@gmail.com)
 * 
 */
public class CheckersAB {

	private static Board b = new Board();
	private static GamePlay gp = new GamePlay(0);
	private static Random random = new Random(System.currentTimeMillis());

	public static void main(String[] args) {

		b = new Board();
		gp = new GamePlay(0);

		int index = -1;
		int moves = 0;

		AlphaBeta ab = new AlphaBeta();

		// for (int i = 0; i < 250; i++) {
		//
		// if ((b.getBlackPieces().isEmpty())
		// || (b.getWhitePieces().isEmpty()))
		// break;
		//
		// int color = gp.getColor();
		// ArrayList<Piece> pieces = new ArrayList<Piece>();
		// int randIndex = 0;
		// Piece piece = new Piece(0);
		// Point position = new Point(0, 0);
		// ArrayList<String> actions = new ArrayList<String>();
		// String action = "ul";
		// // Pair<Point, String> move = ab.AlphaBetaSearch(b, color, gp,
		// // 10);
		// // Point position = move.getLeft();
		// // String action = move.getRight();
		// // b = makeMove(index, b, position, action);
		// // moves++;
		//
		// if (color == 0) {
		//
		// index++;
		// pieces = gp.getJumpableBlackPieces(b);
		//
		// if (!pieces.isEmpty()) {
		//
		// randIndex = random.nextInt(pieces.size());
		// piece = pieces.get(randIndex);
		//
		// actions = gp.getPieceJumps(b, piece);
		// randIndex = random.nextInt(actions.size());
		// action = actions.get(randIndex);
		// b = makeMove(index, b, position, action);
		// moves++;
		//
		// } else {
		//
		// pieces = gp.getMovableBlackPieces(b);
		//
		// if (!pieces.isEmpty()) {
		// randIndex = random.nextInt(pieces.size());
		// piece = pieces.get(randIndex);
		// position = piece.getPosition();
		// actions = gp.getPieceActions(b, piece);
		// randIndex = random.nextInt(actions.size());
		// action = actions.get(randIndex);
		// b = makeMove(index, b, position, action);
		// moves++;
		// } // end if
		//
		// } // end if
		//
		// } else {
		//
		// index++;
		// pieces = gp.getJumpableWhitePieces(b);
		//
		// if (!pieces.isEmpty()) {
		//
		// randIndex = random.nextInt(pieces.size());
		// piece = pieces.get(randIndex);
		// position = piece.getPosition();
		// actions = gp.getPieceJumps(b, piece);
		// randIndex = random.nextInt(actions.size());
		// action = actions.get(randIndex);
		// b = makeMove(index, b, position, action);
		// moves++;
		//
		// } else {
		//
		// pieces = gp.getMovableWhitePieces(b);
		//
		// if (!pieces.isEmpty()) {
		// randIndex = random.nextInt(pieces.size());
		// piece = pieces.get(randIndex);
		// position = piece.getPosition();
		// actions = gp.getPieceActions(b, piece);
		// randIndex = random.nextInt(actions.size());
		// action = actions.get(randIndex);
		// b = makeMove(index, b, position, action);
		// moves++;
		// } // end if
		//
		// } // end if
		//
		// } // end if
		//
		// } // end for

		for (int i = 0; i < 250; i++) {

			if ((b.getBlackPieces().isEmpty())
					|| (b.getWhitePieces().isEmpty()))
				break;

			int color = gp.getColor();
			ArrayList<Piece> pieces = new ArrayList<Piece>();
			int randIndex = 0;
			Piece piece = new Piece(0);
			Point position = new Point(0, 0);
			ArrayList<String> actions = new ArrayList<String>();
			String action = "ul";

			if (color == 0) {

				index++;
				pieces = gp.getJumpableBlackPieces(b);

				if (!pieces.isEmpty()) {

					randIndex = random.nextInt(pieces.size());
					piece = pieces.get(randIndex);
					position = piece.getPosition();
					actions = gp.getPieceJumps(b, piece);
					randIndex = random.nextInt(actions.size());
					action = actions.get(randIndex);
					b = makeMove(index, b, position, action);
					moves++;

				} else {

					pieces = gp.getMovableBlackPieces(b);
					randIndex = random.nextInt(pieces.size());
					piece = pieces.get(randIndex);
					position = piece.getPosition();
					actions = gp.getPieceActions(b, piece);
					randIndex = random.nextInt(actions.size());
					action = actions.get(randIndex);
					b = makeMove(index, b, position, action);
					moves++;

				} // end if

			} else {

				index++;
				pieces = gp.getJumpableWhitePieces(b);

				if (!pieces.isEmpty()) {

					randIndex = random.nextInt(pieces.size());
					piece = pieces.get(randIndex);
					position = piece.getPosition();
					actions = gp.getPieceJumps(b, piece);
					randIndex = random.nextInt(actions.size());
					action = actions.get(randIndex);
					b = makeMove(index, b, position, action);
					moves++;

				} else {

					pieces = gp.getMovableWhitePieces(b);
					randIndex = random.nextInt(pieces.size());
					piece = pieces.get(randIndex);
					position = piece.getPosition();
					actions = gp.getPieceActions(b, piece);
					randIndex = random.nextInt(actions.size());
					action = actions.get(randIndex);
					b = makeMove(index, b, position, action);
					moves++;

				} // end if

			} // end if

		} // end for

		for (int i = 0; i < moves; i++) {
			index++;
			b = undoMove(index, b);
		} // end for

	} // end main()

	/**
	 * Undo last move on the game board.
	 * 
	 * @param i
	 *            move index
	 * @param b
	 *            game board
	 */
	public static Board undoMove(int i, Board b) {
		System.out.println("Undo Move " + i);
		System.out.println("Player " + gp.getColor());
		b = gp.undoMove(b);
		System.out.println(b.toString());
		return b;
	} // end undoMove()

	/**
	 * Make a move on the game board.
	 * 
	 * @param i
	 *            move index
	 * @param b
	 *            game board
	 * @param p
	 *            position of stone to move
	 * @param d
	 *            direction to move stone
	 */
	public static Board makeMove(int i, Board b, Point p, String d) {
		System.out.println("Move " + i);
		System.out.println("Player " + gp.getColor());
		b = gp.movePiece(b, p, d);
		System.out.println(b.toString());
		return b;
	} // end makeMove()

} // end class
