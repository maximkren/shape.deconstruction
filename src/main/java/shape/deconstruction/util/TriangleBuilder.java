/**
 * 
 */
package shape.deconstruction.util;

import java.util.ArrayList;
import java.util.List;
import shape.deconstruction.entity.Line;
import shape.deconstruction.entity.Shape;

/**
 * @author Maxim Kren E-mail: krenmaxim@gmail.com 2 дек. 2018 г. 11:03:49
 */
public class TriangleBuilder {

	public Shape buildTriangle(Line line, Shape shape) {

		System.out.println("====start buildTriangle() ====");
		Shape triangle = new Shape();
		List<Line> relatedLines = shape.getRelatedLines(line);

		if ((line.getMidpoint().getY() > shape.getSuppositiveCenterPoint().getY())
				&& (line.getMidpoint().getX() > shape.getSuppositiveCenterPoint().getX())) {

			// primaryLine in NE sector

			int crossingLinesCounter = 0;

			if ((relatedLines != null && relatedLines.size() <= 2)
					&& (relatedLines.get(0).isHorizontalLine() || relatedLines.get(1).isHorizontalLine())) {

				for (Line l : shape.getLines()) {

					if ((l.containsX(line.getMidpoint().getX()) && !l.containsY(line.getMidpoint().getY()))
							&& (l.getMaxY() >= shape.getSuppositiveCenterPoint().getY() && l.getMaxY() <= line.getMinY())) {

						crossingLinesCounter++;

						// horizontal NE hidden corner

						if (line.getStartX() > line.getEndX()) {
							triangle = this.buildTriangleType3(line);
						} else {
							triangle = this.buildTriangleType4(line);
						}
					}
				}

				if (crossingLinesCounter == 0) {

					// horizontal NE normal corner

					if (line.getStartX() > line.getEndX()) {
						triangle = this.buildTriangleType2(line);
					} else {
						triangle = this.buildTriangleType1(line);
					}
				}
			} else if ((relatedLines != null && relatedLines.size() <= 2)
					&& (relatedLines.get(0).isVerticalLine() || relatedLines.get(1).isVerticalLine())) {
				for (Line l : shape.getLines()) {

					if ((l.containsY(line.getMidpoint().getY()) && !l.containsX(line.getMidpoint().getX()))
							&& (l.getMaxX() >= shape.getSuppositiveCenterPoint().getX() && l.getMaxX() <= line.getMinX())) {

						crossingLinesCounter++;

						// vertical NE hidden

						if (line.getStartX() > line.getEndX()) {
							triangle = this.buildTriangleType3(line);
						} else {
							triangle = this.buildTriangleType1(line);
						}

					}
				}

				if (crossingLinesCounter == 0) {

					// vertica NE normal

					if (line.getStartX() > line.getEndX()) {
						triangle = this.buildTriangleType2(line);
					} else {
						triangle = this.buildTriangleType4(line);
					}
				}
			}
		} else if ((line.getMidpoint().getY() > shape.getSuppositiveCenterPoint().getY())
				&& (line.getMidpoint().getX() < shape.getSuppositiveCenterPoint().getX())) {

			// primaryLine in NW sector

			int crossingLinesCounter = 0;

			if ((relatedLines != null && relatedLines.size() <= 2)
					&& (relatedLines.get(0).isHorizontalLine() || relatedLines.get(1).isHorizontalLine())) {

				for (Line l : shape.getLines()) {

					if ((l.containsX(line.getMidpoint().getX()) && !l.containsY(line.getMidpoint().getY()))
							&& (l.getMaxY() >= shape.getSuppositiveCenterPoint().getY() && l.getMaxY() <= line.getMinY())) {

						crossingLinesCounter++;

						// horizontal NW hidden corner

						if (line.getStartX() > line.getEndX()) {
							triangle = this.buildTriangleType3(line);
						} else  {
							triangle = this.buildTriangleType4(line);
						}
					}
				}

				if (crossingLinesCounter == 0) {

					// horizontal NW normal corner

					if (line.getStartX() > line.getEndX()) {
						triangle = this.buildTriangleType2(line);
					} else {
						triangle = this.buildTriangleType1(line);
					}
				}
			} else if ((relatedLines != null && relatedLines.size() <= 2)
					&& (relatedLines.get(0).isVerticalLine() || relatedLines.get(1).isVerticalLine())) {
				for (Line l : shape.getLines()) {

					if ((l.containsY(line.getMidpoint().getY()) && !l.containsX(line.getMidpoint().getX()))
							&& (l.getMinX() <= shape.getSuppositiveCenterPoint().getX()&& l.getMinX() >= line.getMaxX())) {

						crossingLinesCounter++;

						// vertical NW hidden

						if (line.getStartX() > line.getEndX()) {
							triangle = this.buildTriangleType2(line);
						} else {
							triangle = this.buildTriangleType4(line);
						}

					}
				}

				if (crossingLinesCounter == 0) {

					// vertical NW normal

					if (line.getStartX() > line.getEndX()) {
						triangle = this.buildTriangleType3(line);
					} else {
						triangle = this.buildTriangleType1(line);
					}
				}
			}
		} else if ((line.getMidpoint().getY() < shape.getSuppositiveCenterPoint().getY())
				&& (line.getMidpoint().getX() > shape.getSuppositiveCenterPoint().getX())) {

			// primaryLine in SE sector

			int crossingLinesCounter = 0;

			if ((relatedLines != null && relatedLines.size() <= 2)
					&& (relatedLines.get(0).isHorizontalLine() || relatedLines.get(1).isHorizontalLine())) {

				for (Line l : shape.getLines()) {

					if ((l.containsX(line.getMidpoint().getX()) && !l.containsY(line.getMidpoint().getY()))
							&& (l.getMinY() <= shape.getSuppositiveCenterPoint().getY() && l.getMinY() >= line.getMaxY())) {

						// horizonta SE hidden corner

						crossingLinesCounter++;

						if (line.getStartX() > line.getEndX()) {
							triangle = this.buildTriangleType2(line);
						} else {
							triangle = this.buildTriangleType1(line);
						}
					}
				}

				if (crossingLinesCounter == 0) {

					// horizontal SE normal corner

					if (line.getStartX() > line.getEndX()) {
						triangle = this.buildTriangleType3(line);
					} else {
						triangle = this.buildTriangleType4(line);
					}
				}
			} else if ((relatedLines != null && relatedLines.size() <= 2)
					&& (relatedLines.get(0).isVerticalLine() || relatedLines.get(1).isVerticalLine())) {

				for (Line l : shape.getLines()) {

					if ((l.containsY(line.getMidpoint().getY()) && !l.containsX(line.getMidpoint().getX()))
							&& (l.getMinX() >= shape.getSuppositiveCenterPoint().getX() && l.getMinX() <= line.getMinX())) {

						crossingLinesCounter++;

						// vertical SE hidden corner

						if (line.getStartX() > line.getEndX()) {
							triangle = this.buildTriangleType3(line);
						} else {
							triangle = this.buildTriangleType1(line);
						}

					}
				}

				if (crossingLinesCounter == 0) {
					// vertical SE normal corner
					if (line.getStartX() > line.getEndX()) {
						triangle = this.buildTriangleType2(line);
					} else {
						triangle = this.buildTriangleType4(line);
					}
				}
			}
		} else if ((line.getMidpoint().getY() < shape.getSuppositiveCenterPoint().getY())
				&& (line.getMidpoint().getX() < shape.getSuppositiveCenterPoint().getX())) {

			// SW sector

			int crossingLinesCounter = 0;

			if ((relatedLines != null && relatedLines.size() <= 2)
					&& (relatedLines.get(0).isHorizontalLine() || relatedLines.get(1).isHorizontalLine())) {

				for (Line l : shape.getLines()) {

					if ((l.containsX(line.getMidpoint().getX()) && !l.containsY(line.getMidpoint().getY()))
							&& (l.getMinY() <= shape.getSuppositiveCenterPoint().getY() && l.getMinY() >= line.getMaxY())) {

						crossingLinesCounter++;

						// horizontal SW hidden corner

						if (line.getStartX() > line.getEndX()) {
							triangle = this.buildTriangleType2(line);
						} else {
							triangle = this.buildTriangleType1(line);
						}
					}
				}

				if (crossingLinesCounter == 0) {
					// horizontal SW normal corner

					if (line.getStartX() > line.getEndX()) {
						triangle = this.buildTriangleType3(line);
					} else {
						triangle = this.buildTriangleType4(line);
					}
				}
			} else if ((relatedLines != null && relatedLines.size() <= 2)
					&& (relatedLines.get(0).isVerticalLine() || relatedLines.get(1).isVerticalLine())) {

				for (Line l : shape.getLines()) {

					if ((l.containsY(line.getMidpoint().getY()) && !l.containsX(line.getMidpoint().getX()))
							&& (l.getMinX() <= shape.getSuppositiveCenterPoint().getX() && l.getMinX() >= line.getMaxX())) {

						crossingLinesCounter++;

						// vertical SW hidden corner
						if (line.getStartX() > line.getEndX()) {
							triangle = this.buildTriangleType2(line);
						} else {
							triangle = this.buildTriangleType4(line);
						}

					}
				}

				if (crossingLinesCounter == 0) {
					// SW normal
					if (line.getStartX() > line.getEndX()) {
						triangle = this.buildTriangleType3(line);
					} else {
						triangle = this.buildTriangleType1(line);
					}
				}
			}
		}
		for (Line l : triangle.getLines()) {
			System.out.println(l);
		}
		// add to archetypal list of lines generated cathetus of triangle
		System.out.println("write new sides to main polygon");
		shape.getLines().add(triangle.getLines().get(0));
		shape.getLines().add(triangle.getLines().get(1));
		System.out.println("remove current angle line");
		shape.getLines().remove(line);
		return triangle;
	}

