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
                Parameter.with("q", "Chuck Norris"), Parameter.with("type", "user"));
        System.out.println(profilesFound.getNextPageUrl());
    } 
            
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);
        
        System.out.print("Token:");
        String accessToken = read.next();
        
        new MyFBSearch(accessToken).search();      
    }
    
    
}
