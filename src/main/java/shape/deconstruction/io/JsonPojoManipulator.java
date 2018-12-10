/**
 * 
 */
package shape.deconstruction.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import shape.deconstruction.entity.Shape;

/**
 * @author Maxim Kren E-mail: krenmaxim@gmail.com 29 но€б. 2018 г. 15:07:01
 */
public class JsonPojoManipulator {

	public static Shape readFromJSON(String url) {
		Shape shape = null;
		Gson gson = new Gson();

		try {
			shape = gson.fromJson(new FileReader(url), Shape.class);

//			System.out.println(gson.toJson(shape));

		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}

		return shape;

	}

	public static void writeToJSON(String url, List<Shape> shape) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try {
			FileWriter fw = new FileWriter(url);
			fw.write(gson.toJson(shape));
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}
	public static void writeToJSON(String url, Shape shape) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try {
			FileWriter fw = new FileWriter(url);
			fw.write(gson.toJson(shape));
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

}
