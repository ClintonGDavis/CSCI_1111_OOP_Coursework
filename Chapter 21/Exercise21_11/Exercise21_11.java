/**
 * Author: Clint Davis
 * Date: 10/25/22
 *
 * This is my attempt at solving Exercise 21-11.
 */

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
  Scanner input = new Scanner(System.in);

  private Map<String, Integer> mapForBoy = new HashMap();
  private Map<String, Integer> mapForGirl = new HashMap();

  private Button btFindRanking = new Button("Find Ranking");
  private ComboBox<Integer> cboYear = new ComboBox<>();
  private ComboBox<String> cboGender = new ComboBox<>();
  private TextField tfName = new TextField();
  private Label lblResult = new Label();

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    GridPane gridPane = new GridPane();
    gridPane.add(new Label("Select a year:"), 0, 0);
    gridPane.add(new Label("Boy or girl?"), 0, 1);
    gridPane.add(new Label("Enter a name:"), 0, 2);
    gridPane.add(cboYear, 1, 0);
    gridPane.add(cboGender, 1, 1);
    gridPane.add(tfName, 1, 2);
    gridPane.add(btFindRanking, 1, 3);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(5);
    gridPane.setVgap(5);

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(lblResult);
    BorderPane.setAlignment(lblResult, Pos.CENTER);



    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 370, 160);
    primaryStage.setTitle("Exercise 21-11"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    cboGender.getItems().addAll("Male", "Female");
    cboGender.setValue("Male");

    cboYear.getItems().addAll( 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010);
    cboYear.setValue(2001);

    btFindRanking.setOnAction(b -> {
      if (cboGender.getValue() == "Male") {

        for (int year = 2001; year <= 2010; year++) {
          try {
            java.net.URL url = new java.net.URL(
                    "http://liveexample.pearsoncmg.com/data/babynamesranking"
                            + year + ".txt");

            input = new Scanner(url.openStream());

            while (input.hasNext()) {
              Integer rank = input.nextInt();
              String boysName = input.next();
              input.nextInt();
              input.next();
              input.nextInt();
              mapForBoy.put(boysName, rank);
            }
            if (cboYear.getValue() == year) {
              mapForBoy.forEach((k, v) -> k.compareTo(tfName.getText()));
              {
                lblResult.setText("The boy's name "
                        + tfName.getText() + " was ranked #" + mapForBoy.get(tfName.getText()) + " in the year " + cboYear.getValue());
              }
              if (mapForBoy.get(tfName.getText()) == null)
                lblResult.setText("The boy's name " + tfName.getText() + " wasn't listed for the year " + +cboYear.getValue());
            }
          } catch (MalformedURLException e) {
            e.printStackTrace();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }

      } else if (cboGender.getValue() == "Female") {

        for (int year = 2001; year <= 2010; year++) {
          try {
            java.net.URL url = new java.net.URL(
                    "http://liveexample.pearsoncmg.com/data/babynamesranking"
                            + year + ".txt");

            input = new Scanner(url.openStream());

            while (input.hasNext()) {
              Integer rank = input.nextInt();
              input.next();
              input.nextInt();
              String girlsName = input.next();
              input.nextInt();
              mapForGirl.put(girlsName, rank);
            }
            if (cboYear.getValue() == year) {
              mapForGirl.forEach((k, v) -> k.compareTo(tfName.getText()));
              {
                lblResult.setText("The girl's name "
                        + tfName.getText() + " was ranked #" + mapForGirl.get(tfName.getText()) + " in the year " + cboYear.getValue());
              }
              if (mapForGirl.get(tfName.getText()) == null)
                lblResult.setText("The girl's name " + tfName.getText() + " wasn't listed for the year " + +cboYear.getValue());
            }
          } catch (MalformedURLException e) {
            e.printStackTrace();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    });
  }
}
