/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Categorie;
import Entities.Formation;
import Utils.Crud_categorie;
import Utils.Crud_formation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class FormationController implements Initializable {
 @FXML
    private TableView<Formation> tableformation;

    @FXML
    private TableColumn<Formation,String> idtitre;

    @FXML
    private TableColumn<Formation,String> iddescription;

    @FXML
    private TableColumn<Formation,String> idprix;

    @FXML
    private TableColumn<Formation,String> idnbpersonne;

    @FXML
    private TableColumn<Formation,String> iddate;


      @FXML
    private Button idmodifier;

    @FXML
    private Button idsupprimer;
     private ObservableList<Formation> list;
Crud_formation cf=new Crud_formation();
Crud_categorie c=new Crud_categorie();
    @FXML
    void modifierformation(ActionEvent event) {
         try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Modifierformation.fxml"));
             Parent root1= loader.load();
             ModifierformationController mf=loader.getController();
             Formation f=tableformation.getSelectionModel().getSelectedItem();
           
             mf.settitre(f.getTitre());
             mf.setdes(f.getDescription());
             mf.setdate(f.getDate_formation());
             mf.setnb(String.valueOf(f.getNombre_totale()));
             mf.setprix(String.valueOf(f.getPrix()));
             mf.setcate(c.getnomcategorie(cf.getidcategorie(f.getTitre())));
             mf.setid(cf.getid(f.getTitre()));
               
             
             Stage stage = new Stage();
            
             stage.setScene(new Scene(root1));  
             stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    

    }

    @FXML
    void supprimerformation(ActionEvent event) {
    Formation f=tableformation.getSelectionModel().getSelectedItem();
     ObservableList<Formation> formation; 
       formation=tableformation.getSelectionModel().getSelectedItems();  
        formation.forEach(list::remove);
        cf.supprimerformation(cf.getid(f.getTitre()));
       System.out.println("titre:"+f.getTitre());
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Resultat:");
        alert.setContentText("Formation est supprimé avec succés");
 
        alert.showAndWait();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       list=cf.afficheformation();
        idtitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        iddescription.setCellValueFactory(new PropertyValueFactory<>("description"));
         idprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
          iddate.setCellValueFactory(new PropertyValueFactory<>("date_formation"));
        idnbpersonne.setCellValueFactory(new PropertyValueFactory<>("nombre_totale"));

        
        tableformation.setItems(list);
       
    }    
    
}
