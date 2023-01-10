/**
 * Author: Clint Davis
 * Date: 01/10/23
 * 
 * This is my attempt at solving Exercise 31-20.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise31_20 extends Application {   
  @Override
  public void start(Stage primaryStage) {   
    TabPane tabPane = new TabPane();
    Tab tab1 = new Tab("Line");
    StackPane pane1 = new StackPane();
    pane1.getChildren().add(new Line(10, 10, 80, 80));
    tab1.setContent(pane1);
    Tab tab2 = new Tab("Rectangle");
    tab2.setContent(new Rectangle(10, 10, 200, 200));
    Tab tab3 = new Tab("Circle");
    tab3.setContent(new Circle(50, 50, 20));    
    Tab tab4 = new Tab("Ellipse");
    tab4.setContent(new Ellipse(10, 10, 100, 80));
    tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);
    
    RadioButton rbTop = new RadioButton("Top");
    RadioButton rbBottom = new RadioButton("Bottom");
    RadioButton rbLeft = new RadioButton("Left");
    RadioButton rbRight = new RadioButton("Right");
    ToggleGroup group = new ToggleGroup();
    rbTop.setToggleGroup(group);
    rbBottom.setToggleGroup(group);
    rbLeft.setToggleGroup(group);
    rbRight.setToggleGroup(group);
    rbTop.setSelected(true);

    group.selectedToggleProperty().addListener((ov, oldToggle, newToggle) -> {
      if (rbTop.isSelected()) {
        tabPane.setSide(Side.TOP);
      } else if (rbBottom.isSelected()) {
        tabPane.setSide(Side.BOTTOM);
      } else if (rbLeft.isSelected()) {
        tabPane.setSide(Side.LEFT);
      } else if (rbRight.isSelected()) {
        tabPane.setSide(Side.RIGHT);
      }
    });

    HBox hBox = new HBox(10, rbTop, rbLeft, rbBottom, rbRight);
    
    BorderPane root = new BorderPane();
    root.setBottom(hBox);
    root.setCenter(tabPane);

    Scene scene = new Scene(root, 300, 250);  
    primaryStage.setTitle("Exercise 31-20");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   * line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}