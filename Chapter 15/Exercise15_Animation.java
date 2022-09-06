/**
 * Author: Clint Davis
 * Date: 9/6/22
 *
 * This is my attempt at solving Exercise 15.
 */

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class Exercise15_Animation extends Application {
    @Override
    public void start(Stage primaryStage) {
        final double WIDTH = 200, HEIGHT = 200;
        double centerX = WIDTH / 2, centerY = HEIGHT / 2;
        double radius = Math.min(WIDTH, HEIGHT) * 0.4;

        Pane pane = new Pane();

        Polygon polygon = new Polygon();
        polygon.setRotate(-18);
        polygon.setFill(Color.DARKORANGE);
        ObservableList<Double> list = polygon.getPoints();
        int s = 5;
        for (int i= 0; i < s; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / s));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
        }

        Rectangle rectangle = new Rectangle(0,0,25,50);
        rectangle.setFill(Color.DARKGREEN);

        pane.getChildren().add(polygon);
        pane.getChildren().add(rectangle);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(6000));
        pt.setPath(polygon);
        pt.setNode(rectangle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        FadeTransition ft = new FadeTransition(Duration.millis(6000), rectangle);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        pane.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                pt.pause();
            }

            else if (event.getButton() == MouseButton.SECONDARY) {
                pt.play();
            }
        });

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise 15");
        primaryStage.setScene(scene);
        primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
}