/**
 * Author: Clint Davis
 * Date: 9/9/22
 *
 * This is my attempt at solving Exercise 16-01.
 */

import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Exercise16_01 extends Application {
    protected Text text = new Text(50, 50, "Programming is Fun!");

    @Override
    public void start(Stage primaryStage) {
        HBox paneForButtons = new HBox(20);

        Button btLeftBtn = new Button("<=");
        Button btRightBtn = new Button("=>");
        text.setStyle("-fx-font: 18 arial;");
        text.setFill(Color.LIGHTSLATEGREY);

        paneForButtons.getChildren().addAll(btLeftBtn, btRightBtn);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-width: 1px; -fx-border-color: grey");

        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);

        btLeftBtn.setOnAction(event -> text.setX(text.getX() < 5 ? text.getX() + 5 : text.getX() - 5));
        btRightBtn.setOnAction(event -> text.setX(text.getX() > 90 ? text.getX() - 10 : text.getX() + 5));

        HBox paneForRadioButtons = new HBox(10);
        paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5));
        paneForRadioButtons.setStyle
                ("-fx-border-width: 1px; -fx-border-color: grey");

        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbBlack = new RadioButton("Black");
        RadioButton rbOrange = new RadioButton("Orange");
        RadioButton rbGreen = new RadioButton("Green");

        paneForRadioButtons.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
        paneForRadioButtons.setAlignment(Pos.CENTER);
        pane.setTop(paneForRadioButtons);

        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbBlack.setToggleGroup(group);
        rbOrange.setToggleGroup(group);
        rbGreen.setToggleGroup(group);

        rbRed.setOnAction(event -> {
            if (rbRed.isSelected())
                text.setFill(Color.RED);
        });

        rbYellow.setOnAction(event -> {
            if (rbYellow.isSelected())
                text.setFill(Color.GOLD);
        });

        rbBlack.setOnAction(event -> {
            if (rbBlack.isSelected())
                text.setFill(Color.BLACK);
        });

        rbOrange.setOnAction(event -> {
            if (rbOrange.isSelected())
                text.setFill(Color.DARKORANGE);
        });

        rbGreen.setOnAction(event -> {
            if (rbGreen.isSelected())
                text.setFill(Color.GREEN);
        });

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Exercise 16-01");
        primaryStage.setScene(scene);
        primaryStage.show();
      }

    public static void main(String[] args) {
        launch(args);
      }
}
