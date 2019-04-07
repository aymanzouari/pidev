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
public class Categorie {
    private int id_categorie;
    private String type;
    
    public Categorie(String nom)
    {
        this.type=nom;
    }
    public Categorie(int id,String type)
    {
        this.id_categorie=id;
        this.type=type;
    }

    public int getId_categorie() {
        return id_categorie;
    }


    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

  
    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }
    
}
