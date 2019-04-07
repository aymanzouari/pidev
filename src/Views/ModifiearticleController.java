/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Article;
import Services.PostFile;
import Utils.Crud_Article;
import Utils.Crud_categorie;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ModifiearticleController implements Initializable {
   @FXML
    private TextField idtitre;

    @FXML
    
    private ImageView idimage;
Image image;
    @FXML
    private TextArea iddescription;
  File file;
    String path;
    @FXML
    private ComboBox<String> idcategorie;
 Crud_categorie cc=new Crud_categorie();
 Crud_Article ca=new Crud_Article();
       
        ObservableList<String> list=FXCollections.observableList(cc.getlist());
       
    @FXML
    private DatePicker iddate;
    private int id;
    public void setid(int a)
    {
        id=a;
    }

    public void setIdimage(Image image) {
        this.idimage.setImage(image); 
    }
    
  public void Settitre(String t)
    {
       idtitre.setText(t);
    }

    public void setdescription(String s)
    {
         iddescription.setText(s);
    }
    public void setdate(LocalDate s)
    {
         iddate.setValue(s);
        
    }
    public void setcategorie(String f)
    {
         idcategorie.setValue(f);
    }
  @FXML
    void importer(ActionEvent event) {
         FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile != null)
        {
              
              try {
                  String imageFile= selectedFile.toURI().toURL().toString();
                  this.file= selectedFile;
                  System.out.println(imageFile);
                  System.out.println(selectedFile.getAbsoluteFile());
      
                  image = new Image(imageFile) {} ;
    
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
    void modiiferarticle(ActionEvent event) throws IOException {
         
        FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Article.fxml"));
        Parent root1= loader.load();
       ArticleController ac=loader.getController(); 
      
      
      
    ca.modifier_article(id,idtitre.getText(),iddescription.getText(),iddate.getValue(),path,cc.getid(idcategorie.getValue()));     
     
       
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Resultat:");
        alert.setContentText("Modification effectués avec succés");
          
         alert.showAndWait();
         idtitre.setText("");
        iddescription.setText("");
        iddate.setValue(null);
        Image i=null;
        idimage.setImage(i);
        idcategorie.setValue(null);
     
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
