/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbsearch.model;

/**
 *
 * @author ana
 */
public class MyFBSearch {
       
    private String name;
    private String id;
    private String url;
    
    public MyFBSearch(){
    }
    
    public MyFBSearch(String name, String id, String url){
        this.name = name;
        this.id = id;
        this.url = url;
    }

    public String getName(){
        return name;
    }
    
    public String getUrl() {
        return url;
    }

    public String getId() {
        return id;
    }
    
    public void setName(String name){
        this.name = name;
    }
}