	private Shape buildTriangleType1(Line line) {
		System.out.println("====start buildTriangleType1()====");
		Shape triangleType1 = new Shape();
		List<Line> sideList = new ArrayList<Line>();

		Line vertCath = new Line();
		Line horizCath = new Line();

		vertCath.setStartX(line.getEndX());
		vertCath.setStartY(line.getStartY());
		vertCath.setEndX(line.getEndX());
		vertCath.setEndY(line.getEndY());

		horizCath.setStartX(line.getStartX());
		horizCath.setStartY(line.getStartY());
		horizCath.setEndX(line.getEndX());
		horizCath.setEndY(line.getStartY());

		sideList.add(vertCath);
		sideList.add(horizCath);
		sideList.add(line);
		triangleType1.setLines(sideList);

		return triangleType1;
	}

	private Shape buildTriangleType2(Line line) {
		System.out.println("====start buildTriangleType2()====");
		Shape triangleType2 = new Shape();
		List<Line> sideList = new ArrayList<Line>();

		Line vertCath = new Line();
		Line horizCath = new Line();

		vertCath.setStartX(line.getEndX());
		vertCath.setStartY(line.getStartY());
		vertCath.setEndX(line.getEndX());
		vertCath.setEndY(line.getEndY());

		horizCath.setStartX(line.getEndX());
		horizCath.setStartY(line.getStartY());
		horizCath.setEndX(line.getStartX());
		horizCath.setEndY(line.getStartY());

		sideList.add(vertCath);
		sideList.add(horizCath);
		sideList.add(line);
		triangleType2.setLines(sideList);

		return triangleType2;
	}

