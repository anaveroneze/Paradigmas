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
import java.io.IOException;
import static java.lang.System.out;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ana
 */
public class MyFBSearch {
    
    private FacebookClient fbClient;
    private String accessToken;
    private String username;
    
    private String name;
    private String id;
    private String url;
    private int position;
    
    public MyFBSearch(){
    }
    
    public MyFBSearch(String accessToken, String username){
        this.accessToken = accessToken;
        this.username = username;
        fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_5);
    }
    
    public void setElements(String name, String id, String url, int position){
        this.name = name;
        this.id = id;
        this.url = url;
        this.position = position;
    }
    
    public FacebookClient getFbClient(){
        return fbClient;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getAccessToken(){
        return accessToken;
    }
    
    public int getPosition(){
        return position;
    }
    
    public String getUrl() {
        return url;
    }

    public String getId() {
        return id;
    }
    
    public void setFbClient(FacebookClient fbClient){
        this.fbClient = fbClient;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }
    
    public void setPosition(int position){
        this.position = position;
    }

}