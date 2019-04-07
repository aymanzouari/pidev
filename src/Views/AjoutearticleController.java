/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Article;
import Entities.Categorie;
import Entities.User;
import Services.PostFile;
import Utils.Crud_Article;
import Utils.Crud_categorie;
import Utils.Cruduser;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class AjoutearticleController implements Initializable {

    @FXML
    private TextField idtitre;

       @FXML
    private ImageView idimage;

    @FXML
    private TextArea iddescription;

    @FXML
    private DatePicker iddate;

    @FXML
    private Button idajoute;
    File file;
    String path;
       @FXML
    private ComboBox<String> idcategorie;
     
        Crud_Article c=new Crud_Article();
         Cruduser u=new Cruduser();
        LoginController lc=new LoginController();
        Crud_categorie cc=new Crud_categorie();
       
        ObservableList<String> list=FXCollections.observableList(cc.getlist());
       
    @FXML
    void importerimage(ActionEvent event) {
           FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile != null)
        {
              
              try {
                  String imageFile= selectedFile.toURI().toURL().toString();
                  this.file= selectedFile;
                  System.out.println(imageFile);
                  System.out.println(selectedFile.getAbsoluteFile());
      
                  Image image = new Image(imageFile) {} ;
    
                  try {
                      path=PostFile.upload(selectedFile.getAbsolutePath());
                      idimage.setImage(image);
                      
                  } catch (Exception ex) {
                      Logger.getLogger(AjoutearticleController.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  System.out.println(path);
          
              } catch (MalformedURLException ex) {
                  Logger.getLogger(AjoutearticleController.class.getName()).log(Level.SEVERE, null, ex);
              }
              
            
        }
    }
        
    @FXML
    void ajoutearticle(ActionEvent event) {
        Article a=new Article();
        a.setNom(idtitre.getText());
        a.setDescription(iddescription.getText());
        a.setImage(path);
        a.setUser_id(LoginController.iduser);
        
       
     
        a.setDate_article(iddate.getValue());
  //  a.setUser_id(u.getid(lc.getlist().get(0),lc.getlist().get(1)));
        a.setCategorie_id(cc.getid(idcategorie.getSelectionModel().getSelectedItem().toString()));
     if(iddate.getValue().equals(LocalDate.now()))
     {
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Resultat:");
        alert.setContentText("la date n'est pas valide");
        alert.showAndWait();
     }
     else
     {
             c.Ajoute_article(a);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Resultat:");
        alert.setContentText("Article est ajouté avec succés");
 
        alert.showAndWait();
        Image i = null;
        idtitre.setText("");
        iddescription.setText("");
        iddate.setValue(null);
        idimage.setImage(i); 
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
