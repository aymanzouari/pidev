/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import java.time.LocalDate;

/**
 *
 * @author aymen
 */
public class Formation {
    private int id_formation;
    private int user_id;
    private String titre;
    private int categorie_id;
    private LocalDate date_formation;
    private int nombre_totale;
    private String description;
    private int prix;
    public Formation()
    {
        
    }
    public Formation(int id,String titre,String description,int prix,int nombre,LocalDate date)
    {
        this.id_formation=id;
        this.titre=titre;
        this.description=description;
        this.prix=prix;
        this.nombre_totale=nombre;
        this.date_formation=date;
    }
    public Formation(int nb)
    {
        this.nombre_totale=nb;
    }
    public Formation(int id_formation,int user_id,int categorie_id,String titre,LocalDate date_formation,int nombre_totale,String description,int prix)
    {
        this.id_formation=id_formation;
        this.user_id=user_id;
        this.categorie_id=categorie_id;
        this.date_formation=date_formation;
        this.nombre_totale=nombre_totale;
        this.description=description;
        this.prix=prix;
        this.titre=titre;
    }

    /**
     * @return the id_formation
     */
    public int getId_formation() {
        return id_formation;
    }

   
    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }


    public int getUser_id() {
        return user_id;
    }

  
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCategorie_id() {
        return categorie_id;
    }


    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

 
    public LocalDate getDate_formation() {
        return date_formation;
    }

    public void setDate_formation(LocalDate date_formation) {
        this.date_formation = date_formation;
    }

 
    public int getNombre_totale() {
        return nombre_totale;
    }

  
    public void setNombre_totale(int nombre_totale) {
        this.nombre_totale = nombre_totale;
    }

    public String getDescription() {
        return description;
    }

 
    public void setDescription(String description) {
        this.description = description;
    }

  
    public int getPrix() {
        return prix;
    }


    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getTitre() {
        return titre;
    }

  
    public void setTitre(String titre) {
        this.titre = titre;
    }
    
}
