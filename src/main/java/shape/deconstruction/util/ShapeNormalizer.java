/**
 * 
 */
package shape.deconstruction.util;

import java.util.ArrayList;

import shape.deconstruction.entity.Line;
import shape.deconstruction.entity.Shape;

/**
 * @author Maxim Kren E-mail: krenmaxim@gmail.com 30 но€б. 2018 г. 18:30:55
 */
public class ShapeNormalizer {

	public Shape normalizeShapeLines(Shape shape) {

//this method analyze lines and check that start-to-end coordinates is from bottom to top & from left to right
		Shape normalizedShape = new Shape();
		ArrayList<Line> normalizedList = new ArrayList<Line>();

		for (Line line : shape.getLines()) {

			if ((line.getStartX() == line.getEndX()) && (line.getStartY() != line.getEndY())) {

//				from bottom to top 

				if (line.getStartY() > line.getEndY()) {
//					if conversely

					Line tempLine = new Line();

					tempLine.setStartX(line.getStartX());
					tempLine.setEndX(line.getEndX());
					tempLine.setStartY(line.getEndY());
					tempLine.setEndY(line.getStartY());

					normalizedList.add(tempLine);

				} else {
//					if normal

					normalizedList.add(line);
				}

			} else if ((line.getStartX() != line.getEndX()) && (line.getStartY() == line.getEndY())) {

//				from left to right

				if (line.getStartX() > line.getEndX()) {

//					if conversely

					Line tempLine = new Line();

					tempLine.setStartX(line.getEndX());
					tempLine.setEndX(line.getStartX());
					tempLine.setStartY(line.getStartY());
					tempLine.setEndY(line.getEndY());

					normalizedList.add(tempLine);

				} else {
//					if normal
					normalizedList.add(line);
				}

			} else if ((line.getEndX() > line.getStartX()) && (line.getEndY() > line.getStartY())) {

//			right-up slant (/)
				normalizedList.add(line);

			} else if ((line.getEndX() < line.getStartX()) && (line.getEndY() < line.getStartY())) {

//			left-down slant (/)

				Line tempLine = new Line();

				tempLine.setStartX(line.getStartY());
				tempLine.setEndX(line.getEndY());
				tempLine.setStartY(line.getStartX());
				tempLine.setEndY(line.getEndX());

				normalizedList.add(tempLine);

			} else if ((line.getEndX() > line.getStartX()) && (line.getEndY() < line.getStartY())) {

//			right-down slant (\\)

				Line tempLine = new Line();

				tempLine.setStartX(line.getStartY());
				tempLine.setEndX(line.getEndY());
				tempLine.setStartY(line.getStartX());
				tempLine.setEndY(line.getEndX());

				normalizedList.add(tempLine);

			} else if ((line.getEndX() < line.getStartX()) && (line.getEndY() > line.getStartY())) {

//			left-up slant (\\)
				normalizedList.add(line);

			}

		}
		normalizedShape.setLines(normalizedList);
		return normalizedShape;
	}

}
