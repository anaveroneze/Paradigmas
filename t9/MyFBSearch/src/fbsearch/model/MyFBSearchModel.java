/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbsearch.model;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ana
 */
public class MyFBSearchModel extends AbstractTableModel{
    
    private static final String[] nameColumns = {"#", "Picture", "Id", "Name"}; 
    private String accessToken;
    private String nameToSearch;
    private FacebookClient fbClient;
    
    private ArrayList<MyFBSearch> users;
    
    public MyFBSearchModel(){
        users = new ArrayList<MyFBSearch>();
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return nameColumns.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return nameColumns[columnIndex];
    }
    
    public String getAccessToken(){
        return accessToken;
    }

    public String getNameToSearch(){
        return nameToSearch;
    }
    
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }
    
    public void setNameToSearch(String nameToSearch){
        this.nameToSearch = nameToSearch;
    }
    
    public void add(MyFBSearch fbSearch){
        fbClient= new DefaultFacebookClient(accessToken, Version.VERSION_2_5);
        Connection<User> profilesFound = fbClient.fetchConnection("search", User.class, 
                Parameter.with("q", nameToSearch), Parameter.with("type", "user"),
                Parameter.with("limit", 5000), Parameter.with("offset", 0));
        
        List<User> pages = profilesFound.getData();
        for(User p : pages){
            User user = fbClient.fetchObject(p.getId(), User.class, Parameter.with("fields", "picture")); 
            
            MyFBSearch client = new MyFBSearch(p.getName(), p.getId(), user.getPicture().getUrl());
            users.add(client);
            fireTableRowsInserted(users.size()-1, users.size()-1);
            
            out.println("Number of profiles found: " + profilesFound.getData().size());   
            out.println(p.getName() + " " + p.getId());
            out.println(user.getPicture().getUrl());
            //out.println("Number of profiles found: " + profilesFound.getData().size());   
            //out.println(p.getName() + " " + p.getId());
            //out.println(user.getPicture().getUrl());
          
           /*get the image by the url
            try {
                BufferedImage img = ImageIO.read(new URL(url));
             // save image
                File outputfile = new File("saved.jpg"); 
                ImageIO.write(img, "jpg", outputfile);
               
            } catch (IOException e) {
                Logger.getLogger(MyFBSearch.class.getName()).log(Level.SEVERE, null, e);
            }*/
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return "0";
            case 1: System.out.println(users.get(rowIndex).getUrl());
                    return users.get(rowIndex).getUrl();
            case 2: return users.get(rowIndex).getId();
            case 3: return users.get(rowIndex).getName();
        }
        return users.get(rowIndex);
    }
    
}
