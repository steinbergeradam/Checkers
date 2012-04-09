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
public class CheckersTests {

	private static Board b = new Board();
	private static GamePlay gp = new GamePlay(0);
	private static Random random = new Random(System.currentTimeMillis());

	public static void main(String[] args) {

		for (int testNum = 0; testNum < 8; testNum++) {

			b = new Board();
			gp = new GamePlay(0);

			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("!!!!!!!!!! NEW GAME !!!!!!!!!!");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println();
			System.out.println("Test #" + testNum);

			int index = -1;
			int moves = 0;

			switch (testNum) {

			case 0:
				System.out
						.println("check upRight-upRight double jump that hits a horizontal border");
				System.out.println(b.toString());
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 0), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(2, 7), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(6, 1), "ul");
				index++;
				moves++;
				b = makeMove(index, b, new Point(1, 6), "dr");
				index++;
				moves++;
				b = makeMove(index, b, new Point(7, 0), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(0, 7), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 2), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(2, 5), "dl");
				break;
			case 1:
				System.out
						.println("check upRight-upLeft double jump that hits a horizontal border");
				System.out.println(b.toString());
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 0), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(2, 1), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(6, 1), "ul");
				index++;
				moves++;
				b = makeMove(index, b, new Point(1, 0), "dr");
				index++;
				moves++;
				b = makeMove(index, b, new Point(7, 0), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(0, 1), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 6), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(2, 3), "dl");
				break;
			case 2:
				System.out
						.println("check upLeft-upRight double jump that hits a horizontal border");
				System.out.println(b.toString());
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 6), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(2, 7), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(6, 7), "ul");
				index++;
				moves++;
				b = makeMove(index, b, new Point(1, 6), "dr");
				index++;
				moves++;
				b = makeMove(index, b, new Point(7, 6), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(0, 7), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 0), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(2, 5), "dl");
				break;
			case 3:
				System.out
						.println("check upLeft-upLeft double jump that hits a horizontal border");
				System.out.println(b.toString());
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 6), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(2, 1), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(6, 7), "ul");
				index++;
				moves++;
				b = makeMove(index, b, new Point(1, 0), "dr");
				index++;
				moves++;
				b = makeMove(index, b, new Point(7, 6), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(0, 1), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 4), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(2, 3), "dr");
				break;
			case 4:
				System.out
						.println("check downRight-downRight double jump that hits a horizontal border");
				System.out.println(b.toString());
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 6), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(2, 1), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(6, 7), "ul");
				index++;
				moves++;
				b = makeMove(index, b, new Point(1, 0), "dr");
				index++;
				moves++;
				b = makeMove(index, b, new Point(7, 6), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(0, 1), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 2), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(2, 3), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 4), "ur");
				break;
			case 5:
				System.out
						.println("check downRight-downLeft double jump that hits a horizontal border");
				System.out.println(b.toString());
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 0), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(2, 7), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(6, 1), "ul");
				index++;
				moves++;
				b = makeMove(index, b, new Point(1, 6), "dr");
				index++;
				moves++;
				b = makeMove(index, b, new Point(7, 0), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(0, 7), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 6), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(2, 1), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 2), "ur");
				break;
			case 6:
				System.out
						.println("check downLeft-downRight double jump that hits a horizontal border");
				System.out.println(b.toString());
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 6), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(2, 7), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(6, 7), "ul");
				index++;
				moves++;
				b = makeMove(index, b, new Point(1, 6), "dr");
				index++;
				moves++;
				b = makeMove(index, b, new Point(7, 6), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(0, 7), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 0), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(2, 1), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 4), "ur");
				break;
			case 7:
				System.out
						.println("check downLeft-downLeft double jump that hits a horizontal border");
				System.out.println(b.toString());
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 0), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(2, 7), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(6, 1), "ul");
				index++;
				moves++;
				b = makeMove(index, b, new Point(1, 6), "dr");
				index++;
				moves++;
				b = makeMove(index, b, new Point(7, 0), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(0, 7), "dl");
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 6), "ur");
				index++;
				moves++;
				b = makeMove(index, b, new Point(2, 3), "dr");
				index++;
				moves++;
				b = makeMove(index, b, new Point(5, 2), "ur");
				break;
			} // end switch

			// AlphaBeta ab = new AlphaBeta();

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
