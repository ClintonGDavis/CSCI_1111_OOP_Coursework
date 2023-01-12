package finalProject1175;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PageController extends BalancedLiving implements Initializable {
    @FXML
    AnchorPane apMain;
    BalancedLiving balancedLiving = new BalancedLiving();

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        try
        {
            Pane newLoadedPane;
            Button tempButton = (Button)event.getSource();

            switch(tempButton.getId())
            {
                case "LoveB":
                    newLoadedPane =  FXMLLoader.load(getClass().getResource("View01.fxml"));
                    apMain.getChildren().add(newLoadedPane);
                    break;
                case "WorkB":
                    newLoadedPane =  FXMLLoader.load(getClass().getResource("View02.fxml"));
                    apMain.getChildren().add(newLoadedPane);
                    break;
                case "LearningB":
                    newLoadedPane =  FXMLLoader.load(getClass().getResource("View03.fxml"));
                    apMain.getChildren().add(newLoadedPane);
                    break;
                case "PlayB":
                    newLoadedPane =  FXMLLoader.load(getClass().getResource("View04.fxml"));
                    apMain.getChildren().add(newLoadedPane);
                    break;
                case "HealthB":
                    newLoadedPane =  FXMLLoader.load(getClass().getResource("View05.fxml"));
                    apMain.getChildren().add(newLoadedPane);
                    break;
                case "SafetyB":
                    newLoadedPane =  FXMLLoader.load(getClass().getResource("View06.fxml"));
                    apMain.getChildren().add(newLoadedPane);
                    break;
                case "MainPageB":
                    newLoadedPane =  FXMLLoader.load(getClass().getResource("View07.fxml"));
                    apMain.getChildren().add(newLoadedPane);
                    break;
                case "SaveB":
                    newLoadedPane =  FXMLLoader.load(getClass().getResource("View08.fxml"));
                    apMain.getChildren().add(newLoadedPane);
                    break;
                case "ShowScoreB":
                	newLoadedPane = FXMLLoader.load(getClass().getResource("View09.fxml"));
                	apMain.getChildren().add(newLoadedPane);
                	break;
            }
        }
        catch (IOException ex) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }
}
