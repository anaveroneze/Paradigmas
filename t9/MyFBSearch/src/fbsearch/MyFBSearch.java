/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbsearch;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;
import static java.lang.System.out;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ana
 */
public class MyFBSearch {
    
    private final FacebookClient fbClient;
    
    public MyFBSearch(String accessToken){
        fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_5);
    }
    
    public void search(){
        
        Connection<User> profilesFound = fbClient.fetchConnection("search", User.class, 
                Parameter.with("q", "ana veroneze"), Parameter.with("type", "user"),
                Parameter.with("limit", 5000), Parameter.with("offset", 0));    
        
        
        List<User> pages = profilesFound.getData();
        for(User p : pages){
           //get user profile's picture
           User user = fbClient.fetchObject(p.getId(), User.class, Parameter.with("fields", "picture, first_name, last_name, gender, name"));
           out.println(p.getName() + " " + p.getId());
           out.println(user.getPicture().getUrl());
        }
        
        out.println("Number of profiles found: " + profilesFound.getData().size());   
       
    } 
   
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);
        
        System.out.print("Token:");
        String accessToken = read.next();
        
        new MyFBSearch(accessToken).search();      
    }
       
}