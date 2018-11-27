/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silesiandictionary;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
/**
 * FXML Controller class
 *
 * @author Mateusz Chmielewski
 */
public class FXML_gameController implements Initializable {

    @FXML
    private TextField txt;
    @FXML
    private Label toGuessLable;
    @FXML
    private Button submitButton;
    @FXML
    private Label pointsLabel;
    @FXML
    private ImageView ifCorrectImage;
    @FXML
    private ImageView ifNotCorerctImage;
    
    private FindWordClass fwc = new FindWordClass();
    private Object[] arr = fwc.getTreeOfWords().entrySet().toArray();
    private Random r1 = new Random();
    private int randomWord = r1.nextInt(arr.length);;
    private int score;

    
    
    
    @FXML
    public void submit()
    {
        String [] tmpArr = arr[randomWord].toString().split("=");
        String guess = txt.getText();
        toGuessLable.setText(tmpArr[1]);
        
        if(guess.equalsIgnoreCase(tmpArr[0]))
        {
            randomWord = r1.nextInt(arr.length);
            score++;
            pointsLabel.setText(Integer.toString(score));
            txt.setText("");
            ifNotCorerctImage.setVisible(false);
            ifCorrectImage.setVisible(true);
            submitButton.setTextFill(Color.GREEN);
            submitButton.setText("Zgadza się!");
            
        }
        else if (!guess.equals(""))
        {
            ifCorrectImage.setVisible(false);
            ifNotCorerctImage.setVisible(true);
            submitButton.setTextFill(Color.RED);
            submitButton.setText("Niestety, nie!");
            score = 0;
            pointsLabel.setText(Integer.toString(score));
            txt.setText("");
        }
        
    }
    
    @FXML 
    public void doubleSubmit()
    {
        submit();
        submit();
    }
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        String s = arr[randomWord].toString();
        toGuessLable.setText(s.substring(s.indexOf("=") + 1));
        ifNotCorerctImage.setVisible(false);
        ifCorrectImage.setVisible(false);
    }    
    
}
