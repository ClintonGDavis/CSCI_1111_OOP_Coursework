package Exercise33_01;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
// Exercise31_01Server.java: The server can communicate with
// multiple clients concurrently using the multiple threads
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Exercise33_01Server extends Application {
  // Text area for displaying contents
  private TextArea ta = new TextArea();

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) throws Exception {
    ta.setWrapText(true);
   
    // Create a scene and place it in the stage
    Scene scene = new Scene(new ScrollPane(ta), 400, 200);
    primaryStage.setTitle("Exercise31_01Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  
  new Thread( () -> {
      try {
        ServerSocket serverSocket = new ServerSocket(9000);
        Platform.runLater(() ->
          ta.appendText("Server started at " + new Date() + '\n'));
        
          Socket socket = serverSocket.accept();
        Date time = new Date();
  
        DataInputStream inputFromClient = new DataInputStream(
                socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(
                socket.getOutputStream());
        
        while (true) {

          double annualInterestRate = inputFromClient.readDouble();
          int numOfYears = inputFromClient.readInt();
          double loanAmount = inputFromClient.readDouble();
          
          Loan loan = new Loan(annualInterestRate, numOfYears, loanAmount);
          double monthlyPayment = loan.getMonthlyPayment();
          double totalPayment = loan.getTotalPayment();
          
          outputToClient.writeDouble(monthlyPayment);
          outputToClient.writeDouble(totalPayment);
          
        ta.appendText("Server connected to client at " + time + "\n");
        ta.appendText("Annual Interest Rate: " + annualInterestRate + "\n");
      	ta.appendText("Number of Years: " + numOfYears + "\n");
      	ta.appendText("Loan Amount: " + loanAmount + "\n");
      	ta.appendText("Monthly Payment: " + monthlyPayment + "\n");
      	ta.appendText("Total Payment: " + totalPayment + "\n");
        }
      }
      catch(IOException ex) {
        ex.printStackTrace();
      }
  }).start();
}

/**
 * The main method is only needed for the IDE with limited
 * JavaFX support. Not needed for running from the command line.
 */
public static void main(String[] args) {
  launch(args);
}
}