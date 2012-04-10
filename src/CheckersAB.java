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

	public static void main(String[] args) {

		b = new Board();
		gp = new GamePlay(0);

		int index = -1;
		int moves = -1;

		AlphaBeta ab = new AlphaBeta();
		int color = 0;

		for (int i = 0; i < 250; i++) {

			gp.setColor(color);

			if ((b.getBlackPieces().isEmpty())
					|| (b.getWhitePieces().isEmpty()))
				break;

			index++;
			moves++;
			Move m = ab.AlphaBetaSearch(b, gp, color, Integer.MIN_VALUE,
					Integer.MAX_VALUE, 12, 0);

			Point p = m.getNextPosition();
			String d = m.getDirection();
			System.out.println(p);
			System.out.println(d);
			b = makeMove(index, b, p, d);

			color = enemyColor(color);

			// position = move.getLeft();
			// action = move.getRight();
			// b = makeMove(index, b, position, action);

		} // end for

		for (int i = 0; i < moves; i++) {
			index++;
			b = undoMove(index, b);
		} // end for

	} // end main()

	public static int enemyColor(int c) {
		int result = -1;
		if (c == 0)
			result = 1;
		else if (c == 1)
			result = 0;
		return result;
	} // end enemyColor()

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
