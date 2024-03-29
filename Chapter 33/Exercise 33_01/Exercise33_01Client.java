/**
 * Author: Clint Davis
 * Date: 01/06/22
 * 
 * This is my attempt at solving Exercise 33-01.
 */

package Exercise33_01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// Exercise31_01Client.java: The client sends the input to the server and receives
// result back from the server
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise33_01Client extends Application {
  // Text field for receiving radius
  private TextField tfAnnualInterestRate = new TextField();
  private TextField tfNumOfYears = new TextField();
  private TextField tfLoanAmount = new TextField();
  private Button btSubmit = new Button("Submit");

  // Text area to display contents
  private TextArea ta = new TextArea();
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    ta.setWrapText(true);
   
    GridPane gridPane = new GridPane();
    gridPane.add(new Label("Annual Interest Rate"), 0, 0);
    gridPane.add(new Label("Number Of Years"), 0, 1);
    gridPane.add(new Label("Loan Amount"), 0, 2);
    gridPane.add(tfAnnualInterestRate, 1, 0);
    gridPane.add(tfNumOfYears, 1, 1);
    gridPane.add(tfLoanAmount, 1, 2);
    gridPane.add(btSubmit, 2, 1);
    
    tfAnnualInterestRate.setAlignment(Pos.BASELINE_RIGHT);
    tfNumOfYears.setAlignment(Pos.BASELINE_RIGHT);
    tfLoanAmount.setAlignment(Pos.BASELINE_RIGHT);
    
    tfLoanAmount.setPrefColumnCount(5);
    tfNumOfYears.setPrefColumnCount(5);
    tfLoanAmount.setPrefColumnCount(5);
            
    BorderPane pane = new BorderPane();
    pane.setCenter(new ScrollPane(ta));
    pane.setTop(gridPane);
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 400, 250);
    primaryStage.setTitle("Exercise31_01Client"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    btSubmit.setOnAction(e -> {
        try {
        	Socket socket = new Socket("localhost", 9000);

            DataInputStream inputFromClient = new DataInputStream(
                    socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(
                    socket.getOutputStream());
   
        	double annualInterestRate = Double.parseDouble(tfAnnualInterestRate.getText().trim());
        	int numOfYears = Integer.parseInt(tfNumOfYears.getText().trim());
        	double loanAmount = Double.parseDouble(tfLoanAmount.getText().trim());
        	
        	outputToClient.writeDouble(annualInterestRate);
        	outputToClient.writeInt(numOfYears);
        	outputToClient.writeDouble(loanAmount);
        	outputToClient.flush();

        	double monthlyPayment = inputFromClient.readDouble();
        	double totalPayment = inputFromClient.readDouble();
        	
        	ta.appendText("Annual Interest Rate: " + annualInterestRate + "\n");
        	ta.appendText("Number of Years: " + numOfYears + "\n");
        	ta.appendText("Loan Amount: " + loanAmount + "\n");
        	ta.appendText("Monthly Payment: " + monthlyPayment + "\n");
        	ta.appendText("Total Payment: " + totalPayment + "\n");
        	}
        	catch (IOException ex) {
        	ex.printStackTrace();
        	}
        	});
        }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
