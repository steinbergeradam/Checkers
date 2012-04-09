import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * GamePlay - place pieces on board for both human and machine players.
 * 
 * @author Haoran Ma (mahaoran1020@gmail.com), Adam Steinberger
 *         (steinz08@gmail.com)
 * 
 */
public class GamePlay {

	private int color;
	private boolean gameOver = false;
	private Stack<Move> moves = new Stack<Move>();
	private int[] scores = { 12, 12, 0 };

	public GamePlay() {
		this.color = -1;
	} // end constructor

	/**
	 * Create new GamePlay object given full parameter set for object variables.
	 * 
	 * @param c
	 *            color
	 */
	public GamePlay(int c) {
		this.color = c;
	} // end constructor

	public ArrayList<String> getPieceActions(Board b, Piece p) {

		ArrayList<String> actions = new ArrayList<String>();
		Point pos = p.getPosition();

		Point upLeft = new Point(pos.x - 1, pos.y - 1);
		Point upRight = new Point(pos.x - 1, pos.y + 1);
		Point downRight = new Point(pos.x + 1, pos.y + 1);
		Point downLeft = new Point(pos.x + 1, pos.y - 1);

		Point upLeftx2 = new Point(pos.x - 2, pos.y - 2);
		Point upRightx2 = new Point(pos.x - 2, pos.y + 2);
		Point downRightx2 = new Point(pos.x + 2, pos.y + 2);
		Point downLeftx2 = new Point(pos.x + 2, pos.y - 2);

		Piece pieceUL = b.getPiece(upLeft);
		Piece pieceUR = b.getPiece(upRight);
		Piece pieceDR = b.getPiece(downRight);
		Piece pieceDL = b.getPiece(downLeft);

		Piece pieceULx2 = b.getPiece(upLeftx2);
		Piece pieceURx2 = b.getPiece(upRightx2);
		Piece pieceDRx2 = b.getPiece(downRightx2);
		Piece pieceDLx2 = b.getPiece(downLeftx2);

		if (((pos.x > 0) && (pos.y > 0) && (pieceUL.getColor() != this.color)
				&& (pieceUL.getColor() != this.enemyColor(this.color)) && ((p
				.isKing()) || (this.color == 0)))
				|| ((pos.x > 1)
						&& (pos.y > 1)
						&& (pieceUL.getColor() == this.enemyColor(this.color))
						&& (pieceULx2.getColor() != this.color)
						&& (pieceULx2.getColor() != this.enemyColor(this.color)) && ((p
						.isKing()) || (this.color == 0))))
			actions.add("ul");

		if (((pos.x > 0) && (pos.y < 7) && (pieceUR.getColor() != this.color)
				&& (pieceUR.getColor() != this.enemyColor(this.color)) && ((p
				.isKing()) || (this.color == 0)))
				|| ((pos.x > 1)
						&& (pos.y < 6)
						&& (pieceUR.getColor() == this.enemyColor(this.color))
						&& (pieceURx2.getColor() != this.color)
						&& (pieceURx2.getColor() != this.enemyColor(this.color)) && ((p
						.isKing()) || (this.color == 0))))
			actions.add("ur");

		if (((pos.x < 7) && (pos.y < 7) && (pieceDR.getColor() != this.color)
				&& (pieceDR.getColor() != this.enemyColor(this.color)) && ((p
				.isKing()) || (this.color == 1)))
				|| ((pos.x < 6)
						&& (pos.y < 6)
						&& (pieceDR.getColor() == this.enemyColor(this.color))
						&& (pieceDRx2.getColor() != this.color)
						&& (pieceDRx2.getColor() != this.enemyColor(this.color)) && ((p
						.isKing()) || (this.color == 1))))
			actions.add("dr");

		if (((pos.x < 7) && (pos.y > 0) && (pieceDL.getColor() != this.color)
				&& (pieceDL.getColor() != this.enemyColor(this.color)) && ((p
				.isKing()) || (this.color == 1)))
				|| ((pos.x < 6)
						&& (pos.y > 1)
						&& (pieceDL.getColor() == this.enemyColor(this.color))
						&& (pieceDLx2.getColor() != this.color)
						&& (pieceDLx2.getColor() != this.enemyColor(this.color)) && ((p
						.isKing()) || (this.color == 1))))
			actions.add("dl");

		return actions;

	} // end getPieceActions()

