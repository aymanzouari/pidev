/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entities.Categorie;
import Entities.Formation;
import Entities.Inscription;
import Services.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author aymen
 */
public class Crud_formation {
      Connection C;
       private ObservableList<Formation> list;
        private ObservableList<Formation> recherche;
        private ObservableList<Inscription> listins;
      public Crud_formation()
      {
             C =MyConnection.getInstance().getConn();
      }
      public void ajoute_formation(Formation f)
      {
           try {
             Statement st = C.createStatement();
    
                String req="insert into formation (titre,date,nombretotale,categorie_id,discription,prix,test,user_id) values ('" +f.getTitre()+ "','" +f.getDate_formation()+ "','"+f.getNombre_totale()+ "','" +f.getCategorie_id()+ "','" +f.getDescription()+ "','" +f.getPrix()+ "','" +0+ "','" +f.getUser_id()+ "')";
       
              st.executeUpdate(req);
          } catch (SQLException ex) {
              Logger.getLogger(Crud_formation.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
          public int getidcategorie(String nom)
      {
           try {
          String req="select * from formation where titre='"+nom+"'";
           Statement stl = C.createStatement();
                ResultSet rs = stl.executeQuery(req);
                 if(rs.next()) {
                   
                        return rs.getInt(8);
                       
                    
                    
                }
                  } catch (SQLException ex) {
                
            }
         return 0; 
      }
      public void supprimerformation(int id)
      {
           try {
            PreparedStatement pt = C.prepareStatement("delete  from formation  where id=?");
            pt.setInt(1,id);
            System.out.println(pt);
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Crud_formation.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      public int getid(String titre)
      {
         
            try {
          String req="select * from formation where titre='"+titre+"'";
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
      public ObservableList<Formation> afficheformation()
      {
          list=FXCollections.observableArrayList();
           try {
            Statement st = C.createStatement();
            String req="select * from formation";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
                
            {
                 list.add(new Formation(rs.getInt(1),rs.getString(3),rs.getString(6),rs.getInt(7),rs.getInt(5),rs.getDate(4).toLocalDate()));
            
                
            }   } catch (SQLException ex) {
            Logger.getLogger(Crud_formation.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           return list;
      }
        public ObservableList<Formation> rechercheformation(String nom,String date,String prix)
      {
          recherche=FXCollections.observableArrayList();
           try {
            Statement st = C.createStatement();
            String req="select * from formation where titre like '"+nom+"%'or date like '"+date+"%' or prix='"+prix+"'";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
                
            {
                 recherche.add(new Formation(rs.getInt(1),rs.getString(3),rs.getString(6),rs.getInt(7),rs.getInt(5),rs.getDate(4).toLocalDate()));
            
                
            }   } catch (SQLException ex) {
            Logger.getLogger(Crud_formation.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           return recherche;
      }
      public void modifierformation(int id ,String titre,LocalDate date,int nombretotale,String description,int prix,int categorie)
      {
           try {
            PreparedStatement pt = C.prepareStatement("update formation set titre ='"+titre+"' , date='"+date+"' ,nombretotale='"+nombretotale+"' ,discription='"+description+"' ,prix= '"+prix+"' ,Categorie_id= '"+categorie+"' where id ='"+id+"'");
           
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Crud_formation.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
     
       public ObservableList<Formation> afficheformationparid(int id)
      {
          list=FXCollections.observableArrayList();
           try {
            Statement st = C.createStatement();
            String req="select * from formation where id="+id+"";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
                
            {
                 list.add(new Formation(rs.getInt(1),rs.getString(3),rs.getString(6),rs.getInt(7),rs.getInt(5),rs.getDate(4).toLocalDate()));
            
                
            }   } catch (SQLException ex) {
            Logger.getLogger(Crud_formation.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           return list;
      }

     public void ajoute_inscription(Inscription i)
      {
           try {
             Statement st = C.createStatement();
    
                String req="insert into inscription (formation_id,nomins,date,titre) values ('" +i.getFormation_id()+ "','" +i.getNom_ins()+ "','"+i.getDate_formation()+ "','" +i.getNom_formation()+ "')";
       
              st.executeUpdate(req);
          } catch (SQLException ex) {
              Logger.getLogger(Crud_formation.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    public void modifiernbpersonne(int id, int nb)
    {
         try {
            PreparedStatement pt = C.prepareStatement("update formation set nombretotale ='"+nb+"' where id ="+id+"");
           
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Crud_formation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public ObservableList<Inscription> afficheinscription()
      {
          listins=FXCollections.observableArrayList();
           try {
            Statement st = C.createStatement();
            String req="select * from inscription";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
                
            {
                
                 listins.add(new Inscription(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            
                
            }   } catch (SQLException ex) {
            Logger.getLogger(Crud_formation.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           return listins;
      }
     public ObservableList<Inscription> testinscription()
      {
          listins=FXCollections.observableArrayList();
           try {
            Statement st = C.createStatement();
            String req="select * from inscription";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
                
            {
                
                 listins.add(new Inscription(rs.getInt(2),rs.getString(3)));
            
                
            }   } catch (SQLException ex) {
            Logger.getLogger(Crud_formation.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           return listins;
      }
}
