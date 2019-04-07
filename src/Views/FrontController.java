/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class FrontController implements Initializable {
  @FXML
    private Button idlogout;
    @FXML
    private Pane pane;

 Node[] n=new Node[2];
    @FXML
    void actualite(ActionEvent event) {
          try {
         
           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Actualites.fxml"));
           n[0]=loader.load();
            pane.getChildren().remove(n[1]);
           
           pane.getChildren().add(n[0]);
       } catch (IOException ex) {
           Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
       }
     

    }

    @FXML
    void formation(ActionEvent event) {
               try {
         
           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Frontformation.fxml"));
           n[1]=loader.load();
            pane.getChildren().remove(n[0]);
           
           pane.getChildren().add(n[1]);
       } catch (IOException ex) {
           Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
       }

    }

 

    @FXML
    void logout(ActionEvent event) {
                  Window window = idlogout.getScene().getWindow(); 

     if (window instanceof Stage){ 
      ((Stage) window).close(); 
     } 


    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
