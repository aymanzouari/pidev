/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.User;
import Utils.Cruduser;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.A;
import static javafx.scene.input.KeyCode.Z;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;


/**
 *
 * @author aymen
 */
public class InscriptionController implements Initializable {
@FXML
    private TextField txtusername;

    @FXML
    private Button idinscription;

    @FXML
    private Button fermer;

    @FXML
    private TextField txtmail;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private PasswordField txtpassword2;
private String role="utilisateur";
    @FXML
    void Fermeer(ActionEvent event) {
                 Window window = fermer.getScene().getWindow(); 

     if (window instanceof Stage){ 
      ((Stage) window).close(); 
     } 
    }

    @FXML
    void Inscription(ActionEvent event) {
          Cruduser c=new Cruduser();
          if(txtusername.getText().equals(""))
          {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Alert");
              alert.setHeaderText("Resultat:");
              alert.setContentText("Entrer username");
 
              alert.showAndWait();
              
          }
          else
              if(txtmail.getText().equals("") )
              {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Alert");
              alert.setHeaderText("Resultat:");
              alert.setContentText("Entrer mail");
 
              alert.showAndWait();
                  
              }
             
          else
                  if(txtpassword.getText().equals(""))
                  {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Alert");
              alert.setHeaderText("Resultat:");
              alert.setContentText("Entrer password");
 
              alert.showAndWait();
                  }
          else
                      if(txtpassword2.getText().equals(""))
                      {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Alert");
              alert.setHeaderText("Resultat:");
              alert.setContentText("Entrer la confirmation de password");
 
              alert.showAndWait();
                      }
          else
                          if(!txtpassword.getText().equals(txtpassword2.getText()))
                          {
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Alert");
              alert.setHeaderText("Resultat:");
              alert.setContentText("mot de passe et incorrect");
 
              alert.showAndWait();
                          }
          else
                              if(testmail()==false)
                              {
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Alert");
              alert.setHeaderText("Resultat:");
              alert.setContentText("email n'est pas valide");
 
              alert.showAndWait();
                                  
                              }
          else
                      {
                             c.ajouteuser(new User(txtusername.getText(),txtmail.getText(),txtpassword.getText(),role));
       try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Login.fxml"));
           Parent root1 = loader.load();
              ((Node)(event.getSource())).getScene().getWindow().hide();
             Stage stage = new Stage();
            
             stage.setScene(new Scene(root1));  
             stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }  
                      }
   

    }
    public boolean testmail()
    {
        boolean b=true;
        if(txtmail.getText().contains("@") || txtmail.getText().contains("."))
        {
            b=false;
        }
    return b;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
 
    }


    
    
}
