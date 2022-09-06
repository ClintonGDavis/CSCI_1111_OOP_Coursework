/**
 * Author: Clint Davis
 * Date: 9/2/22
 *
 * This is my attempt at solving "Exercise 15".
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise_15_Listeners extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        int width = 400;
        int height = 400;
        BallPane ballPane = new BallPane(width / 2,height / 2, Math.min(width,height) / 15);

        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        btUp.setOnAction(e -> ballPane.moveUp());
        btDown.setOnAction(e -> ballPane.moveDown());
        btLeft.setOnAction(e -> ballPane.moveLeft());
        btRight.setOnAction(e -> ballPane.moveRight());

        HBox buttons = new HBox(btUp, btDown, btLeft, btRight);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setSpacing(10);
        buttons.setPadding(new Insets(10, 10, 10, 10));

        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setBottom(buttons);

            Scene scene = new Scene(pane, width, height);
            primaryStage.setTitle("Exercise 15: Listeners");
            primaryStage.setScene(scene);
            primaryStage.show();
    }

private class BallPane extends Pane {

    private Circle mCircle;

    public BallPane() {
        this(0, 0, 10);
    }

    public BallPane(double centerX, double centerY, double radius) {
        mCircle = new Circle(centerX, centerY, radius);
        getChildren().add(mCircle);
    }

    public void moveUp() {
        mCircle.setCenterY(mCircle.getCenterY() > 20 ? mCircle.getCenterY() - 10 : 20);
    }
    public void moveDown() {
        mCircle.setCenterY(mCircle.getCenterY() < getHeight() + 20 ? mCircle.getCenterY() + 10 : getHeight() + 20);
    }
    public void moveRight() {
        mCircle.setCenterX(mCircle.getCenterX() < getWidth() - 20 ? mCircle.getCenterX() + 10 : getWidth() - 20);
    }
    public void moveLeft() {
        mCircle.setCenterX(mCircle.getCenterX() > 20 ? mCircle.getCenterX() - 10 : 20);
    }
}

    public static void main(String[] args) {
        Application.launch(args);
    }
}