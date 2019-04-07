/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import Entities.Article;
import Entities.Commantaire;
import Services.MyConnection;
import Views.LoginController;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author aymen
 */

public class Crud_Article {
      Connection C;
    LocalDate date = LocalDate.now(); 
     private ObservableList<Article> list;
      private ObservableList<Commantaire> listcomm;
      Cruduser u=new Cruduser();
    public Crud_Article()
    {
         C =MyConnection.getInstance().getConn();
        
    }
    public void Ajoute_article(Article a)
    {
      
       
          try {
             Statement st = C.createStatement();
    String req = "insert into article (nom,description,datearticle,categorie_id,image_name,updated_at,user_id) values ('" +a.getNom()+ "','" +a.getDescription()+ "','"+a.getDate_article()+ "','" +a.getCategorie_id()+ "','" +a.getImage()+ "','" +date+ "','" +a.getUser_id()+ "')";
   
       System.out.println(req);
              st.executeUpdate(req);
          } catch (SQLException ex) {
              Logger.getLogger(Crud_Article.class.getName()).log(Level.SEVERE, null, ex);
          }
       
        
    }
       public void Ajoute_comm(int article_id,String comm,int iduser,String nom)
    {
      
       
          try {
             Statement st = C.createStatement();
    String req = "insert into commantaire (article_id,commontaire,user_id,nom_user) values ('" +article_id+ "','" +comm+ "','" +iduser+ "','" +nom+ "')";
   
       System.out.println(req);
              st.executeUpdate(req);
          } catch (SQLException ex) {
           Logger.getLogger(Crud_Article.class.getName()).log(Level.SEVERE, null, ex);
          }
       
        
    }
  public ObservableList<Commantaire> affichercomm(int id)
    {
         listcomm=FXCollections.observableArrayList();
        try {
            Statement st = C.createStatement();
            String req="select * from commantaire where article_id="+id;
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                
                listcomm.add(new Commantaire(rs.getString(4),rs.getString(5)));
              
                
            }   
        } catch (SQLException ex) {
            Logger.getLogger(Crud_Article.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listcomm;
        
    }
            public int getidcategorie(String nom)
      {
           try {
          String req="select * from article where nom='"+nom+"'";
           Statement stl = C.createStatement();
                ResultSet rs = stl.executeQuery(req);
                 if(rs.next()) {
                   
                        return rs.getInt(5);
                       
                    
                    
                }
                  } catch (SQLException ex) {
                
            }
         return 0; 
      }
 
     public ObservableList<Article> afficherArticle()
    {
         list=FXCollections.observableArrayList();
        try {
            Statement st = C.createStatement();
            String req="select * from article";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                
                list.add(new Article(rs.getString(2),rs.getString(3),rs.getDate(4).toLocalDate(),rs.getInt(5),rs.getString(6)));
              
                
            }   
        } catch (SQLException ex) {
            Logger.getLogger(Crud_Article.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
       public ObservableList<Article> afficherArticleparcategorie(int categorie)
    {
         list=FXCollections.observableArrayList();
        try {
            Statement st = C.createStatement();
            String req="select * from article where Categorie_id='"+categorie+"'";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                
                list.add(new Article(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4).toLocalDate(),rs.getInt(5),rs.getString(6)));
              
                
            }   
        } catch (SQLException ex) {
            Logger.getLogger(Crud_Article.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
      public int getid(String titre)
      {
         
            try {
          String req="select * from Article where nom='"+titre+"'";
          System.out.println(req);
           Statement stl = C.createStatement();
                ResultSet rs = stl.executeQuery(req);
                 while(rs.next()) {
                 
                        return rs.getInt(1);
                      
                       
                    
                    
                }
                    
                  } catch (SQLException ex) {
                
            }
          
         return 0; 
      }
    
    public void supprimer_article(int id)
    {
          try {
            PreparedStatement pt = C.prepareStatement("delete  from article  where id=?");
            pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Crud_Article.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modifier_article(int id ,String nom,String description,LocalDate date,String image,int categorie)
    {
         try {
            PreparedStatement pt = C.prepareStatement("update article set nom ='"+nom+"' , description='"+description+"' ,datearticle='"+date+"' ,image_name='"+image+"',Categorie_id='"+categorie+"' where id ='"+id+"'");
           System.out.println(pt);
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Crud_Article.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getImage(int id)
    {
           try {
          String req="select image_name from Article where id="+id+"";
          System.out.println(req);
           Statement stl = C.createStatement();
                ResultSet rs = stl.executeQuery(req);
                 while(rs.next()) {
                 
                        return rs.getString(1);
                      
                       
                    
                    
                }
                    
                  } catch (SQLException ex) {
                
            }
           return "";
    }
}
