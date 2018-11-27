
package silesiandictionary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mateusz Chmielewski
 */
public class FXM_findWordController implements Initializable {

    @FXML
    private TextField findField;
    @FXML
    private ListView <String> foundList;
    @FXML
    private RadioButton changeLanguageButton;
    private final FindWordClass worker = new FindWordClass();;
    private String toFind;

  
    
    @FXML
    public void showList()
    {
        toFind = findField.getText();
        if(!changeLanguageButton.isSelected())
            worker.findWords(foundList, toFind);
        
        else 
            worker.findSilesianWords(foundList, toFind);
    } 
    
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    
}
