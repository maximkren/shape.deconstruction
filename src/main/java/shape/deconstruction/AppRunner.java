/**
 * 
 */
package shape.deconstruction;

import java.util.ArrayList;
import java.util.List;

import shape.deconstruction.entity.Shape;
import shape.deconstruction.io.JsonPojoManipulator;
import shape.deconstruction.util.ShapeNormalizer;
import shape.deconstruction.util.TriangleBuilder;

/**
 * @author Maxim Kren E-mail: krenmaxim@gmail.com 29 но€б. 2018 г. 15:40:58
 */
public class AppRunner {

	public static void main(String[] args) {

		String urlReadFrom = "src/main/resources/source.json";
		String urlWriteTo = "src/main/resources/result.json";
		String urlWriteTo2 = "src/main/resources/test1.json";
		
		
		Shape compositeShape = new ShapeNormalizer().normalizeShapeLines(JsonPojoManipulator.readFromJSON(urlReadFrom));

		List<Shape> regularShapes = new ArrayList<Shape>();
	

		regularShapes.add(new TriangleBuilder().buildTriangle(compositeShape.getLines().get(3), compositeShape));
		regularShapes.add(new TriangleBuilder().buildTriangle(compositeShape.getLines().get(2), compositeShape));

		JsonPojoManipulator.writeToJSON(urlWriteTo, regularShapes);
		JsonPojoManipulator.writeToJSON(urlWriteTo2, compositeShape);


		System.out.println("size " + compositeShape.getLines().size());

	}

}
