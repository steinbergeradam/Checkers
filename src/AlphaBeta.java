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
	public Triple<Integer, Point, String> maxValue(Board board, GamePlay game,
			int alpha, int beta, int depthLimit, int depth) {

		// System.out.println("we called maxValue");
		Point pBest = new Point();
		String bestMove = "";

		if (depthLimit <= depth) {
			int[] scores = game.getScores();
			Triple<Integer, Point, String> pFinal = new Triple<Integer, Point, String>(
					scores[2], pBest, bestMove);
			return pFinal;

		} else {

			ArrayList<Piece> pieces = game.getMovableWhitePieces(board);

			for (int i = 0; i < pieces.size(); i++) {

				Point p = pieces.get(i).getPosition();
				Piece pc = board.getPiece(p);

				ArrayList<String> actions = game.getPieceActions(board, pc);

				for (int j = 0; j < actions.size(); j++) {

					String action = actions.get(j);

					// place stone on the board
					game.movePiece(board, p, action);
					Triple<Integer, Point, String> pForminValue = this
							.minValue(board, game, alpha, beta, depthLimit,
									depth + 1);

					game.undoMove(board);

					if (pForminValue.getLeft() > alpha) {
						alpha = pForminValue.getLeft();
						pBest = p;
						bestMove = action;

						if (alpha >= beta) {
							Triple<Integer, Point, String> pFinal = new Triple<Integer, Point, String>(
									alpha, pBest, bestMove);
							return pFinal;
						} // end if
					} // end if

				} // end for

			} // end for

			Triple<Integer, Point, String> pFinal = new Triple<Integer, Point, String>(
					alpha, pBest, bestMove);
			return pFinal;

		} // end if

	} // end maxValue()

	public Triple<Integer, Point, String> minValue(Board board, GamePlay game,
			int alpha, int beta, int depthLimit, int depth) {

		// System.out.println("we called minValue");
		Point pBest = new Point();
		String bestMove = "";

		if (depthLimit <= depth) {
			int[] scores = game.getScores();
			Triple<Integer, Point, String> pFinal = new Triple<Integer, Point, String>(
					scores[2], pBest, bestMove);
			return pFinal;
		} else {

			ArrayList<Piece> pieces = game.getMovableBlackPieces(board);

			for (int i = 0; i < pieces.size(); i++) {

				Point p = pieces.get(i).getPosition();
				Piece pc = board.getPiece(p);

				ArrayList<String> actions = game.getPieceActions(board, pc);

				for (int j = 0; j < actions.size(); j++) {

					String action = actions.get(j);

					// place stone on the board
					game.movePiece(board, p, action);

					Triple<Integer, Point, String> pForminValue = this
							.maxValue(board, game, alpha, beta, depthLimit,
									depth + 1);

					game.undoMove(board);

					if (pForminValue.getLeft() < beta) {
						beta = pForminValue.getLeft();
						pBest = pForminValue.getCenter();
						bestMove = pForminValue.getRight();
						if (alpha >= beta) {
							Triple<Integer, Point, String> pFinal = new Triple<Integer, Point, String>(
									beta, pBest, bestMove);
							return pFinal;
						} // end if
					} // end if

				} // end for

			} // end for

			Triple<Integer, Point, String> pFinal = new Triple<Integer, Point, String>(
					beta, pBest, bestMove);
			return pFinal;

		} // end if

	} // end minValue()

	public Pair<Point, String> AlphaBetaSearch(Board board, int player,
			GamePlay game, int depthLimit) {

		// min's turn black
		if (player == 0) {
			Triple<Integer, Point, String> triple = this.minValue(board, game,
					Integer.MIN_VALUE, Integer.MAX_VALUE, depthLimit, 0);
			return new Pair<Point, String>(triple.getCenter(),
					triple.getRight());
		} // end if

		// max's turn White
		else {
			Triple<Integer, Point, String> triple = this.maxValue(board, game,
					Integer.MIN_VALUE, Integer.MAX_VALUE, depthLimit, 0);
			return new Pair<Point, String>(triple.getCenter(),
					triple.getRight());
		} // end if

	} // end AlphaBetaSearch()

} // end class