	public ArrayList<String> getPieceJumps(Board b, Piece p) {

		b.cleanPieces();
		ArrayList<String> actions = new ArrayList<String>();
		Point pos = p.getPosition();

		Point upLeft = new Point(pos.x - 1, pos.y - 1);
		Point upRight = new Point(pos.x - 1, pos.y + 1);
		Point downRight = new Point(pos.x + 1, pos.y + 1);
		Point downLeft = new Point(pos.x + 1, pos.y - 1);

		Point upLeftx2 = new Point(pos.x - 2, pos.y - 2);
		Point upRightx2 = new Point(pos.x - 2, pos.y + 2);
		Point downRightx2 = new Point(pos.x + 2, pos.y + 2);
		Point downLeftx2 = new Point(pos.x + 2, pos.y - 2);

		Piece pieceUL = b.getPiece(upLeft);
		Piece pieceUR = b.getPiece(upRight);
		Piece pieceDR = b.getPiece(downRight);
		Piece pieceDL = b.getPiece(downLeft);

		Piece pieceULx2 = b.getPiece(upLeftx2);
		Piece pieceURx2 = b.getPiece(upRightx2);
		Piece pieceDRx2 = b.getPiece(downRightx2);
		Piece pieceDLx2 = b.getPiece(downLeftx2);

		// System.out.println("*************");
		// System.out.println("(pos.x > 1) = " + (pos.x > 1));
		// System.out.println("(pos.y > 1) = " + (pos.y > 1));
		// System.out
		// .println("(pieceUL.getColor() == this.enemyColor(this.color)) = "
		// + (pieceUL.getColor() == this.enemyColor(this.color)));
		// System.out.println("(pieceULx2.getColor() != this.color) = "
		// + (pieceULx2.getColor() != this.color));
		// System.out
		// .println("(pieceULx2.getColor() != this.enemyColor(this.color)) = "
		// + (pieceULx2.getColor() != this.enemyColor(this.color)));
		// System.out.println("((p.isKing()) || (this.color == 0))) = "
		// + ((p.isKing()) || (this.color == 0)));

		// System.out.println(p);

		if ((pos.x > 1) && (pos.y > 1) && (pieceULx2.getPosition().x >= 0)
				&& (pieceULx2.getPosition().y >= 0)
				&& (pieceUL.getColor() == this.enemyColor(this.color))
				&& (pieceULx2.getColor() != this.color)
				&& (pieceULx2.getColor() != this.enemyColor(this.color))
				&& ((p.isKing()) || (this.color == 0))) {
			// System.out.println("UL Jump Available");
			actions.add("ul");
		} // end if

		if ((pos.x > 1) && (pos.y < 6) && (pieceURx2.getPosition().x >= 0)
				&& (pieceURx2.getPosition().y <= 8)
				&& (pieceUR.getColor() == this.enemyColor(this.color))
				&& (pieceURx2.getColor() != this.color)
				&& (pieceURx2.getColor() != this.enemyColor(this.color))
				&& ((p.isKing()) || (this.color == 0))) {
			// System.out.println("UR Jump Available");
			actions.add("ur");
		} // end if

		if ((pos.x < 6) && (pos.y < 6) && (pieceDRx2.getPosition().x <= 8)
				&& (pieceDRx2.getPosition().y <= 8)
				&& (pieceDR.getColor() == this.enemyColor(this.color))
				&& (pieceDRx2.getColor() != this.color)
				&& (pieceDRx2.getColor() != this.enemyColor(this.color))
				&& ((p.isKing()) || (this.color == 1))) {
			// System.out.println("DR Jump Available");
			actions.add("dr");
		} // end if

		if ((pos.x < 6) && (pos.y > 1) && (pieceDLx2.getPosition().x <= 8)
				&& (pieceDLx2.getPosition().y >= 0)
				&& (pieceDL.getColor() == this.enemyColor(this.color))
				&& (pieceDLx2.getColor() != this.color)
				&& (pieceDLx2.getColor() != this.enemyColor(this.color))
				&& ((p.isKing()) || (this.color == 1))) {
			// System.out.println("DL Jump Available");
			actions.add("dl");
		} // end if

		return actions;

	} // end getPieceJumps()

