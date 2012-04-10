import java.awt.Point;
import java.util.ArrayList;

/**
 * AlphaBeta - Use alpha-beta pruning with the MiniMax algorithm to play
 * checkers automatically
 * 
 * @author Haoran Ma (mahaoran1020@gmail.com), Adam Steinberger
 *         (steinz08@gmail.com)
 * 
 */
public class AlphaBeta {

	/**
	 * It is alpha-beta player's turn
	 * 
	 * @param game
	 * @param alpha
	 * @param beta
	 * @param depthLimit
	 * @param depth
	 * @return
	 */
	public Move AlphaBetaSearch(Board board, GamePlay game, int color,
			int alpha, int beta, int depthLimit, int depth) {

		game.setColor(color);

		if ((depthLimit <= depth) || (game.isGameOver())) {
			int[] scores = game.getScores();
			Move m = new Move(color, false, new Point(0, 0));
			m.setScore(scores[2]);
			return m;
		} // end if

		ArrayList<Piece> pieces = new ArrayList<Piece>();
		if (color == 0)
			pieces = game.getMovableBlackPieces(board);
		else if (color == 1)
			pieces = game.getMovableWhitePieces(board);

		Move m1 = new Move(color, false, new Point(0, 0));

		for (int i = 0; i < pieces.size(); i++) {

			Point p = pieces.get(i).getPosition();
			Piece pc = board.getPiece(p);

			ArrayList<String> actions = game.getPieceActions(board, pc);

			for (int j = 0; j < actions.size(); j++) {

				String action = actions.get(j);

				// place stone on the board
				game.movePiece(board, p, action);
				m1.setDirection(action);
				m1.setNextPosition(p);

				int c = this.enemyColor(color);
				Move m2 = this.AlphaBetaSearch(board, game, c, -beta, -alpha,
						depthLimit, depth + 1);
				m2.setNextPosition(p);
				m2.setScore(-1 * m2.getScore());
				int value = m2.getScore();

				m1.setScore(value);

				if (value > alpha)
					alpha = value;

				game.undoMove(board);

				if (value >= beta) {
					m1.setScore(beta);
					return m1;
				}

			} // end for

		} // end for

		m1.setScore(alpha);
		return m1;

	} // end AlphaBeta()

	public int enemyColor(int c) {
		int result = -1;
		if (c == 0)
			result = 1;
		else if (c == 1)
			result = 0;
		return result;
	} // end enemyColor()

} // end class