	private Shape buildTriangleType3(Line line) {
		System.out.println("====start buildTriangleType3()====");
		Shape triangleType3 = new Shape();
		List<Line> sideList = new ArrayList<Line>();

		Line vertCath = new Line();
		Line horizCath = new Line();

		vertCath.setStartX(line.getStartX());
		vertCath.setStartY(line.getStartY());
		vertCath.setEndX(line.getStartX());
		vertCath.setEndY(line.getEndY());

		horizCath.setStartX(line.getEndX());
		horizCath.setStartY(line.getEndY());
		horizCath.setEndX(line.getStartX());
		horizCath.setEndY(line.getEndY());

		sideList.add(vertCath);
		sideList.add(horizCath);
		sideList.add(line);
		triangleType3.setLines(sideList);

		return triangleType3;
	}

	private Shape buildTriangleType4(Line line) {
		System.out.println("====start buildTriangleType4()====");
		Shape triangleType4 = new Shape();
		List<Line> sideList = new ArrayList<Line>();

		Line vertCath = new Line();
		Line horizCath = new Line();

		vertCath.setStartX(line.getStartX());
		vertCath.setStartY(line.getStartY());
		vertCath.setEndX(line.getStartX());
		vertCath.setEndY(line.getEndY());

		horizCath.setStartX(line.getStartX());
		horizCath.setStartY(line.getEndY());
		horizCath.setEndX(line.getEndX());
		horizCath.setEndY(line.getEndY());

		sideList.add(vertCath);
		sideList.add(horizCath);
		sideList.add(line);
		triangleType4.setLines(sideList);

		return triangleType4;
	}

}
