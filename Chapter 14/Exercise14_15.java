/** Author: Clint Davis
 * 	Date: 8/29/22
 *
 * 	This is my attempt at solving Exercise 14-15.
 */

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;


public class Exercise14_15 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a polygon and place polygon to pane
		Polygon polygon = new Polygon();
		polygon.setFill(Color.RED);
		polygon.setStroke(Color.RED);
		ObservableList<Double> list = polygon.getPoints();
		polygon.setRotate(22.5);

		final double WIDTH = 200, HEIGHT = 200;
		double centerX = WIDTH / 2, centerY = HEIGHT / 2;
		double radius = Math.min(WIDTH, HEIGHT) * 0.4;

		Text text = new Text("STOP");
		text.setFill(Color.WHITE);
		text.setFont(Font.font("highway gothic", FontWeight.NORMAL, FontPosture.REGULAR, 45));

		StackPane stackpane = new StackPane(polygon, text);

		// s represents the number of sides of the shape
		// Make sure to update this number when necessary
		int s = 8;
		// Add points to the polygon list
		for (int i = 0; i < s; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / s));
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
		}

		// Create a scene and place it in the stage
		Scene scene = new Scene(stackpane, WIDTH, HEIGHT);
		primaryStage.setTitle("Exercise 14-15"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}
