/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Article;
import Entities.Commantaire;
import Entities.Formation;
import Utils.Crud_Article;
import Utils.Crud_categorie;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ActualitesController implements Initializable {
        @FXML
    private VBox vbox;

    @FXML
    private ListView<String> listecategorie;
     Crud_categorie cc=new Crud_categorie();
       
        ObservableList<String> list=FXCollections.observableList(cc.getlist());
          
            private ObservableList<Article> categorie=FXCollections.observableArrayList();
             private ObservableList<Commantaire> com=FXCollections.observableArrayList();
Crud_Article cf=new Crud_Article();
public ObservableList<Article> getlist()
{
    return categorie;
}
      private   int i;
    @FXML
    void afficherarticle(MouseEvent event) {
          vbox.getChildren().clear();
        categorie=cf.afficherArticleparcategorie(cc.getid(listecategorie.getSelectionModel().getSelectedItem()));

             Node[] n=new Node[categorie.size()];
              
          
        for(i=0;i<n.length;i++)
        {
         
                                 try {
                  FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Articlee.fxml"));
           n[i]=loader.load();
           ArticleeController a=loader.getController();
         
   System.out.println(categorie.get(i).getId());
                 vbox.getChildren().add(n[i]);
            a.settitre(categorie.get(i).getNom());
            a.setdes(categorie.get(i).getDescription());
            a.setIdimage(new Image("http://localhost/pi/"+cf.getImage(categorie.get(i).getId())));
            a.setdate(categorie.get(i).getDate_article().toString()); 
           a.setIdarticle(categorie.get(i).getId());
           a.init();
     
            
               } catch (IOException ex) {
           Logger.getLogger(FrontformationController.class.getName()).log(Level.SEVERE, null, ex);
             
       }
                   
    
        }
              
       
        
       
 }
         
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         cc.getnomcategorie();
         listecategorie.setItems(list);
       
         }
    
}
