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
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static sun.security.krb5.KrbException.errorMessage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class AjouteformationController implements Initializable {
 @FXML
    private TextField idtitre;

    @FXML
    private TextField idprix;

    @FXML
    private TextField idnombrep;

    @FXML
    private TextArea iddescription;

    @FXML
    private ComboBox<String> idcategorie;

    @FXML
    private DatePicker iddate;
LocalDate d = LocalDate.now();
    @FXML
    private Button idajouterformation;
Crud_formation cf=new Crud_formation();
Crud_categorie cc=new Crud_categorie();
 ObservableList<String> list=FXCollections.observableList(cc.getlist());


    @FXML
    void ajouterformation(ActionEvent event) {
         String errorMessage = "";
             try {
            Integer.parseInt(idnombrep.getText());
        } catch (NumberFormatException e) {
            errorMessage += "nombre n'est pas valide!\n";
             Alert a1 = new Alert(Alert.AlertType.INFORMATION);
        a1.setTitle("Alert");
        a1.setHeaderText("Resultat:");
        a1.setContentText("nombre n'est pas valide");
         a1.showAndWait();

        }
                try {
            Integer.parseInt(idprix.getText());
        } catch (NumberFormatException e) {
            errorMessage += "prix n'est pas valide!\n";
                  Alert a1 = new Alert(Alert.AlertType.INFORMATION);
        a1.setTitle("Alert");
        a1.setHeaderText("Resultat:");
        a1.setContentText("prix n'est pas valide");
         a1.showAndWait();
        }  
                if(Integer.parseInt(idprix.getText())<0)
                {
          Alert a1 = new Alert(Alert.AlertType.INFORMATION);
        a1.setTitle("Alert");
        a1.setHeaderText("Resultat:");
        a1.setContentText("entrée un prix positive");
         a1.showAndWait();
                }
                else
                              if(Integer.parseInt(idnombrep.getText())<0)
                {
          Alert a1 = new Alert(Alert.AlertType.INFORMATION);
        a1.setTitle("Alert");
        a1.setHeaderText("Resultat:");
        a1.setContentText("entrée un prix positive");
         a1.showAndWait();
                }
                else
                    
       if(idtitre.getText().equals(""))
        {
         Alert a1 = new Alert(Alert.AlertType.INFORMATION);
        a1.setTitle("Alert");
        a1.setHeaderText("Resultat:");
        a1.setContentText("Entrée titre");
         a1.showAndWait();
        }else
            if(iddescription.getText().equals(""))
            {
                          Alert a1 = new Alert(Alert.AlertType.INFORMATION);
        a1.setTitle("Alert");
        a1.setHeaderText("Resultat:");
        a1.setContentText("Entrée description");
         a1.showAndWait();
            }
        else
          if(idcategorie.getSelectionModel().getSelectedItem().toString().equals(""))
                {
                              Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Resultat:");
        alert.setContentText("Entrée categorie");
         alert.showAndWait();
                    
                }
        else
           if(idtitre.getText().equals(""))
                    {
         Alert a2 = new Alert(Alert.AlertType.INFORMATION);
        a2.setTitle("Alert");
        a2.setHeaderText("Resultat:");
        a2.setContentText("Entrée titre");
         a2.showAndWait();
                    }
        else
          if(Integer.parseInt(idnombrep.getText())==0)
                        {
                                      Alert a3 = new Alert(Alert.AlertType.INFORMATION);
        a3.setTitle("Alert");
        a3.setHeaderText("Resultat:");
        a3.setContentText("Entrée nombre de personne");
        
        a3.showAndWait();
                        }
        else
          if(Integer.parseInt(idprix.getText())==0)
                            {
                                          Alert a4 = new Alert(Alert.AlertType.INFORMATION);
        a4.setTitle("Alert");
        a4.setHeaderText("Resultat:");
        a4.setContentText("Entrée prix");
         a4.showAndWait();
                            }
        else
           
                            {
                 Formation fo=new Formation();
        fo.setDate_formation(iddate.getValue());
        fo.setDescription(iddescription.getText());
        fo.setTitre(idtitre.getText());
        fo.setUser_id(LoginController.iduser);
        fo.setCategorie_id(cc.getid(idcategorie.getSelectionModel().getSelectedItem().toString()));
        fo.setNombre_totale(Integer.parseInt(idnombrep.getText()));
        fo.setPrix(Integer.parseInt(idprix.getText()));     
         if(iddate.getValue().isBefore(LocalDate.now()))
     {
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Resultat:");
        alert.setContentText("la date n'est pas valide");
 
        alert.showAndWait();
     }
     else
         {
            cf.ajoute_formation(fo);
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Resultat:");
        alert.setContentText("Formation est ajouté avec succés");
 
        alert.showAndWait();
        iddate.setValue(null);
        iddescription.setText("");
        idtitre.setText("");
        idcategorie.setValue(null);
        idnombrep.setText("");
        idprix.setText("");
         
         }
        
                            }
              }                    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               cc.getnomcategorie();
    
      
       
       
        idcategorie.setItems(list);
    }    
    
}
