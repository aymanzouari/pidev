/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entities.User;
import Services.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author aymen
 */
public class Cruduser {
     Connection C;
     Date t;
     private ObservableList<User> list;
     public Cruduser()
     {
           C =MyConnection.getInstance().getConn();
     }
     
     public void ajouteuser(User u)
     {
           try {
            Statement st = C.createStatement();

            String req = "insert into fos_user (username,username_canonical,email,email_canonical,enabled,salt,password,roles) values ('" + u.getUsername() + "','" + u.getUsername() + "','" +u.getMail() + "','" +u.getMail() + "','" +1+ "','" +u.getPassword()+ "','" + u.getPassword() + "','" + u.getRole() + "')";
            System.out.println(req);
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Cruduser.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     public  ObservableList<User>  afficheuser()
     {
          list=FXCollections.observableArrayList();
          try {
            Statement st = C.createStatement();
            String req = "select * from fos_user";
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                list.add(new User(rs.getString(2),rs.getString(4),rs.getString(7),rs.getString(12)));
                System.out.println("id : " + rs.getInt(1) + " Nom_utilisateur : " + rs.getString(2)+"mail:"+rs.getString(4)+"password"+rs.getString(7)+"role"+rs.getString(12));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Cruduser.class.getName()).log(Level.SEVERE, null, ex);
        }
return list;
     }
      public void Supprimeuser(int a) {
        try {
            PreparedStatement pt = C.prepareStatement("delete  from fos_user  where id=?");
            pt.setInt(1, a);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cruduser.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      public void modifieruser(int id,String role)
      {
           try {
            PreparedStatement pt = C.prepareStatement("update fos_user set roles='"+role+"' where id ="+id+"");
          

            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cruduser.class.getName()).log(Level.SEVERE, null, ex);
        }

      }
      public String getrole(String name ,String password)
      {
         String a="";
           try {
          String req="select * from fos_user where username='"+name+"' and password='"+password+"'";
          System.out.println(req);
           Statement stl = C.createStatement();
                ResultSet rs = stl.executeQuery(req);
               
                 if(rs.next()) {
                   
                       return(rs.getString(12));
                       
                    
                    
                }
                 
                  } catch (SQLException ex) {
                System.err.println("check your email or password");
            }
           System.out.println("role:"+a);   
           return a;
        
          
      }
      
      public int getid(String username,String password)
      {
           try {
          String req="select * from fos_user where username='"+username+"' and password='"+password+"'";
           Statement stl = C.createStatement();
                ResultSet rs = stl.executeQuery(req);
                 if(rs.next()) {
                   
                        return rs.getInt(1);
                       
                    
                    
                }
                  } catch (SQLException ex) {
                System.err.println("check your email or password");
            }
         return 0; 
      }
       public String getnomutilisateur(int id )         
    {
        
        
         try {
                String sql = "Select * from fos_user WHERE id ="+id+"" ; 
                Statement stl = C.createStatement();
                ResultSet rs = stl.executeQuery(sql);
                if (rs.next()) {
                  
                    
                     
                           
                         
                        return rs.getString(2);
                       
                    
                    
                } 
            } catch (SQLException ex) {
                System.err.println("erreur");
            }
        
        return "";
    }
      public boolean Authentifier(String nom,String password)
      {
           try {
       
                String sql = "Select * from fos_user WHERE id =" +getid(nom,password)+"  "; 
                Statement stl = C.createStatement();
                ResultSet rs = stl.executeQuery(sql);
                while(rs.next())
                {
                    System.out.println("id : " + rs.getInt(1) + " Nom_utilisateur : " + rs.getString(2)+"mail:"+rs.getString(4)+"password"+rs.getString(7)+"role"+rs.getString(12));
                    return true;
                }
              
            } catch (SQLException ex) {
                System.err.println("check your email or password");
            }
          
            return false;
      }
      
        

     
    
}
