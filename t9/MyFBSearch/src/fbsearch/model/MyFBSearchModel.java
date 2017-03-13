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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ana
 */
public class MyFBSearchModel extends AbstractTableModel implements Runnable{
    
    private static final String[] nameColumns = {"#", "Picture", "Id", "Name"}; 
    private String accessToken;
    private String nameToSearch;
    private BufferedImage image;
    private int numProfiles;
    private FacebookClient fbClient;
    private String imageName;
    
    private final ArrayList <MyFBSearch> users;
    
    public MyFBSearchModel(){
        users = new ArrayList<>();
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
    
    public int getNumProfiles(){
        return numProfiles;
    }
    
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }
    
    public void setNameToSearch(String nameToSearch){
        this.nameToSearch = nameToSearch;
    }
    
    public void run(){
        fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_5);
        Connection<User> profilesFound = fbClient.fetchConnection("search", User.class, 
                Parameter.with("q", nameToSearch), Parameter.with("type", "user"),
                Parameter.with("limit", 5000), Parameter.with("offset", 0));
        
        numProfiles = profilesFound.getData().size();

        List<User> pages = profilesFound.getData();
        for(User p : pages){
            
            User user = fbClient.fetchObject(p.getId(), User.class, Parameter.with("fields", "picture")); 
            //get the image by the url
            try {
                image = ImageIO.read(new URL(user.getPicture().getUrl()));
            } catch (IOException e) {
                Logger.getLogger(MyFBSearch.class.getName()).log(Level.SEVERE, null, e);
            }
            
            MyFBSearch client = new MyFBSearch(p.getName(), p.getId(), (new ImageIcon(image)), image);
            users.add(client);
            fireTableRowsInserted(users.size()-1, users.size()-1);
                                   
            if(Thread.interrupted())
                try {
                    throw new InterruptedException();
            } catch (InterruptedException ex) {
                Logger.getLogger(MyFBSearchModel.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
    }
    
    public void saveImages(int [] imageIndex) throws IOException{
       for(int i : imageIndex){
           imageName = (i+1) + "-" + users.get(i).getName() + ".jpg";
           File outputfile = new File(imageName); 
           ImageIO.write(users.get(i).getImg(), "jpg", outputfile);
       }
   }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return (rowIndex+1);
            case 1: return users.get(rowIndex).getImage();
            case 2: return users.get(rowIndex).getId();
            case 3: return users.get(rowIndex).getName();
        }
        return users.get(rowIndex);
    }
}