	public ArrayList<Piece> getJumpableBlackPieces(Board b) {
		ArrayList<Piece> jumpableBlacks = new ArrayList<Piece>();
		ArrayList<Piece> blackPieces = b.getBlackPieces();
		ArrayList<Point> pieces = new ArrayList<Point>();
		Iterator<Piece> it = blackPieces.iterator();
		while (it.hasNext()) {
			Piece next = it.next();
			if (!pieces.contains(next.getPosition())) {
				pieces.add(next.getPosition());
				ArrayList<String> actions = this.getPieceJumps(b, next);
				if (!actions.isEmpty())
					jumpableBlacks.add(next);
			} // end if
		} // end while
		return jumpableBlacks;
	} // end getJumpableBlackPieces()

	public ArrayList<Piece> getJumpableWhitePieces(Board b) {
		ArrayList<Piece> jumpableWhites = new ArrayList<Piece>();
		ArrayList<Piece> whitePieces = b.getWhitePieces();
		ArrayList<Point> pieces = new ArrayList<Point>();
		Iterator<Piece> it = whitePieces.iterator();
		while (it.hasNext()) {
			Piece next = it.next();
			if (!pieces.contains(next.getPosition())) {
				pieces.add(next.getPosition());
				ArrayList<String> actions = this.getPieceJumps(b, next);
				if (!actions.isEmpty())
					jumpableWhites.add(next);
			} // end if
		} // end while
		return jumpableWhites;
	} // end getJumpableWhitePieces()

	public ArrayList<Piece> getMovableBlackPieces(Board b) {
		ArrayList<Piece> movableBlacks = new ArrayList<Piece>();
		ArrayList<Piece> blackPieces = b.getBlackPieces();
		ArrayList<Point> pieces = new ArrayList<Point>();
		Iterator<Piece> it = blackPieces.iterator();
		while (it.hasNext()) {
			Piece next = it.next();
			if (!pieces.contains(next.getPosition())) {
				pieces.add(next.getPosition());
				ArrayList<String> actions = this.getPieceActions(b, next);
				if (!actions.isEmpty())
					movableBlacks.add(next);
			} // end if
		} // end while
		return movableBlacks;
	} // end getMovableBlackPieces()

	public ArrayList<Piece> getMovableWhitePieces(Board b) {
		ArrayList<Piece> movableWhites = new ArrayList<Piece>();
		ArrayList<Piece> whitePieces = b.getWhitePieces();
		ArrayList<Point> pieces = new ArrayList<Point>();
		Iterator<Piece> it = whitePieces.iterator();
		while (it.hasNext()) {
			Piece next = it.next();
			if (!pieces.contains(next.getPosition())) {
				pieces.add(next.getPosition());
				ArrayList<String> actions = this.getPieceActions(b, next);
				if (!actions.isEmpty())
					movableWhites.add(next);
			} // end if
		} // end while
		return movableWhites;
	} // end getMovableWhitePieces()

	public void updateScores(Board b) {
		int scoreBlack = 0;
		int scoreWhite = 0;
		ArrayList<Piece> blackPieces = b.getBlackPieces();
		ArrayList<Piece> whitePieces = b.getWhitePieces();
		Iterator<Piece> itBlack = blackPieces.iterator();
		while (itBlack.hasNext()) {
			Piece next = itBlack.next();
			if (next.isKing())
				scoreBlack += 3;
			else
				scoreBlack++;
		} // end while
		Iterator<Piece> itWhite = whitePieces.iterator();
		while (itWhite.hasNext()) {
			Piece next = itWhite.next();
			if (next.isKing())
				scoreWhite += 3;
			else
				scoreWhite++;
		} // end while
		this.scores[0] = scoreBlack;
		this.scores[1] = scoreWhite;
		this.scores[2] = scoreWhite - scoreBlack;
	} // end updateScores()

