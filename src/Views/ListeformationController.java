/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Formation;
import Entities.Inscription;
import Utils.Crud_formation;
import Utils.Cruduser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ListeformationController implements Initializable {
    @FXML
    private TextField idtitre;

    @FXML
    private TextField idprix;

    @FXML
    private TextArea iddes;

    @FXML
    private TextField idnb;

    @FXML
    private TextField iddate;
     @FXML
    private Button idinscription;
private int idformation;
     private ObservableList<Formation> list=FXCollections.observableArrayList();
     private ObservableList<Inscription> listins=FXCollections.observableArrayList();
Crud_formation cf=new Crud_formation();
Cruduser u=new Cruduser();
public Button getinscrip()
{
    return idinscription;
}

public void settitre(String t)
{
    this.idtitre.setText(t);
    
}
public void setprix(String t)
{
    this.idprix.setText(t);
    
}
public void setdesc(String t)
{
    this.iddes.setText(t);
    
}
public void setdate(String t)
{
    this.iddate.setText(t);
    
}
public void setnb(String t)
{
    this.idnb.setText(t);
    
}

    public void setIdformation(int idformation) {
        this.idformation = idformation;
    }

    @FXML
    void inscription(ActionEvent event) {
        
    list=cf.afficheformationparid(idformation);
  
     Inscription i=new Inscription();
  
                            
        for (Formation list1 : list)
        {
            if(list1.getId_formation()==idformation)
            {
                if(Integer.parseInt(idnb.getText())==0)
                {
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                       alert.setTitle("Alert");
                       alert.setHeaderText("Resultat:");
                      alert.setContentText("désolé le nombre des personnes totale et atteint");
                       alert.showAndWait();
                }
                else
                    if(test()==false)
                    {
                           Alert alert = new Alert(Alert.AlertType.INFORMATION);
                     alert.setTitle("Alert");
               alert.setHeaderText("Resultat:");
               alert.setContentText("Deja inscrit dans cette formation");
                alert.showAndWait();
                    }
                else
                        
                {
                    
                          idnb.setText(String.valueOf(list1.getNombre_totale()-1));
                     cf.modifiernbpersonne(idformation,Integer.parseInt(idnb.getText()));
                i.setDate_formation(list1.getDate_formation().toString());
                i.setNom_formation(list1.getTitre());
                i.setNom_ins(u.getnomutilisateur(LoginController.iduser));
                i.setFormation_id(idformation);
                cf.ajoute_inscription(i);
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Alert");
               alert.setHeaderText("Resultat:");
               alert.setContentText("Inscription réussie");
                alert.showAndWait();
               
                
                  
                }
               
               
               
                
            }
       } 
         
   }
                    
     
 public boolean test()
 {
       listins=cf.testinscription();
     Boolean b=true;
        for(Inscription ins:listins)
     {
         System.out.println("list:"+ins.getNom_ins()+ins.getFormation_id());
     }
       for(Inscription in:listins)
                    {
                        if(u.getnomutilisateur(LoginController.iduser).equals(in.getNom_ins()) && in.getFormation_id()==idformation)
                        {
                             b=false;
                            
                        }
                       
                    } 
       System.out.println("test"+b);
       return b;
 }
   
   
         

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }    
    
}
