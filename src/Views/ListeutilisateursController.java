/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.User;
import Utils.Cruduser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ListeutilisateursController implements Initializable {
  @FXML
    private TableView<User> listeutilisateur;

    @FXML
    private TableColumn<User,String> username;

    @FXML
    private TableColumn<User,String> mail;

    @FXML
    private TableColumn<User,String> password;

    @FXML
    private TableColumn<User,String> role;

    @FXML
    private TextField idrole;
    private ObservableList<User> list;
    Cruduser c=new Cruduser();

    @FXML
    void modifier(ActionEvent event) {
        User u=listeutilisateur.getSelectionModel().getSelectedItem();
        if(!idrole.getText().equals("utilisateur") && !idrole.getText().equals("admin") )
        {
                          Alert a = new Alert(Alert.AlertType.INFORMATION);   
        a.setTitle("Alert");
        a.setHeaderText("Resultat:");
        a.setContentText("role est incorrect");
        a.showAndWait(); 
        }
        else
        {
            c.modifieruser(c.getid(u.getUsername(), u.getPassword()),idrole.getText());
                  Alert a = new Alert(Alert.AlertType.INFORMATION);   
        a.setTitle("Alert");
        a.setHeaderText("Resultat:");
        a.setContentText("Modification effectués avec succés");
        a.showAndWait(); 
        }
       

    } 

    
    @FXML
    void supprimer(ActionEvent event) {
User f=listeutilisateur.getSelectionModel().getSelectedItem();
     ObservableList<User> user; 
       user=listeutilisateur.getSelectionModel().getSelectedItems();  
        user.forEach(list::remove);
        c.Supprimeuser(c.getid(f.getUsername(),f.getPassword()));
    
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Resultat:");
        alert.setContentText("l utilisateur" +f.getUsername()+"est supprimé avec succés");
 
        alert.showAndWait();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list=c.afficheuser();
           username.setCellValueFactory(new PropertyValueFactory<>("username"));
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
         password.setCellValueFactory(new PropertyValueFactory<>("password"));
          role.setCellValueFactory(new PropertyValueFactory<>("role"));
          listeutilisateur.setItems(list);
    }    
    
}
