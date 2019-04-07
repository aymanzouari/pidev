/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Formation;
import Utils.Crud_formation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class FrontformationController implements Initializable {
    

     private ObservableList<Formation> list=FXCollections.observableArrayList();
      private ObservableList<Formation> recherche=FXCollections.observableArrayList();
Crud_formation cf=new Crud_formation();
    @FXML
    private TextField idrecherche;
     @FXML
    private VBox vbox;
     
    @FXML
    void chercher(ActionEvent event) {
        vbox.getChildren().clear();
recherche=cf.rechercheformation(idrecherche.getText(), idrecherche.getText(), idrecherche.getText());
          Node[] n=new Node[recherche.size()];
                
        for(int i=0;i<n.length;i++)
        {
              try {
         
           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Listeformation.fxml"));
           n[i]=loader.load();
           
           ListeformationController l=loader.getController();
           vbox.getChildren().add(n[i]);
         l.settitre(recherche.get(i).getTitre());
            l.setprix(String.valueOf(recherche.get(i).getPrix()));
            l.setdesc(recherche.get(i).getDescription());
            l.setnb(String.valueOf(recherche.get(i).getNombre_totale()));
            l.setdate(String.valueOf(recherche.get(i).getDate_formation()));
            l.setIdformation(recherche.get(i).getId_formation());
           
             
                  
                  
            
          
       } catch (IOException ex) {
           Logger.getLogger(FrontformationController.class.getName()).log(Level.SEVERE, null, ex);
       }
            
        }
        idrecherche.setText("");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       list=cf.afficheformation();
       
         Node[] n=new Node[list.size()];
                
        for(int i=0;i<n.length;i++)
        {
              try {
         
           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Listeformation.fxml"));
           n[i]=loader.load();
           
           ListeformationController l=loader.getController();
           vbox.getChildren().add(n[i]);
         l.settitre(list.get(i).getTitre());
            l.setprix(String.valueOf(list.get(i).getPrix()));
            l.setdesc(list.get(i).getDescription());
            l.setnb(String.valueOf(list.get(i).getNombre_totale()));
            l.setdate(String.valueOf(list.get(i).getDate_formation()));
            l.setIdformation(list.get(i).getId_formation());
           
             
                  
                  
            
          
       } catch (IOException ex) {
           Logger.getLogger(FrontformationController.class.getName()).log(Level.SEVERE, null, ex);
       }
            
        } 

    }   
    
}
