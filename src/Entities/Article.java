/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDate;


/**
 *
 * @author aymen
 */
public class Article {
    private int id;
    private int user_id;
    private int categorie_id;
    private String nom;
    private String description;
    private LocalDate date_article;
    private String image;

    
    public Article(int id,String nom,String description,LocalDate date_article,int categorie_id,String image)
    {
      
       
        this.image=image;
        this.nom=nom;
        this.description=description;
        this.date_article=date_article;
        this.categorie_id=categorie_id;
        this.id=id;
       
    }  
    public Article(String nom,String description,LocalDate date_article,int categorie_id,String image)
    {
      
       
        this.image=image;
        this.nom=nom;
        this.description=description;
        this.date_article=date_article;
        this.categorie_id=categorie_id;
        
       
    }    

    public Article()
    {
        
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

  
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  
    public LocalDate getDate_article() {
        return date_article;
    }

 
    public void setDate_article(LocalDate date_article) {
        this.date_article = date_article;
    }

 
    public int getCategorie_id() {
        return categorie_id;
    }

 
    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public int getUser_id() {
        return user_id;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

  
    public String getImage() {
        return image;
    }

  
    public void setImage(String image) {
        this.image = image;
    }
    
}
