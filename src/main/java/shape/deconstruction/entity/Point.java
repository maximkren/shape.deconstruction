/**
 * 
 */
package shape.deconstruction.entity;

/**
 * @author Maxim Kren E-mail: krenmaxim@gmail.com 1 дек. 2018 г. 11:06:26
 */
public class Point {

	private double x;
	private double y;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point X,Y [" + x + ":" + y + "]";
	}

}
