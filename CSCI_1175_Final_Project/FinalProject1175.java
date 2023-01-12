/**
 * Author: Clint Davis
 * Date: 01/12/23
 *
 * This is my submission for my CS 1175 Final Project.
 */

package finalProject1175;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FinalProject1175 extends Application {
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("View00(MainPage).fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Final Project 1175");
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
