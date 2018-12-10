/**
 * 
 */
package shape.deconstruction.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author Maxim Kren E-mail: krenmaxim@gmail.com 29 но€б. 2018 г. 11:34:58
 */
public class Line {

	@SerializedName("startX")
	private double startX;
	@SerializedName("startY")
	private double startY;
	@SerializedName("endX")
	private double endX;
	@SerializedName("endY")
	private double endY;

	public Point getMidpoint() {
		Point medianPoint = new Point();
		medianPoint.setX((double) (startX + endX) / 2);
		medianPoint.setY((double) (startY + endY) / 2);
		return medianPoint;
	}

	public double getLengthOfLine(Line line) {

		if (this.isHorizontalLine() || this.isVerticalLine()) {
//			(line.getStartX() == line.getEndX() && line.getStartY() != line.getEndY())
//			|| (line.getStartX() != line.getEndX() && line.getStartY() == line.getEndY())
//      vertical or horizontal length
			return Math.abs((endX - startX) + (endY - startY));

		} else if (this.isAngleLine()) {
//      slant length
			return Math.sqrt(Math.pow(Math.abs(endX - startX), 2) + Math.pow(Math.abs(endY - startY), 2));
		}

		return 0.0;
	}

	// =======================================================

	public double getMinX() {
		if (startX < endX)
			return startX;
		return endX;
	}

	public double getMaxX() {
		if (startX > endX)
			return startX;
		return endX;
	}

	public double getMinY() {
		if (startY < endY)
			return startY;
		return endY;
	}

	public double getMaxY() {
		if (startY > endY)
			return startY;
		return endY;
	}

	// =======================================================

	public boolean containsX(double x) {
		if (startX >= x && x >= endX) {
			return true;
		} else if (startX <= x && x <= endX) {
			return true;
		}
		return false;
	}

	public boolean containsY(double y) {
		if (startY >= y && y >= endY) {
			return true;
		} else if (startY <= y && y <= endY) {
			return true;
		}
		return false;
	}

	public boolean isSameLine(Line comparedLine) {

		if ((startX == comparedLine.getStartX()) && (startY == comparedLine.getStartY())
				&& (endX == comparedLine.getEndX()) && (endY == comparedLine.getEndY()))
			return true;

		return false;
	}

	public boolean isAngleLine() {
		if (startX != endX && startY != endY)
			return true;
		return false;
	}

	public boolean isVerticalLine() {
		if (startX == endX && startY != endY)
			return true;
		return false;
	}

	public boolean isHorizontalLine() {
		if (startX != endX && startY == endY)
			return true;
		return false;
	}

	// =======================================================

	public Point getStartPoint() {

		Point startPoint = new Point();

		startPoint.setX(startX);
		startPoint.setY(startY);

		return startPoint;
	}

	public Point getEndPoint() {

		Point endPoint = new Point();

		endPoint.setX(endX);
		endPoint.setY(endY);

		return endPoint;
	}

	// ========================================================

	public double getStartX() {
		return startX;
	}

	public void setStartX(double startX) {
		this.startX = startX;
	}

	public double getStartY() {
		return startY;
	}

	public void setStartY(double startY) {
		this.startY = startY;
	}

	public double getEndX() {
		return endX;
	}

	public void setEndX(double endX) {
		this.endX = endX;
	}

	public double getEndY() {
		return endY;
	}

	public void setEndY(double endY) {
		this.endY = endY;
	}

	// ========================================================

	@Override
	public String toString() {

		return "Start X,Y [" + startX + ":" + startY + "]\r" + "End X,Y [" + endX + ":" + endY + "]";
	}

}
