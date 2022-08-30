/**
 * Author: Clint Davis
 * Date: 8/30/22
 *
 * This is my attempt at solving Exercise 14-28.
 */

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Exercise14_28 extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    int randomNumHour = ThreadLocalRandom.current().nextInt(0, 11 + 1);
    int randomNumMinute = ThreadLocalRandom.current().nextInt(0, 30 + 1);
    int randomNumSecond = ThreadLocalRandom.current().nextInt(0, 60 + 1);

    ClockPane clock = new ClockPane(randomNumHour, randomNumMinute, randomNumSecond, true,
            true, false);

    BorderPane pane = new BorderPane();
    pane.setCenter(clock);

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 250, 250);
    primaryStage.setTitle("Exercise 14-28"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  class ClockPane extends Pane {
    private int hour;
    private int minute;
    private int second;
    private boolean hourHandVisible;
    private boolean minuteHandVisible;
    private boolean secondHandVisible;

    /** Construct a default clock with the current time*/
    public ClockPane() {
      setCurrentTime();
    }

    /** Construct a clock with specified hour, minute, and second */
    public ClockPane(int hour, int minute, int second, boolean hourHandVisible, boolean minuteHandVisible,
                     boolean secondHandVisible) {
      this.hour = hour;
      this.minute = minute;
      this.second = second;
      this.hourHandVisible = hourHandVisible;
      this.minuteHandVisible = minuteHandVisible;
      this.secondHandVisible = secondHandVisible;

    }

    /** Return hour */
    public int getHour() {
      return hour;
    }

    /** Set a new hour */
    public void setHour(int hour) {
      this.hour = hour;
      paintClock();
    }

    /** Return minute */
    public int getMinute() {
      return minute;
    }

    /** Set a new minute */
    public void setMinute(int minute) {
      this.minute = minute;
      paintClock();
    }

    /** Return second */
    public int getSecond() {
      return second;
    }

    /** Set a new second */
    public void setSecond(int second) {
      this.second = second;
      paintClock();
    }

    public boolean getHourHand() {
      return hourHandVisible;
    }

    public void setHourHand(boolean hourHandVisible) {
      this.hourHandVisible = hourHandVisible;
      paintClock();
    }

    public boolean getMinuteHand() {
      return minuteHandVisible;
    }

    public void setMinuteHand(boolean minuteHandVisible) {
      this.minuteHandVisible = minuteHandVisible;
      paintClock();
    }

    public boolean getSecondHand() {
      return secondHandVisible;
    }

    public void setSecondHand(boolean secondHandVisible) {
      this.secondHandVisible = secondHandVisible;
      paintClock();
    }

    /* Set the current time for the clock */
    public void setCurrentTime() {
      // Construct a calendar for the current date and time
      Calendar calendar = new GregorianCalendar();

      // Set current hour, minute and second
      this.hour = calendar.get(Calendar.HOUR_OF_DAY);
      this.minute = calendar.get(Calendar.MINUTE);
      this.second = calendar.get(Calendar.SECOND);

      paintClock(); // Repaint the clock
    }

    /** Paint the clock */
    private void paintClock() {
      // Initialize clock parameters
      double clockRadius =
        Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
      double centerX = getWidth() / 2;
      double centerY = getHeight() / 2;

      // Draw circle
      Circle circle = new Circle(centerX, centerY, clockRadius);
      circle.setFill(Color.WHITE);
      circle.setStroke(Color.BLACK);
      Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
      Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
      Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
      Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

      // Draw second hand
      double sLength = clockRadius * 0.8;
      double secondX = centerX + sLength *
        Math.sin(second * (2 * Math.PI / 60));
      double secondY = centerY - sLength *
        Math.cos(second * (2 * Math.PI / 60));
      Line sLine = new Line(centerX, centerY, secondX, secondY);
      sLine.setStroke(Color.RED);

      // Draw minute hand
      double mLength = clockRadius * 0.65;
      double xMinute = centerX + mLength *
        Math.sin(minute * (2 * Math.PI / 60));
      double minuteY = centerY - mLength *
        Math.cos(minute * (2 * Math.PI / 60));
      Line mLine = new Line(centerX, centerY, xMinute, minuteY);
      mLine.setStroke(Color.BLUE);

      // Draw hour hand
      double hLength = clockRadius * 0.5;
      double hourX = centerX + hLength *
        Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
      double hourY = centerY - hLength *
        Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
      Line hLine = new Line(centerX, centerY, hourX, hourY);
      hLine.setStroke(Color.GREEN);

      getChildren().clear();
      getChildren().addAll(circle, t1, t2, t3, t4);
      if (secondHandVisible)
        getChildren().add(sLine);
      if (minuteHandVisible)
        getChildren().add(mLine);
      if (hourHandVisible)
        getChildren().add(hLine);
    }

    @Override
    public void setWidth(double width) {
      super.setWidth(width);
      paintClock();
    }
    
    @Override
    public void setHeight(double height) {
      super.setHeight(height);
      paintClock();
    }
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}