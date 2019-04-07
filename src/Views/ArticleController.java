/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Article;
import Utils.Crud_Article;
import Utils.Crud_categorie;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ArticleController implements Initializable {

    @FXML
    public TableView<Article> tablearticle;

    @FXML
    
    public TableColumn<Article,String> idnom;

    @FXML
    public TableColumn<Article,String> idimage;

    @FXML
    public TableColumn<Article,String> iddescription;

    @FXML
    public TableColumn<Article,String> iddate;
    Crud_categorie cc=new Crud_categorie();
    private ObservableList<Article> list;
Crud_Article ca=new Crud_Article();
List<Integer> l=new ArrayList<>();
private int id;

    
public int getid()
{
     
    return id;
   
}

    @FXML
    private Pane pane;

     @FXML
    void articlee(KeyEvent event) {
        
    }
      @FXML
   void articles(MouseEvent event) {

    }
    @FXML
    void ajoutearticle(ActionEvent event) {
          try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Ajoutearticle.fxml"));
             Parent root1= loader.load();
              ((Node)(event.getSource())).getScene().getWindow().hide();
             Stage stage = new Stage();
            
             stage.setScene(new Scene(root1));  
             stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  

    @FXML
    void modifiearticle(ActionEvent event) {
       
          try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Modifiearticle.fxml"));
         
       
             Parent root1= loader.load();
                  ModifiearticleController modif=loader.getController();
              
          Article a=tablearticle.getSelectionModel().getSelectedItem();
       
      
          
         modif.Settitre(a.getNom());
         modif.setdate(a.getDate_article());
         modif.setdescription(a.getDescription());
         modif.setcategorie(cc.getnomcategorie(ca.getidcategorie(a.getNom())));
         id=ca.getid(a.getNom());
         modif.setid(id);
         modif.setIdimage(new Image("http://localhost/pi/"+ca.getImage(id)));
         System.out.println("id1"+id);
            
             Stage stage = new Stage();
            
             stage.setScene(new Scene(root1));  
             stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
       

  
    }

    @FXML
    void supprimerarticle(ActionEvent event) {
        Article a=tablearticle.getSelectionModel().getSelectedItem();
        ObservableList<Article> article; 
       article=tablearticle.getSelectionModel().getSelectedItems();  
        article.forEach(list::remove);
        ca.supprimer_article(ca.getid(a.getNom()));
      
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Resultat:");
        alert.setContentText("Article est supprimé avec succés");
 
        alert.showAndWait();

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list=ca.afficherArticle();
          idnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        idimage.setCellValueFactory(new PropertyValueFactory<>("image"));
         iddescription.setCellValueFactory(new PropertyValueFactory<>("description"));
          iddate.setCellValueFactory(new PropertyValueFactory<>("date_article"));
       tablearticle.setItems(list);
       

        
    }    
    
}
