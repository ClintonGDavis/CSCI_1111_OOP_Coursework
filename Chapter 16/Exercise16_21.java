/**
 * Author: Clint Davis
 * Date: 9/12/22
 *
 * This is my attempt at solving Exercise 16-21.
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.util.Duration;
import javafx.scene.media.*;

public class Exercise16_21 extends Application {
    TextField text = new TextField();
    int countDown = 0;

    @Override
    public void start(Stage primaryStage) {
        Media media = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        BorderPane pane = new BorderPane();
        pane.setCenter(text);
        text.setFont(Font.font("Courier", 40));
        text.setAlignment(Pos.CENTER);

        text.setText(Integer.toString(countDown));

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            if (countDown > 0) {
                countDown--;
                text.setText(Integer.toString(countDown));

            } else {
                mediaPlayer.play();
            }
        }));

        text.setOnAction(e -> {
            countDown = Integer.parseInt(text.getText());
            animation.setCycleCount(countDown + 1);
            animation.play();
        });

        Scene scene = new Scene(pane, 250, 75);
        primaryStage.setTitle("Exercise 16-21");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}