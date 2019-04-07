/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Commantaire;
import Utils.Crud_Article;
import Utils.Cruduser;
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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ArticleeController implements Initializable {
private int idarticle;
    @FXML
    private ImageView idimage;

    @FXML
    private TextField idtitre;

    @FXML
    private TextArea iddescription;

    @FXML
    private TextField iddate;
     
    @FXML
    private ListView<Commantaire> listecomm=new ListView<Commantaire>();

    @FXML
    private Button idcom;
    @FXML
    private TextArea idcomment;
     private ObservableList<Commantaire> com=FXCollections.observableArrayList();
     Crud_Article a=new Crud_Article();
     Cruduser u=new Cruduser();

    public void setIdarticle(int idarticle) {
        this.idarticle = idarticle;
    }
     
      public void init()
      {
         listecomm.getItems().clear();
         com=a.affichercomm(idarticle);
       
        com.stream().forEach((m) -> {listecomm.getItems().add(m);});
      
        listecomm.setCellFactory(param -> new ListCell<Commantaire>() {
            protected void updateItem(Commantaire item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null); 
                } else {
                   
                    setText(" User name   : "+item.getNom_user()+"\n "+item.getCommantaire()+"\n ");
                }
            }
        });
         
           
      }


    @FXML
    void Commentaire(ActionEvent event) {
   a.Ajoute_comm(idarticle,idcomment.getText(),LoginController.iduser,u.getnomutilisateur(LoginController.iduser));
   idcomment.setText("");
   init();

    }

    public void setIdimage(Image idimage) {
        this.idimage.setImage(idimage); 
    }
  
    public void settitre(String nom)
    {
        idtitre.setText(nom);
    }
    public void setdes(String n)
    {
        iddescription.setText(n);
        
    }
    public void setdate(String s)
    {
        iddate.setText(s);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
     
    }    
    
}
