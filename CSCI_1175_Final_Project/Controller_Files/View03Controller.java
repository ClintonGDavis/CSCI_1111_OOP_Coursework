package finalProject1175;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class View03Controller extends PageController implements Initializable {
    @FXML
    TextField textField1;
    @FXML
    TextArea textArea1;
    @FXML
    TextField textField2;
    @FXML
    TextArea textArea2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textArea1.setText(balancedLiving.getLearningStandard());
        textArea2.setText(balancedLiving.getLearningScore());

        textField1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea1.setText(textField1.getText());
                balancedLiving.setLearningStandard(textField1.getText());
            }
        });

        textField2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea2.setText(textField2.getText());
                balancedLiving.setLearningScore(textField2.getText());

                System.out.println(balancedLiving.toString());
            }
        });
    }
}
