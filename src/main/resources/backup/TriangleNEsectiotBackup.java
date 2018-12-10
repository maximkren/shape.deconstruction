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
public class ShapeBuilder {

	public Shape buildTriangle(Line pl, Shape cs) {
		System.out.println("====start buildTriangle() ====");
		Shape triangle = new Shape();
		// relatedLines
		List<Line> rl = cs.getRelatedLines(pl);

		if ((pl.getMedianOfLine().getY() > cs.getMedianPointOfShape().getY())
				&& (pl.getMedianOfLine().getX() > cs.getMedianPointOfShape().getX())) {

			// primaryLine in NE sector

			System.out.println("primaryLine in NE sector");

			int crossingLinesCounter = 0;

			if ((rl != null && rl.size() <= 2) && (rl.get(0).isHorizontalLine() || rl.get(1).isHorizontalLine())) {

				for (Line l : cs.getShapeLine()) {

					if ((l.containsX(pl.getMedianOfLine().getX()) && !l.containsY(pl.getMedianOfLine().getY()))
							&& (l.getMinY() >= cs.getMedianPointOfShape().getY() && l.getMinY() <= pl.getMinY())
							&& (l.getMaxY() >= cs.getMedianPointOfShape().getY() && l.getMaxY() <= pl.getMinY())) {
						crossingLinesCounter++;
						// primaryLine belongs to NE vertical
						System.out.println("primaryLine belongs to NE vertical");
						if (pl.getStartX() > pl.getEndX()) {
							System.out.println("call t2");
							System.out.println(l);
							triangle = this.buildTriangleType2(pl);
						} else if (pl.getStartX() < pl.getEndX()) {
							System.out.println("call t4");
							System.out.println(l);
							triangle = this.buildTriangleType4(pl);
						}
					}
				}
				if (crossingLinesCounter == 0) {
					// primaryLine belongs to NE horizontal
					System.out.println("primaryLine belongs to NE vertical");
					if (pl.getStartX() > pl.getEndX()) {
//					System.out.println("call t2");
//					System.out.println(l);
						triangle = this.buildTriangleType2(pl);
					} else if (pl.getStartX() < pl.getEndX()) {
//					System.out.println("call t4");
//					System.out.println(l);
						triangle = this.buildTriangleType1(pl);
					}
				}
			} else if ((rl != null && rl.size() <= 2) && (rl.get(0).isVerticalLine() || rl.get(1).isVerticalLine())) {
				System.out.println("pass vert");
				for (Line l : cs.getShapeLine()) {

					if ((l.containsY(pl.getMedianOfLine().getY()) && !l.containsX(pl.getMedianOfLine().getX()))
							&& (l.getMinX() >= cs.getMedianPointOfShape().getX() && l.getMinX() <= pl.getMinX())
							&& (l.getMaxX() >= cs.getMedianPointOfShape().getX() && l.getMaxX() <= pl.getMinX())) {
						crossingLinesCounter++;
						// primaryLine belongs to NE vertical
						System.out.println("primaryLine belongs to NE vertical");
						if (pl.getStartX() > pl.getEndX()) {
							System.out.println("call t2");
							System.out.println(l);
							triangle = this.buildTriangleType3(pl);
						} else if (pl.getStartX() < pl.getEndX()) {
							System.out.println("call t4");
							System.out.println(l);
							triangle = this.buildTriangleType1(pl);
						}

					}
				}
				if (crossingLinesCounter == 0) {
					System.out.println("vert count = 0");
					// primaryLine belongs to NE horizontal
					System.out.println("primaryLine belongs to NE vertical");
					if (pl.getStartX() > pl.getEndX()) {
//					System.out.println("call t2");
//					System.out.println(l);
						triangle = this.buildTriangleType2(pl);
					} else if (pl.getStartX() < pl.getEndX()) {
//					System.out.println("call t4");
//					System.out.println(l);
						triangle = this.buildTriangleType1(pl);
					}
				}
			}

		}
		for (Line l : triangle.getShapeLine()) {
			System.out.println(l);
		}
		// add to archetypal list of lines generated cathetus of triangle
		System.out.println("запись новых элементов в исходный список");
		cs.getShapeLine().add(triangle.getShapeLine().get(0));
		cs.getShapeLine().add(triangle.getShapeLine().get(1));

		// remove angle from archetypal list
		System.out.println("удаление базовой наклонной из исходного списка");
		cs.getShapeLine().remove(pl);
//		System.out.println("====выход из метода====");
		return triangle;
	}

