package FinalProject1112;

import javafx.fxml.Initializable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.net.URL;
import java.util.ResourceBundle;

public class View08Controller extends PageController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Path path = Paths.get("SavedData.txt");

        byte[] bytes = balancedLiving.toString().getBytes();

        try {
            Files.write(path, bytes);
        } catch (IOException ex) {

        }
    }
}
