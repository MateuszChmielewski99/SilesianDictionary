package silesiandictionary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;


public class FXMLDocumentController  implements Initializable {
    
    
    
    @FXML
    private Label label;
    @FXML 
    private RadioButton button1;
    @FXML 
    private RadioButton button2;
    
    
    private void launch(String FXMLname, String title)
    {
         try
        {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(FXMLname));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } 
        
        catch (IOException e)
        {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    
    }
    
    @FXML
    private void launchGame()
    {
        launch("FXML_game.fxml", "Giera!");
    }
    
    @FXML
    private void launchFinding()
    { 
        launch("FXM_findWord.fxml", "Wyszukaj wyraz");
    }
    
    @FXML
    private void launchShowAll()
    {
         launch("FXML_showAll.fxml", "Cały słownik");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
 /*
 * @author Mateusz Chmielewski/ 2018
 */
}
