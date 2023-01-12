# CS 1175 Final Project

## Synopsis
This is a continuation of the program I created for my CS 1111 Final Project.

My CS 1111 project was a rudimentary logbook produced for the benefit of people who will utilize a new mental health program called "Balanced Living."

This project (for CS 1175) is basically a more advanced GUI version of that project.

## Motivation
I built this project at the behest of the person who created the Balanced Living program (who is a professional psychologist & personal friend of mine).

## How to Run
Click on the "FinalProject1175" class in order to run the program.

## Code Example
I am proud of the following line of code because it took me quite a while before I was able to get "chart1" to successfully implement the "balancedLiving"
data it was meant to utilize.
What ultimately made everything work correctly was for me to make sure that the balancedLiving variables were not instantiated with a NULL value.
```
    @FXML
        private BarChart<String, Double> barChart;
        
        @FXML
        private CategoryAxis xAxis;
        
        @FXML
        private NumberAxis yAxis;
        
        @Override
        public void initialize(URL url, ResourceBundle rb) {
            XYChart.Series<String, Double> chart1 = new XYChart.Series<>();
            
            chart1.getData().add(new XYChart.Data<>("Love", balancedLiving.getLoveScoreDouble()));
            chart1.getData().add(new XYChart.Data<>("Work", balancedLiving.getWorkScoreDouble()));
            chart1.getData().add(new XYChart.Data<>("Learning", balancedLiving.getLearningScoreDouble()));
            chart1.getData().add(new XYChart.Data<>("Play", balancedLiving.getPlayScoreDouble()));
            chart1.getData().add(new XYChart.Data<>("Health", balancedLiving.getHealthScoreDouble()));
            chart1.getData().add(new XYChart.Data<>("Safety", balancedLiving.getSafetyScoreDouble()));
            barChart.getData().add(chart1);
```