package silesiandictionary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class FXML_showAllController implements Initializable
{
    
    @FXML
    private ListView listOfAll;
    private FindWordClass fwc = new FindWordClass();
            
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        fwc.getTreeOfWords().entrySet().stream().map(s -> s.getKey() + " - " + s.getValue()).
        forEach(i -> listOfAll.getItems().add(i));
        
    }
    
}
