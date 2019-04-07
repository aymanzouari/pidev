/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ModifierformationController implements Initializable {
  @FXML
    private TextField idtitre;

    @FXML
    private TextArea iddes;

    @FXML
    private TextField idprix;

    @FXML
    private TextField idnb;

    @FXML
    private DatePicker iddate;

    @FXML
    private ComboBox<String> idcategorie;
 Crud_categorie cc=new Crud_categorie();
 Crud_formation cf=new Crud_formation();
       
        ObservableList<String> list=FXCollections.observableList(cc.getlist());
           private int id;
    public void setid(int a)
    {
        id=a;
    }
   public void settitre(String t)
  {
      this.idtitre.setText(t);
  }
    public void setdes(String t)
  {
      this.iddes.setText(t);
  }
      public void setprix(String t)
  {
      this.idprix.setText(t);
  }
        public void setnb(String t)
  {
      this.idnb.setText(t);
  }
  public void setdate(LocalDate t)
  {
      this.iddate.setValue(t);
  }
public void setcate(String t)
{
    this.idcategorie.setValue(t);
}
    @FXML
    void modifierformation(ActionEvent event) {
        
  cf.modifierformation(id, idtitre.getText(), iddate.getValue(), Integer.parseInt(idnb.getText()), iddes.getText(),Integer.parseInt(idprix.getText()),cc.getid(idcategorie.getValue()));
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Resultat:");
        alert.setContentText("Modification effectués avec succés");
          alert.showAndWait();
         idtitre.setText("");
         iddate.setValue(null);
         idnb.setText("");
         iddes.setText("");
         idprix.setText("");
         idcategorie.setValue("");
         
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
