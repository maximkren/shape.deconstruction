/**
 * 
 */
package shape.deconstruction.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Kren E-mail: krenmaxim@gmail.com 29 но€б. 2018 г. 12:08:18
 */
public class Shape {

	private List<Line> lines;

	// =================================

	public List<Line> getRelatedLines(Line primaryLine) {
		List<Line> relatedLines = new ArrayList<Line>();

		for (Line line : this.getLinesByCoordinates(primaryLine.getStartPoint().getX(),
				primaryLine.getStartPoint().getY())) {
			// if not the same line
			if (!primaryLine.isSameLine(line)) {
				relatedLines.add(line);
			}
		}

		for (Line line : this.getLinesByCoordinates(primaryLine.getEndPoint().getX(),
				primaryLine.getEndPoint().getY())) {
			// if not the same line
			if (!primaryLine.isSameLine(line)) {
				relatedLines.add(line);
			}
		}
		return relatedLines;
	}

	public List<Line> getLinesByCoordinates(double x, double y) {
		// return the list of lines which contains point with defined coordinates but
		// NOT THE SAME LINE
		List<Line> matchedLines = new ArrayList<Line>();
		for (Line l : lines) {
			if ((l.getStartX() == x && l.getStartY() == y) || (l.getEndX() == x && l.getEndY() == y))
				matchedLines.add(l);
		}
		return matchedLines;
	}

	public Point getSuppositiveCenterPoint() {
		// this method calculate average value from all XY values
		Point medianPoint = new Point();
		double sumX = 0;
		double sumY = 0;

		for (Line line : lines) {
			sumX += line.getStartX();
			sumX += line.getEndX();
			sumY += line.getStartY();
			sumY += line.getEndY();
		}

		medianPoint.setX(sumX / (lines.size() * 2));
		medianPoint.setY(sumY / (lines.size() * 2));
		return medianPoint;
	}

	// =================================

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}
}
