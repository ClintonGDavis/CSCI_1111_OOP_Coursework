/**
 * Author: Clint Davis
 * Date: 01/10/23
 * 
 * This is my attempt at solving Exercise 31-17.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise31_17 extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Label investmentAmountLabel = new Label("Investment Amount");
    TextField investmentAmountField = new TextField();
    Label interestRateLabel = new Label("Annual Interest Rate");
    TextField interestRateField = new TextField();
    Label yearsLabel = new Label("Number of Years");
    TextField yearsField = new TextField();
    Label futureValueLabel = new Label("Future Value");
    TextField futureValueField = new TextField();
    futureValueField.setEditable(false);
    Button calculateButton = new Button("Calculate");
    MenuBar menuBar = new MenuBar();
    Menu operationMenu = new Menu("Operation");
    MenuItem calculateMenuItem = new MenuItem("Calculate");
    MenuItem exitMenuItem = new MenuItem("Exit");
    operationMenu.getItems().addAll(calculateMenuItem, exitMenuItem);
    menuBar.getMenus().add(operationMenu);

    // Create the layout
    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(10, 10, 10, 10));
    gridPane.setVgap(8);
    gridPane.setHgap(10);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.add(menuBar, 0, 0, 2, 1);
    gridPane.add(investmentAmountLabel, 0, 1);
    gridPane.add(investmentAmountField, 1, 1);
    gridPane.add(yearsLabel, 0, 2);
    gridPane.add(yearsField, 1, 2);
    gridPane.add(interestRateLabel, 0, 3);
    gridPane.add(interestRateField, 1, 3);
    gridPane.add(futureValueLabel, 0, 4);
    gridPane.add(futureValueField, 1, 4);
    gridPane.add(calculateButton, 1, 5);

    calculateButton.setOnAction(event -> {
      double investmentAmount = Double.parseDouble(investmentAmountField.getText());
      double annualInterestRate = Double.parseDouble(interestRateField.getText());
      int years = Integer.parseInt(yearsField.getText());
      double monthlyInterestRate = annualInterestRate / 12 / 100;
      double futureValue = investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
      futureValueField.setText(String.format("$%.2f", futureValue));
    });
    calculateMenuItem.setOnAction(event -> calculateButton.fire());

    exitMenuItem.setOnAction(event -> primaryStage.close());

    Scene scene = new Scene(gridPane, 400, 200);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Exercise 33-17");
    primaryStage.show();
  }
}

