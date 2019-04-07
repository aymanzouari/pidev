/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import Entities.Article;
import Entities.Categorie;
import Services.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author aymen
 */
public class Crud_categorie {
       Connection C;
      private List<String>  liste=new ArrayList<>();
       private ObservableList<Categorie> list;
      
    public Crud_categorie()
    {
        C =MyConnection.getInstance().getConn();
        
    }
    
    public void ajoute_categorie(String nom)
    {
         try {
             Statement st = C.createStatement();
    
             String req = "insert into categorie (type) values ('" +nom+ "')";
            System.out.println(req);
              st.executeUpdate(req);
          } catch (SQLException ex) {
              Logger.getLogger(Crud_categorie.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }
         public int getid(String nom)
      {
           try {
          String req="select * from categorie where type='"+nom+"'";
           Statement stl = C.createStatement();
                ResultSet rs = stl.executeQuery(req);
                 if(rs.next()) {
                   
                        return rs.getInt(1);
                       
                    
                    
                }
                  } catch (SQLException ex) {
                
            }
         return 0; 
      }
     public List<String> getlist()
    {
        return liste;
    }
     
    public void getnomcategorie()
    {
    
        try {
            Statement st = C.createStatement();
            String req="select * from categorie";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                liste.add(rs.getString(2));
                System.out.println("Id : "+rs.getInt(1)+"type:"+rs.getString(2));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(Crud_categorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("aa");
        for(String x:liste)
        {
            System.out.println(x);
        }
       
        
    }
     public String getnomcategorie(int id)
    {
        String a="";
    
        try {
            Statement st = C.createStatement();
            String req="select * from categorie where id='"+id+"'";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
             a=rs.getString(2);
                
            }   
        } catch (SQLException ex) {
            Logger.getLogger(Crud_categorie.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       System.out.println("nom"+a);
        return a;
    }
            
     public ObservableList<Categorie> affichercategorie()
    {
       list=FXCollections.observableArrayList();
        try {
            Statement st = C.createStatement();
            String req="select * from categorie";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                list.add(new Categorie(rs.getString(2)));
                System.out.println("Id : "+rs.getInt(1)+"type:"+rs.getString(2));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(Crud_categorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public void supprimercategorie(int id)
     {
        
          try {
            PreparedStatement pt = C.prepareStatement("delete  from categorie  where id=?");
           
            pt.setInt(1,id);
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Crud_categorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
       public void modifier_categorie(int id,String nom)
    {
         try {
            PreparedStatement pt = C.prepareStatement("update categorie set type = ?  where id =?");
            pt.setString(1,nom);
           
            pt.setInt(2, id);
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Crud_Article.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public boolean verif(String nom)
       {
           try {
            Statement st = C.createStatement();
            String req="select * from categorie where type='"+nom+"'";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                
                System.out.println("Id : "+rs.getInt(1)+"type:"+rs.getString(2));
                return true;
                
            }   } catch (SQLException ex) {
            Logger.getLogger(Crud_categorie.class.getName()).log(Level.SEVERE, null, ex);
        } 
         return false;
                 
       }
}
