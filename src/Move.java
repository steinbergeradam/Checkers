import java.awt.Point;

/**
 * Move - keep track of everything that changes on game board for each move.
 * 
 * @author Haoran Ma (mahaoran1020@gmail.com), Adam Steinberger
 *         (steinz08@gmail.com)
 * 
 */
public class Move {

	private int color;
	private String direction = "ul";
	private Point prevPosition;
	private Point nextPosition;
	private Point enemyPosition;
	private boolean isEnemyRemoved = false;
	private boolean isMadeKing = false;
	private boolean isKing = false;
	private boolean isEnemyKing = false;
	private int score = 0;
	private int counter;
	private static int counterOfMove;

	public Move(int c, boolean k, Point prev) {
		this.color = c;
		this.isKing = k;
		this.prevPosition = prev;
		counter = counterOfMove;
		counterOfMove++;
	} // end constructor

	public Move(int c, boolean k, boolean ek, Point prev, Point next,
			Point enemy) {
		this.color = c;
		this.isKing = k;
		this.isEnemyKing = ek;
		this.prevPosition = prev;
		this.nextPosition = next;
		this.enemyPosition = enemy;
		this.isEnemyRemoved = true;
		counter = counterOfMove;
		counterOfMove++;
	} // end constructor

	public Move(int c, boolean k, Point prev, Point next) {
		this.color = c;
		this.isKing = k;
		this.prevPosition = prev;
		this.nextPosition = next;
		this.isEnemyRemoved = false;
		counter = counterOfMove;
		counterOfMove++;
	} // end constructor

	@Override
	public String toString() {
		return "Move [color=" + color + ", direction=" + direction
				+ ", prevPosition=" + prevPosition + ", nextPosition="
				+ nextPosition + ", enemyPosition=" + enemyPosition
				+ ", isEnemyRemoved=" + isEnemyRemoved + ", isMadeKing="
				+ isMadeKing + ", isKing=" + isKing + ", isEnemyKing="
				+ isEnemyKing + ", score=" + score + ", counter=" + counter
				+ "]";
	}

	public int getCounter() {
		return this.counter;
	} // end getCounter()

	public void setCounter(int c) {
		this.counter = c;
	} // end setCounter()

	public int getColor() {
		return this.color;
	} // end getColor()

	public void setColor(int c) {
		this.color = c;
	} // end setColor()

	public boolean isEnemyRemoved() {
		return this.isEnemyRemoved;
	} // end isEnemyRemoved()

	public void setEnemyRemoved(boolean er) {
		this.isEnemyRemoved = er;
	} // end setEnemyRemoved()

	public Point getEnemyPosition() {
		return this.enemyPosition;
	} // end getEnemyPosition()

	public void setEnemyPosition(Point ep) {
		this.enemyPosition = ep;
	} // end setEnemyPosition()

	public Point getNextPosition() {
		return this.nextPosition;
	} // end getNextPosition()

	public void setNextPosition(Point np) {
		this.nextPosition = np;
	} // end setNextPosition()

	public Point getPrevPosition() {
		return this.prevPosition;
	} // end getPrevPosition()

	public void setPrevPosition(Point pp) {
		this.prevPosition = pp;
	} // end setPrevPosition()

	public boolean isMadeKing() {
		return this.isMadeKing;
	} // end isMadeKing()

	public void setMadeKing(boolean mk) {
		this.isMadeKing = mk;
	} // end setMadeKing()

	public boolean isKing() {
		return this.isKing;
	} // end isKing()

	public void setKing(boolean k) {
		this.isKing = k;
	} // end setKing()

	public boolean isEnemyKing() {
		return this.isEnemyKing;
	} // end isEnemyKing()

	public void setEnemyKing(boolean ek) {
		this.isEnemyKing = ek;
	} // end setEnemyKing()

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

} // end class