	/**
	 * Move piece on game board
	 * 
	 * @param b
	 *            game board
	 * @param p
	 *            position
	 * @param d
	 *            direction value: "ul" = up-left, "ur" = up-right, "dr" =
	 *            down-right, "dl" = down-left
	 */
	public Board movePiece(Board b, Point p, String d) {

		boolean toggle = true;
		Piece piece = b.getPiece(p);
		Move move = new Move(this.color, piece.isKing(), p);

		if (this.color == piece.getColor()) {

			Point upLeft = new Point(p.x - 1, p.y - 1);
			Point upRight = new Point(p.x - 1, p.y + 1);
			Point downRight = new Point(p.x + 1, p.y + 1);
			Point downLeft = new Point(p.x + 1, p.y - 1);

			Point upLeftx2 = new Point(p.x - 2, p.y - 2);
			Point upRightx2 = new Point(p.x - 2, p.y + 2);
			Point downRightx2 = new Point(p.x + 2, p.y + 2);
			Point downLeftx2 = new Point(p.x + 2, p.y - 2);

			Piece pieceUL = b.getPiece(upLeft);
			Piece pieceUR = b.getPiece(upRight);
			Piece pieceDR = b.getPiece(downRight);
			Piece pieceDL = b.getPiece(downLeft);

			Piece pieceULx2 = b.getPiece(upLeftx2);
			Piece pieceURx2 = b.getPiece(upRightx2);
			Piece pieceDRx2 = b.getPiece(downRightx2);
			Piece pieceDLx2 = b.getPiece(downLeftx2);

			if ((d.equals("ul")) && (p.x > 0) && (p.y > 0)
					&& (pieceUL.getColor() != this.color)
					&& (pieceUL.getColor() != this.enemyColor(this.color))
					&& ((piece.isKing()) || (this.color == 0))) {

				move.setNextPosition(upLeft);
				piece.setPosition(upLeft);

				if ((upLeft.x == 0) && (this.color == 0)) {
					move.setMadeKing(true);
					piece.setKing(true);
				} // end if

			} else if ((d.equals("ul")) && (p.x > 1) && (p.y > 1)
					&& (pieceUL.getColor() == this.enemyColor(this.color))
					&& (pieceULx2.getColor() != this.color)
					&& (pieceULx2.getColor() != this.enemyColor(this.color))
					&& ((piece.isKing()) || (this.color == 0))) {

				move.setNextPosition(upLeftx2);
				piece.setPosition(upLeftx2);

				move.setEnemyPosition(upLeft);
				move.setEnemyRemoved(true);
				move.setEnemyKing(pieceUL.isKing());
				b.removePiece(upLeft);

				if ((upLeftx2.x == 0) && (this.color == 0)) {

					move.setMadeKing(true);
					piece.setKing(true);

				} else {

					Point upLeftx2upLeft = new Point(upLeftx2.x - 1,
							upLeftx2.y - 1);
					Point upLeftx2upRight = new Point(upLeftx2.x - 1,
							upLeftx2.y + 1);
					Point upLeftx2downRight = new Point(upLeftx2.x + 1,
							upLeftx2.y + 1);
					Point upLeftx2downLeft = new Point(upLeftx2.x + 1,
							upLeftx2.y - 1);

					Piece pieceULx2UL = b.getPiece(upLeftx2upLeft);
					Piece pieceULx2UR = b.getPiece(upLeftx2upRight);
					Piece pieceULx2DR = b.getPiece(upLeftx2downRight);
					Piece pieceULx2DL = b.getPiece(upLeftx2downLeft);

					Point upLeftx3 = new Point(upLeftx2.x - 2, upLeftx2.y - 2);
					Point upRightx3 = new Point(upLeftx2.x - 2, upLeftx2.y + 2);
					Point downRightx3 = new Point(upLeftx2.x + 2,
							upLeftx2.y + 2);
					Point downLeftx3 = new Point(upLeftx2.x + 2, upLeftx2.y - 2);

					Piece pieceULx3 = b.getPiece(upLeftx3);
					Piece pieceURx3 = b.getPiece(upRightx3);
					Piece pieceDRx3 = b.getPiece(downRightx3);
					Piece pieceDLx3 = b.getPiece(downLeftx3);

					/* up left */
					if (((upLeftx3.x > -1)
							&& (upLeftx3.y > -1)
							&& (pieceULx2UL.getColor() == this
									.enemyColor(this.color))
							&& (pieceULx3.getColor() != this.color)
							&& (pieceULx3.getColor() != this
									.enemyColor(this.color)) && ((piece
							.isKing()) || (this.color == 0)))
							/* up right */
							|| ((upRightx3.x > -1)
									&& (upRightx3.y < 9)
									&& (pieceULx2UR.getColor() == this
											.enemyColor(this.color))
									&& (pieceURx3.getColor() != this.color)
									&& (pieceURx3.getColor() != this
											.enemyColor(this.color)) && ((piece
									.isKing()) || (this.color == 0)))
							/* down right */
							|| ((downRightx3.x < 9)
									&& (downRightx3.y < 9)
									&& (pieceULx2DR.getColor() == this
											.enemyColor(this.color))
									&& (pieceDRx3.getColor() != this.color)
									&& (pieceDRx3.getColor() != this
											.enemyColor(this.color)) && ((piece
									.isKing()) || (this.color == 1)))
							/* down left */
							|| ((downLeftx3.x < 9)
									&& (downLeftx3.y > -1)
									&& (pieceULx2DL.getColor() == this
											.enemyColor(this.color))
									&& (pieceDLx3.getColor() != this.color)
									&& (pieceDLx3.getColor() != this
											.enemyColor(this.color)) && ((piece
									.isKing()) || (this.color == 1))))
						toggle = false;

				} // end if

			} else if ((d.equals("ur")) && (p.x > 0) && (p.y < 8)
					&& (pieceUR.getColor() != this.color)
					&& (pieceUR.getColor() != this.enemyColor(this.color))
					&& ((piece.isKing()) || (this.color == 0))) {

				move.setNextPosition(upRight);
				piece.setPosition(upRight);

				if ((upRight.x == 0) && (this.color == 0)) {
					move.setMadeKing(true);
					piece.setKing(true);
				} // end if

			} else if ((d.equals("ur")) && (p.x > 1) && (p.y < 7)
					&& (pieceUR.getColor() == this.enemyColor(this.color))
					&& (pieceURx2.getColor() != this.color)
					&& (pieceURx2.getColor() != this.enemyColor(this.color))
					&& ((piece.isKing()) || (this.color == 0))) {

				move.setNextPosition(upRightx2);
				piece.setPosition(upRightx2);

				move.setEnemyPosition(upRight);
				move.setEnemyRemoved(true);
				move.setEnemyKing(pieceUR.isKing());
				b.removePiece(upRight);

				if ((upRightx2.x == 0) && (this.color == 0)) {

					move.setMadeKing(true);
					piece.setKing(true);

				} else {

					Point upRightx2upLeft = new Point(upRightx2.x - 1,
							upRightx2.y - 1);
					Point upRightx2upRight = new Point(upRightx2.x - 1,
							upRightx2.y + 1);
					Point upRightx2downRight = new Point(upRightx2.x + 1,
							upRightx2.y + 1);
					Point upRightx2downLeft = new Point(upRightx2.x + 1,
							upRightx2.y - 1);

					Piece pieceURx2UL = b.getPiece(upRightx2upLeft);
					Piece pieceURx2UR = b.getPiece(upRightx2upRight);
					Piece pieceURx2DR = b.getPiece(upRightx2downRight);
					Piece pieceURx2DL = b.getPiece(upRightx2downLeft);

					Point upLeftx3 = new Point(upRightx2.x - 2, upRightx2.y - 2);
					Point upRightx3 = new Point(upRightx2.x - 2,
							upRightx2.y + 2);
					Point downRightx3 = new Point(upRightx2.x + 2,
							upRightx2.y + 2);
					Point downLeftx3 = new Point(upRightx2.x + 2,
							upRightx2.y - 2);

					Piece pieceULx3 = b.getPiece(upLeftx3);
					Piece pieceURx3 = b.getPiece(upRightx3);
					Piece pieceDRx3 = b.getPiece(downRightx3);
					Piece pieceDLx3 = b.getPiece(downLeftx3);

					/* up left */
					if (((upLeftx3.x > -1)
							&& (upLeftx3.y > -1)
							&& (pieceURx2UL.getColor() == this
									.enemyColor(this.color))
							&& (pieceULx3.getColor() != this.color)
							&& (pieceULx3.getColor() != this
									.enemyColor(this.color)) && ((piece
							.isKing()) || (this.color == 0)))
							/* up right */
							|| ((upRightx3.x > -1)
									&& (upRightx3.y < 9)
									&& (pieceURx2UR.getColor() == this
											.enemyColor(this.color))
									&& (pieceURx3.getColor() != this.color)
									&& (pieceURx3.getColor() != this
											.enemyColor(this.color)) && ((piece
									.isKing()) || (this.color == 0)))
							/* down right */
							|| ((downRightx3.x < 9)
									&& (downRightx3.y < 9)
									&& (pieceURx2DR.getColor() == this
											.enemyColor(this.color))
									&& (pieceDRx3.getColor() != this.color)
									&& (pieceDRx3.getColor() != this
											.enemyColor(this.color)) && ((piece
									.isKing()) || (this.color == 1)))
							/* down left */
							|| ((downLeftx3.x < 9)
									&& (downLeftx3.y > -1)
									&& (pieceURx2DL.getColor() == this
											.enemyColor(this.color))
									&& (pieceDLx3.getColor() != this.color)
									&& (pieceDLx3.getColor() != this
											.enemyColor(this.color)) && ((piece
									.isKing()) || (this.color == 1))))
						toggle = false;

				} // end if

			} else if ((d.equals("dr")) && (p.x < 8) && (p.y < 8)
					&& (pieceDR.getColor() != this.color)
					&& (pieceDR.getColor() != this.enemyColor(this.color))
					&& ((piece.isKing()) || (this.color == 1))) {

				move.setNextPosition(downRight);
				piece.setPosition(downRight);

				if ((downRight.x == 7) && (this.color == 1)) {
					move.setMadeKing(true);
					piece.setKing(true);
				} // end if

			} else if ((d.equals("dr")) && (p.x < 7) && (p.y < 7)
					&& (pieceDR.getColor() == this.enemyColor(this.color))
					&& (pieceDRx2.getColor() != this.color)
					&& (pieceDRx2.getColor() != this.enemyColor(this.color))
					&& ((piece.isKing()) || (this.color == 1))) {

				move.setNextPosition(downRightx2);
				piece.setPosition(downRightx2);

				move.setEnemyPosition(downRight);
				move.setEnemyRemoved(true);
				move.setEnemyKing(pieceDR.isKing());
				b.removePiece(downRight);

				if ((downRightx2.x == 7) && (this.color == 1)) {

					move.setMadeKing(true);
					piece.setKing(true);

				} else {

					Point downRightx2upLeft = new Point(downRightx2.x - 1,
							downRightx2.y - 1);
					Point downRightx2upRight = new Point(downRightx2.x - 1,
							downRightx2.y + 1);
					Point downRightx2downRight = new Point(downRightx2.x + 1,
							downRightx2.y + 1);
					Point downRightx2downLeft = new Point(downRightx2.x + 1,
							downRightx2.y - 1);

					Piece pieceDRx2UL = b.getPiece(downRightx2upLeft);
					Piece pieceDRx2UR = b.getPiece(downRightx2upRight);
					Piece pieceDRx2DR = b.getPiece(downRightx2downRight);
					Piece pieceDRx2DL = b.getPiece(downRightx2downLeft);

					Point upLeftx3 = new Point(downRightx2.x - 2,
							downRightx2.y - 2);
					Point upRightx3 = new Point(downRightx2.x - 2,
							downRightx2.y + 2);
					Point downRightx3 = new Point(downRightx2.x + 2,
							downRightx2.y + 2);
					Point downLeftx3 = new Point(downRightx2.x + 2,
							downRightx2.y - 2);

					Piece pieceULx3 = b.getPiece(upLeftx3);
					Piece pieceURx3 = b.getPiece(upRightx3);
					Piece pieceDRx3 = b.getPiece(downRightx3);
					Piece pieceDLx3 = b.getPiece(downLeftx3);

					/* up left */
					if (((upLeftx3.x > -1)
							&& (upLeftx3.y > -1)
							&& (pieceDRx2UL.getColor() == this
									.enemyColor(this.color))
							&& (pieceULx3.getColor() != this.color)
							&& (pieceULx3.getColor() != this
									.enemyColor(this.color)) && ((piece
							.isKing()) || (this.color == 0)))
							/* up right */
							|| ((upRightx3.x > -1)
									&& (upRightx3.y < 9)
									&& (pieceDRx2UR.getColor() == this
											.enemyColor(this.color))
									&& (pieceURx3.getColor() != this.color)
									&& (pieceURx3.getColor() != this
											.enemyColor(this.color)) && ((piece
									.isKing()) || (this.color == 0)))
							/* down right */
							|| ((downRightx3.x < 9)
									&& (downRightx3.y < 9)
									&& (pieceDRx2DR.getColor() == this
											.enemyColor(this.color))
									&& (pieceDRx3.getColor() != this.color)
									&& (pieceDRx3.getColor() != this
											.enemyColor(this.color)) && ((piece
									.isKing()) || (this.color == 1)))
							/* down left */
							|| ((downLeftx3.x < 9)
									&& (downLeftx3.y > -1)
									&& (pieceDRx2DL.getColor() == this
											.enemyColor(this.color))
									&& (pieceDLx3.getColor() != this.color)
									&& (pieceDLx3.getColor() != this
											.enemyColor(this.color)) && ((piece
									.isKing()) || (this.color == 1))))
						toggle = false;

				} // end if

			} else if ((d.equals("dl")) && (p.x < 8) && (p.y > 0)
					&& (pieceDL.getColor() != this.color)
					&& (pieceDL.getColor() != this.enemyColor(this.color))
					&& ((piece.isKing()) || (this.color == 1))) {

				move.setNextPosition(downLeft);
				piece.setPosition(downLeft);

				if ((downLeft.x == 7) && (this.color == 1)) {
					move.setMadeKing(true);
					piece.setKing(true);
				} // end if

			} else if ((d.equals("dl")) && (p.x < 7) && (p.y > 1)
					&& (pieceDL.getColor() == this.enemyColor(this.color))
					&& (pieceDLx2.getColor() != this.color)
					&& (pieceDLx2.getColor() != this.enemyColor(this.color))
					&& ((piece.isKing()) || (this.color == 1))) {

				move.setNextPosition(downLeftx2);
				piece.setPosition(downLeftx2);

				move.setEnemyPosition(downLeft);
				move.setEnemyRemoved(true);
				move.setEnemyKing(pieceDL.isKing());
				b.removePiece(downLeft);

				if ((downLeftx2.x == 7) && (this.color == 1)) {

					move.setMadeKing(true);
					piece.setKing(true);

				} else {

					Point downLeftx2upLeft = new Point(downLeftx2.x - 1,
							downLeftx2.y - 1);
					Point downLeftx2upRight = new Point(downLeftx2.x - 1,
							downLeftx2.y + 1);
					Point downLeftx2downRight = new Point(downLeftx2.x + 1,
							downLeftx2.y + 1);
					Point downLeftx2downLeft = new Point(downLeftx2.x + 1,
							downLeftx2.y - 1);

					Piece pieceDLx2UL = b.getPiece(downLeftx2upLeft);
					Piece pieceDLx2UR = b.getPiece(downLeftx2upRight);
					Piece pieceDLx2DR = b.getPiece(downLeftx2downRight);
					Piece pieceDLx2DL = b.getPiece(downLeftx2downLeft);

					Point upLeftx3 = new Point(downLeftx2.x - 2,
							downLeftx2.y - 2);
					Point upRightx3 = new Point(downLeftx2.x - 2,
							downLeftx2.y + 2);
					Point downRightx3 = new Point(downLeftx2.x + 2,
							downLeftx2.y + 2);
					Point downLeftx3 = new Point(downLeftx2.x + 2,
							downLeftx2.y - 2);

					Piece pieceULx3 = b.getPiece(upLeftx3);
					Piece pieceURx3 = b.getPiece(upRightx3);
					Piece pieceDRx3 = b.getPiece(downRightx3);
					Piece pieceDLx3 = b.getPiece(downLeftx3);

					/* up left */
					if (((upLeftx3.x > -1)
							&& (upLeftx3.y > -1)
							&& (pieceDLx2UL.getColor() == this
									.enemyColor(this.color))
							&& (pieceULx3.getColor() != this.color)
							&& (pieceULx3.getColor() != this
									.enemyColor(this.color)) && ((piece
							.isKing()) || (this.color == 0)))
							/* up right */
							|| ((upRightx3.x > -1)
									&& (upRightx3.y < 9)
									&& (pieceDLx2UR.getColor() == this
											.enemyColor(this.color))
									&& (pieceURx3.getColor() != this.color)
									&& (pieceURx3.getColor() != this
											.enemyColor(this.color)) && ((piece
									.isKing()) || (this.color == 0)))
							/* down right */
							|| ((downRightx3.x < 9)
									&& (downRightx3.y < 9)
									&& (pieceDLx2DR.getColor() == this
											.enemyColor(this.color))
									&& (pieceDRx3.getColor() != this.color)
									&& (pieceDRx3.getColor() != this
											.enemyColor(this.color)) && ((piece
									.isKing()) || (this.color == 1)))
							/* down left */
							|| ((downLeftx3.x < 9)
									&& (downLeftx3.y > -1)
									&& (pieceDLx2DL.getColor() == this
											.enemyColor(this.color))
									&& (pieceDLx3.getColor() != this.color)
									&& (pieceDLx3.getColor() != this
											.enemyColor(this.color)) && ((piece
									.isKing()) || (this.color == 1))))
						toggle = false;

				} // end if

			} // end if

			b.setPiece(p, piece);
			if (toggle)
				this.togglePlayer();

		} // end if

		this.moves.add(move);

		this.updateScores(b);

		return b;

	} // end movePiece()