	private Shape buildTriangleType1(Line primaryLine) {
		System.out.println("====start buildTriangleType1()====");
		Shape triangleType1 = new Shape();
		List<Line> sideList = new ArrayList<Line>();

		Line vertCath = new Line();
		Line horizCath = new Line();

		vertCath.setStartX(primaryLine.getEndX());
		vertCath.setStartY(primaryLine.getStartY());
		vertCath.setEndX(primaryLine.getEndX());
		vertCath.setEndY(primaryLine.getEndY());

		horizCath.setStartX(primaryLine.getStartX());
		horizCath.setStartY(primaryLine.getStartY());
		horizCath.setEndX(primaryLine.getEndX());
		horizCath.setEndY(primaryLine.getStartY());

		sideList.add(vertCath);
		sideList.add(horizCath);
		sideList.add(primaryLine);
		triangleType1.setShapeLine(sideList);

		return triangleType1;
	}

	private Shape buildTriangleType2(Line primaryLine) {
		System.out.println("====start buildTriangleType2()====");
		Shape triangleType2 = new Shape();
		List<Line> sideList = new ArrayList<Line>();

		Line vertCath = new Line();
		Line horizCath = new Line();

		vertCath.setStartX(primaryLine.getEndX());
		vertCath.setStartY(primaryLine.getStartY());
		vertCath.setEndX(primaryLine.getEndX());
		vertCath.setEndY(primaryLine.getEndY());

		horizCath.setStartX(primaryLine.getEndX());
		horizCath.setStartY(primaryLine.getStartY());
		horizCath.setEndX(primaryLine.getStartX());
		horizCath.setEndY(primaryLine.getStartY());

		sideList.add(vertCath);
		sideList.add(horizCath);
		sideList.add(primaryLine);
		triangleType2.setShapeLine(sideList);

		return triangleType2;
	}

	private Shape buildTriangleType3(Line primaryLine) {
		System.out.println("====start buildTriangleType3()====");
		Shape triangleType3 = new Shape();
		List<Line> sideList = new ArrayList<Line>();

		Line vertCath = new Line();
		Line horizCath = new Line();

		vertCath.setStartX(primaryLine.getStartX());
		vertCath.setStartY(primaryLine.getStartY());
		vertCath.setEndX(primaryLine.getStartX());
		vertCath.setEndY(primaryLine.getEndY());

		horizCath.setStartX(primaryLine.getEndX());
		horizCath.setStartY(primaryLine.getEndY());
		horizCath.setEndX(primaryLine.getStartX());
		horizCath.setEndY(primaryLine.getEndY());

		sideList.add(vertCath);
		sideList.add(horizCath);
		sideList.add(primaryLine);
		triangleType3.setShapeLine(sideList);

		return triangleType3;
	}

	private Shape buildTriangleType4(Line primaryLine) {
		System.out.println("====start buildTriangleType4()====");
		Shape triangleType4 = new Shape();
		List<Line> sideList = new ArrayList<Line>();

		Line vertCath = new Line();
		Line horizCath = new Line();

		vertCath.setStartX(primaryLine.getStartX());
		vertCath.setStartY(primaryLine.getStartY());
		vertCath.setEndX(primaryLine.getStartX());
		vertCath.setEndY(primaryLine.getEndY());

		horizCath.setStartX(primaryLine.getStartX());
		horizCath.setStartY(primaryLine.getEndY());
		horizCath.setEndX(primaryLine.getEndX());
		horizCath.setEndY(primaryLine.getEndY());

		sideList.add(vertCath);
		sideList.add(horizCath);
		sideList.add(primaryLine);
		triangleType4.setShapeLine(sideList);

		return triangleType4;
	}

}
