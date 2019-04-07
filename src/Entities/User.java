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
public class User {
    private int id;
    private String username;
    private String mail;
    private String password;
    private String role;

    
    public User(String username,String mail,String password,String role)
    {
       
        this.username=username;
        this.mail=mail;
        this.password=password;
        this.role=role;
    }
    public User()
    {
        
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

   
    
    public void setId(int id) {
        this.id = id;
    }

  
    
    public String getUsername() {
        return username;
    }

   
    
    public void setUsername(String username) {
        this.username = username;
    }

  
    
    public String getMail() {
        return mail;
    }

  
    
    public void setMail(String mail) {
        this.mail = mail;
    }

   
    
    public String getPassword() {
        return password;
    }

  
    
    public void setPassword(String password) {
        this.password = password;
    }

   
    
    public String getRole() {
        return role;
    }

   
    
    public void setRole(String role) {
        this.role = role;
    }
    
    
    
    
    
    
    
    
}
