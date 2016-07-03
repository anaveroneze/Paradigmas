/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbsearch.model;

import com.restfb.Connection;
import com.restfb.Parameter;
import com.restfb.types.User;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ana
 */
public class MyFBSearchModel extends AbstractTableModel{
    
    private static final String[] column = {"#", "Picture", "Id", "Name"};
    private int position = 0;   
 
    private ArrayList<MyFBSearch> users;
    
    public MyFBSearchModel(){
        users = new ArrayList<MyFBSearch>();
    }
    
    public void add(MyFBSearch fbSearch) { 
        Connection<User> profilesFound = fbSearch.getFbClient().fetchConnection("search", User.class, 
                Parameter.with("q", fbSearch.getUsername()), Parameter.with("type", "user"),
                Parameter.with("limit", 5000), Parameter.with("offset", 0));    
        
        List<User> pages = profilesFound.getData();
        for(User p : pages){
            position++;
            User user = fbSearch.getFbClient().fetchObject(p.getId(), User.class, Parameter.with("fields", "picture")); 
            fbSearch.setElements(p.getName(), p.getId(), user.getPicture().getUrl(), position);
            users.add(fbSearch);
            
            //out.println("Number of profiles found: " + profilesFound.getData().size());   
            out.println(p.getName() + " " + p.getId());
            out.println(user.getPicture().getUrl());
          
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
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return column.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return users.get(rowIndex).getPosition();
            case 1: return users.get(rowIndex).getUrl();
            case 2: return users.get(rowIndex).getId();
            case 3: return users.get(rowIndex).getUsername();
        }
        return users.get(rowIndex);
    }


    
}
