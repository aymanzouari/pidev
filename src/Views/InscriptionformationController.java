/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Inscription;
import Utils.Crud_formation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class InscriptionformationController implements Initializable {
    @FXML
    private TableView<Inscription> tableinscription;

    @FXML
    private TableColumn<Inscription,String> idnomformation;

    @FXML
    private TableColumn<Inscription,String> iddateformation;

    @FXML
    private TableColumn<Inscription,String> idnominscription;
    private ObservableList<Inscription> list;
    Crud_formation cf=new Crud_formation();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list=cf.afficheinscription();
        idnomformation.setCellValueFactory(new PropertyValueFactory<>("nom_formation"));
        iddateformation.setCellValueFactory(new PropertyValueFactory<>("date_formation"));
        idnominscription.setCellValueFactory(new PropertyValueFactory<>("nom_ins"));
        tableinscription.setItems(list);
    }    
    
}
