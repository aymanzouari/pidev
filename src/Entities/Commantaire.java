/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author aymen
 */
public class Commantaire {
    private int id_commantaire;
    private int user_id;
    private int article_id;
    private String commantaire;
    private String nom_user;
    public Commantaire(int id_commantaire,int user_id,int article_id,String commantaire,String nom_user)
    {
        this.id_commantaire=id_commantaire;
        this.user_id=user_id;
        this.article_id=article_id;
        this.commantaire=commantaire;
        this.nom_user=nom_user;
    }
    public Commantaire(int article_id,String commantaire)
    {
       
        this.article_id=article_id;
        this.commantaire=commantaire;
     
    }
        public Commantaire(String commantaire,String nom)
    {
       
       this.nom_user=nom;
        this.commantaire=commantaire;
     
    }
 
    public int getId_commantaire() {
        return id_commantaire;
    }

  
    public void setId_commantaire(int id_commantaire) {
        this.id_commantaire = id_commantaire;
    }

  
    public int getUser_id() {
        return user_id;
    }

 
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    
    public int getArticle_id() {
        return article_id;
    }

 
    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

 
    public String getCommantaire() {
        return commantaire;
    }

   
    public void setCommantaire(String commantaire) {
        this.commantaire = commantaire;
    }

 
    
    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }
    
}