	public Board undoMove(Board b) {

		Move move = this.moves.pop();
		int color = move.getColor();
		Point prev = move.getPrevPosition();
		Point next = move.getNextPosition();
		boolean isEnemyRemoved = move.isEnemyRemoved();
		boolean isMadeKing = move.isMadeKing();
		boolean isKing = move.isKing();

		b.removePiece(next);

		Piece prevPiece = new Piece(color, prev);
		if (isMadeKing)
			prevPiece.setKing(false);
		else if (isKing)
			prevPiece.setKing(true);
		b.setPiece(prev, prevPiece);

		if (isEnemyRemoved) {
			Point enemy = move.getEnemyPosition();
			Piece enemyPiece = new Piece(this.enemyColor(color), enemy);
			if (move.isEnemyKing())
				enemyPiece.setKing(true);
			b.setPiece(enemy, enemyPiece);
		} // end if

		this.updateScores(b);

		return b;

	} // end undoMove()

	public int enemyColor(int c) {
		int result = -1;
		if (c == 0)
			result = 1;
		else if (c == 1)
			result = 0;
		return result;
	} // end enemyColor()

	protected void togglePlayer() {
		if (this.color == 0)
			this.color = 1;
		else if (this.color == 1)
			this.color = 0;
	} // end togglePlayer()

	public void forfeit(int p) {
		if (p == 0)
			System.out.println("Black Player Forfeits!");
		else
			System.out.println("White Player Forfeits!");
		this.gameOver();
	} // end forfeit()

	public void gameOver() {
		if (this.color == 0)
			System.out.println("Black Player Ended Game!");
		else
			System.out.println("White Player Ended Game!");
	} // end gameOver()

	public int getColor() {
		return this.color;
	} // end getColor()

	public void setColor(int c) {
		this.color = c;
	} // end setColor()

	public boolean isGameOver() {
		return this.gameOver;
	} // end isGameOver()

	public void setGameOver(boolean go) {
		this.gameOver = go;
	} // end setGameOver()

	public Stack<Move> getMoves() {
		return this.moves;
	} // end getMoves()

	public void setMoves(Stack<Move> m) {
		this.moves = m;
	} // end setMoves()

	public int[] getScores() {
		return this.scores;
	} // end getScores()

	public void setScores(int[] s) {
		this.scores = s;
	} // end setScores()

} // end class
