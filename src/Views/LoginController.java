/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.User;
import Utils.Cruduser;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;


/**
 *
 * @author aymen
 */
public class LoginController implements Initializable{
 @FXML
    public TextField txtusername;

    @FXML
    public PasswordField txtpassword;

    @FXML
    private Button idmotdepasseoublier;

    @FXML
    private Button idfermer;

    @FXML
    private Button idconnexion;

    @FXML
    private Button inscription;
Cruduser c=new Cruduser();
List<String> list=new ArrayList<>();
public List<String> getlist()
{
      for(String x:list)
              {
                  System.out.println("liste:"+x);
                
              }
    return list;
    
}
public static int iduser=0;
    @FXML
    void Connexion(ActionEvent event) {
        if(txtusername.getText().equals("") )
        {
                  Alert alert = new Alert(AlertType.INFORMATION);
              alert.setTitle("Alert");
              alert.setHeaderText("Resultat:");
              alert.setContentText("Entrer votre username  ");
 
              alert.showAndWait();
        }
        if( txtpassword.getText().equals(""))
        {
              Alert alert = new Alert(AlertType.INFORMATION);
              alert.setTitle("Alert");
              alert.setHeaderText("Resultat:");
              alert.setContentText("Entrer votre password ");
 
              alert.showAndWait();
            
        }
        if(c.Authentifier(txtusername.getText(),txtpassword.getText())==true)
        {
            if(c.getrole(txtusername.getText(), txtpassword.getText()).equals("admin"))
            {
                iduser=c.getid(txtusername.getText(), txtpassword.getText());
              try {
             FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Backend.fxml"));
            
            Parent root1 = loader.load();
             
            
              
              ((Node)(event.getSource())).getScene().getWindow().hide();
             Stage stage = new Stage();
           
             stage.setScene(new Scene(root1));  
             stage.show();
             
               } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }    
            }
            else
            {
                            iduser=c.getid(txtusername.getText(), txtpassword.getText());
                      try {
             FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Front.fxml"));
            
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
        else
        {
                  Alert alert = new Alert(AlertType.INFORMATION);
              alert.setTitle("Alert");
              alert.setHeaderText("Resultat:");
              alert.setContentText("username ou passord incorrect");
 
              alert.showAndWait();
            System.out.println("erreur");
        }
        
      
        
      
        

    }

    @FXML
    void Fermer(ActionEvent event) {
           Window window = idfermer.getScene().getWindow(); 

     if (window instanceof Stage){ 
      ((Stage) window).close(); 
     } 

    }

    @FXML
    void Motdepasseoublier(ActionEvent event) {

    }

    @FXML
    void inscription(ActionEvent event) {
 try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Inscription.fxml"));
           Parent root1 = loader.load();
              ((Node)(event.getSource())).getScene().getWindow().hide();
             Stage stage = new Stage();
            
             stage.setScene(new Scene(root1));  
             stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
              list.add(0,txtusername.getText());
              list.add(1,txtpassword.getText());
    }
    
   
    
}
