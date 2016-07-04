/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbsearch.model;

import javax.swing.ImageIcon;

/**
 *
 * @author ana
 */
public class MyFBSearch {
       
    private String name;
    private String id;
    private ImageIcon image;
    
    public MyFBSearch(){
    }
    
    public MyFBSearch(String name, String id, ImageIcon image){
        this.name = name;
        this.id = id;
        this.image = image;
    }

    public String getName(){
        return name;
    }
    
    public ImageIcon getImage() {
        return image;
    }

    public String getId() {
        return id;
    }
    
}