/**
 * Triple - data structure for holding instances of three different data
 * structures together in a list.
 * 
 * @author Haoran Ma (mahaoran1020@gmail.com), Adam Steinberger
 *         (steinz08@gmail.com)
 * 
 * @param <L>
 * @param <C>
 * @param <R>
 */
public class Triple<L, C, R> {

	private L left;
	private C center;
	private R right;

	public Triple(L l, C c, R r) {
		this.left = l;
		this.center = c;
		this.right = r;
	} // end constructor

	public L getLeft() {
		return this.left;
	} // end getLeft()

	public void setLeft(L left) {
		this.left = left;
	} // end setLeft()

	public R getRight() {
		return this.right;
	} // end getRight()

	public void setRight(R right) {
		this.right = right;
	} // end setRight()

	public C getCenter() {
		return this.center;
	} // end getCenter()

	public void setCenter(C center) {
		this.center = center;
	} // end setCenter()

} // end class