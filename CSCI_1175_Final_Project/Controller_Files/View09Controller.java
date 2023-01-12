package finalProject1175;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class View09Controller extends PageController implements Initializable {

    @FXML
    private BarChart<String, Double> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	xAxis.setLabel("X-Axis");
        yAxis.setLabel("Y-Axis");
        XYChart.Series<String, Double> series1 = new XYChart.Series<>();

        series1.getData().add(new XYChart.Data<>("Love", balancedLiving.getLoveScoreDouble()));
        series1.getData().add(new XYChart.Data<>("Work", balancedLiving.getWorkScoreDouble()));
        series1.getData().add(new XYChart.Data<>("Learning", balancedLiving.getLearningScoreDouble()));
        series1.getData().add(new XYChart.Data<>("Play", balancedLiving.getPlayScoreDouble()));
        series1.getData().add(new XYChart.Data<>("Health", balancedLiving.getHealthScoreDouble()));
        series1.getData().add(new XYChart.Data<>("Safety", balancedLiving.getSafetyScoreDouble()));
        barChart.getData().add(series1);
        
        Node n = barChart.lookup(".data0.chart-bar");
        n.setStyle("-fx-bar-fill: blue");
        n = barChart.lookup(".data1.chart-bar");
        n.setStyle("-fx-bar-fill: red");
        n = barChart.lookup(".data2.chart-bar");
        n.setStyle("-fx-bar-fill: green");
        n = barChart.lookup(".data3.chart-bar");
        n.setStyle("-fx-bar-fill: yellow");
        n = barChart.lookup(".data4.chart-bar");
        n.setStyle("-fx-bar-fill: orange");
        n = barChart.lookup(".data5.chart-bar");
        n.setStyle("-fx-bar-fill: purple");
    }
}