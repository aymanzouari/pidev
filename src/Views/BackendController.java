/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class BackendController implements Initializable {
 
   @FXML
    private Pane pane1;
   
    @FXML
    private MenuItem idlogout;

  
  Node[] n=new Node[7];
    @FXML
    void ajoutecategorie(ActionEvent event )  {
     pane1.getChildren().clear();
       try {
         
           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Categorie.fxml"));
           n[0]=loader.load();
      
           pane1.getChildren().add(n[0]);
       } catch (IOException ex) {
           Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
       }
     
     

    
    }
  @FXML
    void ajoutearticle(ActionEvent event) {
         pane1.getChildren().clear();
      try {
         
           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Ajoutearticle.fxml"));
           n[5]=loader.load();
       
           pane1.getChildren().add(n[5]);
       } catch (IOException ex) {
           Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    @FXML
    void ajoutformation(ActionEvent event) {
         pane1.getChildren().clear();
            try {
          
           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Ajouteformation.fxml"));
           n[1]=loader.load();
         
           pane1.getChildren().add(n[1]);
       } catch (IOException ex) {
           Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @FXML
    void listearticle(ActionEvent event) {
         pane1.getChildren().clear();
               try {
          
           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Article.fxml"));
           n[2]=loader.load();
     
           pane1.getChildren().add(n[2]);
       } catch (IOException ex) {
           Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

 

    @FXML
    void listeformation(ActionEvent event) {
         pane1.getChildren().clear();
                  try {
          
           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Formation.fxml"));
           n[3]=loader.load();
        
           pane1.getChildren().add(n[3]);
       } catch (IOException ex) {
           Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
       }
  
    }

    @FXML
    void listeinscription(ActionEvent event) {
         pane1.getChildren().clear();
            try {
          
           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Inscriptionformation.fxml"));
           n[4]=loader.load();
        
           pane1.getChildren().add(n[4]);
       } catch (IOException ex) {
           Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @FXML
    void listeutilisateur(ActionEvent event) {
         pane1.getChildren().clear();
                    try {
          
           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Listeutilisateurs.fxml"));
           n[6]=loader.load();
         
           pane1.getChildren().add(n[6]);
       } catch (IOException ex) {
           Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @FXML
    void logout(ActionEvent event) {
              try {
             FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Login.fxml"));
            
            Parent root1 = loader.load();
             
            
              
              ((Node)(event.getSource())).getScene().getWindow().hide();
             Stage stage = new Stage();
           
             stage.setScene(new Scene(root1));  
             stage.show();
             
               } catch (IOException ex) {
            Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
    }

  


 

  

    }
 

