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
 * @author Maxim Kren E-mail: krenmaxim@gmail.com 2 дек. 2018 г. 22:21:24
 */
public class UtilPoint {

	public List<Point> sortByX(List<Point> p) {

		List<Point> sortedPointList = p;

// bubble sort
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < p.size() - 1; i++) {
				if (p.get(i).getX() > p.get(i + 1).getX()) {
					isSorted = false;

					p.add(i + 2, p.get(i));
					p.remove(i);
				}
			}

		}

		return sortedPointList;
	}

	public List<Point> sortByY(List<Point> p) {

		List<Point> sortedPointList = p;

// bubble sort
		boolean isSorted = false;

		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < p.size() - 1; i++) {
				if (p.get(i).getY() > p.get(i + 1).getY()) {
					isSorted = false;

					p.add(i + 2, p.get(i));
					p.remove(i);
				}
			}
		}

		return sortedPointList;
	}

	public List<Point> getAllUniquePoints(Shape s) {

		List<Point> p = this.getAllPoints(s);

		for (int i = 0; i < p.size() - 1; i++) {

			for (int k = (i + 1); k < p.size(); k++) {

				if (p.get(i).getX() == p.get(k).getX() && p.get(i).getY() == p.get(k).getY()) {
					p.remove(k);
					break;
				}

			}

		}

		return p;
	}

	public List<Point> getAllUniquePointsOfLine(List<Line> l) {

		Shape s = new Shape();
		s.setLines(l);

		List<Point> p = this.getAllUniquePoints(s);

		for (int i = 0; i < p.size() - 1; i++) {

			for (int k = (i + 1); k < p.size(); k++) {

				if (p.get(i).getX() == p.get(k).getX() && p.get(i).getY() == p.get(k).getY()) {
					p.remove(k);
					break;
				}

			}

		}

		return p;
	}

	private List<Point> getAllPoints(Shape shape) {
		List<Point> point = new ArrayList<Point>();

		for (Line line : shape.getLines()) {

			Point startPoint = new Point();
			Point endPoint = new Point();

			startPoint.setX(line.getStartX());
			startPoint.setY(line.getStartY());

			endPoint.setX(line.getEndX());
			endPoint.setY(line.getEndY());
			point.add(startPoint);
			point.add(endPoint);

		}
		return point;
	}
}
