package FinalProject1112;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class View05Controller extends PageController implements Initializable {
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
        textArea1.setText(balancedLiving.getHealthStandard());
        textArea2.setText(balancedLiving.getHealthScore());

        textField1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea1.setText(textField1.getText());
                balancedLiving.setHealthStandard(textField1.getText());
            }
        });

        textField2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea2.setText(textField2.getText());
                balancedLiving.setHealthScore(textField2.getText());
            }
        });
    }
}
