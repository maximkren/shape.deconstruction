/**
 * 
 */
package shape.deconstruction.util.entityUtil;

import java.util.ArrayList;
import java.util.List;

import shape.deconstruction.entity.Line;
import shape.deconstruction.entity.Point;
import shape.deconstruction.entity.Shape;

/**
 * @author Maxim Kren E-mail: krenmaxim@gmail.com 1 дек. 2018 г. 23:33:36
 */
public class UtilLine {

	public Point getMedianOfLine(Line line) {
		Point medianPoint = new Point();
		medianPoint.setX((double) (line.getStartX() + line.getEndX()) / 2);
		medianPoint.setY((double) (line.getStartY() + line.getEndY()) / 2);
		return medianPoint;
	}

	public List<Point> getMedianPointList(List<Line> lineList) {
		List<Point> pointList = new ArrayList<Point>();

		for (Line line : lineList) {
			Point point = new Point();
			point.setX(this.getMedianOfLine(line).getX());
			point.setY(this.getMedianOfLine(line).getY());
			pointList.add(point);
		}

		return pointList;
	}

	public List<Line> getAllAngles(List<Line> lines) {
		List<Line> angle = new ArrayList<Line>();
		for (Line line : lines) {
			if (this.isAngleLine(line))
				angle.add(line);
		}

		return angle;
	}

	public double getLengthOfLine(Line line) {

		if ((line.getStartX() == line.getEndX() && line.getStartY() != line.getEndY())
				|| (line.getStartX() != line.getEndX() && line.getStartY() == line.getEndY())) {
//      vertical or horizontal length
			return Math.abs((line.getEndX() - line.getStartX()) + (line.getEndY() - line.getStartY()));
		} else if (line.getStartX() != line.getEndX() || line.getStartY() != line.getEndY()) {
//      slant length
			return Math.sqrt(Math.pow(Math.abs(line.getEndX() - line.getStartX()), 2)
					+ Math.pow(Math.abs(line.getEndY() - line.getStartY()), 2));
		}

		return 0.0;
	}

	public boolean isAngleLine(Line line) {
		if (line.getStartX() != line.getEndX() || line.getStartY() != line.getEndY())
			return true;
		return false;
	}

	public boolean isVerticalLine(Line line) {
		if (line.getStartX() == line.getEndX() && line.getStartY() != line.getEndY())
			return true;
		return false;
	}

	public boolean isHorizontalLine(Line line) {
		if (line.getStartX() != line.getEndX() && line.getStartY() == line.getEndY())
			return true;
		return false;
	}
//--
	public boolean isLineContainsPoint(Line line, Point p) {

		if ((p.getX() == line.getStartX() && p.getY() == line.getStartY())
				|| (p.getX() == line.getEndX() && p.getY() == line.getEndY()))
			return true;

		return false;
	}

	public boolean isSameLine(Line line1, Line line2) {

		if ((line1.getStartX() == line2.getStartX()) && (line1.getStartY() == line2.getStartY())
				&& (line1.getEndX() == line2.getEndX()) && (line1.getEndY() == line2.getEndY()))
			return true;

		return false;
	}

	public boolean isSideOfSimpleShape(Shape baseShape, Line line) {

		Point p1 = new Point();
		Point p2 = new Point();
		p1.setX(line.getStartX());
		p1.setY(line.getStartY());
		p2.setX(line.getEndX());
		p2.setY(line.getEndY());

		List<Line> lines = new ArrayList<Line>();
		lines.add(line);

		for (Line l : baseShape.getLines()) {

			if ((this.isLineContainsPoint(l, p1) || this.isLineContainsPoint(l, p2)) && !this.isSameLine(l, line)) {
				lines.add(l);
			}

		}

		if (this.isAngleLine(line)) {
			List<Point> pointsOfCollectedLines = new UtilPoint().getAllUniquePointsOfLine(lines);

			if (pointsOfCollectedLines.size() == 3) {
//then this is triangle
			}

		}

		return false;
	}

}
