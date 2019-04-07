/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Categorie;
import Utils.Crud_categorie;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class CategorieController  implements Initializable {
 @FXML
    private TextField idcategorie;

    @FXML
    private Button ajoutercategorie;
   @FXML
    private Button idmodifier;

    @FXML
    private Button idsupprimer;

    @FXML
    private TableView<Categorie> listecategorie;

    @FXML
    private TableColumn<Categorie,String> nomcategorie;
       private ObservableList<Categorie> list;

    @FXML
            
    Crud_categorie cc=new Crud_categorie();


    @FXML
    void ajoutercategorie(ActionEvent event) {
   
       if(cc.verif(idcategorie.getText())==false )
       {
                  
        if(idcategorie.getText().equals(""))
        {
            Alert alert = new Alert(AlertType.INFORMATION);
              alert.setTitle("Alert");
              alert.setHeaderText("Resultat:");
              alert.setContentText("Entrer un nom");
 
              alert.showAndWait();
            
        }else
        {
             cc.ajoute_categorie(idcategorie.getText());
               Alert a = new Alert(AlertType.INFORMATION);
                a.setTitle("Alert");
        a.setHeaderText("Resultat:");
        a.setContentText("Categorie ajoutée avec succés");
        a.showAndWait();
          list=cc.affichercategorie();
        
       
       
        
        listecategorie.setItems(list);
        idcategorie.setText(""); 
        }
           
       }
       else
       {
          Alert a = new Alert(AlertType.INFORMATION);   
        a.setTitle("Alert");
        a.setHeaderText("Resultat:");
        a.setContentText("ce nom existe deja!");
        a.showAndWait();
           System.out.println("nom categorie existe");
       }
      
        
       
      nomcategorie.setCellValueFactory(new PropertyValueFactory<>("type"));
    
    }
        @FXML
    void categoriee(KeyEvent event) {
          Categorie c=listecategorie.getSelectionModel().getSelectedItem();
         idcategorie.setText(c.getType());

    }
   
      @FXML
    void modifiercategorie(ActionEvent event) {
       Categorie c=listecategorie.getSelectionModel().getSelectedItem();
          if(idcategorie.getText().equals(""))
        {
            Alert alert = new Alert(AlertType.INFORMATION);
              alert.setTitle("Alert");
              alert.setHeaderText("Resultat:");
              alert.setContentText("Entrer un nom");
 
              alert.showAndWait();
            
        }
          else
          {
              cc.modifier_categorie(cc.getid(c.getType()),idcategorie.getText());
               Alert a = new Alert(AlertType.INFORMATION);   
        a.setTitle("Alert");
        a.setHeaderText("Resultat:");
        a.setContentText("Modification effectués avec succés");
        a.showAndWait();
        idcategorie.setText("");
         
           list=cc.affichercategorie();
        listecategorie.setItems(list);
        nomcategorie.setCellValueFactory(new PropertyValueFactory<>("type")); 

              
          }
      
    }
   
 
 
    @FXML
    void supprimercategorie(ActionEvent event) {
        
         Categorie c=listecategorie.getSelectionModel().getSelectedItem();
        
      ObservableList<Categorie> categorie; 
       categorie=listecategorie.getSelectionModel().getSelectedItems();
       
        categorie.forEach(list::remove);
       
       cc.supprimercategorie(cc.getid(c.getType()));
           Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Resultat:");
        alert.setContentText("Categorie est supprimé avec succés");
 
        alert.showAndWait();
       
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         list=cc.affichercategorie();
        
        nomcategorie.setCellValueFactory(new PropertyValueFactory<>("type"));
       
        
        listecategorie.setItems(list);
       
     Categorie c=listecategorie.getSelectionModel().getSelectedItem();
     listecategorie.setOnKeyPressed(e->{
         
         idcategorie.setText(c.getType());
             });
         
    
     
     
         
       
    }    
    
}
