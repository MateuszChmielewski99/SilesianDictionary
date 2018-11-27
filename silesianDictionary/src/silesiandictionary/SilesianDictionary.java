package silesiandictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Mateusz Chmielewski
 */
public class SilesianDictionary extends Application {
   
    @Override
    public void start(Stage stage) throws Exception {
        Parent rootP = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        
        
        Scene scene = new Scene(rootP);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Słownik polsko - śląski");
        stage.show();
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try
        {
            FileClass fc = new FileClass();
            Thread t = new Thread (new FileClassRunnable(fc));
            t.start();
            t.join();
        }
        catch(InterruptedException ex)
        {
            System.out.println(ex.getMessage());
        }
      
       
        launch(args);
    }
    
}
