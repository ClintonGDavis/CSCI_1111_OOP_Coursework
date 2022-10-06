# CS 1112 Final Project

## Synopsis
This is a continuation of the program I created for my CS 1111 Final Project.

My CS 1111 project was a rudimentary logbook produced for the benefit of people who will utilize a new mental health program called "Balanced Living."

This project (for CS 1112) is basically a GUI version of that project.

## Motivation
I built this project at the behest of the person who created the Balanced Living program (a professional psychologist & personal friend of mine).

## How to Run
Click on the "FinalProject1112" class in order to run the program.

## Code Example
I am particularly proud of this line of code.
Not because I find it to be especially complicated (I don't, for the record),
but it was the one portion of code in my entire project I had difficulty formulating successfully.

Somehow I forgot that I needed to write an action event for each TextField.
I felt simultaniously dumb & brilliant once I finally realized what my oversight had been.
```
   @FXML
    TextField textField1;
    @FXML
    TextArea textArea1;
    @FXML
    TextField textField2;
    @FXML
    TextArea textArea2;

@Override
    public void initialize(URL url, ResourceBundle rb)
    {
        textArea1.setText(balancedLiving.getWorkStandard());
        textArea2.setText(balancedLiving.getWorkScore());

        textField1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea1.setText(textField1.getText());
                balancedLiving.setWorkStandard(textField1.getText());
            }
        });

        textField2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea2.setText(textField2.getText());
                balancedLiving.setWorkScore(textField2.getText());
            }
        });
```
